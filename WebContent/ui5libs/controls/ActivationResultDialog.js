sap.ui.define([
	"sap/m/Dialog",
	"sap/m/DialogType",
	"sap/m/Button",
	"sap/m/ButtonType",
	"sap/ui/table/TreeTable",
	"sap/ui/core/Icon"
], function(Dialog) {
  return Dialog.extend("ui5libs.controls.ActivationResultDialog", {
		metadata : {
			properties: {
				activationResult: {type : "string", defaultValue : undefined}
			}
		},
		renderer : {},
		init : function() {
			Dialog.prototype.init.call(this);
			var oTreeTable = new sap.ui.table.TreeTable("activationtree", {
				"rows": "{path:'/', parameters: {arrayNames:['children'], numberOfExpandedLevels: 3} }",
				"visibleRowCountMode": "Auto",
				"selectionMode": sap.ui.table.SelectionMode.None,
				"enableSelectAll": false,
				"columns": [
					new sap.ui.table.Column({label: "Name", template: new sap.m.Text({ "text": "{info}", "wrapping": false }) }),
					new sap.ui.table.Column({label: "Result", width: "6em", template: new sap.ui.core.Icon({
						"src": "{= ${success} === 'SUCCESS' ? 'sap-icon://message-success' : (${success} === 'WARNING' ? 'sap-icon://message-warning' : 'sap-icon://message-error') }",
						"color": "{= ${success} === 'SUCCESS' ? 'Positive' : (${success} === 'WARNING' ? 'Default' : 'Critical') }",
						 "tooltip": "{sqltext}"
						 })
					})
				]
			});
			this.addAggregation("content", oTreeTable );
			this.setModel(new sap.ui.model.json.JSONModel());
			this.setEndButton( new sap.m.Button({
						text: "Close",
						press: function () {
							this.close();
						}.bind(this)
					})
			);
		},
		setActivationResult : function(sJson) {
			this.getModel().setJSON(sJson);
			this.setProperty("activationResult", sJson);
			// this.getModel().refresh();
		}
	});
});
