sap.ui.define(
  [
	  'sap/m/Input',
	  'sap/ui/model/json/JSONModel', 
	  'sap/ui/core/TextAlign',
	  'sap/m/InputTextFormatMode',
	  'sap/m/InputType',
	  'sap/ui/core/ValueState'],
  function(Input, JSONModel) {
  return sap.m.Input.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Input", {
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
				sap.m.Input.prototype.init.apply(this, arguments);
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
					{ "propertyname": "description", "showmodelcolumns" : 2 },
					{ "propertyname": "name" },
					{ "propertyname": "value", "showmodelcolumns" : 2 },
					{ "propertyname": "type" },
					{ "propertyname": "autocomplete" },
					{ "propertyname": "width" },
					{ "propertyname": "fieldWidth" },
					{ "propertyname": "textAlign" },
					{ "propertyname": "textFormatMode" },
					{ "propertyname": "maxLength" },
					{ "propertyname": "filterSuggests" },
					{ "propertyname": "enableSuggestionsHighlighting" },
					{ "propertyname": "showSuggestion" },
					{ "propertyname": "showTableSuggestionValueHelp" },
					{ "propertyname": "showValueHelp" },
					{ "propertyname": "showValueStateMessage" },
					{ "propertyname": "startSuggestion" },
					{ "propertyname": "maxSuggestionWidth" },
					{ "propertyname": "valueLiveUpdate" },
					{ "propertyname": "valueState" },
					{ "propertyname": "valueStateText" }
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
				return sap.m.Input.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.Input.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.Input.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.Input.prototype.getMetadata.apply(this, arguments).getName();
			}

		});
});