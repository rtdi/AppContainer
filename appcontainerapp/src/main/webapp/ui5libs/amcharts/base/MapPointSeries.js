sap.ui.define([
	'ui5libs/amcharts/base/MapSeries',
	'ui5libs/amcharts/library',
], function(MapSeries, library) {
	return MapSeries.extend("ui5libs.amcharts.base.MapPointSeries", {
		metadata: {
            properties: {
				clipBack: {type: "boolean"},
				clipFront: {type: "boolean"},
				latitudeField: {type: "string"},
				longitudeField: {type: "string"},
				polygonIdField: {type: "string"},
            },
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "clipBack");
			this._addFromProperty(oSettings, "clipFront");
			this._addFromProperty(oSettings, "latitudeField");
			this._addFromProperty(oSettings, "longitudeField");
			this._addFromProperty(oSettings, "polygonIdField");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5map.MapPointSeries.new", oSettings);
			return am5map.MapPointSeries.new(root, oSettings);
		},
	});
});