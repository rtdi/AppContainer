/*!
 * ${copyright}
 */

/**
 * Initialization Code and shared classes of library it.designfuture.flatpickr.
 */
sap.ui.define([
	'jquery.sap.global', 
	'sap/ui/core/library' // library dependency
	],  function(jQuery, library) {

		"use strict";

		/**
		 * Suite controls library.
		 *
		 * @namespace
		 * @name ui5libs.chartjs.openui5wrapper
		 * @author Emanuele Ricci <stermi@gmail.com>
		 * @version ${version}
		 * @public
		 */


		// delegate further initialization of this library to the Core
		sap.ui.getCore().initLibrary({
			name : "ui5libs.chartjs.openui5wrapper",
			version: "${version}",
			noLibraryCSS: true,
			dependencies : ["sap.ui.core", "sap.m"],
			types: [],
			interfaces: [],
			controls: [ 
				"ui5libs.chartjs.openui5wrapper.BarChartJS",
				"ui5libs.chartjs.openui5wrapper.BubbleChartJS",
				"ui5libs.chartjs.openui5wrapper.LineChartJS",
				"ui5libs.chartjs.openui5wrapper.PieChartJS",
				"ui5libs.chartjs.openui5wrapper.PolarAreaChartJS",
				"ui5libs.chartjs.openui5wrapper.RadarChartJS"
			],
			elements: []
		});

		return ui5libs.chartjs.openui5wrapper;

}, /* bExport= */ false);