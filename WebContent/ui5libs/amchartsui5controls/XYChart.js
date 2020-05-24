/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.SerialChart.extend("io.rtdi.amchartsui5controls.XYChart", {
		metadata: {
            properties: {
            	arrangeTooltips: { type: "boolean" },
            	horizontalMouseWheelBehavior: { type: "string" },
            	maskBullets: { type: "boolean" },
            	mouseWheelBehavior: { type: "string" },
            }, 
            aggregations: {
                xAxis : {type : "io.rtdi.amchartsui5controls.Axis", multiple : true},
                yAxis : {type : "io.rtdi.amchartsui5controls.Axis", multiple : true},
            }
		},
		renderer : {},
		init : function() {
		},
		addXAxis : function(axis) {
			this.addAggregation("xAxis", axis, true);
		},
		addYAxis : function(axis) {
			this.addAggregation("yAxis", axis, true);
		},
		chartRendering : function(chart) {
			if (this.getAggregation("xAxis")) {
				this.getAggregation("xAxis").forEach(function(axis) {
					var a = axis._getAm4ChartObject();
					chart.xAxes.push(a);
					axis._link();
				}, this);
			}
			if (this.getAggregation("yAxis")) {
				this.getAggregation("yAxis").forEach(function(axis) {
					var a = axis._getAm4ChartObject();
					chart.yAxes.push(a);
					axis._link();
				}, this);
			}
			io.rtdi.amchartsui5controls.SerialChart.prototype.chartRendering.apply(this, arguments);
		},
		_getXAxisRenderer : function() {
			return undefined;
		},		
		_getYAxisRenderer : function() {
			return undefined;
		},		
		createCategoryAxis : function() {
			var axis = new io.rtdi.amchartsui5controls.CategoryAxis();
			this.addXAxis(axis);
			axis.setRenderer(this._getXAxisRenderer());

			return axis;
		},
		createValueAxis : function() {
			var axis = new io.rtdi.amchartsui5controls.ValueAxis();
			this.addYAxis(axis);
			axis.setRenderer(this._getYAxisRenderer());
			return axis;
		},

	});
});
