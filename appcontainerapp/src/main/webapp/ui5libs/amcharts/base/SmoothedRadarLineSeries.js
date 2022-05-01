sap.ui.define([
	'ui5libs/amcharts/base/RadarLineSeries',
	'ui5libs/amcharts/library'
], function(RadarLineSeries, library) {
	return RadarLineSeries.extend("ui5libs.amcharts.base.SmoothedRadarLineSeries", {
		metadata: {
            properties: {
				tension: {type: "float" },
            },
		},
		_buildSettings : function() {
			var oSettings = RadarLineSeries.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "tension");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5radar.SmoothedRadarLineSeries.new", oSettings);
			return am5radar.SmoothedRadarLineSeries.new(root, oSettings);
		},
	});
});