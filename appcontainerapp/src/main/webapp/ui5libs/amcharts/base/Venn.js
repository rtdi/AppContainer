sap.ui.require([
	'ui5libs/amcharts/dist/venn'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/Series',
	'ui5libs/amcharts/library',
	'ui5libs/amcharts/dist/venn'
], function(Series, library) {
	return Series.extend("ui5libs.amcharts.base.Venn", {
		metadata: {
            properties: {
				categoryField: {type: "string" },
				colors: {type: "object" },
				fillField: {type: "string" },
				intersectionsField: {type: "string" },
            },
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "categoryField");
			this._addFromProperty(oSettings, "colors");
			this._addFromProperty(oSettings, "fillField");
			this._addFromProperty(oSettings, "intersectionsField");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5venn.Venn.new", oSettings);
			return am5venn.Venn.new(root, oSettings);
		},
	});
});