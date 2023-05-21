sap.ui.define([],
	function() {
	"use strict";

	var renderer = {
	};

	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl); 
		oRm.addClass("notebookcell");
		oRm.writeStyles();
		oRm.openEnd();
		oRm.renderControl(oControl.getAggregation("_menu"));
		oRm.renderControl(oControl.getAggregation("content"));
		oRm.close("div");

	};

	return renderer;

}, /* bExport= */ true);