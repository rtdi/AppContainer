sap.ui.define([
	'ui5libs/amcharts/base/FunnelSeries',
	'ui5libs/amcharts/library'
], function(FunnelSeries, library) {
	return FunnelSeries.extend("ui5libs.amcharts.base.PyrmaidSeries", {
		metadata: {
            properties: {
				bottomWidth: {type: "sap.ui.core.CSSSize"},
				topWidth: {type: "sap.ui.core.CSSSize"},
				valueIs: {type: "ui5libs.amcharts.ValueIs"},
            },
		},
		_buildSettings : function() {
			var oSettings = FunnelSeries.prototype._buildSettings.apply(this);
			this._addNumberPercentFromProperty(oSettings, "bottomWidth");
			this._addNumberPercentFromProperty(oSettings, "topWidth");
			this._addFromProperty(oSettings, "valueIs");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5percent.PyramidSeries.new", oSettings);
			return am5percent.PyramidSeries.new(root, oSettings);
		},
	});
});