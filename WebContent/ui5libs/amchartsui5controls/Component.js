/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/Container" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Container.extend("io.rtdi.amchartsui5controls.Component", {
		metadata: {
            properties: {
                data : {type : "any" },
                dataFields : {type : "io.rtdi.amchartsui5controls.ComponentDataFields" },
                dataItems : {type : "io.rtdi.amchartsui5controls.DataItem"},
                dataSourceUrl : {type : "io.rtdi.amchartsui5controls.DataSource" },
                interpolationDuration : {type : "int" },
                maxZoomCount : {type : "int" },
                maxZoomFactor : {type : "float" },
                minZoomCount : {type : "int" },
                rangeChangeDuration : {type : "int" },
                sequencedInterpolation : {type : "boolean" },
                sequencedInterpolationDelay : {type : "int" },
                skipRangeEvent : {type : "boolean" },
                start : {type : "float" },
            }
		},
		init : function() {
		},

	});
});
