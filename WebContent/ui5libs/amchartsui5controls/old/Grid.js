/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Sprite.extend("io.rtdi.amchartsui5controls.Grid", {
		metadata: {
            properties: {
            	above : {type : "boolean"},
            	location : {type : "float"},
            },
		},
		constructor: function(mSettings) {
			io.rtdi.amchartsui5controls.Sprite.apply(this, arguments);
		},

	});
});


