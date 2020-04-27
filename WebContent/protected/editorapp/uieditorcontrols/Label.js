sap.ui.define(
  [
	  'sap/m/Label', 
	  'sap/ui/model/json/JSONModel',
	  'sap/m/LabelDesign', 
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/VerticalAlign'],
  function(Label, JSONModel) {
  return sap.m.Label.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Label", {
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
				sap.m.Label.prototype.init.apply(this, arguments);
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
					{ "propertyname": "text", "showmodelcolumns" : 2 },
					{ "propertyname": "design" },
					{ "propertyname": "required" },
					{ "propertyname": "width" },
					{ "propertyname": "textAlign" },
					{ "propertyname": "vAlign" },
					{ "propertyname": "wrapping" },
					{ "propertyname": "wrappingType" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    this.fireEvent("showProperties", undefined, true, false);
				    event.stopPropagation();
				}, this);			
			},
			getParentProperties : function() {
				return sap.m.Label.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.Label.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.Label.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.Label.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});