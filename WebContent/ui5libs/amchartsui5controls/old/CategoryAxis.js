/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/Axis"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Axis.extend("io.rtdi.amchartsui5controls.CategoryAxis", {
		metadata: {
            properties: {
            }
		},
		constructor: function(mSettings) {
			io.rtdi.amchartsui5controls.Axis.apply(this, arguments);
		},
		init : function() {
		},
		_createNewAm4ChartsObject : function(oAxis) {
			return new am4charts.CategoryAxis();
		},
		getDataFields : function() {
			var l = this.getProperty("dataFields");
			if (!l) {
				l = new io.rtdi.amchartsui5controls.CategoryAxisDataFields();
				this.setProperty("dataFields", l, true);
			}
			return l;
		},
	});
});
