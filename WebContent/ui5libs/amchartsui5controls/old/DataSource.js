/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/RootWrapper"  ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.RootWrapper.extend("io.rtdi.amchartsui5controls.DataSource", {
		metadata: {
            properties: {
            	dateFormatter : {type : "io.rtdi.amchartsui5controls.DateFormatter"},
            	disableCache : {type : "boolean"},
            	incremental : {type : "boolean"},
            	incrementalParams : {type : "object"},
            	keepCount : {type : "boolean"},
            	reloadFrequency : {type : "int"},
            	showPreloader : {type : "boolean"},
            	updateCurrentData : {type : "boolean"},
            	url : {type : "string"},
            }
		},

	});
});
