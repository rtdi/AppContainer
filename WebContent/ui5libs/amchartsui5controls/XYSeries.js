/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/Component",
	"io/rtdi/amchartsui5controls/Series" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Series.extend("io.rtdi.amchartsui5controls.XYSeries", {
		metadata: {
            properties: {
            	cursorHoverEnabled : {type : "boolean"},
                cursorTooltipEnabled : {type : "boolean"},
                excludeFromTotal : {type : "boolean"},
                hideTooltipWhileZooming : {type : "boolean"},
                maskBullets : {type : "boolean"},
                snapTooltip : {type : "boolean"},
                stacked : {type : "boolean"},
                xAxis : {type : "io.rtdi.amchartsui5controls.Axis"},
                yAxis : {type : "io.rtdi.amchartsui5controls.Axis"},
            }
		},
		init : function() {
		},

	});
});
