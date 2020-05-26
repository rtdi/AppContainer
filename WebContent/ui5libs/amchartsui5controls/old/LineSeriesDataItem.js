/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"  ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.XYSeriesDataItem.extend("io.rtdi.amchartsui5controls.LineSeriesDataItem", {
		metadata: {
            properties: {
            	// point : {type : "io.rtdi.amchartsui5controls.Point" },
            	segment : {type : "io.rtdi.amchartsui5controls.LineSeriesSegment" },
            }
		},

	});
});
