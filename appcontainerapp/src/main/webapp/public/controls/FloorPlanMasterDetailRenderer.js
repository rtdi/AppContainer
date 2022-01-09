sap.ui.define(['sap/ui/core/Control'],
	function(Control) {
	"use strict";

	var FloorPlanMasterDetailRenderer = {
	};

	FloorPlanMasterDetailRenderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl); 
		oRm.class("FloorPlanMasterDetail"); 
		oRm.addStyle("height", "100%");
		oRm.addStyle("order", "0");
		oRm.addStyle("flex-shrink", "1");
		oRm.addStyle("flex-basis", "auto");
		oRm.addStyle("display", "flex");
		oRm.addStyle("flex-direction", "column");
		oRm.writeStyles();
		oRm.openEnd();
		oRm.renderControl(oControl.getAggregation("_shellbar")).addStyle("flex-shrink", "1");
		oRm.renderControl(oControl.getAggregation("master")).addStyle("flex-shrink", "1");
		oRm.renderControl(oControl.getAggregation("detail")).addStyle("flex-shrink", "1").addStyle("flex-grow", "1");
		oRm.close("div");
	};

	return FloorPlanMasterDetailRenderer;

}, /* bExport= */ true);