sap.ui.define([
	'ui5libs/amcharts/base/BaseColumnSeries',
	'ui5libs/amcharts/library'
], function(BaseColumnSeries, library) {
	return BaseColumnSeries.extend("ui5libs.amcharts.base.RadarColumnSeries", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = BaseColumnSeries.prototype._buildSettings.apply(this);
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5radar.RadarColumnSeries.new", oSettings);
			return am5radar.RadarColumnSeries.new(root, oSettings);
		},
	});
});