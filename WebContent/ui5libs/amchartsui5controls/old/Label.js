/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/Container"  ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Container.extend("io.rtdi.amchartsui5controls.Label", {
		metadata: {
            properties: {
            	ellipsis : {type : "string"},
            	fullWords : {type : "boolean"},
            	hideOversized : {type : "boolean"},
            	locationOnPath : {type : "float"},
            	path : {type : "string"},
            	readerTitle : {type : "string"},
            	selectable : {type : "boolean"},
            	textAlign : {type : "string"},
            	truncate : {type : "boolean"},
            	wrap : {type : "boolean"},
            }
		},

	});
});
