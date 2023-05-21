sap.ui.define([],
	function() {
	"use strict";

	var renderer = {
	};

	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl); 
		oRm.addClass("sqlprojection");
		oRm.writeStyles();
		oRm.openEnd();
		
		oRm.renderControl(oControl.getAggregation("_alias"));
		oRm.write("<span class=\"sqlkeyword\">AS</span>");
		oRm.renderControl(oControl.getAggregation("_expression"));
		oRm.close("div");

	};

	return renderer;

}, /* bExport= */ true);