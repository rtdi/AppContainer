/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/Sprite" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Sprite.extend("io.rtdi.amchartsui5controls.Container", {
		metadata: {
            properties: {
            	contentAlign : {type : "string"},
            	contentValign : {type : "string"},
            	fixedWidthGrid : {type : "boolean"},
            	fontFamily : {type : "string"},
            	fontSize : {type : "any"},
            	fontWeight : {type : "any"},
            	layout : {type : "any"},
            	contentAlign : {type : "string"},
            	maxColumns : {type : "int"},
            	minHeight : {type : "float"},
            	minWidth : {type : "float"},
            	reverseOrder : {type : "boolean"},
            	setStateOnChildren : {type : "boolean"},
            	textDecoration : {type : "string"},
            }
		},
		init : function() {
		},

	});
});
