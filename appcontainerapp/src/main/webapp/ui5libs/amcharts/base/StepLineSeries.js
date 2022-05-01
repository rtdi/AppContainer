sap.ui.define([
	'ui5libs/amcharts/base/LineSeries',
	'ui5libs/amcharts/library'
], function(LineSeries, library) {
	return LineSeries.extend("ui5libs.amcharts.base.StepLineSeries", {
		metadata: {
            properties: {
				noRisers: {type: "boolean" },
				stepWidth: {type: "int" },
            },
		},
		_buildSettings : function() {
			var oSettings = LineSeries.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "noRisers");
			this._addFromProperty(oSettings, "stepWidth", am5.percent(this.getProperty("stepWidth")));
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.StepLineSeries.new", oSettings);
			return am5xy.StepLineSeries.new(root, oSettings);
		},
	});
});