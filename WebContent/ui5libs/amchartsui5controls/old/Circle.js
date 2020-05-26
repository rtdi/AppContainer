/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Sprite.extend("io.rtdi.amchartsui5controls.Circle", {
		metadata: {
            properties: {
            	radius : {type : "any"},
            },
		},
		init : function() {
		},

	});
});
