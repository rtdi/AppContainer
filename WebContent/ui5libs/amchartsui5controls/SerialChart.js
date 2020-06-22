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
                series: {type : "io.rtdi.amchartsui5controls.Series", multiple : true},
            }
		},
		renderer : {},
		addSeries : function(s) {
			var series = new io.rtdi.amchartsui5controls.Series();
			series._setAm4ChartObject(s);
			this.addAggregation("series", series);
			this.getChart().series.push(s);
			return series;
		},
		executeQuery : function() {
			var aSeries = this.getAggregation("series");
			if (aSeries) {
				aSeries.forEach(function(series) {
					series.executeQuery();
				}, this);
			}
		}
	});
});
