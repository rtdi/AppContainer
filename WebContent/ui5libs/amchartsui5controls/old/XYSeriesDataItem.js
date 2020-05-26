/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.SeriesDataItem.extend("io.rtdi.amchartsui5controls.XYSeriesDataItem", {
		metadata: {
            properties: {
            	categoryX : {type : "string"},
            	categoryY : {type : "string"},
            	customValue : {type : "string"},
            	dateX : {type : "date"},
            	dateY : {type : "date"},
            	openCategoryX : {type : "string"},
            	openCategoryY : {type : "string"},
            	openDateX : {type : "date"},
            	openDateY : {type : "date"},
            	openValueX : {type : "float"},
            	openValueY : {type : "float"},
            	valueX : {type : "float"},
            	valueY : {type : "float"},
            },
		},
		init : function() {
		},

	});
});
