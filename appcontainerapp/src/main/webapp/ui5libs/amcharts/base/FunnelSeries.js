sap.ui.define([
	'ui5libs/amcharts/base/PercentSeries',
	'ui5libs/amcharts/library'
], function(PercentSeries, library) {
	return PercentSeries.extend("ui5libs.amcharts.base.FunnelSeries", {
		metadata: {
            properties: {
				alignLabels: {type: "boolean"},
				bottomRatio: {type: "int"},
				endLocation: {type: "int"},
				ignoreZeroValues: {type: "boolean"},
				orientation: {type: "ui5libs.amcharts.Orientation"},
				startLocation: {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = PercentSeries.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "alignLabels");
			this._addFromProperty(oSettings, "bottomRatio");
			this._addFromProperty(oSettings, "endLocation");
			this._addFromProperty(oSettings, "ignoreZeroValues");
			this._addFromProperty(oSettings, "orientation");
			this._addFromProperty(oSettings, "startLocation");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5percent.FunnelSeries.new", oSettings);
			return am5percent.FunnelSeries.new(root, oSettings);
		},
	});
});