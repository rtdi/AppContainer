/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.AxisDate.extend("io.rtdi.amchartsui5controls.RadarChartYearAxis", {
		metadata: {
            properties: {
                yearPath: {type : "string"},
            }, 
            aggregations: {
            },
		},
		initAxis : function() {
   			var dateAxis = this.getAm4ChartObject();
   			dateAxis.baseInterval = { timeUnit: "week", count: 1 };
   			dateAxis.renderer.minGridDistance = 5;
   			dateAxis.renderer.labels.template.relativeRotation = 0;
   			dateAxis.renderer.labels.template.location = 0.5;
   			dateAxis.renderer.labels.template.fontSize = "8px";
   			dateAxis.dateFormats.setKey("week", "w");
   			dateAxis.periodChangeDateFormats.setKey("week", "w");
   			dateAxis.cursorTooltipEnabled = false;

   			// add month ranges
   			for (var i = 0; i < 13; i++) {
   				var range = dateAxis.axisRanges.create();
   				if (i % 2) {
   					range.axisFill.fillOpacity = 0.4;
   				}
   				else {
   					range.axisFill.fillOpacity = 0.8;
   				}
   				range.axisFill.radius = -28;
   				range.axisFill.adapter.add("innerRadius", function(innerRadius, target) {
   					return dateAxis.renderer.pixelRadius + 7;
   				})
   				range.axisFill.fill = am4core.color("#b9ce37");
   				range.axisFill.stroke = am4core.color("#5f6062");
   				range.grid.disabled = true;
   				range.label.text = dateAxis.chart.dateFormatter.months[i];
   				range.label.bent = true;
   				range.label.fontSize = 10;
   				range.label.paddingBottom = 5;
   				range.label.interactionsEnabled = false;
   				range.axisFill.interactionsEnabled = true;
   				range.axisFill.cursorOverStyle = am4core.MouseCursorStyle.pointer;
   				range.axisFill.events.on("hit", function(event) {
   					if (dateAxis.start == 0 && dateAxis.end == 1) {
   						dateAxis.zoomToDates(event.target.dataItem.date, event.target.dataItem.endDate);
   					}
   					else {
   						dateAxis.zoom({ start: 0, end: 1 });
   					}
   				})
   			}
		},
		executeQuery : function() {
			var path = this.getYearPath();
   			var dateAxis = this.getAm4ChartObject();
   			var year = this.getModel().getProperty(path);
   			dateAxis.min = Date.UTC(year, 0, 0, 0, 0, 0); // needs the milliseconds anyway
   			dateAxis.max = Date.UTC(year, 11, 31, 0, 0, 0);
   			for (var i = 0; i < 13; i++) {
   				var range = dateAxis.axisRanges.values[i];
   				range.label.radius = 10; // Needs to be placed here because of https://github.com/amcharts/amcharts4/issues/2522
   				range.date = new Date(Date.UTC(year, i, 0, 0, 0, 0));
   				range.endDate = new Date(Date.UTC(year, i + 1, 0, 0, 0, 0));
   			}
		},
	});
});
