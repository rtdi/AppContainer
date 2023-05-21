sap.ui.define([],
	function() {
	"use strict";

	var renderer = {
	};

	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl); 
		oRm.addClass("sqlquery");
		oRm.writeStyles();
		oRm.openEnd();
		
		oRm.write("<span class=\"sqlkeyword\">WITH</span>");
		for (var owithexpressions of oControl.getWithexpressions()) {
			oRm.renderControl(owithexpressions);
		}
		
		oRm.renderControl(oControl.getSubqueryexpression());
		oRm.renderControl(oControl.getAggregation("_limitexpression"));
		
		oRm.close("div");

	};

	return renderer;

}, /* bExport= */ true);