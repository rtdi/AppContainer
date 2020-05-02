sap.ui.define(
  [
	  'sap/m/DateTimePicker', 
	  'sap/ui/model/json/JSONModel'],
  function(DateTimePicker, JSONModel) {
  return sap.m.DateTimePicker.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.DateTimePicker", {
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
				sap.m.DateTimePicker.prototype.init.apply(this, arguments);
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
					{ "propertyname": "minDate" },
					{ "propertyname": "maxDate" },
					{ "propertyname": "secondaryCalendarType" },
					{ "propertyname": "minutesStep" },
					{ "propertyname": "secondsStep" },
					{ "propertyname": "placeholder" },
					{ "propertyname": "name" },
					{ "propertyname": "width" },
					{ "propertyname": "textAlign" },
					{ "propertyname": "valueState" },
					{ "propertyname": "valueStateText" },
					{ "propertyname": "showValueStateMessage" }
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
				return sap.m.DateTimePicker.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.DateTimePicker.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.DateTimePicker.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.DateTimePicker.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});