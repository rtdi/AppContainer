/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/Container" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Container.extend("io.rtdi.amchartsui5controls.Tooltip", {
		metadata: {
            properties: {
            	animationDuration : {type : "int" },
            	autoTextColor : {type : "boolean" },
            	fitPointerToBounds : {type : "boolean" },
            	getFillFromObject : {type : "boolean" },
            	getStrokeFromObject : {type : "boolean" },
            	html : {type : "string" },
            	keepTargetHover : {type : "boolean" },
            	label : {type : "io.rtdi.amchartsui5controls.Label" },
            	pointerOrientation : {type : "string" },
            	showInViewport : {type : "boolean" },
            	text : {type : "string" },
            }
		},
		init : function() {
		},

	});
});
