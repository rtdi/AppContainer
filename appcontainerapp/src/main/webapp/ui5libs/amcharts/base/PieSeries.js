sap.ui.define([
	'ui5libs/amcharts/base/PercentSeries',
	'ui5libs/amcharts/library'
], function(PercentSeries, library) {
	return PercentSeries.extend("ui5libs.amcharts.base.PieSeries", {
		metadata: {
            properties: {
				endAngle: {type: "int"},
				innerRadius: {type: "sap.ui.core.CSSSize"},
				radius: {type: "sap.ui.core.CSSSize"},
				startAngle: {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = PercentSeries.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "endAngle");
			this._addNumberPercentFromProperty(oSettings, "innerRadius");
			this._addNumberPercentFromProperty(oSettings, "radius");
			this._addFromProperty(oSettings, "startAngle");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5percent.PieSeries.new", oSettings);
			return am5percent.PieSeries.new(root, oSettings);
		},
		prepareChart : function() {
			PercentSeries.prototype.prepareChart.call(this);
			// PieCharts require the series angles to be the same as the chart angles to function properly
			this.setEndAngle(this.getParent().getEndAngle());
			this.setStartAngle(this.getParent().getStartAngle());
		},
	});
});
