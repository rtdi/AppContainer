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
		
		oRm.renderControl(oControl.getAggregation("_expression"));
		oRm.write("<span class=\"sqlkeyword\">AS</span>");
		oRm.renderControl(oControl.getAggregation("_alias"));
		if (oControl.getAggregation("_order").getVisible()) {
			oRm.write("<span class=\"sqlkeyword sqlkeywordorderby\">ORDER BY</span>");
		}
		oRm.renderControl(oControl.getAggregation("_order"));
		oRm.close("div");

	};

	return renderer;

}, /* bExport= */ true);