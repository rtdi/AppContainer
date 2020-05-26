/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.XYSeries.extend("io.rtdi.amchartsui5controls.ColumnSeries", {
		metadata: {
            properties: {
            	clustered : {type : "boolean"},
            	columns : {type : "io.rtdi.amchartsui5controls.ListTemplate"},
            }
		},
		init : function() {
		},

	});
});
