/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Label.extend("io.rtdi.amchartsui5controls.AxisLabel", {
		metadata: {
            properties: {
            	inside : {type : "boolean"},
            	location : {type : "float"},
            }
		},

	});
});
