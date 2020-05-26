/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
           	"sap/ui/core/mvc/Controller",
           	"io/rtdi/amchartsui5controls/library"
   ], function(Controller) {
   	"use strict";
   	return Controller.extend("ui5.app.RadarController", {
   		onInit : function() {
			var oView = sap.ui.getCore().byId("mainview");
   			var chart = oView.byId("radarchart");
   			
		    var oModel = new sap.ui.model.odata.v4.ODataModel({
	    		serviceUrl : "/HanaAppContainer/protected/odata/SYS/M_CS_TABLES/", 
	    		"autoExpandSelect": true,
				"operationMode": "Server",
				"groupId": "$direct",
				"synchronizationMode": "None"
		    });

		    var oList = oModel.bindList("/TABLE", undefined, undefined, undefined, {
		          $$ownRequest: true,
		          $filter : "SCHEMA_NAME eq 'SAPHANADB'",
		          $select: ["TABLE_NAME", "MEMORY_SIZE_IN_TOTAL", "RECORD_COUNT"]
		        });
		    
		    chart.setChartInitCallback(this.initChart);
		    
   		},
   		initChart : function(oControl, chart) {
   			var firstDay = new Date(2003, 1, 1);
   			firstDay = am4core.time.round(firstDay, "year", 1);

   			var dailyData = [];
			for (var i = 0; i < 7; i++) {
			    // dailyData.push({ day: chart.dateFormatter.language.translate(chart.dateFormatter.weekdaysShort[i]) });
			    dailyData.push({ "DAY_IN_WEEK": i });
			}


   			chart.dataSource.url = "/HanaAppContainer/protected/odata/RTDI/SALES_DATA_DAILY/TABLE?$filter=YEAR_ID%20eq%202003&$skip=0&$top=100";
   			chart.innerRadius = am4core.percent(15);
   			chart.radius = am4core.percent(90);
   			chart.fontSize = "11px";
   			chart.startAngle = 95;
   			chart.endAngle = chart.startAngle + 350;
   			chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

   			// Create axes
   			var dateAxis = chart.xAxes.push(oControl.createDateAxis());
   			dateAxis.baseInterval = { timeUnit: "week", count: 1 };
   			dateAxis.renderer.innerRadius = oControl.createCSSPercentNumber(40);
   			dateAxis.renderer.minGridDistance = 5;
   			dateAxis.renderer.labels.template.relativeRotation = 0;
   			dateAxis.renderer.labels.template.location = 0.5;
   			dateAxis.renderer.labels.template.radius = oControl.createCSSPercentNumber(-57);
   			dateAxis.renderer.labels.template.fontSize = "8px";
   			dateAxis.dateFormats.setKey("week", "w");
   			dateAxis.periodChangeDateFormats.setKey("week", "w");
   			dateAxis.cursorTooltipEnabled = false;

   			var valueAxis = chart.yAxes.push(oControl.createValueAxis());
   			valueAxis.renderer.inversed = true;
   			valueAxis.renderer.radius = oControl.createCSSPercentNumber(40);
   			valueAxis.renderer.minGridDistance = 15;
   			valueAxis.renderer.minLabelPosition = 0.05;
   			valueAxis.renderer.axisAngle = 90;
   			valueAxis.cursorTooltipEnabled = false;
   			valueAxis.renderer.labels.template.fill = oControl.createCSSColor("#000000");

   			/*
   			 *  create view sales_data_daily as select orderdate, year_id, week(orderdate) as week_id,
			 *	weekday(orderdate) as day_in_week, sum(msrp) as revenue from sales_data
			 *	group by orderdate, year_id, week(orderdate), weekday(orderdate);
   			 */
   			// Create series
   			var columnSeries = chart.series.push(oControl.createRadarColumnSeries());
   			columnSeries.dataFields.dateX = "ORDERDATE";
   			columnSeries.dataFields.valueY = "REVENUE";
   			columnSeries.columns.template.strokeOpacity = 0;
   			columnSeries.columns.template.width = oControl.createCSSPercentNumber(95);
   			columnSeries.fill = oControl.createCSSColor("#00ffff");
   			columnSeries.fillOpacity = 0.6;
   			columnSeries.tooltip.fontSize = 10;
   			columnSeries.tooltip.pointerOrientation = "down";
   			columnSeries.tooltip.background.fillOpacity = 1;
   			columnSeries.columns.template.tooltipText = "[bold]week {DAY_IN_WEEK}\n[font-size:13px]Total {valueY}";
   			columnSeries.cursorTooltipEnabled = false;

   			// weekday axis
   			var weekDayAxis = chart.yAxes.push(oControl.createCategoryAxis());
   			weekDayAxis.dataFields.category = "DAY_IN_WEEK";
   			weekDayAxis.data = dailyData;
   			weekDayAxis.renderer.innerRadius = oControl.createCSSPercentNumber(50);
   			weekDayAxis.renderer.minGridDistance = 10;
   			weekDayAxis.renderer.grid.template.location = 0;
   			weekDayAxis.renderer.line.disabled = true;
   			weekDayAxis.renderer.axisAngle = 90;
   			weekDayAxis.cursorTooltipEnabled = false;
   			weekDayAxis.renderer.labels.template.fill = oControl.createCSSColor("#0f0f00");

   			// bubble series
   			var bubbleSeries = chart.series.push(oControl.createRadarSeries());
   			bubbleSeries.dataFields.dateX = "ORDERDATE";
   			bubbleSeries.dataFields.categoryY = "DAY_IN_WEEK";
   			bubbleSeries.dataFields.value = "REVENUE";
   			bubbleSeries.yAxis = weekDayAxis;
   			bubbleSeries.strokeOpacity = 0;
   			bubbleSeries.maskBullets = false;
   			bubbleSeries.cursorTooltipEnabled = false;
   			bubbleSeries.tooltip.fontSize = 10;
   			bubbleSeries.tooltip.pointerOrientation = "down";
   			bubbleSeries.tooltip.background.fillOpacity = 1;

   			var bubbleBullet = bubbleSeries.bullets.push(oControl.createCircleBullet());
   			bubbleBullet.locationX = 0.5;
   			bubbleBullet.stroke = oControl.createCSSColor("#b9ce37");
   			bubbleBullet.fill = oControl.createCSSColor("#b9ce37");
   			bubbleBullet.tooltipText = "[bold]{ORDERDATE}, {value}";
   			bubbleBullet.adapter.add("tooltipY", function(tooltipY, target) {
   			  return -target.circle.radius;
   			})

   			bubbleSeries.heatRules.push({ target: bubbleBullet.circle, min: 2, max: 12, dataField: "value", property: "radius" });
   			bubbleSeries.dataItems.template.locations.categoryY = 0.5;

   			// add month ranges
   			for (var i = 0; i < 13; i++) {
   			  var range = dateAxis.axisRanges.create();
   			  range.date = new Date(firstDay.getFullYear(), i, 0, 0, 0, 0);
   			  range.endDate = new Date(firstDay.getFullYear(), i + 1, 0, 0, 0, 0);
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
   			  range.axisFill.fill = oControl.createCSSColor("#b9ce37");
   			  range.axisFill.stroke = oControl.createCSSColor("#5f6062");
   			  range.grid.disabled = true;
   			  range.label.text = chart.dateFormatter.language.translate(chart.dateFormatter.months[i])
   			  range.label.bent = true;
   			  range.label.radius = 10;
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

   			chart.cursor = new am4charts.RadarCursor();
   			chart.cursor.innerRadius = am4core.percent(40);
   			chart.cursor.lineY.disabled = true;


   			/* var label = chart.radarContainer.createChild(am4core.Label);
   			label.horizontalCenter = "middle";
   			label.verticalCenter = "middle";
   			label.fill = am4core.color("#ffffff");
   			label.fontSize = 12;
   			label.fontWeight = "bold";
   			label.text = "WEEKLY\nTOTALS"; */

   			/* var title = chart.createChild(am4core.Label);
   			title.fill = am4core.color("#b9ce37");
   			title.fontSize = 20;
   			title.isMeasured = false;
   			title.valign = "top";
   			title.align = "left";
   			title.wrap = true;
   			title.width = 200;
   			title.text = "[bold]IN " + firstDay.getFullYear() + "\nI CYCLED " + Math.round(total) + " km.\n[font-size:11; #ffffff]Each circle represents a bike ride. Size represents distance.";

   			var link = chart.createChild(am4core.TextLink);
   			link.fill = am4core.color("#ffffff");
   			link.fontSize = 13;
   			link.url = "https://www.instagram.com/brian_devine/";
   			link.valign = "bottom";
   			link.align = "right";
   			link.marginRight = 10;
   			link.text = "Chart design inspired by Brian Devine"; */
   		}

   	});
});