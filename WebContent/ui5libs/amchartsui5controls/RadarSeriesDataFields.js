/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.LineSeriesDataFields.extend("io.rtdi.amchartsui5controls.RadarSeriesDataFields", {
		metadata: {
            properties: {
            	width : {type : "string" },
            }
		},
		init : function() {
		},

	});
});
