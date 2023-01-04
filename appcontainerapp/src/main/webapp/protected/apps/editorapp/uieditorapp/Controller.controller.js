sap.ui.define([ 
	"ui5libs/controls/Controller", 
	"sap/ui/base/DataType",
	"ui5app/controls/ControlWrapper",
	"ui5app/controls/TableWrapper",
	"ui5app/controls/TabContainerWrapper",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"sap/ui/model/Sorter"
	], function(Controller, DataType, ControlWrapper, TableWrapper, TabContainerWrapper, ui5ajax, errorfunctions) {
	"use strict";

	const hiddenProperties = [
		"visible",
		"busy",
		"blocked",
		"enabled",
		"id",
		"oDataURL"
	];

	return Controller.extend("ui5app.Controller", {
		onInit : function() {
			var oView = this.getView();
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
			var oOpenFileLink = oView.byId("openfile");
			if (sFilename.endsWith(".view.xml")) {
				oOpenFileLink.setHref("../../../repo/currentuser/" + sFilename.substring(0, sFilename.length-9) + ".html");
			}
			
			var that = this;
			ui5ajax.ajaxGet("/repo/file/" + sFilename, "ui5rest")
				.then(
					data => {
						var parser = new DOMParser();
						var sFileContent = JSON.parse(data.text).content;
						if (sFileContent) {
							var xmlView = parser.parseFromString(sFileContent, "text/xml");					
							that._buildContentTree(xmlView.documentElement);
						}
					}, 
					error => {
						oView.setBusy(false);
						if (error.code === 400) {
							errorfunctions.addError(that.getView(), error);
						} else {
							errorfunctions.uiError(error.text);
						}
					}
				);
			
		    var oModel = new sap.ui.model.odata.v4.ODataModel({
		    		serviceUrl : sap.ui.require.toUrl("ui5rest") + "/odata/tables/", 
		    		"autoExpandSelect": true,
					"operationMode": "Server",
					"groupId": "$direct",
					"synchronizationMode": "None"
		    });
		    var oModelControl = oView.byId("odatamodels");
		    oModelControl.setModel(oModel);
		    
		    var oModelSchema = new sap.ui.model.json.JSONModel();
		    oModelSchema.loadData(sap.ui.require.toUrl("ui5rest") + '/catalog/schemas');
		    var oModelSchemaControl = oView.byId("odatamodelschema");
		    oModelSchemaControl.setModel(oModelSchema);
		    
			var oBinding = oModelControl.getBinding("items");
			oBinding.sort( [ new sap.ui.model.Sorter("SCHEMANAME"), new sap.ui.model.Sorter("OBJECTNAME") ] );
			
			var oPropertiesTable = oView.byId("properties");
			var oPropertiesModel = new sap.ui.model.json.JSONModel();
			oPropertiesTable.setModel(oPropertiesModel);
		},
		onDelete : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			// Find the ControlWrapper this item belongs to, e.g. the Table this column belongs to
			var oControlWrapper = oSourceControl.getParent();
			while (oControlWrapper && !(oControlWrapper instanceof ui5app.controls.ControlWrapper)) {
				oControlWrapper = oControlWrapper.getParent();
			}
			if (oControlWrapper) {
				oControlWrapper.deleteControl.call(oControlWrapper, oEvent);
			}
		},
		onmodelsearch : function(oEvent) {
			var oModelControl = this.byId("odatamodels");
			var cSearchFilter = this.getView().byId("odatamodelsearch");
			var sSearch = cSearchFilter.getValue();
			var cSchemaFilter = this.getView().byId("odatamodelschema");
			var sSchema = cSchemaFilter.getSelectedKey();

			var oBinding = oModelControl.getBinding("items");
			var aFilter = [];
			if (sSearch) {
				aFilter.push(new sap.ui.model.Filter("OBJECTNAME", sap.ui.model.FilterOperator.Contains, sSearch));
			}
			if (sSchema) {
				aFilter.push(new sap.ui.model.Filter("SCHEMANAME", sap.ui.model.FilterOperator.EQ, sSchema));
			}
			oBinding.filter(aFilter, "Application");
		},
		_buildContentTree : function(node, level = 0) {
			/*
			 * The first invocation has node = XMLView.
			 * Then either the list of elements is found or an AppContainer with a Panel and this has the list of elements.
			 */
			if (node) {
				if (node.localName === "View" && level == 0) {
					this._buildContentTree(node.children, 1);
				} else if (node instanceof HTMLCollection) {
					if (node.length == 1 && node[0].localName === "AppContainerPage") {
						this._buildContentTree(node[0].children, 2);
					} else if (node.length == 1 && node[0].localName === "Panel") {
						this._buildContentTree(node[0].children, 3);
					} else {
						var oEditor = sap.ui.getCore().byId("__xmlview0--editorcontent").getWrappedControl();
						var aControls = this._buildContentTreeAggregation(node, node.nodeName, this.showProperties);
						for (var i=0; i<aControls.length; i++) {
							oEditor.addContent(aControls[i]);
						}
					}
				}
			}
		},
		_buildContentTreeControl : function(node, sClassName, showProperties) {
			var oClass = eval(sClassName);
			if (oClass) {
				var oAllSettings = oClass.getMetadata().getAllSettings();
				var sDefaultAggregation = oClass.getMetadata().getDefaultAggregationName();
				var oCustomProperties = {};
				var oSettings = {};
				var sODataURL;
				for (var i = 0; i < node.attributes.length; i++) {
					var attribute = node.attributes[i];
					var sAttributeName = attribute.localName;
					/*
					 * Redirect the following settings into the oCustomProperties:
				     * - id
				     * - all events
					 */
					if (oAllSettings[sAttributeName]) {
						/*
						 * Ignore properties that are hidden in the control like selectedkey in sap.m.Select
						 */
						if (oAllSettings[sAttributeName]._iKind === 5) { // events
							oCustomProperties[sAttributeName] = attribute.value;
						} else if (sAttributeName === "id") {
							oCustomProperties["controlid"] = attribute.value;
						} else {
							var vType = oAllSettings[sAttributeName].type;
							oSettings[sAttributeName] = this._convertScalarDatatype(vType, attribute.value);
						}
					}
				}
				var nodes = node.childNodes;
				var oControlTemplate;
				for (var i = 0; i < nodes.length; i++) {
					var node = nodes[i];
					if (node instanceof Element) {
						var aggregationname = node.localName;
						if (aggregationname === "customData") {
							sODataURL = this._findODataURLAttributeValue(node.childNodes);
						} else if (aggregationname === "layoutData") {
							// TODO: assign layout data to the wrapped control
						} else if (aggregationname in oSettings) {
							/*
							 * In case "items" was set already in the attributes above, this is a template and items needs to be set again with the full binding info
							 */
							var sPath = oSettings[aggregationname];
							oControlTemplate = this._buildContentTreeAggregation(node.childNodes, showProperties)[0];
							oSettings[aggregationname] = { path: sPath, template: oControlTemplate.clone(), targetType: "any"};
						} else if (oAllSettings[aggregationname]) {
							oSettings[aggregationname] = this._buildContentTreeAggregation(node.childNodes, showProperties);
						} else {
							// default aggregation
							if (!oSettings[aggregationname]) {
								oSettings[aggregationname] = [];
							}
							oSettings[aggregationname].push(this._buildContentTreeControl(node, sClassName, showProperties));
						}
					}
				}
				var oControl = this.createControl(new oClass( oSettings ), oCustomProperties, oControlTemplate, sODataURL);
				return oControl;
			}
		},
		_findODataURLAttributeValue : function(nodes) {
			for (var i = 0; i < nodes.length; i++) {
				if (nodes[i].attributes) {
					var oAttribute = nodes[i].attributes["key"];
					if (oAttribute && oAttribute.nodeValue === "odataurl") {
						if (nodes[i].attributes["value"]) {
							return nodes[i].attributes["value"].nodeValue;
						}
					}
				}
			}
			return null;
		},
		_buildContentTreeAggregation : function(nodes, showProperties) {
			var aItems = [];
			for (var j = 0; j < nodes.length; j++) {
				var node = nodes[j];
				if (node instanceof Element) {
					var sClassName = node.namespaceURI + "." + node.localName;
					aItems.push(this._buildContentTreeControl(node, sClassName, showProperties));
				}
			}
			return aItems;
		},
		_convertScalarDatatype : function(sType, sValue) {
			var vValue = sValue;
			var oType = DataType.getType(sType);
			if (oType) {
				if (oType instanceof DataType) {
					vValue = oType.parseValue(sValue);

					// if the parsed value is not valid, we don't fail but only log an error
					if (!oType.isValid(vValue)) {
						Log.error("Value '" + sValue + "' is not valid for type '" + oType.getName() + "'.");
					}
				}
				// else keep original sValue (e.g. for enums)
			} else {
				throw new Error("Property " + sName + " has unknown type " + sType);
			}
			return vValue;
		},
		_getBaseDataTypeName : function(oDatatype) {
			var oBaseType = oDatatype.getBaseType();
			if (oBaseType) {
				return oBaseType.getName();
			} else {
				return oDatatype.getName();
			}					
		},
		showProperties : function(oEvent, oWrapperControl, oControl) {
			/*
			 * The oWrapperControl is the control selected, the oControl the one the properties are shown for.
			 * In many cases the oControl = oWrapperControl.getWrappedControl() but for example if the
			 * ListAggregation of a Combobox is viewed, it is not.
			 */
			var oView = sap.ui.getCore().byId("__xmlview0");
			if (!oWrapperControl) {
				oWrapperControl = oEvent.getSource();
				if (oWrapperControl instanceof ui5app.controls.ControlWrapper) {
					/*
					 * Option 1: ShowProperties was called by a doubleclick on the wrapper.
					 * In that case the properties are shown for the template control, if exists, or the control itself.
					 */
					oWrapperControl = this.findTemplate(oWrapperControl);
					oControl = oWrapperControl.getDropTarget();
				} else {
					/*
					 * Option 2: ShowProperties was called by a click on a specific child, e.g. a list item
					 */
					if (oEvent.getParameter("listItem")) {
						oControl = oEvent.getParameter("listItem"); // sap.m.List
					} else if (oEvent.getParameter("item")) {
						oControl = oEvent.getParameter("item"); // sap.m.SelectList
					} else if (oEvent.getParameter("selectedItem")) {
						oControl = oEvent.getParameter("selectedItem"); // sap.m.ComboBox, sap.m.Select
					} else if (oEvent.getParameter("changedItem")) {
						oControl = oEvent.getParameter("changedItem"); // sap.m.MultiComboBox
					}
					oWrapperControl = oWrapperControl.getParent(); // List --> Wrapper
					oWrapperControl = oWrapperControl.findTemplate(oWrapperControl);
					if (oWrapperControl.getControlTemplate()) {
						// The control has a template, so we want to edit that.
						oControl = oWrapperControl.getControlTemplate();
					} else if (oControl) {
						/*
						 * At this point we know which element was selected and we want to edit that.
						*/
						var sAggregationName = oControl.sParentAggregationName;
						if (sAggregationName) {
							var index = oControl.getParent().indexOfAggregation(sAggregationName, oControl);
							if (index >= 0) {
								oControl = oWrapperControl.getDropTarget().getAggregation(sAggregationName)[index];
							} else {
								oControl = undefined;
							}
						}
					}
				}
			}
			if (oWrapperControl && oControl && !oWrapperControl.getId().endsWith('editorcontent')) {
				var oPropertiesTable = oView.byId("properties");
				oPropertiesTable.setExpanded(true); // Make sure the properties panel is expanded, all properties visible
				oPropertiesTable.data("control", oControl);
				oPropertiesTable.data("wrappercontrol", oWrapperControl);
				var oModel = oPropertiesTable.getModel();
				var oAllProperties = oControl.getMetadata().getAllProperties();
				var aProps = [];
				if (oWrapperControl.allowModelDrop(oControl)) {
					aProps.push( {propertyvalue: oWrapperControl.getODataURL(), propertydatatype: 'string', "propertyname": "oDataURL" } );
				}
				aProps.push( {propertyvalue: oWrapperControl.getControlid(), propertydatatype: 'string', "propertyname": "id" } );
				for (let [sKey, oItem] of Object.entries(oAllProperties)) {
					/*
					 * Hide all properties that are marked as deprecated or have a visibility != public.
					 * Hide the properties: busy, visible, enabled,...
					 */
					if (hiddenProperties.includes(sKey)) {
						// do not show the property
					} else if (!oItem.deprecated && (!oItem.visibility || oItem.visibility === "public")) {
						var method = oItem._sGetter;
						/*
						 * When the property is bound, this has higher prio over the literal value
						 */
						var value = oControl.getBindingPath(oItem.propertyname);
						if (value) {
							value = "{" + value + "}";
						} else {
							value = oControl[method].call(oControl);
						}
						var datatype = oItem.getType();
						var aOptionValues = [];
						
						if (datatype) {
							var sBaseTypeName;
							var oBaseType = datatype.getBaseType();
							if (oBaseType) {
								sBaseTypeName = oBaseType.getName();
							} else {
								sBaseTypeName = datatype.getName();
							}					
							var aEnumValues = datatype.getEnumValues();
							if (aEnumValues) {
								Object.keys(aEnumValues).forEach(function(sItem) {
									aOptionValues.push( { value: sItem } );
								});
							} else if (sBaseTypeName === "boolean") {
								aOptionValues.push( { value: "true" } );
								aOptionValues.push( { value: "false" } );
							}
						}
		
						var sGroup = oItem.group;
						var bBindable = oItem.bindable;
						var bShowModel = false;
						switch (sKey) {
							case "value":
							case "text":
							case "key":
							case "title":
							case "label":
							case "additionalText":
								/*
								 * Very specific fields are meant to be used by the model. Theoretically it could be any but the UI supports only the basic ones.
								 */
								var that = this;
								var oModelColumns = oWrapperControl.getModelColumns(oWrapperControl);
								if (oModelColumns) {
									oModelColumns.forEach(function(sItem) {
										aOptionValues.push( { value: "{" + sItem + "}" } );
									});
								}
								break;
						}

						aProps.push( {propertyvalue: value, propertydatatype: datatype, "propertyname": sKey, "options": aOptionValues } );
					}
				}
				oModel.setData( {"classname": oControl.getMetadata()._sClassName, "list": aProps} );
			}
		},
		updateProperties : function(oEvent) {
			var oView = sap.ui.getCore().byId("__xmlview0");
			var oPropertiesTable = oView.byId("properties");
			var oModel = oPropertiesTable.getModel();
			var aRows = oModel.getProperty("/list");
			var oControl = oPropertiesTable.data("control");
			var oWrapperControl = oPropertiesTable.data("wrappercontrol");
			if (!!oControl) {
				var oAllProperties = oControl.getMetadata().getAllProperties();
				aRows.forEach(function(oItem) {
					if (oItem.propertyname === "id") {
						oWrapperControl.setControlid(oItem.propertyvalue);
					} else if (oItem.propertyname === "oDataURL") {
						oWrapperControl.setODataURL(oItem.propertyvalue);
					} else {
						var sSetter = oAllProperties[oItem.propertyname]._sMutator;
						var sGetter = oAllProperties[oItem.propertyname]._sGetter;
						if (!!sGetter) {
							var currentvalue = oControl[sGetter].call(oControl);
							var newvalue = oItem.propertyvalue;
							var sDataTypeName = this._getBaseDataTypeName(oAllProperties[oItem.propertyname].getType());
							if (newvalue === "" && sDataTypeName !== "string") {
								newvalue = undefined;
							}
							/*
							 * Update the value and the binding. Setting a 
							 * value of "{name}" is not sufficient to trigger a binding creation.
							 */
							oControl[sSetter].call(oControl, newvalue);
							if ((typeof newvalue === 'string' || newvalue instanceof String) && newvalue.startsWith("{")) {
								oControl.bindProperty(oItem.propertyname, { path: newvalue.substring(1, newvalue.length-1), targetType: "any" } );
							} else {
								oControl.unbindProperty(oItem.propertyname);
							}
						} else {
							alert('Code Error: The control has no property named "' + row.propertyname + '"');
						}
					}
				}, this);
				/*
				 * Find the control that has the aggregation binding and refresh.
				 * If the oDataURL has been updated already, this did happen already.
				 */
				oWrapperControl.rebindTemplate(oWrapperControl);
			}
		},
		saveAsXmlView : function() {
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
		    if (!!sFilename) {
				var buffer = [];
				var sViewName = sFilename.substring(sFilename.lastIndexOf('/')+1);
				if (sViewName.endsWith(".view.xml")) {
					sViewName = sViewName.substring(0, sViewName.length-9);
				}
				var oEditor = sap.ui.getCore().byId("__xmlview0--editorcontent").getWrappedControl();
				oEditor.getContent().forEach(function(oItem, index) {
					oItem.generateXML(buffer, 1, oItem);
				});
				var viewcontent = '<mvc:View height="100%" class="sapUiSizeCompact"\r\n' +
						'    controllerName="ui5app.' + sViewName + '"\r\n' + 
						'    xmlns:mvc="sap.ui.core.mvc"\r\n' + 
						'    xmlns:sap.m="sap.m"\r\n' + 
						'    xmlns:sap.ui.layout="sap.ui.layout"\r\n' + 
						'    xmlns:sap.ui.core.dnd="sap.ui.core.dnd" \r\n' +
						'    xmlns:sap.ui.core="sap.ui.core" \r\n' + 
						'    xmlns:ui5libs.controls="ui5libs.controls">\r\n' + 
						'    <ui5libs.controls:AppContainerPage>\r\n' +
						'        <sap.m:Panel height="100%">\r\n' +
						buffer.join("") +
						'        </sap.m:Panel>\r\n' +
						'    </ui5libs.controls:AppContainerPage>\r\n' +
						'</mvc:View>';
				var that = this;
				var oView = this.getView();
				ui5ajax.postText("/repo/file/" + sFilename, viewcontent, "ui5rest")
					.then(
						data => {
							errorfunctions.uiSuccess(that.getView(), data);
						}, 
						error => {
							oView.setBusy(false);
							if (error.code === 400) {
								errorfunctions.addError(that.getView(), error);
							} else {
								errorfunctions.uiError(error.text);
							}
						}
					);
		    } else {
		    	alert("No filename parameter provided in the URL");
		    }
		},
		
			
		generateXML : function(buffer, level = 0, oControl) {
			if (oControl instanceof ui5app.controls.ControlWrapper) {
				return oControl.generateXML(buffer, level, oControl.getWrappedControl());
			} else {
				return this.generateXMLInnerControl.call(this, buffer, level, oControl);
			}
		},
	
	   	generateXMLInnerControl : function(buffer, level = 0, oControl) {
	   	   	function indent(text, level) {
	   	   		return " ".repeat(level*4) + text;
	   	   	};
			function xmlEncode(text) {
				if (typeof(text) === 'string') {
			    	return text.replace(/&/g, '&amp;')
				               .replace(/</g, '&lt;')
				               .replace(/>/g, '&gt;')
				               .replace(/"/g, '&quot;')
				               .replace(/'/g, '&apos;');
				} else {
					return text;
				}
			};
	   	   	
	   	   	var hasdata = false;
	   		var sClassname = oControl.getMetadata().getName();
			var vProperties = oControl.getMetadata().getAllProperties();
			var vAggregations = oControl.getMetadata().getAllAggregations();
			var vAssociations = oControl.getMetadata().getAllAssociations();
	   		var xmlname;
	   		var ns;
	   		var p = sClassname.lastIndexOf(".");
	   		if (p > 0) {
	   			ns = sClassname.substring(0, p) + ":";
	   			xmlname = sClassname.substring(p+1);
	   		} else {
	   			ns = "";
	   			xmlname = sClassname;
	   		}
			buffer.push(indent("<" + ns + xmlname + " ", level));
			
			if ('getControlid' in oControl && !!oControl.getControlid()) {
				buffer.push("\r\n" + indent("id=\"" + oControl.getControlid() + "\"", level+1));
			}
			// Add all properties to the XML node
			Object.keys(vProperties).forEach( function (sName) {
				/*
				 * Write properties only if the exist in the actual control and the wrapper control.
				 * This should avoid writing temporary properties like selectedid of the sap.m.select control.
				 */
				if (sName !== "propertiesModel" && sName in oControl.getMetadata().getAllProperties()) {
					var sMethodname = vProperties[sName]._sGetter;
					if (!vProperties[sName].deprecated) {
						var defaultvalue = vProperties[sName].defaultValue;
						if (defaultvalue === "" || (Array.isArray(defaultvalue) && defaultvalue.length == 0)) {
							defaultvalue = null;
						}
						/*
						 * Binding or literal text? Which one to use?
						 */
						var sBindingPath = oControl.getBindingPath(sName);
						var sValue;
						if (sBindingPath) {
							sValue = "{" + xmlEncode(sBindingPath) + "}";
						} else if (oControl[sMethodname]) {
							sValue = oControl[sMethodname].apply(oControl);
						} else {
							sValue = defaultvalue;
						}
						if (sValue === "" || (Array.isArray(sValue) && sValue.length == 0)) {
							sValue = null;
						}
						if (sValue !== defaultvalue) {
							hasdata = true;
							buffer.push("\r\n" + indent(sName + "=\"" + xmlEncode(sValue) + "\"", level+1));
						}
					}
				}
			}, this);
			var bindingposition = buffer.length;
			buffer.push(">");
	
			/*
			 * Finally add the aggregation binding info.
			 * For the oDataModel there is no place in the XML View yet, hence need to use the customData aggregation.
			 */
			if (oControl.getParent() instanceof ui5app.controls.ControlWrapper && oControl.getParent().getODataURL()) {
				buffer.push("\r\n" + indent("<" + ns + "customData>", level+1));
				buffer.push("\r\n" + indent("<ui5libs.controls:ODataContainer url=\"" + oControl.getParent().getODataURL() + "\" />", level+2));
				buffer.push("\r\n" + indent("</" + ns + "customData>", level+1));
			}
	
			// Add some aggregations
			Object.keys(vAggregations).forEach( function (sName) {
				if (sName !== "customData" && sName !== "dragDropConfig") { // these two are used internally
					var sMethodname = vAggregations[sName]._sGetter;
					if (!vAggregations[sName].deprecated && oControl[sMethodname]) {
						var aElements = oControl[sMethodname].apply(oControl);
						var oBindingInfo = oControl.getBindingInfo(sName);
						if (oBindingInfo) {
							var oTemplate = oBindingInfo.template;
							/*
							 * Add the aggregation binding to the properties
							 */
							buffer.splice(bindingposition, 0, "\r\n" + indent(sName + "=\"{" + oBindingInfo.path + "}\"", level+1));
							buffer.push("\r\n" + indent("<" + ns + sName + ">\r\n", level+1 ));
							var ret = this.generateXML.call(this, buffer, level+2, oTemplate);
							if (!ret) {
								buffer.pop(); // <tagname...>
							} else {
								buffer.push(indent("</" + ns + sName + ">", level+1) );
							}
							hasdata |= ret;
						} else if (!!aElements) {
							/*
							 * One of the features is that if a child does not have any data, it should not be added.
							 * That is easy for properties, but more difficult for nested data.
							 * For example a Button always has a layoutdata aggregation. But the content of this aggregation
							 * has only default values. Hence this child should not be rendered but if the 
							 * child is made non-existent, then the parent has to be removed as well.
							 * The hasdata=true/false tells that. And the buffer.pop() removes the previously
							 *  generated start tag when it is not needed due to no-data.
							 */
							if (Array.isArray(aElements)) {
								if (aElements.length != 0) {
									var ret = false;
									buffer.push("\r\n" + indent("<" + ns + sName + ">\r\n", level+1 ));
									aElements.forEach(function(oItem, index) {
										ret |= this.generateXML.call(this, buffer, level+2, oItem);
									}, this);
									if (!ret) {
										buffer.pop(); // <tagname...>
									} else {
										buffer.push(indent("</" + ns + sName + ">", level+1) );
									}
									hasdata |= ret;
								} else {
									// ignore empty arrays
								}
							} else {
								// ???? layoutdata aggregation for example
								buffer.push("\r\n" + indent("<" + ns + sName + ">\r\n", level+1 ));
								var ret = this.generateXML.call(this, buffer, level+2, aElements);
								if (!ret) {
									buffer.pop(); // <tagname...>
								} else {
									buffer.push(indent("</" + ns + sName + ">", level+1) );
								}
								hasdata |= ret;
							}
						}
					}
				}
			}, this);
			if (hasdata || oControl instanceof sap.ui.core.Control ) {
				// A control with all default should be added to the view of course
				buffer.push("\r\n" + indent("</" + ns + xmlname + ">\r\n", level));
			} else {
				buffer.pop(); // <tagname...
				buffer.pop(); // ...>
			}
			return hasdata;
		},
		
		
		createNewControl : function(sControlType, sText) {
			var cClass = eval(sControlType);
			var oSettings = this._getControlDefault(sControlType, sText);
			var oControl;
			if (cClass) {
				if (sControlType === 'sap.m.Table') {
				} else {
				}
				switch (sControlType) {
				case 'sap.m.Table':
					oControl = new ui5app.controls.TableWrapper( { "wrappedControl": new sap.m.Table(oSettings) } );
					break;
				case 'sap.m.TabContainer':
					oControl = new ui5app.controls.TabContainerWrapper( { "wrappedControl": new sap.m.TabContainer(oSettings), maximize: true } );
					break;
				/*
					<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="StandardListItem" controlType="sap.m.StandardListItem" dndGroupName="ListItem" />
					<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="DisplayListItem" controlType="sap.m.DisplayListItem" dndGroupName="ListItem" />
					<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="ActionListItem" controlType="sap.m.ActionListItem" dndGroupName="ListItem" />
					<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="FeedListItem" controlType="sap.m.FeedListItem" dndGroupName="ListItem" />
					<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="GroupHeaderListItem" controlType="sap.m.GroupHeaderListItem" dndGroupName="ListItem" />
					<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="InputListItem" controlType="sap.m.InputListItem" dndGroupName="ListItem" />
					<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="ObjectListItem" controlType="ObjectListItem" dndGroupName="ListItem" />
				*/
				case "sap.m.StandardListItem":
				case "sap.m.DisplayListItem":
				case "sap.m.ActionListItem":
				case "sap.m.FeedListItem":
				case "sap.m.GroupHeaderListItem":
				case "sap.m.InputListItem":
				case "sap.m.ObjectListItem":
					oControl = new cClass(oSettings);
					break;
				/*				
					<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="Item" controlType="sap.ui.core.ListItem" dndGroupName="CoreItem" />
				*/
				case "sap.ui.core.ListItem":
					oControl = new cClass(oSettings);
					break;
				default:
					oControl = new ui5app.controls.ControlWrapper( { "wrappedControl": new cClass(oSettings) } );
					break;
				}
			}
			return oControl;
		},
		createControl : function(oControl, oCustomProperties, oControlTemplate, sODataURL) {
			var wrap = function(oControl, oCustomProperties, oControlTemplate, sODataURL) {
				var oParentControl = new ControlWrapper({
										"wrappedControl": oControl,
										"customProperties" : oCustomProperties,
										"controlTemplate": oControlTemplate
									} );
				oParentControl.setODataURL(sODataURL);
				return oParentControl;
			};
			var sControlType = oControl.getMetadata().getName();
			switch (sControlType) {
			case 'sap.m.Table': {
					var oParentControl = new TableWrapper({
											"wrappedControl": oControl,
											"customProperties" : oCustomProperties,
											"controlTemplate": oControlTemplate
										} );
					oParentControl.setODataURL(sODataURL);
					return oParentControl;
				}
			case 'sap.m.TabContainer': {
					var oParentControl = new TabContainerWrapper({
											"wrappedControl": oControl,
											"customProperties" : oCustomProperties,
											"controlTemplate": oControlTemplate,
											maximize: true
										} );
					oParentControl.setODataURL(sODataURL);
					return oParentControl;
				}
			case "sap.m.List":
				oControl.attachItemPress(this.showProperties);
				return wrap(oControl, oCustomProperties, oControlTemplate, sODataURL);
			case "sap.m.Select":
				oControl.attachChange(this.showProperties);
				return wrap(oControl, oCustomProperties, oControlTemplate, sODataURL);
			case "sap.m.SelectList":
				oControl.attachItemPress(this.showProperties);
				return wrap(oControl, oCustomProperties, oControlTemplate, sODataURL);
			case "sap.m.ComboBox":
				oControl.attachSelectionChange(this.showProperties);
				return wrap(oControl, oCustomProperties, oControlTemplate, sODataURL);
			case "sap.m.MultiComboBox":
				oControl.attachSelectionChange(this.showProperties);
				return wrap(oControl, oCustomProperties, oControlTemplate, sODataURL);
			/*
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="StandardListItem" controlType="sap.m.StandardListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="DisplayListItem" controlType="sap.m.DisplayListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="ActionListItem" controlType="sap.m.ActionListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="FeedListItem" controlType="sap.m.FeedListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="GroupHeaderListItem" controlType="sap.m.GroupHeaderListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="InputListItem" controlType="sap.m.InputListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="ObjectListItem" controlType="ObjectListItem" dndGroupName="ListItem" />
			*/
			case "sap.m.StandardListItem":
			case "sap.m.DisplayListItem":
			case "sap.m.ActionListItem":
			case "sap.m.FeedListItem":
			case "sap.m.GroupHeaderListItem":
			case "sap.m.InputListItem":
			case "sap.m.ObjectListItem":
				oControl.setType(sap.m.ListType.Active);
				return oControl;
			/*				
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="Item" controlType="sap.ui.core.ListItem" dndGroupName="CoreItem" />
			*/
			case "sap.ui.core.ListItem":
				return oControl;
			default:
				return wrap(oControl, oCustomProperties, oControlTemplate, sODataURL);
			}
		},

		_getControlDefault : function(vClassName, sText) {
			switch (vClassName) {
			case "sap.m.Button":
				return {"text": (sText?sText:"New Button")};
			case "sap.m.CheckBox":
				return { text: (sText?sText:"CheckBox") };
			case "sap.m.FormattedText":
				return { htmlText: "<pre>HTML Text</pre>"};
			case "sap.ui.core.Icon":
				return { src: "sap-icon://add-photo"};
			case "sap.m.Image":
				return { src: "./images/TP-Image.png"};
			case "sap.m.Label":
				return { text: (sText?sText:"Label") };
			case "sap.m.Link":
				return { text: (sText?sText:"Link"), enabled: false };
			case "sap.m.Table":
				return {
					columns: [ 
						new sap.m.Column({ header: new ui5app.controls.TableColumn() })
					],
					items: [
						new ui5app.controls.TableRow( { cells: [
							new ui5app.controls.TableCell() 
						] } )
					]
				};
			case "sap.m.TabContainer":
				return { itemSelect: this.showProperties };
			case "sap.m.Text":
				return { text: (sText?sText:"New Text")};
			case "sap.m.TextArea":
				return { value: (sText?sText:"New Text")};
			case "sap.m.Title":
				return { text: (sText?sText:"New Title") };
			case "sap.m.SegmentedButton":
				return { items: [ 	new sap.m.SegmentedButtonItem( { text: "A", press: this.showProperties.bind(this) } ),
									new sap.m.SegmentedButtonItem( { text: "B", press: this.showProperties.bind(this) } ),
									new sap.m.SegmentedButtonItem( { text: "C", press: this.showProperties.bind(this) } )
						 ],
						 customData: [ new sap.ui.core.CustomData( { key: "defaultAggregation", value: "none", writeToDom: true }) ] 
						 };
			/*
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="StandardListItem" controlType="sap.m.StandardListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="DisplayListItem" controlType="sap.m.DisplayListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="ActionListItem" controlType="sap.m.ActionListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="FeedListItem" controlType="sap.m.FeedListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="GroupHeaderListItem" controlType="sap.m.GroupHeaderListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="InputListItem" controlType="sap.m.InputListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="ObjectListItem" controlType="ObjectListItem" dndGroupName="ListItem" />
			*/
			case "sap.m.StandardListItem":
				return { title: (sText?sText:"StandardListItem"), "type": sap.m.ListType.Active };
			case "sap.m.DisplayListItem":
				return { label: (sText?sText:"DisplayListItem"), "type": sap.m.ListType.Active };
			case "sap.m.ActionListItem":
				return { text: (sText?sText:"ActionListItem"), "type": sap.m.ListType.Active };
			case "sap.m.FeedListItem":
				return { text: (sText?sText:"FeedListItem"), "type": sap.m.ListType.Active };
			case "sap.m.GroupHeaderListItem":
				return { title: (sText?sText:"GroupItem"), "type": sap.m.ListType.Active };
			case "sap.m.InputListItem":
				return { label: (sText?sText:"InputListItem"), "type": sap.m.ListType.Active };
			case "sap.m.ObjectListItem":
				return { title: (sText?sText:"ObjectListItem"), "type": sap.m.ListType.Active };
			/*
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="Item" controlType="sap.ui.core.ListItem" dndGroupName="CoreItem" />
			*/
			case "sap.ui.core.ListItem":
				return { text: (sText?sText:"Item") };
			/*
				<rtdi:ToolPaletteButton icon="sap-icon://list" tooltip="List" controlType="sap.m.List" />
				<rtdi:ToolPaletteButton icon="sap-icon://resize-vertical" tooltip="Select" controlType="sap.m.Select" />
				<rtdi:ToolPaletteButton icon="sap-icon://paging" tooltip="Select List" controlType="sap.m.SelectList" />
				<rtdi:ToolPaletteButton icon="sap-icon://slim-arrow-down" tooltip="Combo Box" controlType="sap.m.ComboBox" />
				<rtdi:ToolPaletteButton icon="sap-icon://multiselect-none" tooltip="Multi Combo Box" controlType="sap.m.MultiComboBox" />
			*/
			case "sap.m.List":
				return {"itemPress" : this.showProperties };
			case "sap.m.Select":
				return {"change" : this.showProperties };
			case "sap.m.SelectList":
				return { "itemPress": this.showProperties };
			case "sap.m.ComboBox":
				return { "selectionChange": this.showProperties };
			case "sap.m.MultiComboBox":
				return { "selectionChange": this.showProperties };
			/*
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="StandardListItem" controlType="sap.m.StandardListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="DisplayListItem" controlType="sap.m.DisplayListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="ActionListItem" controlType="sap.m.ActionListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="FeedListItem" controlType="sap.m.FeedListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="GroupHeaderListItem" controlType="sap.m.GroupHeaderListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="InputListItem" controlType="sap.m.InputListItem" dndGroupName="ListItem" />
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="ObjectListItem" controlType="ObjectListItem" dndGroupName="ListItem" />
			*/
			case "sap.m.StandardListItem":
				return { title: (sText?sText:"StandardListItem"), "type": sap.m.ListType.Active };
			case "sap.m.DisplayListItem":
				return { label: (sText?sText:"DisplayListItem"), "type": sap.m.ListType.Active };
			case "sap.m.ActionListItem":
				return { text: (sText?sText:"ActionListItem"), "type": sap.m.ListType.Active };
			case "sap.m.FeedListItem":
				return { text: (sText?sText:"FeedListItem"), "type": sap.m.ListType.Active };
			case "sap.m.GroupHeaderListItem":
				return { title: (sText?sText:"GroupItem"), "type": sap.m.ListType.Active };
			case "sap.m.InputListItem":
				return { label: (sText?sText:"InputListItem"), "type": sap.m.ListType.Active };
			case "sap.m.ObjectListItem":
				return { title: (sText?sText:"ObjectListItem"), "type": sap.m.ListType.Active };
			/*				
				<rtdi:ToolPaletteButton icon="sap-icon://activity-items" tooltip="Item" controlType="sap.ui.core.ListItem" dndGroupName="CoreItem" />
			*/
			case "sap.ui.core.ListItem":
				return { text: (sText?sText:"ObjectListItem") };
			default:
				return {};
			}
		},

	});

});
