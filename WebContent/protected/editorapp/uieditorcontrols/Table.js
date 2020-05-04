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
					oDataURL: { type: "string", defaultValue: "" },
					oDataItemPath: { type: "string", defaultValue: "" },
					columnCount: { type: "int", defaultValue: 0 },
					showHeaderToolbar: {type: "boolean", defaultValue: false},
					showInfoToolbar: {type: "boolean", defaultValue: false},
					modelColumns: { type: "object", defaultValue: undefined }
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
				var oModel = new JSONModel();
				oModel.setData({ "list": [
					{ "propertyname": "controlid" },
					{ "propertyname": "headerText", "showmodelcolumns" : 2 },
					{ "propertyname": "footerText", "showmodelcolumns" : 2 },
					{ "propertyname": "showHeaderToolbar" },
					{ "propertyname": "showInfoToolbar" },
					{ "propertyname": "columnCount" },
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
				this.attachEvent("showProperties", sap.ui.getCore().byId("mainview").getController().showProperties);
			},
			_refreshTemplate : function() {
				if (this.getModel()) {
					var oRow = this.data("template");
					var isChanged = false;
					if (!oRow) {
						oRow = new sap.m.ColumnListItem();
						this.data("template", oRow);
						oRow.data("templateFor", this);
						isChanged = true;
					}
					var aCells = oRow.getCells();
					var columncount = this.getColumns().length;
					for (var i = aCells.length; i < columncount; i++) {
						oRow.addCell(this._getTableCellControl(i));
						isChanged = true;
					}
					if (isChanged) {
						this.bindAggregation("items", { path: this.getProperty("oDataItemPath"), template: oRow } );
					}
				}
			},
			setColumnCount : function(value) {
				this.setProperty("columnCount", value);
				var count = 0;
				var isChanged = false;
				if (this.getColumns()) {
					count = this.getColumns().length;
				}
				while (count < value) {
					var oColumnheader = new dText({text : "Column" + String(count+1) } );
					this.addColumn(new sap.m.Column({ header: [ oColumnheader ] }));
					count++;
					isChanged = true;
				}
				while (count > value) {
					var index = this.getColumns().length-1;
					this.removeColumn(index);
					var oRow = this.getTemplate();
					if (oRow) {
						oRow.removeCell(index);
					}
					count--;
					isChanged = true;
				}
				if (isChanged) {
					this.rebindTemplate();
				}
			},
			bindAggregation : function(sName, oBindingInfo) {
				sap.m.Table.prototype.bindAggregation.apply(this, arguments);
				/*
				 * Overwrite the columnCount with the columns of the aggregation
				 */
				this.setProperty("columnCount", oBindingInfo.template.getCells().length);
				this.data("template", oBindingInfo.template);
				oBindingInfo.template.data("templateFor", this);
				var sPath = oBindingInfo.path;
				if (sPath.charAt(0) === '{') {
					sPath = sPath.substring(1, sPath.length-1);
				}
				this.setODataItemPath(sPath);
			},
			_getTableCellControl : function(index) {
				var oCellControl = new dHBox();
				var sMapping = "ColumnText";
				var oModelColumns = this.getProperty("modelColumns");
				if (oModelColumns && index < oModelColumns.length) {
					sMapping = "{" + oModelColumns[index] + "}";
				}
				var oText = new dText( {text: sMapping });
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
					if (!that.getODataItemPath()) {
						that.setODataItemPath("/TABLE");
					}
					this.setModel(oModel);
					this.rebindTemplate(); // TODO: Why is this neccessary??? Template is bound at that time and setModel fires an context event...
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
								that.setProperty("modelColumns", oColumns, true);
								if (!that.getTemplate()) {
									for (var i=0; i<Math.min(4, oColumns.length); i++) {
										var oColumnheader = new dText({text : oColumns[i] } );
										that.addColumn(new sap.m.Column({ header: [ oColumnheader ] }));
									}
									that.setProperty("columnCount", i);
									that._refreshTemplate();
								}
							} );
				} else if (this.getModel()) {
					this.setModel(undefined);
				}
			},
			setODataItemPath : function(sPath) {
				this.setProperty("oDataItemPath", sPath, false);
				if (this.getModel()) {
					vBindingInfo = this.getBinding("items");
					if (vBindingInfo && vBindingInfo.sPath !== sPath) {
						this.rebindTemplate();
					}
				}
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
				this.setProperty("columnCount", this.getColumns().length);
			},
			removeContent : function(vContent) {
				var index = this.indexOfColumn(vContent);
				this.removeColumn(vContent);
				if (this.getModel()) {
					if (this.getBinding("items")) {
						oRow = this.getTemplate();
						oRow.removeCell(index);
						this.rebindTemplate();
					}
				}
				this.setProperty("columnCount", this.getColumns().length);
			},
			insertContent : function(vContent, vIndex) {
				this.insertColumn(new sap.m.Column({ header: vContent}), vIndex);
				if (this.getModel()) {
					oRow = this.getTemplate();
					if (oRow) {
						oRow.insertCell( this._getTableCellControl(), vIndex);
						this.rebindTemplate();
					}
				}
				this.setProperty("columnCount", this.getColumns().length);
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
					oRow = this.getTemplate();
					if (oRow) {
						oRow.insertCell( oRemovedTemplate, targetindex);
						this.rebindTemplate();
					}
				}
			},
			getTemplate : function() {
				return this.data("template");
			},
			indexOfTemplate : function(vContent) {
				return this.indexOfItem(vContent);
			},
			rebindTemplate : function() {
				if (this.getModel()) {
					if (this.getBinding("items")) {
						this.unbindAggregation("items");
						this.bindAggregation("items", { path: this.getProperty("oDataItemPath"), template: this.getTemplate() } );
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