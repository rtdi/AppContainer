sap.ui.define([
	'ui5libs/amcharts/base/PercentChart',
	'ui5libs/amcharts/library'
], function(PercentChart, library) {
	return PercentChart.extend("ui5libs.amcharts.base.PieChart", {
		metadata: {
            properties: {
				endAngle: {type: "int"},
				innerRadius: {type: "sap.ui.core.CSSSize"},
				radius: {type: "sap.ui.core.CSSSize"},
				startAngle: {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = PercentChart.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "endAngle");
			this._addNumberPercentFromProperty(oSettings, "innerRadius");
			this._addNumberPercentFromProperty(oSettings, "radius");
			this._addFromProperty(oSettings, "startAngle");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5percent.PieChart.new", oSettings);
			return am5percent.PieChart.new(root, oSettings);
		},

	});
});