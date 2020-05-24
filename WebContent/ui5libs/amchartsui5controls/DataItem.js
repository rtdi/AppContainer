/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/RootWrapper"  ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.RootWrapper.extend("io.rtdi.amchartsui5controls.DataItem", {
		metadata: {
            properties: {
            	categories : {type : "object"},
            	hidden : {type : "boolean"},
            	ignoreMinMax : {type : "boolean"},
            	opacity : {type : "float"},
            	visible : {type : "boolean"},
            }
		},

	});
});
