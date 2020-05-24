/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/Component" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Component.extend("io.rtdi.amchartsui5controls.Axis", {
		metadata: {
            properties: {
            	axisRanges : {type : "io.rtdi.amchartsui5controls.ListTemplate"},
                cursorTooltipEnabled : {type : "boolean"},
                endLocation : {type : "float"},
                hideTooltipWhileZooming : {type : "boolean"},
                renderer : {type : "io.rtdi.amchartsui5controls.AxisRenderer"},
                startLocation : {type : "float"},
                title: {type : "io.rtdi.amchartsui5controls.Label"},
                toggleZoomOutButton : {type : "boolean"},
            },
            aggregations: {
            	axisBreaks: {type : "io.rtdi.amchartsui5controls.AxisBreak", multiple : true},
            }
		},
		init : function() {
		},

	});
});


