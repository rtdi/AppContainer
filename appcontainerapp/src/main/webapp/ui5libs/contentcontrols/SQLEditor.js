sap.ui.define([
	"ui5libs/ui5ajax",
	"ui5libs/helperfunctions",
	'ui5libs/contentcontrols/ContentBase',
	'sap/ui/codeeditor/CodeEditor'
], function(ui5ajax, helperfunctions) {
  return ui5libs.contentcontrols.ContentBase.extend("ui5libs.contentcontrols.SQLEditor", {
		metadata : {
			properties : {
				codeEditorHeight: {type: "sap.ui.core.CSSSize", defaultValue: "auto" },
				tableVisibleRowCountMode: {type: "string" },
			},
			aggregations : {
			},
			events : {}
		},
		renderer: {},
		init : function() {
			ui5libs.contentcontrols.ContentBase.prototype.init.call(this);
			this.setEditorControl(new sap.ui.codeeditor.CodeEditor( {
				type: "sql"
			}));
			var table = new sap.ui.table.Table( {
					selectionMode: "Single",
					selectionBehavior: "RowOnly",
					enableSelectAll: false,
					rowsUpdated: this._onTableDataResizeColumns
				} );
			table.setModel(new ui5libs.libs.model.json.JSONModelE());
			this.setDataControl(new sap.m.ScrollContainer( { content: table }));
		},
		getDataModel : function() {
			/*
			 * Used by the NBJsonContainer to find the previous control with a data type
			 */
			return this.getDataControl().getContent()[0].getModel();
		},
		setValue: function(text) {
			this.setProperty("value", text);
			this.getEditorControl().setValue(text);
		},
		getValue: function() {
			return this.getEditorControl().getValue();
		},
		setCodeEditorHeight : function(value) {
			this.setProperty("codeEditorHeight", value);
			this.getEditorControl().setHeight(value);
		},
		setTableVisibleRowCountMode : function(value) {
			this.setProperty("tableVisibleRowCountMode", value);
			this.getDataControl().getContent()[0].setVisibleRowCountMode(value);
		},
		compile : function() {
			var oTableData = this.getDataControl().getContent()[0];
			oTableData.removeAllColumns();
			var datamodel = oTableData.getModel();
			var sqltext = this.getEditorControl().getValue();
			ui5ajax.getJsonObject("../../rest/query?$select="+ helperfunctions.encodeURIfull(sqltext))
				.then(
					data => {
						var oData = JSON.parse(data.text);
						for (var oCol of oData.columns) {
							var oColumn = new sap.ui.table.Column({
								resizable: true,
								autoResizable: true,
								minWidth: 80,
								label: [new sap.m.Label({ text: oCol.name })],
								template: [new sap.m.Text({ text: "{ path: '" + oCol.name + "', targetType:'any'}", wrapping: false })]
							});
							oTableData.addColumn(oColumn);
						}
						oTableData.bindRows("/rows");
						oTableData._wasresized = false;
						datamodel.setData(oData);
					},
					error => {
						var oData = JSON.parse(error.text);
						datamodel.setData(undefined);
						oTableData.setNoData(oData.message + "\n" + oData.sqlstatement.replace("\\r\\n", "\n"));
						this._addDefaultColumn(oTableData);
					}
				);
		},
		_addDefaultColumn : function(oTableData) {
			var oColumn = new sap.ui.table.Column({
				resizable: true,
				autoResizable: true,
				minWidth: 80,
				label: [new sap.m.Label({ text: "Error" })],
					template: [new sap.m.Text({ text: "none", wrapping: false })]
			});
			oTableData.addColumn(oColumn);
		},
		_onTableDataResizeColumns : function(oEvent) {
			if (!this._wasresized) {
				for (var i=0; i<this.getColumns().length; i++) {
					this.autoResizeColumn(i);
				}
				this._wasresized = true;
			}
		},
		_setEditorVisible : function(isVisible) {
			this.getEditorControl().setVisible(isVisible);
		},
		getType : function() {
			return "SQL";
		}
	});
});
