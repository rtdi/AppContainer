/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.AxisRenderer.extend("io.rtdi.amchartsui5controls.AxisRendererY", {
		metadata: {
            properties: {
            },
		},
		constructor: function(mSettings) {
			io.rtdi.amchartsui5controls.AxisRenderer.apply(this, arguments);
		},
		init : function() {
		},
		_getAxisLabel : function() {
			return new io.rtdi.amchartsui5controls.AxisLabelCircular();
		},
	});
});


