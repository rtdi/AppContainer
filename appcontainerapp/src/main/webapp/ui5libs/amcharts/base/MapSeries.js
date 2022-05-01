sap.ui.define([
	'ui5libs/amcharts/base/Series'
], function(Series) {
	return Series.extend("ui5libs.amcharts.base.MapSeries", {
		metadata: {
            properties: {
				exclude: {type: "object[]" },
				include : {type: "object[]"},
				valueField: {type: "string" },
            },
            aggregations: {
				geoJSON: {type: "ui5libs.amcharts.base.GeoJson", multiple: false},
			},
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "exclude");
			this._addFromProperty(oSettings, "include");
			this._addFromProperty(oSettings, "valueField");
			if (this.getGeoJSON()) {
				this._addToSetting(oSettings, "geoJSON", this.getGeoJSON().getData());
			}
			return oSettings;
		},
	});
});