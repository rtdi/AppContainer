/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.AxisRendererY.extend("io.rtdi.amchartsui5controls.AxisRendererRadial", {
		metadata: {
            properties: {
            	axisAngle : {type : "float"},
            	endAngle : {type : "float"},
            	gridType : {type : "string"},
            	innerRadius : {type : "any"},
            	radius : {type : "any"},
            	startAngle : {type : "float"},
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
		setRadiusPercent : function(value) {
			this.setRadius(am4core.percent(value));
		},
		setInnerRadiusPercent : function(value) {
			this.setInnerRadius(am4core.percent(value));
		},
	});
});


