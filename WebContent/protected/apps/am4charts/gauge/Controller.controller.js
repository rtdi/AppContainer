sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"ui5libs/ui5init"
], function(Controller, ui5init) {
	"use strict";

	return Controller.extend("ui5app.Controller", {
		onInit : function() {
			var oView = this.getView();
			var oChart = oView.byId("chart1");
			ui5init.init(oView);
		},

	});

});
