/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Container.extend("io.rtdi.amchartsui5controls.LineSeriesSegment", {
		metadata: {
            properties: {
            	fillSprite : {type : "io.rtdi.amchartsui5controls.Sprite"},
            	strokeSprite : {type : "io.rtdi.amchartsui5controls.Sprite"},
            },
		},
		init : function() {
		},

	});
});
