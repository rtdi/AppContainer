sap.ui.define([ "sap/ui/core/mvc/Controller"], function(Controller) {
	"use strict";

	return Controller.extend("ui5app.Controller", {

		onInit : function() {
			var cOwner = this.getView().byId("idChartList");
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData("charts.json");
			this.getView().setModel(oModel);
		},
		visibleFormatter: function(sPath) {
			if (sPath) {
				return true;
			} else {
				return false;
			}
		}

	});

});
