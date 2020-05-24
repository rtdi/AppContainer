/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/RootWrapper"  ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.RootWrapper.extend("io.rtdi.amchartsui5controls.DateFormatter", {
		metadata: {
            properties: {
            	capitalize : {type : "boolean"},
            	dateFormat : {type : "string"},
            	firstDayOfWeek : {type : "int"},
            	inputDateFormat : {type : "string"},
            	intlLocales : {type : "string"},
            	timezoneOffset : {type : "int"},
            	utc : {type : "boolean"},
            }
		},

	});
});
