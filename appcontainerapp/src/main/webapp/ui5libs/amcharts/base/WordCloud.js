sap.ui.require([
	'ui5libs/amcharts/dist/wc'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/Series',
	'ui5libs/amcharts/library',
	'ui5libs/amcharts/dist/wc'
], function(Series, library) {
	return Series.extend("ui5libs.amcharts.base.WordCloud", {
		metadata: {
            properties: {
				angles: {type: "int[]" },
				animationDuration: {type: "int" },
				animationEasing: {type: "function" },
				autoFit: {type: "boolean" },
				categoryField: {type: "string" },
				colors: {type: "object" },
				excludeWords: {type: "string[]" },
				fillField: {type: "string" },
				maxCount: {type: "int" },
				maxFontSize: {type: "sap.ui.core.CSSSize" },
				minFontSize: {type: "sap.ui.core.CSSSize" },
				minValue: {type: "int" },
				minWordLength: {type: "int" },
				randomness: {type: "float" },
				step: {type: "float" },
				text: {type: "string" },
            },
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "angles");
			this._addFromProperty(oSettings, "animationDuration");
			this._addFromProperty(oSettings, "animationEasing");
			this._addFromProperty(oSettings, "autoFit");
			this._addFromProperty(oSettings, "categoryField");
			this._addFromProperty(oSettings, "colors");
			this._addFromProperty(oSettings, "excludeWords");
			this._addFromProperty(oSettings, "fillField");
			this._addFromProperty(oSettings, "maxCount");
			this._addNumberPercentFromProperty(oSettings, "maxFontSize");
			this._addNumberPercentFromProperty(oSettings, "minFontSize");
			this._addFromProperty(oSettings, "minWordLength");
			this._addFromProperty(oSettings, "randomness");
			this._addFromProperty(oSettings, "step");
			this._addFromProperty(oSettings, "text");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5wc.WordCloud.new", oSettings);
			return am5wc.WordCloud.new(root, oSettings);
		},
	});
});