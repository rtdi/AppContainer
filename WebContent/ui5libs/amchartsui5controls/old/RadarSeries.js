/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.LineSeries.extend("io.rtdi.amchartsui5controls.RadarSeries", {
		metadata: {
            properties: {
            	connectEnds : {type : "boolean" },
            }
		},
		init : function() {
		},
		_createNewAm4ChartsObject : function(oAxis) {
			return new am4charts.RadarSeries();
		},
		getDataFields : function() {
			var l = this.getProperty("dataFields");
			if (!l) {
				l = new io.rtdi.amchartsui5controls.RadarSeriesDataFields();
				this.setProperty("dataFields", l, true);
			}
			return l;
		},
		getDataItems : function() {
			var l = this.getProperty("dataItems");
			if (!l) {
				l = new io.rtdi.amchartsui5controls.RadarSeriesDataItem();
				this.setProperty("dataItems", l, true);
			}
			return l;
		},

	});
});


