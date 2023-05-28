sap.ui.define([],
	function() {
	"use strict";

	var renderer = {
	};

	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl);
		oRm.addStyle("height", "100%");
		oRm.writeStyles();
		oRm.openEnd();
		if (oControl.getUseSplitter()) {
			oRm.renderControl(oControl.getAggregation("_splitter"));
		} else {
			oRm.renderControl(oControl.getEditorControl());
			// oRm.write("<div style='width: 100%;'>");
			oRm.renderControl(oControl.getDataControl());
			// oRm.write("</div>");
		}
		oRm.close("div");
	};

	return renderer;

}, /* bExport= */ true);