sap.ui.define(
  [
	  'sap/m/TextArea',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/Wrapping',
	  'sap/ui/core/ValueState'
  ],
  function(TextArea, JSONModel) {
  return sap.m.TextArea.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.TextArea", {
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
				sap.m.TextArea.prototype.init.apply(this, arguments);
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
					{ "propertyname": "value", "showmodelcolumns" : 2 },
					{ "propertyname": "name" },
					{ "propertyname": "cols" },
					{ "propertyname": "rows" },
					{ "propertyname": "height" },
					{ "propertyname": "width" },
					{ "propertyname": "wrapping" },
					{ "propertyname": "textAlign" },
					{ "propertyname": "growing" },
					{ "propertyname": "growingMaxLines" },
					{ "propertyname": "maxLength" },
					{ "propertyname": "placeholder" },
					{ "propertyname": "showExceededText" },
					{ "propertyname": "showValueStateMessage" },
					{ "propertyname": "valueLiveUpdate" },
					{ "propertyname": "valueState" }
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
				return sap.m.TextArea.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.TextArea.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.TextArea.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.TextArea.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});