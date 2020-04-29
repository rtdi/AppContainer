sap.ui.define(
  [
	  'sap/ui/layout/BlockLayout',
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/BlockLayoutRow',
	  'sap/ui/layout/BlockBackgroundType'
	  ],
  function(BlockLayout, JSONModel, BlockLayoutRow) {
  return sap.ui.layout.BlockLayout.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.BlockLayout", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					rows: { type: "int", defaultValue: "2" }
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.ui.layout.BlockLayout.prototype.init.apply(this, arguments);
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
					{ "propertyname": "background" },
					{ "propertyname": "rows" }
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
				this.setRows(getRows());
			},
			setRows : function(value) {
				if (value > 1) {
					var oView = sap.ui.getCore().byId("mainview");
					this.setProperty("rows", value, true);
					var count = 0;
					if (!!this.getContent()) {
						count = this.getContent().length;
					}
					while (count < value) {
						var oRow = new BlockLayoutRow();
						oRow.attachEvent("showProperties", oView.getController().showProperties);
						this.addContent(oRow);
						count++;
					}
					while (count > value) {
						this.removeContent(count-1);
						count--;
					}
				}
			},
			getParentProperties : function() {
				return sap.ui.layout.BlockLayout.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.ui.layout.BlockLayout.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.ui.layout.BlockLayout.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.ui.layout.BlockLayout.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});