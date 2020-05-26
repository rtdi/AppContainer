/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.XYSeries.extend("io.rtdi.amchartsui5controls.LineSeries", {
		metadata: {
            properties: {
            	autoGapCount : {type : "float" },
            	connect : {type : "boolean" },
            	minDistance : {type : "float" },
            	segments : {type : "io.rtdi.amchartsui5controls.ListTemplate" },
            	tensionX : {type : "float" },
            	tensionY : {type : "float" },
            }
		},
		init : function() {
		},

	});
});


