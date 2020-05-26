/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Chart.extend("io.rtdi.amchartsui5controls.SerialChart", {
		metadata: {
            properties: {
            }, 
            aggregations: {
                series : {type : "io.rtdi.amchartsui5controls.Series", multiple : true},
            }
		},
		renderer : {},
		init : function() {
		},
		addSeries : function(series) {
			this.addAggregation("series", series, true);
		},
		chartRendering : function(chart) {
			if (this.getAggregation("series")) {
				this.getAggregation("series").forEach(function(series) {
					chart.series.push(series._getAm4ChartObject());
					series._link();
				}, this);
			}
			io.rtdi.amchartsui5controls.Chart.prototype.chartRendering.apply(this, arguments);
		},
	});
});
