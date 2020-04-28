sap.ui.define(
  [
	  'sap/ui/layout/BlockLayoutCell',
	  'sap/ui/model/json/JSONModel'
	  ],
  function(BlockLayoutCell, JSONModel) {
  return sap.ui.layout.BlockLayoutCell.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.BlockLayoutCell", {
			metadata : {
				dnd : {
					draggable : false,
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
				sap.ui.layout.BlockLayoutCell.prototype.init.apply(this, arguments);
				var oView = sap.ui.getCore().byId("mainview");
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
					{ "propertyname": "backgroundColorSet" },
					{ "propertyname": "backgroundColorShade" },
					{ "propertyname": "title" },
					{ "propertyname": "titleAlignment" },
					{ "propertyname": "titleLevel" },
					{ "propertyname": "width" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.addStyleClass("uieditorbox");
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    this.fireEvent("showProperties", undefined, true, false);
				    event.stopPropagation();
				}, this);			
			},
			getParentProperties : function() {
				return sap.ui.layout.BlockLayoutCell.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.ui.layout.BlockLayoutCell.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.ui.layout.BlockLayoutCell.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.ui.layout.BlockLayoutCell.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});