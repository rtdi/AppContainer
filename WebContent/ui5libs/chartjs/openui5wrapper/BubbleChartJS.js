// Provides control ui5libs.chartjs.openui5wrapper.BubbleChartJS
sap.ui.define([
	"./BaseChartJS",
], function (BaseChartJS) {
	"use strict";
	
	/**
	 * Constructor for a new Chart.
	 *
	 * @param {string} [sId] id for the new control, generated automatically if no id is given 
	 * @param {object} [mSettings] initial settings for the new control
	 *
	 * @class
	 * QRCode Control to render a QR Code
	 * @extends sap.m.InputBase
	 * @version ${version}
	 *
	 * @constructor
	 * @public
	 * @since 1.40
	 * @name ui5libs.chartjs.openui5wrapper.BubbleChartJS
	 */
	var BubbleChartJS =  BaseChartJS.extend("ui5libs.chartjs.openui5wrapper.BubbleChartJS", {
		
		metadata : {
			//library: 'ui5libs.chartjs.openui5wrapper',
			properties: {},
			aggregations: {},
			events: {}
		},
		
		onBeforeRendering: function() {
			this.setChartType("bubble");
		},
		
		/////////////////////////////////////
		// OVERRIDE
		/////////////////////////////////////
		
		addGlobalOptions: function(globalOptions) {},
		
		//////////////////////////////////////////////
		// GETTER / SETTER
		//////////////////////////////////////////////
		
		
		//////////////////////////////////////////////
		// CHART METHODS
		//////////////////////////////////////////////
		
	});


	return BubbleChartJS;

}, /* bExport= */ true);