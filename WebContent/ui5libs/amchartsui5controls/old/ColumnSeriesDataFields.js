/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/XYSeriesDataFields" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.XYSeriesDataFields.extend("io.rtdi.amchartsui5controls.ColumnSeriesDataFields", {
		metadata: {
            properties: {
            	width : {type : "string" },
            }
		},
		init : function() {
		},

	});
});
