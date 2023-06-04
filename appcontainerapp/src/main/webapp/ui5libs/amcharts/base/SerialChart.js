sap.ui.define([
	'ui5libs/amcharts/base/Chart',
	'ui5libs/amcharts/library'
], function(Chart, library) {
	return Chart.extend("ui5libs.amcharts.base.SerialChart", {
		metadata: {
            properties: {
				colors: {type: "object"},
            },
            aggregations: {
				series: {type: "ui5libs.amcharts.base.Series", multiple: true, singularName: "series"},
				legend: {type: "ui5libs.amcharts.base.Legend", multiple: false},
			},
		},
		prepareChart : function() {
			for (var child of this.getSeries()) {
				child.prepareChart();
			}
		},
		_buildSettings : function() {
			var oSettings = Chart.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "colors");
			return oSettings;
		},
		buildSubComponents : function() {
			Chart.prototype.buildSubComponents.apply(this);
			if (this.getLegend()) {
				var legend = this.getLegend();
				legend.parentContainer = this.container;
				legend._root = this._root;
				legend.renderChart();
			}
			if (this.getSeries()) {
				for (var series of this.getSeries()) {
					series.parentContainer = this.container;
					series._root = this._root;
					var oSeriesSettings = series._buildSettings();
					var instance = series._newInstance(this._root, oSeriesSettings);
					var container = this.container.series.push(instance);
					library.logContainerOp(this.container, instance, "series.push");
					series.container = container;
					series.buildSubComponents();
					series.applyTemplates();
				}
			}
		},
		updateData : function() {
			Chart.prototype.updateData.apply(this);
			if (this.getSeries()) {
				for (var series of this.getSeries()) {
					series.updateData();
				}
			}
			if (this.getLegend()) {
				var legend = this.getLegend().container;
				if (legend) {
					legend.data.setAll(this.container.series.values);
					library.logContainerOp(legend, instance, "data.setAll");
				}
			}
		},
	});
});