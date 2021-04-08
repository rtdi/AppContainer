sap.ui.define(['jquery.sap.global'],
	function(jQuery) {
	"use strict";
	var ChartRenderer = {};
	
	ChartRenderer.render = function(oRM, oControl) {
		oRM.write("<div");
		oRM.writeControlData(oControl);
		oRM.writeClasses();
		
		if (oControl.getHeight() !== undefined && oControl.getHeight() !== null) {
			oRM.addStyle("height", oControl.getHeight());
		}
		if (oControl.getWidth() !== undefined && oControl.getWidth() !== null) {
			oRM.addStyle("width", oControl.getWidth());
		}
		oRM.writeStyles();
		oRM.write("</div>");
	};
	
	ChartRenderer.addOuterClasses = function(oRm, oControl) {};


	return ChartRenderer;

}, /* bExport= */ true);
