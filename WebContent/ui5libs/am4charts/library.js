sap.ui.loader.config({
	async: true,
	shim: {
		'am4charts/core': {
			amd: false,
			exports: 'am4core'
		},
		'am4charts/charts': {
			amd: false,
			exports: 'am4charts',
			deps: ["am4charts/core"]
		},
		'am4charts/themes/animated': {
			amd: false,
			exports: 'am4themes_animated',
			deps: ["am4charts/core"]
		},
		'am4charts/plugins/timeline': {
			amd: false,
			exports: 'am4plugins_timeline',
			deps: ["am4charts/core"]
		},
		'am4charts/plugins/sunburst': {
			amd: false,
			exports: 'am4plugins_sunburst',
			deps: ["am4charts/core"]
		},
		'am4charts/plugins/venn': {
			amd: false,
			exports: 'am4plugins_venn',
			deps: ["am4charts/core"]
		},
		'am4charts/plugins/wordCloud': {
			amd: false,
			exports: 'am4plugins_wordCloud',
			deps: ["am4charts/core"]
		},
		'am4charts/plugins/forceDirected': {
			amd: false,
			exports: 'am4plugins_forceDirected',
			deps: ["am4charts/core"]
		}
	}
});
sap.ui.require([
	'jquery.sap.global', 
	'sap/ui/core/library',
	'am4charts/core',
	'am4charts/charts'
	],  function(jQuery, library) {

		"use strict";
		var thislib = ui5libs.am4charts;
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
