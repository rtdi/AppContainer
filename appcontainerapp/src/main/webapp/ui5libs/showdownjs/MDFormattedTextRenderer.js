sap.ui.define([],
	function() {
	"use strict";
	var renderer = {};
	
	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl); 
		if (oControl.getHeight() !== undefined && oControl.getHeight() !== null) {
			oRm.addStyle("height", oControl.getHeight());
		}
		if (oControl.getWidth() !== undefined && oControl.getWidth() !== null) {
			oRm.addStyle("width", oControl.getWidth());
		}
		oRm.writeStyles();
		oRm.writeClasses();
		oRm.openEnd();
		var html = oControl.getHtml();
		if (html) {
			// if empty do nothing
			oRm.write(html);
		}
		oRm.close("div");
	};

	return renderer;

}, /* bExport= */ true);
