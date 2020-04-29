sap.ui.define(
  [
	  'sap/m/MultiInput',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign', 
	  'sap/m/InputTextFormatMode',
	  'sap/m/InputType', 
	  'sap/ui/core/ValueState',
	  'sap/ui/core/Item',
	  'sap/m/Token'],
  function(MultiInput, JSONModel) {
  return sap.m.MultiInput.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.MultiInput", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					oDataURL: { type: "String", defaultValue: "" }
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.m.MultiInput.prototype.init.apply(this, arguments);
				var oView = sap.ui.getCore().byId("mainview");
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "controls" });
				var dropinfo = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "controls", 
							"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
							"drop": oView.getController().onDropControl 
						}
				);
				
				this.setTokens([
					new sap.m.Token({text: "Token 1", key: "0001"}),
					new sap.m.Token({text: "Token 2", key: "0002"})
				]);
				this.addValidator(function(args){
					var text = args.text;
					return new sap.m.Token({key: text, text: text});
				});
				
				for (var i=1; i<5; i++) {
					this.addSuggestionItem(new sap.ui.core.Item( { text: "Token " + i, key: "000" + i } ));
				}
				var oModel = new JSONModel();
				oModel.setData({ "list": [
					{ "propertyname": "controlid" },
					{ "propertyname": "description", "showmodelcolumns" : 2 },
					{ "propertyname": "enableSuggestionsHighlighting" },
					{ "propertyname": "oDataURL" },
					{ "propertyname": "autocomplete" },
					{ "propertyname": "name" },
					{ "propertyname": "fieldWidth" },
					{ "propertyname": "width" },
					{ "propertyname": "filterSuggests" },
					{ "propertyname": "maxLength" },
					{ "propertyname": "maxSuggestionWidth" },
					{ "propertyname": "maxTokens" },
					{ "propertyname": "placeholder" },
					{ "propertyname": "showSuggestion" },
					{ "propertyname": "showTableSuggestionValueHelp" },
					{ "propertyname": "showValueHelp" },
					{ "propertyname": "showValueStateMessage" },
					{ "propertyname": "startSuggestion" },
					{ "propertyname": "textAlign" },
					{ "propertyname": "textFormatMode" },
					{ "propertyname": "type" },
					{ "propertyname": "value", "showmodelcolumns" : 2 },
					{ "propertyname": "valueHelpOnly" },
					{ "propertyname": "valueLiveUpdate" },
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
			},
			getParentProperties : function() {
				return sap.m.MultiInput.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.MultiInput.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.MultiInput.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.MultiInput.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});