sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function(Controller) {
	"use strict";

	return Controller.extend("ui5app.Controller", {
		onInit : function() {
			var oView = this.getView();
			var oChart = oView.byId("chart1");
		},

	});

});
