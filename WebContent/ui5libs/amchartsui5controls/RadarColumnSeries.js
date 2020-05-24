/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.ColumnSeries.extend("io.rtdi.amchartsui5controls.RadarColumnSeries", {
		metadata: {
            properties: {
            }
		},
		init : function() {
		},
		_createNewAm4ChartsObject : function(oAxis) {
			return new am4charts.RadarColumnSeries();
		},
		getColumns : function() {
			var l = this.getProperty("columns");
			if (!l) {
				l = new io.rtdi.amchartsui5controls.ListTemplate();
				l.setTemplate(new io.rtdi.amchartsui5controls.RadarColumn());
				this.setProperty("columns", l, true);
			}
			return l;
		},
		getDataFields : function() {
			var l = this.getProperty("dataFields");
			if (!l) {
				l = new io.rtdi.amchartsui5controls.RadarColumnSeriesDataFields();
				this.setProperty("dataFields", l, true);
			}
			return l;
		},

	});
});
