sap.ui.define([],
	function() {
	"use strict";

	var renderer = {
	};

	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl); 
		oRm.addClass("sqllimit");
		oRm.writeStyles();
		oRm.openEnd();
		
		oRm.write("<span class=\"sqlkeyword\">OFFSET</span>");
		oRm.renderControl(oControl.getAggregation("_offset"));
		oRm.write("<span class=\"sqlkeyword\">LIMIT</span>");
		oRm.renderControl(oControl.getAggregation("_limit"));
		oRm.close("div");

	};

	return renderer;

}, /* bExport= */ true);