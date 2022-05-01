sap.ui.define([
	'ui5libs/amcharts/base/MapSeries',
	'ui5libs/amcharts/library',
], function(MapSeries, library) {
	return MapSeries.extend("ui5libs.amcharts.base.MapLineSeries", {
		metadata: {
            properties: {
				clipBack: {type: "boolean"},
            },
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "clipBack");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5map.MapLineSeries.new", oSettings);
			return am5map.MapLineSeries.new(root, oSettings);
		},
	});
});