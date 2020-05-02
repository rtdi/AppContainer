sap.ui.define(
  [
	  'sap/m/VBox',
	  'sap/ui/model/json/JSONModel',
	  'sap/m/FlexAlignContent', 
	  'sap/m/FlexAlignItems',
	  'sap/m/BackgroundDesign', 
	  'sap/m/FlexDirection', 
	  'sap/m/FlexJustifyContent',
	  'sap/m/FlexWrap'
	  ],
  function(VBox, JSONModel) {
  return sap.m.VBox.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.VBox", {
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
				sap.m.VBox.prototype.init.apply(this, arguments);
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
				this.addStyleClass("uieditorhandle");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    event.stopPropagation();
				    this.fireEvent("showProperties", undefined, true, false);
				    return false;
				}, this);			
				this.attachEvent("showProperties", sap.ui.getCore().byId("mainview").getController().showProperties);
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
				return sap.m.VBox.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.VBox.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.VBox.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.VBox.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});