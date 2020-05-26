/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Bullet.extend("io.rtdi.amchartsui5controls.CircleBullet", {
		metadata: {
            properties: {
            	circle : {type : "io.rtdi.amchartsui5controls.Circle"},
            },
		},
		init : function() {
		},
		_createNewAm4ChartsObject : function(oAxis) {
			return new am4charts.CircleBullet();
		},

	});
});
