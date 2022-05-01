sap.ui.define([
	'ui5libs/amcharts/base/BaseColumnSeries',
	'ui5libs/amcharts/library'
], function(BaseColumnSeries, library) {
	return BaseColumnSeries.extend("ui5libs.amcharts.base.ColumnSeries", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = BaseColumnSeries.prototype._buildSettings.apply(this);
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.ColumnSeries.new", oSettings);
			return am5xy.ColumnSeries.new(root, oSettings);
		},
	});
});