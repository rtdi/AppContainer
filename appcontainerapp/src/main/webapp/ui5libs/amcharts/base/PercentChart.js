sap.ui.require([
	'ui5libs/amcharts/dist/percent'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/SerialChart',
	'ui5libs/amcharts/dist/percent'
], function(SerialChart) {
	return SerialChart.extend("ui5libs.amcharts.base.PercentChart", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = SerialChart.prototype._buildSettings.apply(this);
			return oSettings;
		},
		buildChart : function() {
			SerialChart.prototype.buildChart.apply(this);
		},
	});
});