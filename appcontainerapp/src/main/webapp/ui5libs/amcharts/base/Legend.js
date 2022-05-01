sap.ui.define([
	'ui5libs/amcharts/base/Series',
	'ui5libs/amcharts/library'
], function(Series, library) {
	return Series.extend("ui5libs.amcharts.base.Legend", {
		metadata: {
            properties: {
				clickTarget: {type: "ui5libs.amcharts.ClickTarget" },
				fillField: {type: "string" },
				nameField : {type: "string"},
				strokeField : {type: "string"},
				useDefaultMarker : {type: "boolean"},
				seriesIndex : {type: "int", defaultValue: 0},
            },
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "clickTarget");
			this._addFromProperty(oSettings, "fillField");
			this._addFromProperty(oSettings, "nameField");
			this._addFromProperty(oSettings, "strokeField");
			this._addFromProperty(oSettings, "useDefaultMarker");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5.Legend.new", oSettings);
			return am5.Legend.new(root, oSettings);
		},
		_setComponentData : function() {
			/*
			 * Legend does not set the data itself, it is set by the Series
			 */
		}
	});
});