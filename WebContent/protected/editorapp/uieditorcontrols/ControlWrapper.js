sap.ui.define(
  ['sap/ui/model/json/JSONModel'],
  function(JSONModel) {
  return sap.ui.core.Control.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					_anchor : { type: "boolean", defaultValue: true }
				},
				aggregations: {
					"_control" : {type : "sap.ui.core.Control", multiple : false, visibility: "hidden"}
				},
				events : {
					showProperties : {}
				}
			},
			constructor: function(mSettings) {
				sap.ui.core.Control.apply(this, arguments);
				// var oBindingInfo = sap.ui.core.Control.prototype.getBindingInfo.call(this, "items");
			},
			renderer : function (oRm, oControl) {
				oRm.openStart("div", oControl);
				oRm.write(" style= \"position: relative; width: fit-content; display: inline; white-space: nowrap\" ");
				oRm.openEnd();
				oRm.renderControl(oControl.getAggregation("_control"));
				if (oControl.getProperty("_anchor")) {
					// oRm.write("<img src=\"images/anchor.png\" style=\"width: 10px; position: absolute; right: 0px; bottom: 0px; z-index: 9\" >");
					oRm.write("<img src=\"images/anchor.png\" style=\"width: 10px; z-index: 9\" >");
				}
				oRm.close("div");
			},
			init : function(oChildControl, bAnchor = true, bPreventDefault = false) {
				this.setAggregation("_control", oChildControl);
				this.setProperty("_anchor", bAnchor, true);
				var oAllSettings = oChildControl.getMetadata().getAllProperties();
				if (bAnchor) {
					oChildControl.addStyleClass("uieditorhandle");
				}
				var aPropertyList = [];
				/*
				 * For every property of the child control, create a setter/getter in the wrapper control
				 * which calls the corresponding child methods. 
				 */
				Object.keys(oAllSettings).forEach(function (sName) {
					switch (sName) {
					case "enabled":
					case "visible":
					case "id":
						break;
					default:
						var sSetterName = oAllSettings[sName]._sMutator;
						var sGetterName = oAllSettings[sName]._sGetter;
						this[sSetterName] = function(value) {
							oChildControl[sSetterName].call(oChildControl, value);
						};
						this[sGetterName] = function() {
							return oChildControl[sGetterName].call(oChildControl);
						};
					}
			    }, this );
				/*
				 * The showProperties() should show all properties of the wrapper control minus
				 * a few technical ones.
				 */
				Object.keys(this.getMetadata().getAllProperties()).forEach(function (sName) {
					switch (sName) {
					case "enabled":
					case "visible":
					case "id":
					case "propertiesModel":
					case "blocked":
					case "busy":
					case "busyIndicatorDelay":
					case "busyIndicatorSize":
					case "fieldGroupIds":
					case "modelColumns":
						break;
					default:
						if (sName.charAt(0) !== "_") {
							var oSettings = this.getMetadata().getAllProperties()[sName];
							if (oSettings.appData && oSettings.appData.showmodelcolumns) {
								aPropertyList.push( { "propertyname": sName, "showmodelcolumns": oSettings.appData.showmodelcolumns } );
							} else {
								aPropertyList.push( { "propertyname": sName } );
							}
						}
					}
				}, this );
				var oView = sap.ui.getCore().byId("mainview");
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "controls" });
				var dropinfo = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "controls", 
							"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
							"drop": oView.getController().onDropControl 
						}
				);
				var oModel = new JSONModel();
				oModel.setData({ "list": aPropertyList });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    if (bPreventDefault) {
				    	event.preventDefault();
				    }
				    event.stopPropagation();
				    this.fireEvent("showProperties", undefined, true, false);
				    return false;
				}, this);			
				this.attachEvent("showProperties", sap.ui.getCore().byId("mainview").getController().showProperties);
			},
			_getDefaultsFromSettings : function() {
			    /*
			     * When the control is created via the settings, no method is called, hence none of the item*
			     * values are being set. This code assigns the values.  
			     */
			    var oBindingInfo = sap.ui.core.Control.prototype.getBindingInfo.call(this, "items");
				if (oBindingInfo) {
				    getDefault = function(sName, oTemplate) {
				    	var sText = oTemplate.getBindingPath(sName);
				    	if (!!sText) {
				    		return "{" + sText + "}";
				    	} else {
				    		return "";
				    	}
				    };

				    var sPath = oBindingInfo.path;
					if (sPath.startsWith("{")) {
						sPath = sPath.substring(1, sPath.length-1);
					}
					this.setProperty("oDataItemPath", sPath, true);
					Object.keys(this.getMetadata().getAllProperties()).forEach(function (sName) {
						var oMetadata = this.getMetadata().getAllProperties()[sName];
						if (oMetadata.appData && oMetadata.appData.itemSetting) {
							this.setProperty(sName, getDefault(oMetadata.appData.itemSetting, oBindingInfo.template), true);
						}
					}, this);
					/*
					 * Remove the binding from the wrapper control, it is not supposed to be here but rather on the 
					 * child control.
					 */
					sap.ui.core.Control.prototype.unbindAggregation.call(this, "items");
				}
			},
			getBindingInfo : function(name) {
				var oBindingInfo = this.getAggregation("_control").getBindingInfo(name);
				if (!oBindingInfo) {
				    oBindingInfo = sap.ui.core.Control.prototype.getBindingInfo.call(this, name);
				}
				return oBindingInfo;
			},
			getBindingPath : function(name) {
				var sPath = this.getAggregation("_control").getBindingPath(name);
				if (!sPath) {
					sPath = sap.ui.core.Control.prototype.getBindingPath.call(this, name);
				}
				return sPath;
			},
			getParentProperties : function() {
				return this.getAggregation("_control").getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return this.getAggregation("_control").getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return this.getAggregation("_control").getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return this.getAggregation("_control").getMetadata.apply(this, arguments).getName();
			}

		});
});