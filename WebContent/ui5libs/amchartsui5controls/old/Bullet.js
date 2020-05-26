/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Container.extend("io.rtdi.amchartsui5controls.Bullet", {
		metadata: {
            properties: {
            	copyToLegendMarker : {type : "boolean"},
            	isDynamic : {type : "boolean"},
            	locationX : {type : "float"},
            	locationY : {type : "float"},
            	xField : {type : "string"},
            	yField : {type : "string"},
            },
		},
		init : function() {
		},
		_createNewAm4ChartsObject : function(oAxis) {
			return new am4charts.Bullet();
		},

	});
});
