/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"  ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.DataItem.extend("io.rtdi.amchartsui5controls.LegendDataItem", {
		metadata: {
            properties: {
            	color : {type : "any"},
            	label : {type : "io.rtdi.amchartsui5controls.Label"},
            	marker : {type : "io.rtdi.amchartsui5controls.Container"},
            	valueLabel : {type : "io.rtdi.amchartsui5controls.Label"},
            }
		},

	});
});
