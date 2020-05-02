sap.ui.define(
  ['sap/m/StepInput', 'sap/ui/model/json/JSONModel'],
  function(StepInput, JSONModel) {
  return sap.m.StepInput.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.StepInput", {
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
				sap.m.StepInput.prototype.init.apply(this, arguments);
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
					{ "propertyname": "description" },
					{ "propertyname": "width" },
					{ "propertyname": "displayValuePrecision" },
					{ "propertyname": "fieldWidth" },
					{ "propertyname": "largerStep" },
					{ "propertyname": "min" },
					{ "propertyname": "max" },
					{ "propertyname": "name" },
					{ "propertyname": "placeholder" },
					{ "propertyname": "step" },
					{ "propertyname": "stepMode" },
					{ "propertyname": "textAlign" },
					{ "propertyname": "value" },
					{ "propertyname": "valueState" },
					{ "propertyname": "valueStateText" }
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
				return sap.m.StepInput.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.StepInput.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.StepInput.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.StepInput.prototype.getMetadata.apply(this, arguments).getName();
			}

		});
});