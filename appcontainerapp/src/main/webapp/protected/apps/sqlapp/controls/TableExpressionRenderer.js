sap.ui.define([],
	function() {
	"use strict";

	var renderer = {
	};

	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl); 
		oRm.addClass("sqljoinedtable");
		oRm.writeStyles();
		oRm.openEnd();
		
		if (oControl.getJoinVisible()) {
			oRm.renderControl(oControl.getAggregation("_jointype"));
		}
		oRm.renderControl(oControl.getAggregation("_table"));
		oRm.write("<span class=\"sqlkeyword\">AS</span>");
		oRm.renderControl(oControl.getAggregation("_alias"));
		if (oControl.getJoinVisible()) {
			oRm.write("<span class=\"sqlkeyword\">ON</span>");
			oRm.write("<div class=\"sqljoinconditionunit\">");
			for (var oJoin of oControl.getJoinconditions()) {
				oRm.renderControl(oJoin);
			}
			oRm.write("</div>");
		}
		oRm.close("div");

	};

	return renderer;

}, /* bExport= */ true);