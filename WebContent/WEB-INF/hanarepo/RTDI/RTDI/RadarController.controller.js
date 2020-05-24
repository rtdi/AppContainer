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
   			var oRadar = oView.byId("radarchart");
   			
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
   			
			oRadar.getDataSource().setUrl("/HanaAppContainer/protected/odata/SYS/M_CS_TABLES/TABLE?$filter=SCHEMA_NAME%20eq%20%27SAPHANADB%27&$skip=0&$top=100");
   			
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

			
   		}
   	});
});