sap.ui.define(
  ['sap/m/Slider', 'sap/ui/model/json/JSONModel'],
  function(Slider, JSONModel) {
  return sap.m.Slider.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Slider", {
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
				sap.m.Slider.prototype.init.apply(this, arguments);
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
					{ "propertyname": "enableTickmarks" },
					{ "propertyname": "width" },
					{ "propertyname": "min" },
					{ "propertyname": "max" },
					{ "propertyname": "showHandleTooltip" },
					{ "propertyname": "step" },
					{ "propertyname": "value" }
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
				return sap.m.Slider.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.Slider.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.Slider.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.Slider.prototype.getMetadata.apply(this, arguments).getName();
			}

		});
});