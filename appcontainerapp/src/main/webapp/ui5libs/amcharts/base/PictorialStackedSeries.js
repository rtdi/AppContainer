sap.ui.define([
	'ui5libs/amcharts/base/PyramidSeries',
	'ui5libs/amcharts/library'
], function(PyramidSeries, library) {
	return PyramidSeries.extend("ui5libs.amcharts.base.PictorialStackedSeries", {
		metadata: {
            properties: {
				svgPath: {type: "string"},
            },
		},
		_buildSettings : function() {
			var oSettings = PyramidSeries.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "svgPath");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5percent.PictorialStackedSeries.new", oSettings);
			return am5percent.PictorialStackedSeries.new(root, oSettings);
		},
	});
});