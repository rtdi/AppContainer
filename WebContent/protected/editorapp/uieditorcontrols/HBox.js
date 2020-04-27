sap.ui.define(
  [
	  'sap/m/HBox',
	  'sap/ui/model/json/JSONModel',
	  'sap/m/FlexAlignContent', 
	  'sap/m/FlexAlignItems',
	  'sap/m/BackgroundDesign', 
	  'sap/m/FlexDirection', 
	  'sap/m/FlexJustifyContent',
	  'sap/m/FlexWrap'
	  ],
  function(HBox, JSONModel) {
  return sap.m.HBox.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.HBox", {
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
				sap.m.HBox.prototype.init.apply(this, arguments);
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
					{ "propertyname": "height" },
					{ "propertyname": "width" },
					{ "propertyname": "alignContent" },
					{ "propertyname": "alignItems" },
					{ "propertyname": "backgroundDesign" },
					{ "propertyname": "direction" },
					{ "propertyname": "fitContainer" },
					{ "propertyname": "justifyContent" },
					{ "propertyname": "wrap" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.addStyleClass("uieditorbox");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    this.fireEvent("showProperties", undefined, true, false);
				    event.stopPropagation();
				}, this);			
			},
			addContent : function(vContent) {
				this.addItem(vContent);
			},
			getContent : function(index) {
				return this.getItems()[index];
			},
			removeContent : function(vContent) {
				this.removeItem(vContent);
			},
			reorderContent : function(oSourceControl, oTargetControl) {
				this.removeItem(oSourceControl);
				var targetindex = this.indexOfContent(oTargetControl);
				this.insertContent(oSourceControl, targetindex);
			},
			insertContent : function(vContent, vIndex) {
				this.insertItem(vContent, vIndex);
			},
			indexOfContent : function(vContent) {
				return this.indexOfItem(vContent);
			},
			getParentProperties : function() {
				return sap.m.HBox.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.HBox.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.HBox.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.HBox.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});