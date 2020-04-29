sap.ui.define(
  [
	  'sap/m/Table', 
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Text', 
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/HBox', 
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/OverflowToolbar', 
	  'sap/ui/model/json/JSONModel', 
	  'sap/m/Column', 
	  'sap/m/ColumnListItem',
	  'sap/m/BackgroundDesign',
	  'sap/m/ListGrowingDirection',
	  'sap/m/ListMode'
	  ],
  function(
		  Table, 
		  dText, 
		  dHBox, 
		  dOverflowToolbar,
		  JSONModel, 
		  Column) {
  return sap.m.Table.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Table", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					oDataURL: { type: "String", defaultValue: "" },
					oDataItemPath: { type: "String", defaultValue: "" },
					showHeaderToolbar: {type: "Boolean", defaultValue: false},
					showInfoToolbar: {type: "Boolean", defaultValue: false},
					_modelColumns: { type: "Object", defaultValue: undefined }
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.m.Table.prototype.init.apply(this, arguments);
				var oView = sap.ui.getCore().byId("mainview");
				var draginfo1 = new sap.ui.core.dnd.DragInfo({ "groupName": "controls", "sourceAggregation": "columns" });
				var draginfo2 = new sap.ui.core.dnd.DragInfo({ "groupName": "controls" });
				var dropinfo1 = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "controls", 
							"dropPosition": sap.ui.core.dnd.DropPosition.On,
							"drop": oView.getController().onDropControl,
							"targetAggregation": "columns"
						}
				);
				var dropinfo2 = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "model", 
							"dropPosition": sap.ui.core.dnd.DropPosition.On,
							"drop": oView.getController().onDropModel
						}
				);
				this.insertDragDropConfig(draginfo1);
				this.insertDragDropConfig(draginfo2);
				this.insertDragDropConfig(dropinfo1);
				this.insertDragDropConfig(dropinfo2);
				this.addNewColumn(5);
				var oModel = new JSONModel();
				oModel.setData({ "list": [
					{ "propertyname": "controlid" },
					{ "propertyname": "headerText", "showmodelcolumns" : 2 },
					{ "propertyname": "footerText", "showmodelcolumns" : 2 },
					{ "propertyname": "showHeaderToolbar" },
					{ "propertyname": "showInfoToolbar" },
					{ "propertyname": "oDataURL" },
					{ "propertyname": "oDataItemPath" },
					{ "propertyname": "alternateRowColors" },
					{ "propertyname": "backgroundDesign" },
					{ "propertyname": "fixedLayout" },
					{ "propertyname": "growing" },
					{ "propertyname": "growingDirection" },
					{ "propertyname": "growingScrollToLoad" },
					{ "propertyname": "growingThreshold" },
					{ "propertyname": "inset" },
					{ "propertyname": "mode" },
					{ "propertyname": "showUnread" },
					{ "propertyname": "width" }
				] });
				this.setProperty("propertiesModel", oModel, true);
				this.attachBrowserEvent("dblclick", function(event) {
				    event.stopPropagation();
				    this.fireEvent("showProperties", undefined, true, false);
				    return false;
				}, this);			
			},
			addNewColumn : function(iCount = 1) {
				while (iCount > 0) {
					var oColumnheader = new dText({text : "Column" } );
					oColumnheader.attachEvent("showProperties", function(oEvent) {
						var oView = sap.ui.getCore().byId("mainview");
						oView.getController().showProperties(oEvent);
					});
					this.addColumn(new sap.m.Column({ header: [ oColumnheader ] }));
					iCount--;
				}
				this._refreshTemplate();
			},
			_refreshTemplate : function() {
				var oRow;
				if (this.getModel()) {
					if (this.getBinding("items")) {
						oRow = this.data("template");
					}
					if (!oRow) {
						oRow = new sap.m.ColumnListItem();
						this.data("template", oRow);
						oRow.data("templateFor", this);
					}
					var aCells = oRow.getCells();
					var columncount = this.getColumns().length;
					for (var i = aCells.length; i < columncount; i++) {
						oRow.addCell(this._getTableCellControl(i));
					}
					this.bindAggregation("items", this.getProperty("oDataItemPath"), oRow);
				}
			},
			_getTableCellControl : function(index) {
				var oCellControl = new dHBox();
				oCellControl.attachEvent("showProperties", function(oEvent) {
					var oView = sap.ui.getCore().byId("mainview");
					oView.getController().showProperties(oEvent);
				});
				var sMapping = "ColumnText";
				var oModelColumns = this.getProperty("_modelColumns");
				if (oModelColumns && index < oModelColumns.length) {
					sMapping = "{" + oModelColumns[index] + "}";
				}
				var oText = new dText( {text: sMapping });
				oText.attachEvent("showProperties", function(oEvent) {
					var oView = sap.ui.getCore().byId("mainview");
					oView.getController().showProperties(oEvent);
				});
				oCellControl.addItem(oText);
				return oCellControl;
			},
			setODataURL : function(sUrl) {
				this.setProperty("oDataURL", sUrl, false);
				/*
				 * The oData endpoint is the only element controlling if an odata model should be used or not.
				 * Thus it creates a model and removes it from the control.
				 */
				if (!!sUrl && sUrl !== "") {
					var that = this;
				    var oModel = new sap.ui.model.odata.v4.ODataModel({
			    		serviceUrl : sUrl, 
			    		"autoExpandSelect": true,
						"operationMode": "Server",
						"groupId": "$direct",
						"synchronizationMode": "None"
				    });
					this.setModel(oModel);
					/*
					 * Assuming the oData Service used in one from the HanaAppContainer, the 
					 * modelColumns property should be updated to support the user picking the
					 * proper binding. It does not refresh the properties pane, no event fired.
					 */
					var oMetamodel = oModel.getMetaModel();
					oMetamodel.requestObject("/HANAOBJECT.ROW").then(
							function(meta) { 
								var oColumns = [];
								Object.keys(meta).forEach( function(item) {
									if (!item.startsWith("$")) {
										oColumns.push(item);
									}
								} );
								that.setProperty("_modelColumns", oColumns, true);
								that.setODataItemPath("/TABLE");
								that._refreshTemplate();
							} );
				} else if (this.getModel()) {
					this.setModel(undefined);
				}
			},
			setODataItemPath : function(sPath) {
				this.setProperty("oDataItemPath", sPath, false);
			},
			setShowHeaderToolbar : function(vToolbar) {
				this.setProperty("showHeaderToolbar", vToolbar, true);
				// The toolbar needs to be saved elsewhere and removed from the control, else it does not show the table text again
				var vToolbarControl = this.getHeaderToolbar();
				var vToolbarControlBackup = this.data("headertoolbar");
				if (vToolbar) {
					if (!!vToolbarControlBackup) {
						this.setHeaderToolbar(vToolbarControlBackup);
					} else {
						this.setHeaderToolbar(new dOverflowToolbar());
					}
				} else {
					this.data("headertoolbar", vToolbarControl);
					this.destroyHeaderToolbar();
				}
			},
			setShowInfoToolbar : function(vToolbar) {
				this.setProperty("showInfoToolbar", vToolbar, true);
				// The toolbar needs to be saved elsewhere and removed from the control, else it does not show the table text again
				var vToolbarControl = this.getInfoToolbar();
				var vToolbarControlBackup = this.data("infotoolbar");
				if (vToolbar) {
					if (!!vToolbarControlBackup) {
						this.setInfoToolbar(vToolbarControlBackup);
					} else {
						this.setInfoToolbar(new dOverflowToolbar());
					}
				} else {
					this.data("infotoolbar", vToolbarControl);
					this.destroyInfoToolbar();
				}
			},
			addContent : function(vContent) {
				this.addColumn(new sap.m.Column({ header: vContent }));
				this._refreshTemplate();
			},
			removeContent : function(vContent) {
				var index = this.indexOfColumn(vContent);
				this.removeColumn(vContent);
				if (this.getModel()) {
					if (this.getBinding("items")) {
						oRow = this.getBindingInfo("items").template;
						this.unbindAggregation("items");
						oRow.removeCell(index);
						this.bindAggregation("items", this.getProperty("oDataItemPath"), oRow);
					}
				}
			},
			insertContent : function(vContent, vIndex) {
				this.insertColumn(new sap.m.Column({ header: vContent}), vIndex);
				if (this.getModel()) {
					if (this.getBinding("items")) {
						oRow = this.getBindingInfo("items").template;
						this.unbindAggregation("items");
						oRow.insertCell( this._get_getTableCellControl(), index);
						this.bindAggregation("items", this.getProperty("oDataItemPath"), oRow);
					}
				}
			},
			indexOfContent : function(vContent) {
				return this.indexOfColumn(vContent);
			},
			reorderContent : function(oSourceControl, oTargetControl) {
				var sourceindex = this.indexOfColumn(oSourceControl);
				var targetindex = this.indexOfColumn(oTargetControl);
				var oRemovedCol = this.removeColumn(sourceindex);
				this.insertColumn(oRemovedCol, targetindex);
				if (this.getModel()) {
					if (this.getBinding("items")) {
						oRow = this.getBindingInfo("items").template;
						this.unbindAggregation("items");
						var oRemovedTemplate = oRow.removeCell(sourceindex);
						oRow.insertCell( oRemovedTemplate, targetindex);
						this.bindAggregation("items", this.getProperty("oDataItemPath"), oRow);
					}
				}
			},
			getTemplate : function() {
				return this.data("template");
			},
			rebindTemplate : function() {
				if (this.getModel()) {
					if (this.getBinding("items")) {
						this.unbindAggregation("items");
						this.bindAggregation("items", this.getProperty("oDataItemPath"), this.getTemplate());
					}
				}
			},
			getParentProperties : function() {
				return sap.m.Table.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.Table.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.Table.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.Table.prototype.getMetadata.apply(this, arguments).getName();
			}

		});
});