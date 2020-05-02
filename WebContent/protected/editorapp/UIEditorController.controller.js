sap.ui.define([ 
	"sap/ui/core/mvc/Controller", 
	"sap/ui/base/DataType",
	"sap/ui/core/XMLTemplateProcessor",
	"io/rtdi/hanaappcontainer/editorapp/libs/XMLHelper/XMLFormatter",
	"sap/ui/model/Sorter",
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Button", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/CheckBox", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ComboBox", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/FormattedText", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Icon", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Image", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Input", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Label", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Link", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/List", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/MaskInput", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/MultiComboBox", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/MultiInput", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/SearchField", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/SegmentedButton", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Select", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/SelectList", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Text", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/TextArea", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Title", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Table",
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/HBox", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/VBox", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/FlexBox", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/BlockLayout", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Carousel", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Panel", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ColorPalette", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ColorPicker", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Currency", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/DatePicker", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/DateRangeSelection", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/DateTimePicker", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/RadioButton", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/RangeSlider", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Slider", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/RatingIndicator", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Switch", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/TimePicker", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/TimePickerSliders", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/StepInput", 
	"io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/PropertyInputControl"
	], function(Controller, DataType, XMLTemplateProcessor, XMLFormatter) {
	"use strict";

	return Controller.extend("io.rtdi.hanaappcontainer.editorapp.UIEditorController", {
		onInit : function() {
			var oView = sap.ui.getCore().byId("mainview");
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
			var oOpenFileLink = oView.byId("openfile");
			if (sFilename.endsWith(".view.xml")) {
				oOpenFileLink.setHref("../hanarepo/%5Bcurrentuser%5D/" + sFilename.substring(0, sFilename.length-9) + ".html");
			}
			
			var that = this;
			var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		        if (this.readyState == 4 && this.status == 200) {
					var parser = new DOMParser();
					var xmlView = parser.parseFromString(JSON.parse(this.responseText).content, "text/xml");					
					that._buildContentTree(xmlView.documentElement, that);
		        }
		    };
		    xhttp.open("GET", "../rest/editorapp/file/" + sFilename, true);
		    xhttp.setRequestHeader("Content-type", "application/xml");
		    xhttp.send();
		    var oModel = new sap.ui.model.odata.v4.ODataModel({
		    		serviceUrl : "/HanaAppContainer/protected/catalog/odataendpoints/", 
		    		"autoExpandSelect": true,
					"operationMode": "Server",
					"groupId": "$direct",
					"synchronizationMode": "None"
		    });
		    var oModelControl = oView.byId("odatamodels");
		    oModelControl.setModel(oModel);
		    
		    var oModelSchema = new sap.ui.model.odata.v4.ODataModel({
	    		serviceUrl : "/HanaAppContainer/protected/odata/SYS/SCHEMAS/", 
	    		"autoExpandSelect": true,
				"operationMode": "Server",
				"groupId": "$direct",
				"synchronizationMode": "None"
		    });
		    var oModelSchemaControl = oView.byId("odatamodelschema");
		    oModelSchemaControl.setModel(oModelSchema);
		    
			var oBinding = oModelControl.getBinding("items");
			oBinding.sort( [ new sap.ui.model.Sorter("SCHEMA_NAME"), new sap.ui.model.Sorter("OBJECT_NAME") ] );
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
				aFilter.push(new sap.ui.model.Filter("OBJECT_NAME", sap.ui.model.FilterOperator.Contains, sSearch));
			}
			if (sSchema) {
				aFilter.push(new sap.ui.model.Filter("SCHEMA_NAME", sap.ui.model.FilterOperator.EQ, sSchema));
			}
			oBinding.filter(aFilter, "Application");
		},
		_buildContentTree : function(vNode, controller) {
			var oView = sap.ui.getCore().byId("mainview");
			var oEditor = oView.byId("editor");
			var aControls = this._buildContentTreeAggregation(vNode.childNodes, this.showProperties);
			for (var i=0; i<aControls.length; i++) {
				oEditor.addContent(aControls[i]);
			}
		},
		_buildContentTreeControl : function(node, sClassName, showProperties) {
			var oClass = this._getClass(sClassName);
			if (oClass) {
				var oAllSettings = oClass.getMetadata().getAllSettings();
				var sDefaultAggregation = oClass.getMetadata().defaultAggregation;
				var oSettings = {};
				for (var i = 0; i < node.attributes.length; i++) {
					var attribute = node.attributes[i];
					var sAttributeName = attribute.localName;
					if (sAttributeName === "id") {
						sAttributeName = "controlid";
					}
					var vType = oAllSettings[sAttributeName].type;
					oSettings[sAttributeName] = this._convertScalarDatatype(vType, attribute.value);
				}
				oSettings["showProperties"] = showProperties;
				var nodes = node.childNodes;
				for (var i = 0; i < nodes.length; i++) {
					var node = nodes[i];
					if (node instanceof Element) {
						var aggregationname = node.localName;
						if (oAllSettings[aggregationname]) {
							oSettings[aggregationname] = this._buildContentTreeAggregation(node.childNodes, showProperties);
						} else {
							// default aggregation
							if (oSettings[aggregationname]) {
								oSettings[aggregationname] = [];
							}
							oSettings[aggregationname].push(this._buildContentTreeControl(node, sClassName, showProperties));
						}
					}
				}
				return new oClass( oSettings );
			}
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
		onDropModel : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			var oView = sap.ui.getCore().byId("mainview");
			if (oSourceControl.getParent().getId() === "mainview--odatamodels") {
				/*
				 * A oData model has been dropped over a control.
				 * The corresponding view element shows SCHEMA_NAME and OBJECT_NAME but
				 * has a first custom data element with the oData URL.
				 */
				if ('setODataURL' in oTargetControl) {
					var sEndpoint = oSourceControl.getCustomData()[0].getValue();
					oTargetControl.setODataURL(sEndpoint);
					
					/*
					 * Empty the properties table as the drop does refresh some
					 * values, some in an async fashion.
					 */
					var oView = sap.ui.getCore().byId("mainview");
					var oPropertiesTable = oView.byId("properties");
					oPropertiesTable.setModel(new sap.ui.model.json.JSONModel());
				}
			}
		},
		onDropControl : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			var oView = sap.ui.getCore().byId("mainview");
			
			var oControl = null;
			var istemplate = false;
			/*
			 * When the controls are part of a template, not the controls themselves
			 * are modified but their template structure.
			 */
			oSourceControl = oView.getController().findTemplate(oSourceControl);
			var oTargetControlTemplate = oView.getController().findTemplate(oTargetControl);
			if (oTargetControlTemplate !== oTargetControl) {
				oTargetControl = oTargetControlTemplate;
				istemplate = true;
			}
			
			if (oSourceControl.getParent().getId().startsWith("mainview--toolbar")) { // an element of the toolbar
				var cClass = oView.getController()._getClass(oSourceControl.getControlType());
				var oSettings = oView.getController()._getControlDefault(oSourceControl.getControlType());
				if (cClass) {
					oControl = new cClass(oSettings);
					if (oControl != null) {
						if ("addContent" in oTargetControl) {
							oTargetControl.addContent(oControl);
						} else if (oTargetControl instanceof sap.m.Column) {
							var oTable = oTargetControl.getParent();
							var index = oTable.indexOfColumn(oTargetControl);
							oTable.insertContent(oControl, index);
						} else {
							sap.m.MessageToast.show("Drop Target does not allow adding children");
						}
						if (istemplate) {
							/*
							 * Rebind only if template was modified
							 */
							oView.getController()._triggerRebind(oTargetControl);
						}
					}
				} else {
					sap.m.MessageToast.show("Control not yet supported");
				}
			} else {
				var itemcontainer = oSourceControl.getParent();
				if (oSourceControl == oTargetControl) {
					// Do nothing is the object is dropped over itself
				} else if (oSourceControl.getParent() === oTargetControl.getParent()) {
					// reorder within collection, insert the dragged control before the dropped control
					if ("reorderContent" in itemcontainer) {
						itemcontainer.reorderContent(oSourceControl, oTargetControl);
					}
				} else if (oSourceControl.getParent() === oTargetControl) {
					// move dragged control to the end of the container
					if ("addContent" in oTargetControl) {
						itemcontainer.reorderContent(oSourceControl, undefined);
					}
				} else if (oTargetControl.getId() === "mainview--delete") {
					// source control dropped over the trash can palette icon
					var itemcontainer = oSourceControl.getParent();
					if ("removeContent" in itemcontainer) {
						itemcontainer.removeContent(oSourceControl);
					}
				} else {
					sap.m.MessageToast.show("Not a valid drop target");
				}
				oView.getController()._triggerRebind(itemcontainer);
			}
		},
		findTemplate : function(oControl) {
			/*
			 * When a control created from a template is modified, this function
			 * finds the matching template control in order to modify this instead.
			 */
			var aIndex = [];
			var oParent = oControl.getParent();
			var oLastControl = oControl;
			while (oParent && !("getTemplate" in oParent) ) {
				var index = -1;
				if ("indexOfContent" in oParent) {
					index = oParent.indexOfContent(oLastControl);
				} else if ("indexOfCell" in oParent) {
					index = oParent.indexOfCell(oLastControl);
				}
				aIndex.push(index);
				oLastControl = oParent;
				oParent = oParent.getParent();
			}
			if (oParent && aIndex.length > 0 && oParent.indexOfTemplate(oLastControl) != -1) {
				/*
				 * Yes, there is a template and the control is part of the template and not e.g. a toolbar control
				 */
				var oTemplate = oParent.getTemplate();
				if (oTemplate) {
					for (var i=aIndex.length-1; i>=0; i--) {
						if ("getContent" in oTemplate) {
							oTemplate = oTemplate.getContent(aIndex[i]);
						} else if ("getCells" in oTemplate) {
							oTemplate = oTemplate.getCells()[aIndex[i]];
						}
					}
					if (oTemplate) {
						return oTemplate;
					} else {
						/*
						 * The control is part of the table but not a template
						 */
						return oControl;
					}
				}
			}
			return oControl;
		},
		_triggerRebind : function(oControl) {
			/*
			 * Find out if the control is part of a template. If yes, rebind its template
			 * to make sure the change gets reflected in all items.
			 */
			while (oControl && !('rebindTemplate' in oControl)) {
				/*
				 * In case the updated control is part of a template, the template needs a unbind/bind call
				 * to update all controls.
				 */
				if (oControl.getParent()) {
					oControl = oControl.getParent();
				} else {
					/*
					 * In case a control of a template was provided, then the template row
					 * does not have the table as parent. But it has a custom data property.
					 * Maybe such element is found.
					 */
					if ("data" in oControl) {
						oControl = oControl.data("templateFor");
					} else {
						oControl = undefined;
					}
				}
			}
			if (oControl && "rebindTemplate" in oControl) {
				oControl.rebindTemplate();
			}
		},
		showProperties : function(oEvent) {
			var oView = sap.ui.getCore().byId("mainview");
			var oSourceControl = oEvent.getSource();
			var oPropertiesTable = oView.byId("properties");
			
			/*
			 * The selected item might be one generated out of a template, e.g. one row of a table.
			 * In that case we want to show the template control's properties of course.
			 */
			oSourceControl = oView.getController().findTemplate(oSourceControl);
			var oCurrentShownControl = oPropertiesTable.data("control");
			// if (oSourceControl !== oCurrentShownControl) {
				oPropertiesTable.data("control", oSourceControl);
				if ('getPropertiesModel' in oSourceControl) {
					var oAllProperties = oSourceControl.getMetadata().getAllProperties();
					var oModel = oSourceControl.getPropertiesModel();
					oModel.setProperty("/classname", oSourceControl.getParentClassName());
					var aProps = oModel.getProperty("/list");
					aProps.forEach( function(oItem, index) {
						if (oAllProperties[oItem.propertyname]) {
							var method = oAllProperties[oItem.propertyname]._sGetter;
							/*
							 * When the property is bound, this has preference over the literal value
							 */
							var value = oSourceControl.getBindingPath(oItem.propertyname);
							if (value) {
								value = "{" + value + "}";
							} else {
								value = oSourceControl[method].call(oSourceControl);
							}
							var datatype = oAllProperties[oItem.propertyname].getType();
							oModel.setProperty("/list/" + index + "/propertyvalue", value);
							oModel.setProperty("/list/" + index + "/propertydatatype", datatype);
						} else {
							console.log(oSourceControl.getParentClassName() + " does not have a getter for property " + oItem.propertyname);
						}
					});
					oPropertiesTable.setModel(oModel);
				} else {
					oPropertiesTable.setModel(new sap.ui.model.json.JSONModel());
				}
			// }
		},
		updateProperties : function(oEvent) {
			var oView = sap.ui.getCore().byId("mainview");
			var oPropertiesTable = oView.byId("properties");
			var oModel = oPropertiesTable.getModel();
			var aRows = oModel.getProperty("/list");
			var oSourceControl = oPropertiesTable.data("control");
			if (!!oSourceControl) {
				var oAllProperties = oSourceControl.getMetadata().getAllProperties();
				aRows.forEach(function(oItem){
					var sSetter = oAllProperties[oItem.propertyname]._sMutator;
					var sGetter = oAllProperties[oItem.propertyname]._sGetter;
					if (!!sGetter) {
						var currentvalue = oSourceControl[sGetter].call(oSourceControl);
						var newvalue = oItem.propertyvalue;
						if (currentvalue != newvalue) {
							/*
							 * Update the value and the binding. Setting a 
							 * value of "{name}" is not sufficient to trigger a binding creation.
							 */
							oSourceControl[sSetter].call(oSourceControl, newvalue);
							if ((typeof newvalue === 'string' || newvalue instanceof String) && newvalue.startsWith("{")) {
								// TODO: reuse control creation code
								oSourceControl.bindProperty(oItem.propertyname, { path: newvalue.substring(1, newvalue.length-1) } );
							} else {
								oSourceControl.unbindProperty(oItem.propertyname);
							}
						}
					} else {
						  alert('Code Error: The control has no property named "' + row.propertyname + '"');
					}
				});
				oView.getController()._triggerRebind(oSourceControl);
			}
		},
		saveAsXmlView : function() {
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
		    if (!!sFilename) {
				var buffer = [];
				var oEditor = sap.ui.getCore().byId("mainview--editor");
				oEditor.getContent().forEach(function(oItem, index) {
					XMLFormatter.generateXML(oItem, buffer, 1);
				});
				var viewcontent = '<mvc:View height="100%" class="sapUiSizeCompact"\r\n' +
						'    xmlns:mvc="sap.ui.core.mvc"\r\n' + 
						'    xmlns:sap.m="sap.m"\r\n' + 
						'    xmlns:sap.ui.layout="sap.ui.layout"\r\n' + 
						'    xmlns:sap.ui.core.dnd="sap.ui.core.dnd" \r\n' +
						'    xmlns:sap.ui.core="sap.ui.core">\r\n' + 
						buffer.join("") +
						'</mvc:View>';
				var xhttp = new XMLHttpRequest();
			    xhttp.onreadystatechange = function() {
			         if (this.readyState == 4 ) {
			        	 if (this.status == 200) {
			        		 // saved
			         	 } else {
				             alert(this.responseText);
			         	 }
			         }
			    };
			    xhttp.open("POST", "../rest/editorapp/file/" + sFilename, true); 
			    xhttp.setRequestHeader("Content-type", "text/plain");
			    xhttp.send(viewcontent);
		    } else {
		    	alert("No filename parameter provided in the URL");
		    }
		},
		_getControlDefault : function(vClassName) {
			switch (vClassName) {
			case "sap.m.Button":
				return {"text": "New Button"};
			case "sap.m.CheckBox":
				return { text: "CheckBox" };
			case "sap.m.FormattedText":
				return { htmlText: "<pre>HTML Text</pre>"};
			case "sap.ui.core.Icon":
				return { src: "sap-icon://add-photo"};
			case "sap.m.Image":
				return { src: "./images/TP-Image.png"};
			case "sap.m.Label":
				return { text: "Label" };
			case "sap.m.Link":
				return { text: "Link" };
			case "sap.m.MaskInput":
				return { 
						placeholder:"Mask Input", 
						mask: "***-***", 
						regex: "[a-zA-Z0-9]", 
						placeholderSymbol: "_", 
						maskFormatSymbol: "*" 
					};
			case "sap.m.MultiComboBox":
				return { oDataURL: "", itemText: "Item" };
			case "sap.m.SegmentedButton":
				return { buttonCount: 3 };
			case "sap.m.Select":
				return { oDataURL: "", itemText: "Item" };
			case "sap.m.SelectList":
				return { oDataURL: "", itemText: "Item" };
			case "sap.m.Table":
				return { headerText: "New Table" };
			case "sap.m.Text":
				return { text: "New Text"};
			case "sap.m.TextArea":
				return { value: "New Text"};
			case "sap.m.Title":
				return { text: "New Title" };
			default:
				return undefined;
			}
		},
		_getClass : function(vClassName) {
			switch (vClassName) {
			case "sap.m.Button":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Button;
			case "sap.m.CheckBox":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.CheckBox;
			case "sap.m.ComboBox":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ComboBox;
			case "sap.m.FormattedText":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.FormattedText;
			case "sap.ui.core.Icon":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Icon;
			case "sap.m.Image":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Image;
			case "sap.m.Input":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Input;
			case "sap.m.Label":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Label;
			case "sap.m.Link":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Link;
			case "sap.m.List":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.List;
			case "sap.m.MaskInput":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.MaskInput;
			case "sap.m.MultiComboBox":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.MultiComboBox;
			case "sap.m.MultiInput":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.MultiInput;
			case "sap.m.SearchField":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.SearchField;
			case "sap.m.SegmentedButton":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.SegmentedButton;
			case "sap.m.Select":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Select;
			case "sap.m.SelectList":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.SelectList;
			case "sap.m.Table":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Table;
			case "sap.m.Text":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Text;
			case "sap.m.TextArea":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.TextArea;
			case "sap.m.Title":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Title;
			case "sap.m.HBox":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.HBox;
			case "sap.m.VBox":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.VBox;
			case "sap.m.FlexBox":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.FlexBox;
			case "sap.ui.layout.BlockLayout":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.BlockLayout;
			case "sap.m.Carousel":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Carousel;
			case "sap.m.Panel":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Panel;
			case "sap.m.ColorPalette":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ColorPalette;
			case "sap.ui.unified.ColorPicker":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ColorPicker;
			case "sap.ui.unified.Currency":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Currency;
			case "sap.m.DatePicker":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.DatePicker;
			case "sap.m.DateRangeSelection":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.DateRangeSelection;
			case "sap.m.DateTimePicker":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.DateTimePicker;
			case "sap.m.RadioButton":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.RadioButton;
			case "sap.m.RangeSlider":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.RangeSlider;
			case "sap.m.Slider":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Slider;
			case "sap.m.RatingIndicator":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.RatingIndicator;
			case "sap.m.Switch":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Switch;
			case "sap.m.TimePicker":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.TimePicker;
			case "sap.m.TimePickerSliders":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.TimePickerSliders;
			case "sap.m.StepInput":
				return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.StepInput;
			default:
				return undefined;
			}

		}

	});

});
