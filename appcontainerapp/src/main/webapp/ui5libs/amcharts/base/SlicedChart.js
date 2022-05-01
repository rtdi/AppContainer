sap.ui.define([
	'ui5libs/amcharts/base/PercentChart',
	'ui5libs/amcharts/library'
], function(PercentChart, library) {
	return PercentChart.extend("ui5libs.amcharts.base.SlicedChart", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = PercentChart.prototype._buildSettings.apply(this);
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5percent.SlicedChart.new", oSettings);
			return am5percent.SlicedChart.new(root, oSettings);
		},

	});
});