/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.AxisRenderer.extend("io.rtdi.amchartsui5controls.AxisRendererCircular", {
		metadata: {
            properties: {
            	endAngle : {type : "float"},
            	innerRadius : {type : "any"},
            	radius : {type : "any"},
            	startAngle : {type : "float"},
            	useChartAngles : {type : "boolean"},
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
		_getGrid : function() {
			return new io.rtdi.amchartsui5controls.GridCircular();
		},
		setRadiusPercent : function(value) {
			this.setRadius(am4core.percent(value));
		},
		setInnerRadiusPercent : function(value) {
			this.setInnerRadius(am4core.percent(value));
		},

	});
});


