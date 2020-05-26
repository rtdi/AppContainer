/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/RootWrapper"  ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.RootWrapper.extend("io.rtdi.amchartsui5controls.ListTemplate", {
		metadata: {
            properties: {
            	template : {type : "object"},
            }
		},
		setTemplate: function(o) {
			this.setProperty("template", o);
		},

	});
});
