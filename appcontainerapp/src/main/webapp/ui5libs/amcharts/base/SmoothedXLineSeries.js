sap.ui.define([
	'ui5libs/amcharts/base/LineSeries',
	'ui5libs/amcharts/library'
], function(LineSeries, library) {
	return LineSeries.extend("ui5libs.amcharts.base.SmoothedXLineSeries", {
		metadata: {
            properties: {
				tension: {type: "float" },
            },
		},
		_buildSettings : function() {
			var oSettings = LineSeries.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "tension");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.SmoothedXLineSeries.new", oSettings);
			return am5xy.SmoothedXLineSeries.new(root, oSettings);
		},
	});
});