/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.XYChart.extend("io.rtdi.amchartsui5controls.RadarChart", {
		metadata: {
            properties: {
                endAngle: { type: "int", defaultValue: undefined },
                innerRadius: { type: "object", defaultValue: undefined },
                radius: { type: "object", defaultValue: undefined },
                startAngle: { type: "int", defaultValue: undefined },
            }, 
		},
		renderer : {},
		init : function() {
		},
		_createNewChart : function() {
			return am4charts.RadarChart;
		},
		setInnerRadiusPercent : function(value) {
			this.setProperty("innerRadius", am4core.percent(value), false);
		},
		setRadiusPercent : function(value) {
			this.setProperty("radius", am4core.percent(value), false);
		},
		_getXAxisRenderer : function() {
			return new io.rtdi.amchartsui5controls.AxisRendererCircular();
		},		
		_getYAxisRenderer : function() {
			return new io.rtdi.amchartsui5controls.AxisRendererCircular();
		},		
		createRadarSeries : function() {
			var series = new io.rtdi.amchartsui5controls.RadarSeries();
			this.addSeries(series);
			return series;
		},
		createRadarColumnSeries : function() {
			var series = new io.rtdi.amchartsui5controls.RadarColumnSeries();
			this.addSeries(series);
			return series;
		}
	});
});
