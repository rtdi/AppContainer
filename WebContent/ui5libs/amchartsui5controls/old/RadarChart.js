/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.XYChart.extend("io.rtdi.amchartsui5controls.RadarChart", {
		metadata: {
            properties: {
            }, 
		},
		renderer : {},
		init : function() {
		},
		_createNewChart : function() {
			return am4charts.RadarChart;
		},
		createRadarSeries : function() {
			return new am4charts.RadarSeries();
		},
		createRadarColumnSeries : function() {
			return new am4charts.RadarColumnSeries();
		}
	});
});
