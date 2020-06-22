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
		addNewRadarSeries : function() {
			var s = new am4charts.RadarSeries();
			return this.addSeries(s);
		},
		addNewRadarColumnSeries : function() {
			var s = new am4charts.RadarColumnSeries();
			return this.addSeries(s);
		},
		addNewWeekdayYAxis : function() {
			var wa = this.addNewCategoryYAxis();
			var weekDayAxis = wa.getAm4ChartObject();
			weekDayAxis.dataFields.category = "dayid";
			weekDayAxis.renderer.axisAngle = 90;
			weekDayAxis.renderer.innerRadius = am4core.percent(50);
			weekDayAxis.renderer.minGridDistance = 10;
			weekDayAxis.renderer.grid.template.location = 0;
			weekDayAxis.renderer.line.disabled = true;
			weekDayAxis.cursorTooltipEnabled = false;
			weekDayAxis.renderer.labels.template.fill = am4core.color("#0f0f00");

			var data = [];
			var formatter = new am4core.DateFormatter();
			for (var i=0; i<7; i++) {
				data.push({dayid: i, shortname: formatter.weekdaysShort[i], fullname: formatter.weekdays[i] })
			}
			weekDayAxis.data = data;
			return wa;
		},
		addNewYearXAxis : function(path) {
			var a = new io.rtdi.amchartsui5controls.RadarChartYearAxis();
			this.addXAxis(a);
			return a;
		},
		executeQuery : function() {
			io.rtdi.amchartsui5controls.XYChart.prototype.executeQuery.apply(this, arguments);
		}
	});
});


