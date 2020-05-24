/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"  ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.RootWrapper.extend("io.rtdi.amchartsui5controls.LegendSettings", {
		metadata: {
            properties: {
            	createMarker : {type : "boolean"},
            	itemLabelText : {type : "string"},
            	itemValueText : {type : "string"},
            	labelText : {type : "string"},
            	valueText : {type : "string"},
            }
		},

	});
});
