/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Axis.extend("io.rtdi.amchartsui5controls.AxisDate", {
		metadata: {
            properties: {
            }, 
            aggregations: {
            },
		},
		constructor : function() {
			io.rtdi.amchartsui5controls.Axis.prototype.constructor.apply(this, arguments);
			this._setAm4ChartObject(new am4charts.DateAxis());
		},
	});
});
