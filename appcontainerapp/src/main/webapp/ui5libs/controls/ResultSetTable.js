sap.ui.define([
	"sap/ui/table/Table",
	"./library"
], function(Table) {
  return Table.extend("ui5libs.controls.ResultSetTable", {
		metadata : {
			properties : {
			},
			aggregations : {
			},
			events : {}
		},
		renderer: {},
		init : function() {
			Table.prototype.init.call(this);
			this.attachModelContextChange(this.createColumns);
			this.attachRowsUpdated(this._onTableDataChange);
			this.bindRows("rows");
			this.setMinAutoRowCount(2);
		},
		createColumns : function(event) {
			var control = event.getSource();
			var context = control.getBindingContext();
			if (context) {
				var model = context.getModel();
				if (model) {
					var columns = model.getProperty(context.getPath() + "/columns");
					control.removeAllColumns();
					control._wasresized = false;
					if (columns && Array.isArray(columns)) {
						for (var oCol of columns) {
							var oColumn = new sap.ui.table.Column({
								resizable: true,
								autoResizable: true,
								minWidth: 80,
								label: [new sap.m.Label({ text: oCol.name })],
								// template: [new sap.m.Text({ text: "{" + oCol.name + "}", wrapping: false })]
								// template: [new sap.m.Text({ text: "{=!!${" + oCol.name + "}?${" + oCol.name + "}:'<null>'}", wrapping: false })]
								template: [new ui5libs.controls.TextWithStyle({
									text: "{=!!${" + oCol.name + "}?${" + oCol.name + "}:'<null>'}",
									wrapping: false,
									fontstyle: "{=!!${" + oCol.name + "}?'Normal':'Italic'}",
								})]
							});
							control.addColumn(oColumn);
						}
					}
				}
			}
		},
		_addDefaultColumn : function() {
			var oColumn = new sap.ui.table.Column({
				resizable: true,
				autoResizable: true,
				minWidth: 80,
				label: [new sap.m.Label({ text: "Error" })],
				template: [new sap.m.Text({ text: "none", wrapping: false })]
			});
			this.addColumn(oColumn);
		},
		_onTableDataChange : function(oEvent) {
			var control = oEvent.getSource();
			if (!control._wasresized) {
				for (var i=0; i<this.getColumns().length; i++) {
					this.autoResizeColumn(i);
				}
				control._wasresized = true;
			}
		},
	});
});
