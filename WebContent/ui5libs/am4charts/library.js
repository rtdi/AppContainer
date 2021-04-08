/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'jquery.sap.global', 
	'sap/ui/core/library'
	],  function(jQuery, library) {

		"use strict";
		sap.ui.getCore().initLibrary({
			name : "ui5libs.am4charts",
			version: "${version}",
			noLibraryCSS: true,
			dependencies : ["sap.ui.core"],
			types: [],
			interfaces: [],
			controls: [ 
				"ui5libs.am4charts.Chart",
			],
			elements: []
		});

		return ui5libs.am4charts;

}, /* bExport= */ true);