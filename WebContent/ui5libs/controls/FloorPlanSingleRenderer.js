sap.ui.define(['sap/ui/core/Control'],
	function(Control) {
	"use strict";

	var FloorPlanSingleRenderer = {
	};

	FloorPlanSingleRenderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl); 
		oRm.class("AppContainerPage"); 
		oRm.addStyle("height", "100%");
		oRm.addStyle("display", "flex");
		oRm.addStyle("flex-direction", "column");
		oRm.writeStyles();
		oRm.openEnd();
		oRm.renderControl(oControl.getAggregation("_shellbar")).addStyle("flex-shrink", "1");
		oRm.renderControl(oControl.getAggregation("content")).addStyle("flex-shrink", "1").addStyle("flex-grow", "1");
		oRm.close("div");

	};

	return FloorPlanSingleRenderer;

}, /* bExport= */ true);