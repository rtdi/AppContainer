// Provides control ui5libs.chartjs.openui5wrapper.PieChartJS
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
	 * @name ui5libs.chartjs.openui5wrapper.PieChartJS
	 */
	var PieChartJS =  BaseChartJS.extend("ui5libs.chartjs.openui5wrapper.PieChartJS", {
		
		DEFAULT_PIE_CUTOUT_PERCENTAGE: 50,
		DEFAULT_DOUGHNUT_CUTOUT_PERCENTAGE: 0,
		
		metadata : {
			//library: 'ui5libs.chartjs.openui5wrapper',
			properties: {
				/**
				 * If the Pie Chart doughnut style
				 */
				isDoughnut : {type : "boolean", group : "Appearance", defaultValue : false},
				
				///////////////////////////////////////////////////////////////////////////////////
				// GENERAL
				// These are the customization options specific to Pie & Doughnut charts. 
				// These options are merged with the global chart configuration options, and form the options of the chart.
				///////////////////////////////////////////////////////////////////////////////////
				
				/**
				 * The percentage of the chart that is cut out of the middle.
				 * 50 - for doughnut, 0 - for pie
				 */
				cutoutPercentage : {type : "string", group : "Appearance", defaultValue : null},
				
				/**
				 * Starting angle to draw arcs from
				 */
				rotation : {type : "int", group : "Appearance", defaultValue : -90},
				
				/**
				 * Sweep to allow arcs to cover
				 */
				circumference : {type : "int", group : "Appearance", defaultValue : 360},
				
				///////////////////////////////////////////////////////////////////////////////////
				// ANIMATION
				///////////////////////////////////////////////////////////////////////////////////
				
				/**
				 * If true, will animate the rotation of the chart.
				 */
				animationAnimateRotate : {type : "boolean", group : "Appearance", defaultValue : true},
				
				/**
				 * If true, will animate scaling the Doughnut from the centre.
				 */
				animationAnimateScale : {type : "boolean", group : "Appearance", defaultValue : false},
				
			},
			aggregations: {},
			events: {}
		},
		
		onBeforeRendering: function() {
			this.setChartType(this.getIsDoughnut() ? "doughnut" : "pie");
		},
		
		/////////////////////////////////////
		// OVERRIDE
		/////////////////////////////////////
		
		addGlobalOptions: function(globalOptions) {
			if( this.getCutoutPercentage() === null ) {
				globalOptions.cutoutPercentage = this.getIsDoughnut() ? this.DEFAULT_DOUGHNUT_CUTOUT_PERCENTAGE : this.DEFAULT_PIE_CUTOUT_PERCENTAGE;
			} else {
				globalOptions.cutoutPercentage = this.getCutoutPercentage();
			}
			globalOptions.rotation = this.getRotation();
			globalOptions.circumference = this.getCircumference();
			globalOptions.animation.animateRotate = this.getAnimationAnimateRotate();
			globalOptions.animation.animateScale = this.getAnimationAnimateScale();
		},
		
		//////////////////////////////////////////////
		// GETTER / SETTER
		//////////////////////////////////////////////
		
		
		
		//////////////////////////////////////////////
		// CHART METHODS
		//////////////////////////////////////////////
		
	});


	return PieChartJS;

}, /* bExport= */ true);