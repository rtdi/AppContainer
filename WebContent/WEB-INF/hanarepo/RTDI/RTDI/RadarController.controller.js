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
		    
		    /* oList.requestContexts().then(function (aContexts) {
		    	var oData = [];
		    	aContexts.forEach(function (oContext) {
		    		oData.push(oContext.getObject());
		    	});
		    }); */
   			
			chart.getDataSource().setUrl("/HanaAppContainer/protected/odata/SALESDB/SALES_DATA_DAILY/TABLE?$filter=YEAR_ID%20eq%202003$skip=0&$top=100");
   			
			// oRadar.setInnerRadiusPercent(0);
			/*
			var categoryAxis = oRadar.createCategoryAxis();
			categoryAxis.getDataFields().setCategory("TABLE_NAME");
			categoryAxis.getRenderer().getLabels().getTemplate().setLocation(0.5);
			// categoryAxis.getRenderer().setInnerRadiusPercent(50);
			// categoryAxis.getRenderer().setRadiusPercent(50);

			var valueAxis = oRadar.createValueAxis();
			valueAxis.getRenderer().setInnerRadiusPercent(60);
			valueAxis.getRenderer().setInversed(false);

			var series = oRadar.createRadarColumnSeries();
			series.getDataFields().setValueY("LAST_ESTIMATED_MEMORY_SIZE");
			series.getDataFields().setCategoryX("TABLE_NAME");
			series.setName("MEMORY_SIZE");
			series.getColumns().getTemplate().setFill("#05A20B");
			series.setZIndex(2);

			var series2 = oRadar.createRadarColumnSeries();
			series2.getDataFields().setValueY("RECORD_COUNT");
			series2.getDataFields().setCategoryX("TABLE_NAME");
			series2.setName("RECORD_COUNT");
			series2.setZIndex(1); */

			
			
			chart.setInnerRadiusPercent(15);
			chart.setRadiusPercent(90);
			chart.setFontSize("11px");
			chart.setStartAngle(95);
			chart.setEndAngle(95+350);

			// Create axes
			var dateAxis = chart.createDateAxis();
			dateAxis.setBaseInterval({ timeUnit: "week", count: 1 });
			dateAxis.getRenderer().setInnerRadiusPercent(40);
			dateAxis.getRenderer().setMinGridDistance(5);
			dateAxis.getRenderer().getLabels().getTemplate().setRelativeRotation(0);
			dateAxis.getRenderer().getLabels().getTemplate().setLocation(0.5);
			dateAxis.getRenderer().getLabels().getTemplate().setRadiusPercent(-57);
			dateAxis.getRenderer().getLabels().getTemplate().setFontSize("8px");
			dateAxis.getDateFormats().setKey({"week": "w"});
			dateAxis.setPeriodChangeDateFormats.setKey({"week": "w"});
			dateAxis.setCursorTooltipEnabled(false);

			var valueAxis = chart.createValueAxis();
			valueAxis.getRenderer().setInversed(true);
			valueAxis.getRenderer().setRadiusPercent(40);
			valueAxis.getRenderer().setMinGridDistance(15);
			valueAxis.getRenderer().setMinLabelPosition(0.05);
			valueAxis.getRenderer().setAxisAngle(90);
			valueAxis.setCursorTooltipEnabled(false);
			valueAxis.getRenderer().getLabels().getTemplate().setFill("#ffffff");

			// Create series
			var columnSeries = chart.createRadarColumnSeries();
			columnSeries.getDataFields().setDateX("ORDERDATE");
			columnSeries.getDataFields().setValueY("REVENUE");
			columnSeries.getColumns().getTemplate().setStrokeOpacity(0);
			columnSeries.getColumns().getTemplate().setWidth(95);
			columnSeries.setFill("#ffffff");
			columnSeries.setFillOpacity(0.6);
			columnSeries.getTooltip().setFontSize(10);
			columnSeries.getTooltip().setPointerOrientation("down");
			columnSeries.getTooltip().setBackground.fillOpacity(0.5);
			// columnSeries.getColumns().getTemplate().setTooltipText("[bold]{date} - {endDate}\n[font-size:13px]Total {valueY} km");
			columnSeries.setCursorTooltipEnabled(false);

			// weekday axis
			var weekDayAxis = chart.createCategoryAxis();
			weekDayAxis.getDataFields().setCategory("DAY_IN_WEEK");
			// weekDayAxis.data = dailyData;
			weekDayAxis.getRenderer().setInnerRadiusPercent(50);
			weekDayAxis.getRenderer().setMinGridDistance(10);
			weekDayAxis.getRenderer().getGrid().getTemplate().setLocation(0);
			weekDayAxis.getRenderer().getLine().setDisabled(true);
			weekDayAxis.getRenderer().setAxisAngle(90);
			weekDayAxis.setCursorTooltipEnabled(false);
			weekDayAxis.getRenderer().getLabels().getTemplate().setFill("#ffffff");

			// bubble series
			var bubbleSeries = chart.createRadarSeries();
			bubbleSeries.getDataFields().setDateX("ORDERDATE");
			bubbleSeries.getDataFields().setCategoryY("DAY_IN_WEEK");
			bubbleSeries.getDataFields().setValue("REVENUE");
			bubbleSeries.setYAxis(weekDayAxis);
			// bubbleSeries.data = dailyData;
			bubbleSeries.setStrokeOpacity(0);
			bubbleSeries.setMaskBullets(false);
			bubbleSeries.setCursorTooltipEnabled(false);
			bubbleSeries.getTooltip().setFontSize(10);
			bubbleSeries.getTooltip().setPointerOrientation("down");
			bubbleSeries.getTooltip().getBackground().setFillOpacity(0.4);

			var bubbleBullet = bubbleSeries.createCircleBullet();
			bubbleBullet.setLocationX(0.5);
			bubbleBullet.setStroke("#b9ce37");
			bubbleBullet.setFill("#b9ce37");
			/* bubbleBullet.setTooltipText("[bold]{date}, {value} km\n[font-size:13px]{title}");
			bubbleBullet.adapter.add("tooltipY", function(tooltipY, target) {
			  return -target.circle.radius;
			}) */

			// bubbleSeries.heatRules.push({ target: bubbleBullet.circle, min: 2, max: 12, dataField: "value", property: "radius" });
			bubbleSeries.getDataItems().getTemplate().getLocations().setCategoryY(0.5);

			// add month ranges
			/* for (var i = 0; i < 13; i++) {
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
			  range.axisFill.fill = am4core.color("#b9ce37");
			  range.axisFill.stroke = am4core.color("#5f6062");
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
			} */

			/* chart.cursor = new am4charts.RadarCursor();
			chart.cursor.innerRadius = am4core.percent(40);
			chart.cursor.lineY.disabled = true; */


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
			title.text = "[bold]IN " + firstDay.getFullYear() + "\nI CYCLED " + Math.round(total) + " km.\n[font-size:11; #ffffff]Each circle represents a bike ride. Size represents distance.";*/
			
   		}
   	});
});