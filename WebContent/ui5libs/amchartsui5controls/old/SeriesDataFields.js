/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/ComponentDataFields" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.ComponentDataFields.extend("io.rtdi.amchartsui5controls.SeriesDataFields", {
		metadata: {
            properties: {
            	categoryX : {type : "string" },
            	categoryY : {type : "string" },
            	customValue : {type : "string" },
            	dateX : {type : "string" },
            	dateY : {type : "string" },
            	openCategoryX : {type : "string" },
            	openCategoryY : {type : "string" },
            	openDateX : {type : "string" },
            	openDateY : {type : "string" },
            	openValueX : {type : "string" },
            	openValueXShow : {type : "string" },
            	openValueY : {type : "string" },
            	openValueYShow : {type : "string" },
            	valueX : {type : "string" },
            	valueXShow : {type : "string" },
            	valueY : {type : "string" },
            	valueYShow : {type : "string" },
            }
		},
		init : function() {
		},

	});
});
