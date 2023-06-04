sap.ui.define([],
	function() {
	"use strict";

	var renderer = {
	};

	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl);
		if (oControl.getHeight()) {
			oRm.addStyle("height", oControl.getHeight());
		}
		if (oControl.getWidth()) {
			oRm.addStyle("width", oControl.getWidth());
		}
		oRm.writeStyles();
		oRm.openEnd();
		if (oControl.getUseSplitter()) {
			oRm.renderControl(oControl.getAggregation("_splitter"));
		} else {
			oRm.renderControl(oControl.getEditorControl());
			oRm.renderControl(oControl.getDataControl());
		}
		oRm.close("div");
	};

	return renderer;

}, /* bExport= */ true);