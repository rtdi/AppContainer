/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.SerialChart.extend("io.rtdi.amchartsui5controls.XYChart", {
		metadata: {
            properties: {
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
			return axis;
		},
		addYAxis : function(axis) {
			this.addAggregation("yAxis", axis, true);
			return axis;
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
		createCategoryAxis : function() {
			return new am4charts.CategoryAxis();
		},
		createDateAxis : function() {
			return new am4charts.DateAxis();
		},
		createValueAxis : function() {
			return new am4charts.ValueAxis();
		},
		createCircleBullet : function() {
			return new am4charts.CircleBullet();
		},
	});
});
