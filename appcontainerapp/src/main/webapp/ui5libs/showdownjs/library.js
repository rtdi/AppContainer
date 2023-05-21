sap.ui.require([
	'ui5libs/showdownjs/dist/showdown'
], function() {
});

sap.ui.define([
	"sap/ui/core/library",
	'ui5libs/showdownjs/dist/showdown'
], function(library) {
	"use strict";

	sap.ui.getCore().initLibrary({
		name : "ui5libs.showdownjs",
		version: "1.0",
		dependencies : ["sap.ui.core"],
		controls: [
		],
		modules: [
		]
	});
	

	return thisLib;
}, /* bExport= */ false);