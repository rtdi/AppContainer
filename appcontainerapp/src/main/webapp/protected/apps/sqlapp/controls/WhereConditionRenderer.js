sap.ui.define([],
	function() {
	"use strict";

	var renderer = {
	};

	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl); 
		oRm.addClass("sqlwherecondition");
		oRm.writeStyles();
		oRm.openEnd();
		
		oRm.renderControl(oControl.getAggregation("_left"));
		oRm.renderControl(oControl.getAggregation("_condition"));
		oRm.renderControl(oControl.getAggregation("_right"));
		oRm.close("div");

	};

	return renderer;

}, /* bExport= */ true);