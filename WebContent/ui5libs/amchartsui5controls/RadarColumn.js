/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Column.extend("io.rtdi.amchartsui5controls.RadarColumn", {
		metadata: {
            properties: {
            	radarColumn : {type : "any"},
            }
		},
		init : function() {
		},

	});
});
