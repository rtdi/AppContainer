// Provides control ui5libs.chartjs.openui5wrapper.BarChartJS
sap.ui.define([
	"./BaseChartJS",
], function (BaseChartJS) {
	"use strict";
	
	/**
	 * BaseChart class
	 * A bar chart provides a way of showing data values represented as vertical bars. 
	 * It is sometimes used to show trend data, and the comparison of multiple data sets side by side.
	 *
	 * @param {string} [sId] id for the new control, generated automatically if no id is given 
	 * @param {object} [mSettings] initial settings for the new control
	 *
	 * @class
	 * BaseChart constructor
	 * @extends ui5libs.chartjs.openui5wrapper.BaseChartJS
	 * @alias ui5libs.chartjs.openui5wrapper.BarChartJS
	 * @version ${version}
	 *
	 * @constructor
	 * @public
	 * @since 1.40
	 * @name ui5libs.chartjs.openui5wrapper.BarChartJS
	 */
	var BarChartJS =  BaseChartJS.extend("ui5libs.chartjs.openui5wrapper.BarChartJS", /** @lends sap.m.BarChartJS.prototype */ {
		
		metadata : {
			library: 'ui5libs.chartjs.openui5wrapper',
			properties: {
				/**
				 * If the Bar Chart is horizontal
				 */
				isHorizontal : {type : "boolean", group : "Appearance", defaultValue : false},
				
				///////////////////////////////////////////////////////////////////////////////////
				// HOVER
				// The hover configuration is passed into the options.hover namespace. 
				// The global hover configuration is at Chart.defaults.global.hover.
				///////////////////////////////////////////////////////////////////////////////////
				
				/**
				 * Sets which elements appear in the tooltip.
				 */
				hoverMode : {type : "string", group : "Appearance", defaultValue : "label"},
				
			},
			aggregations: {},
			events: {}
		},
		
		onBeforeRendering: function() {
			this.setChartType(this.getIsHorizontal() ? "horizontalBar" : "bar");
			BaseChartJS.prototype.setHoverMode.call(this, this.getHoverMode());
		},
		
		/////////////////////////////////////
		// OVERRIDE
		/////////////////////////////////////
		
		addGlobalOptions: function(globalOptions) {
		},
		
		//////////////////////////////////////////////
		// GETTER / SETTER
		//////////////////////////////////////////////
		
		
		
		//////////////////////////////////////////////
		// CHART METHODS
		//////////////////////////////////////////////
		
	});


	return BarChartJS;

}, /* bExport= */ true);