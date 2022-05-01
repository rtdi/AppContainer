sap.ui.define([
	'ui5libs/amcharts/base/ColumnSeries',
	'ui5libs/amcharts/library'
], function(ColumnSeries, library) {
	return ColumnSeries.extend("ui5libs.amcharts.base.CandlestickSeries", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = ColumnSeries.prototype._buildSettings.apply(this);
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.CandlestickSeries.new", oSettings);
			return am5xy.CandlestickSeries.new(root, oSettings);
		},
	});
});