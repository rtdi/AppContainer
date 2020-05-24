/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/SeriesDataFields" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.SeriesDataFields.extend("io.rtdi.amchartsui5controls.XYSeriesDataFields", {
		metadata: {
            properties: {
            	hidden : {type : "string" },
            	value : {type : "string" },
            }
		},
		init : function() {
		},

	});
});
