sap.ui.define(
  [
	  'sap/m/FormattedText',
	  'sap/ui/model/json/JSONModel', 
	  'sap/m/LinkConversion', 
	  'sap/m/WrappingType'],
  function(FormattedText, JSONModel) {
  return sap.m.FormattedText.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.FormattedText", {
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
				sap.m.FormattedText.prototype.init.apply(this, arguments);
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
					{ "propertyname": "convertLinksToAnchorTags" },
					{ "propertyname": "convertedLinksDefaultTarget" },
					{ "propertyname": "height" },
					{ "propertyname": "width" },
					{ "propertyname": "htmlText", "showmodelcolumns" : 2 }
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
				return sap.m.FormattedText.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.FormattedText.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.FormattedText.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.FormattedText.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});