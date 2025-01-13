sap.ui.require([
	'ui5libs/amcharts/dist/percent'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/Series',
	'ui5libs/amcharts/library',
	'ui5libs/amcharts/dist/percent'
], function(Series, library) {
	return Series.extend("ui5libs.amcharts.base.PercentSeries", {
		metadata: {
            properties: {
				alignLabels: {type: "boolean" },
				categoryField: {type: "string" },
				fillField: {type: "string" },
            },
            aggregations: {
				colors: {type: "ui5libs.amcharts.base.ColorSet", multiple: false },
				labels: {type: "ui5libs.amcharts.base.RadialLabel", multiple: false },
				ticks: {type: "ui5libs.amcharts.base.Tick", multiple: false },
				slices: {type: "ui5libs.amcharts.base.Tick", multiple: false },
			}
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "alignLabels");
			this._addFromProperty(oSettings, "categoryField");
			library._addColorSetFromAggregation(this, oSettings, "colors");
			this._addFromProperty(oSettings, "fillField");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5percent.PercentSeries.new", oSettings);
			return am5percent.PercentSeries.new(root, oSettings);
		},
		getDefaultTemplate : function() {
			return this.container.slices.template;
		},
		applyTemplates : function() {
			Series.prototype.applyTemplates.apply(this);
			var labels = this.getLabels();
			if (labels) {
				this.container.labels.template.setAll(labels._buildSettings());
			}
			var ticks = this.getTicks();
			if (ticks) {
				this.container.ticks.template.setAll(ticks._buildSettings());
			}
		},
	});
});