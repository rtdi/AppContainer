sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"ui5libs/ui5init"
], function(Controller, ui5init) {
	"use strict";

	return Controller.extend("ui5lib.Controller", {
		onInit : function() {
			var oView = this.getView();
			ui5init.init(oView);
			this.init();
		},
		init : function() {
		}

	});

});
