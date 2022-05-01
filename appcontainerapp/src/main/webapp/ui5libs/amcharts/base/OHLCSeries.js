sap.ui.define([
	'ui5libs/amcharts/base/CandlestickSeries',
	'ui5libs/amcharts/library'
], function(CandlestickSeries, library) {
	return CandlestickSeries.extend("ui5libs.amcharts.base.OHLCSeries", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = CandlestickSeries.prototype._buildSettings.apply(this);
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.OHLCSeries.new", oSettings);
			return am5xy.OHLCSeries.new(root, oSettings);
		},
	});
});