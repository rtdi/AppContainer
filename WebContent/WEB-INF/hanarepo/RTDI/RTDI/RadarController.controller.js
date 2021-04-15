/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
           	"sap/ui/core/mvc/Controller",
           	"io/rtdi/amchartsui5controls/library"
   ], function(Controller) {
   	"use strict";
   	return Controller.extend("ui5app.RadarController", {
   		onInit : function() {
			var oView = sap.ui.getCore().byId("mainview");
   			var oControl = oView.byId("radarchart");
   			var oFilterModel = new sap.ui.model.json.JSONModel( { year: 2003} );
   			oControl.setModel(oFilterModel);
   			var chart = oControl.getChart();
   			
		    /* var oModel = new sap.ui.model.odata.v4.ODataModel({
	    		serviceUrl : "/AppContainer/protected/odata/RTDI/SALES_DATA_WEEKLY/", 
	    		"autoExpandSelect": true,
				"operationMode": "Server",
				"groupId": "$direct",
				"synchronizationMode": "None"
		    });
		    
		    var oBindingContext = oModel.bindContext("/TABLE", undefined, {
		          $$ownRequest: true,
		          $filter : "YEAR_ID eq 2003",
		          // $select: ["TABLE_NAME", "MEMORY_SIZE_IN_TOTAL", "RECORD_COUNT"]
		        });
		    
		    var oContext = oBindingContext.getBoundContext();
		    var oProperty = oModel.bindProperty("WEEK_START_DATE", oContext);
		    var oProperty = oModel.bindProperty("YEAR_ID", oContext);
		    var oProperty = oModel.bindProperty("WEEK_ID", oContext);
		    var oProperty = oModel.bindProperty("REVENUE", oContext);
		    
		    
		    oBindingContext.initialize();
		    
		    oBindingContext.requestObject().then(function (o) {
	            var data = o; 
		    });
		    
		    
		    var oList = oModel.bindList("/TABLE", undefined, undefined, undefined, {
		          $$ownRequest: true,
		          $filter : "YEAR_ID eq 2003",
		          // $select: ["TABLE_NAME", "MEMORY_SIZE_IN_TOTAL", "RECORD_COUNT"]
		        });
		    var oListContext = oList.getContext();
		    var oProperty = oModel.bindProperty("WEEK_START_DATE", oListContext);
		    var oProperty = oModel.bindProperty("YEAR_ID", oListContext);
		    var oProperty = oModel.bindProperty("WEEK_ID", oListContext);
		    var oProperty = oModel.bindProperty("REVENUE", oListContext);
		    
		    oList.initialize();
		    
		    var sUrl = oList.requestDownloadUrl().then(function (o) {
		    	var x = o;
		    });
		    
		    oList.requestContexts().then(function (aContexts) {
		        aContexts.forEach(function (oContext) {
		            var data = oContext.getObject(); 
		        });
		    }); */

		    
/*		    chart.setChartInitCallback(this.initChart);
		    
		    
   		},
   		initChart : function(oControl, chart) { */
   			
   			chart.innerRadius = am4core.percent(15);
   			chart.radius = am4core.percent(90);
   			chart.fontSize = "11px";
   			chart.startAngle = 95;
   			chart.endAngle = chart.startAngle + 350;
   			chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

   			var da = oControl.addNewYearXAxis();
   			var dateAxis = da.getAm4ChartObject();
   			da.setYearPath("/year");
   			dateAxis.renderer.innerRadius = oControl.createCSSPercentNumber(40);
   			dateAxis.renderer.labels.template.radius = oControl.createCSSPercentNumber(-57);

   			var va = oControl.addNewValueYAxis();
   			var valueAxis = va.getAm4ChartObject();
   			valueAxis.renderer.inversed = true;
   			valueAxis.renderer.radius = oControl.createCSSPercentNumber(40);
   			valueAxis.renderer.minGridDistance = 15;
   			valueAxis.renderer.minLabelPosition = 0.05;
   			valueAxis.renderer.axisAngle = 90;
   			valueAxis.cursorTooltipEnabled = false;
   			valueAxis.renderer.labels.template.fill = oControl.createCSSColor("#000000");

   			// Create series
   			var cs = oControl.addNewRadarColumnSeries();
   			var columnSeries = cs.getAm4ChartObject();
   			columnSeries.dataFields.dateX = "WEEK_START_DATE";
   			columnSeries.dataFields.valueY = "REVENUE";
   			cs.setODataUrl("/AppContainer/protected/odata/RTDI/SALES_DATA_WEEKLY/", "TABLE");
   			cs.addFilter(new io.rtdi.amchartsui5controls.DataProviderFilterEqual("YEAR_ID", "/year"));

   			columnSeries.columns.template.strokeOpacity = 0;
   			columnSeries.columns.template.width = oControl.createCSSPercentNumber(95);
   			columnSeries.fill = oControl.createCSSColor("#00ffff");
   			columnSeries.fillOpacity = 0.6;
   			columnSeries.tooltip.fontSize = 10;
   			columnSeries.tooltip.pointerOrientation = "down";
   			columnSeries.tooltip.background.fillOpacity = 1;
   			columnSeries.columns.template.tooltipText = "[bold]week {DAY_IN_WEEK}\n[font-size:13px]Total {valueY}";
   			columnSeries.cursorTooltipEnabled = false;

   			var wa = oControl.addNewWeekdayYAxis();
   			var weekDayAxis = wa.getAm4ChartObject();
   			

   			// bubble series
   			var bs = oControl.addNewRadarSeries();
   			var bubbleSeries = bs.getAm4ChartObject();
   			bubbleSeries.dataFields.dateX = "ORDERDATE";
   			bubbleSeries.dataFields.categoryY = "DAY_IN_WEEK";
   			bubbleSeries.dataFields.value = "REVENUE";
   			bs.setODataUrl("/AppContainer/protected/odata/RTDI/SALES_DATA_DAILY/", "TABLE");
   			bs.addFilter(new io.rtdi.amchartsui5controls.DataProviderFilterEqual("YEAR_ID", "/year"));
   			
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


   			chart.cursor = new am4charts.RadarCursor();
   			chart.cursor.innerRadius = am4core.percent(40);
   			chart.cursor.lineY.disabled = true;
   			
   			// oDataProvider.updateData();


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