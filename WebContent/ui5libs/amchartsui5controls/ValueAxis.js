/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/Axis" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Axis.extend("io.rtdi.amchartsui5controls.ValueAxis", {
		metadata: {
            properties: {
            }
		},
		init : function() {
		},
		_createNewAm4ChartsObject : function(oAxis) {
			return new am4charts.ValueAxis();
		},
		getDataFields : function() {
			var l = this.getProperty("dataFields");
			if (!l) {
				l = new io.rtdi.amchartsui5controls.ValueAxisDataFields();
				this.setProperty("dataFields", l, true);
			}
			return l;
		},
	});
});


