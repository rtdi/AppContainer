/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.AxisLabel.extend("io.rtdi.amchartsui5controls.AxisLabelCircular", {
		metadata: {
            properties: {
            	bent : {type : "boolean"},
            	radius : {type : "any"},
            	relativeRotation : {type : "float"},
            }
		},
		setRadiusPercent : function(value) {
			this.setProperty("radius", am4core.percent(value), false);
		},

	});
});
