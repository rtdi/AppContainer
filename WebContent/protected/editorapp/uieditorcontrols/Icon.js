sap.ui.define(
  [
	  'sap/ui/core/Icon',
	  'sap/ui/model/json/JSONModel'],
  function(Icon, JSONModel) {
  return sap.ui.core.Icon.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Icon", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" }
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.ui.core.Icon.prototype.init.apply(this, arguments);
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
					{ "propertyname": "src", "showmodelcolumns" : 2 },
					{ "propertyname": "color" },
					{ "propertyname": "activeColor" },
					{ "propertyname": "hoverColor" },
					{ "propertyname": "backgroundColor" },
					{ "propertyname": "hoverBackgroundColor" },
					{ "propertyname": "alt", "showmodelcolumns" : 2 },
					{ "propertyname": "decorative" },
					{ "propertyname": "height" },
					{ "propertyname": "width" },
					{ "propertyname": "size" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    event.stopPropagation();
				    this.fireEvent("showProperties", undefined, true, false);
				    return false;
				}, this);			
				this.attachEvent("showProperties", sap.ui.getCore().byId("mainview").getController().showProperties);
			},
			getParentProperties : function() {
				return sap.ui.core.Icon.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.ui.core.Icon.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.ui.core.Icon.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.ui.core.Icon.prototype.getMetadata.apply(this, arguments).getName();
			}

		});
});