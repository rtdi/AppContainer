/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/ComponentDataFields" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.ComponentDataFields.extend("io.rtdi.amchartsui5controls.DateAxisDataFields", {
		metadata: {
            properties: {
            	date : {type : "string" },
            }
		},
		init : function() {
		},

	});
});
