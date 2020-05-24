/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Sprite.extend("io.rtdi.amchartsui5controls.RoundedRectangle", {
		metadata: {
            properties: {
            	cornerRadiusBottomLeft : {type : "any"},
            	cornerRadiusBottomRight : {type : "any"},
            	cornerRadiusTopLeft : {type : "any"},
            	cornerRadiusTopRight : {type : "any"},
            }
		},
		init : function() {
		},

	});
});
