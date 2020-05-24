sap.ui.define(
  [
	  'sap/ui/layout/BlockLayoutRow',
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/BlockLayoutCell',
	  'sap/ui/layout/BlockBackgroundType'
	  ],
  function(BlockLayoutRow, JSONModel, BlockLayoutCell) {
  return sap.ui.layout.BlockLayoutRow.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.BlockLayoutRow", {
			metadata : {
				dnd : {
					draggable : false,
					droppable : false
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					columns: { type: "int", defaultValue: 2 }
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.ui.layout.BlockLayoutRow.prototype.init.apply(this, arguments);
				var oView = sap.ui.getCore().byId("mainview");
				var oModel = new JSONModel();
				oModel.setData({ "list": [
					{ "propertyname": "controlid" },
					{ "propertyname": "columns" },
					{ "propertyname": "rowColorSet" },
					{ "propertyname": "scrollable" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.addStyleClass("uieditorbox");
				this.addStyleClass("uieditorhandle");
				this.attachBrowserEvent("dblclick", function(event) {
				    event.stopPropagation();
				    this.fireEvent("showProperties", undefined, true, false);
				    return false;
				}, this);
				this.setColumns(this.getColumns());
				this.attachEvent("showProperties", sap.ui.getCore().byId("mainview").getController().showProperties);
			},
			setColumns : function(value) {
				if (value > 1) {
					this.setProperty("columns", value, true);
					var count = 0;
					if (!!this.getContent()) {
						count = this.getContent().length;
					}
					while (count < value) {
						var oRow = new BlockLayoutCell();
						this.addContent(oRow);
						count++;
					}
					while (count > value) {
						this.removeContent(count-1);
						count--;
					}
				}
			},
			reorderContent : function(oSourceControl, oTargetControl) {
				this.removeContent(oSourceControl);
				if (oTargetControl) {
					var targetindex = this.indexOfContent(oTargetControl);
					this.insertContent(oSourceControl, targetindex);
				} else {
					this.addContent(oSourceControl);
				}
			},
			getParentProperties : function() {
				return sap.ui.layout.BlockLayoutRow.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.ui.layout.BlockLayoutRow.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.ui.layout.BlockLayoutRow.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.ui.layout.BlockLayoutRow.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});