sap.ui.define(
  [
	  'sap/m/Panel',
	  'sap/ui/model/json/JSONModel', 
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/OverflowToolbar'
	  ],
  function(Panel, JSONModel, dOverflowToolbar) {
  return sap.m.Panel.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Panel", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					showHeaderToolbar: {type: "boolean", defaultValue: false},
					showInfoToolbar: {type: "boolean", defaultValue: false}
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.m.Panel.prototype.init.apply(this, arguments);
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
				oModel.setData({ "list": [
					{ "propertyname": "controlid" },
					{ "propertyname": "headerText" },
					{ "propertyname": "height" },
					{ "propertyname": "width" },
					{ "propertyname": "backgroundDesign" },
					{ "propertyname": "showHeaderToolbar" },
					{ "propertyname": "showInfoToolbar" },
					{ "propertyname": "expandable" },
					{ "propertyname": "expanded" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.addStyleClass("uieditorbox");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    event.stopPropagation();
				    this.fireEvent("showProperties", undefined, true, false);
				    return false;
				}, this);			
				this.attachEvent("showProperties", sap.ui.getCore().byId("mainview").getController().showProperties);
			},
			reorderContent : function(oSourceControl, oTargetControl) {
				this.removeContent(oSourceControl);
				if (oTargetControl) {
					var targetindex = this.indexOfContent(oTargetControl);
					this.insertContent(oSourceControl, targetindex);
				} else {
					this.addContent(oSourceControl);
				}
			},
			setShowHeaderToolbar : function(vToolbar) {
				this.setProperty("showHeaderToolbar", vToolbar, true);
				// The toolbar needs to be saved elsewhere and removed from the control, else it does not show the table text again
				var vToolbarControl = this.getHeaderToolbar();
				var vToolbarControlBackup = this.data("headertoolbar");
				if (vToolbar) {
					if (!!vToolbarControlBackup) {
						this.setHeaderToolbar(vToolbarControlBackup);
					} else {
						this.setHeaderToolbar(new dOverflowToolbar());
					}
				} else {
					this.data("headertoolbar", vToolbarControl);
					this.destroyHeaderToolbar();
				}
			},
			setShowInfoToolbar : function(vToolbar) {
				this.setProperty("showInfoToolbar", vToolbar, true);
				// The toolbar needs to be saved elsewhere and removed from the control, else it does not show the table text again
				var vToolbarControl = this.getInfoToolbar();
				var vToolbarControlBackup = this.data("infotoolbar");
				if (vToolbar) {
					if (!!vToolbarControlBackup) {
						this.setInfoToolbar(vToolbarControlBackup);
					} else {
						this.setInfoToolbar(new dOverflowToolbar());
					}
				} else {
					this.data("infotoolbar", vToolbarControl);
					this.destroyInfoToolbar();
				}
			},
			getParentProperties : function() {
				return sap.m.Panel.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.Panel.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.Panel.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.Panel.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});