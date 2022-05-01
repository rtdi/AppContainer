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
				colors: {type: "object" },
				fillField: {type: "string" },
            },
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "alignLabels");
			this._addFromProperty(oSettings, "categoryField");
			this._addFromProperty(oSettings, "colors");
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
	});
});