sap.ui.define([
	'ui5libs/amcharts/base/LineSeries',
	'ui5libs/amcharts/library'
], function(LineSeries, library) {
	return LineSeries.extend("ui5libs.amcharts.base.RadarLineSeries", {
		metadata: {
            properties: {
				connectEnds: {type: "boolean" },
            },
		},
		_buildSettings : function() {
			var oSettings = LineSeries.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "connectEnds");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5radar.RadarLineSeries.new", oSettings);
			return am5radar.RadarLineSeries.new(root, oSettings);
		},
	});
});