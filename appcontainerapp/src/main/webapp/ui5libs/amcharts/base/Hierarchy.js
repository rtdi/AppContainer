sap.ui.require([
	'ui5libs/amcharts/dist/hierarchy'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/Series',
	'ui5libs/amcharts/dist/hierarchy'
], function(Series) {
	return Series.extend("ui5libs.amcharts.base.Hierarchy", {
		metadata: {
            properties: {
				animationDuration: {type: "int" },
				animationEasing: {type: "function" },
				categoryField: {type: "string" },
				childDataField: {type: "string" },
				colors : {type: "object"},
				disabledField : {type: "string"},
				downDepth : {type: "int"},
				fillField : {type: "string"},
				initialDepth : {type: "int"},
				selectedDataItem : {type: "object"},
				singleBranchOnly : {type: "boolean"},
				sort : {type: "object"},
				topDepth : {type: "int"},
				upDepth : {type: "int"},
				valueField : {type: "string"},
            },
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "animationDuration");
			this._addFromProperty(oSettings, "animationEasing");
			this._addFromProperty(oSettings, "categoryField");
			this._addFromProperty(oSettings, "childDataField");
			this._addFromProperty(oSettings, "colors");
			this._addFromProperty(oSettings, "disabledField");
			this._addFromProperty(oSettings, "downDepth");
			this._addFromProperty(oSettings, "fillField");
			this._addFromProperty(oSettings, "initialDepth");
			this._addFromProperty(oSettings, "selectedDataItem");
			this._addFromProperty(oSettings, "singleBranchOnly");
			this._addFromProperty(oSettings, "sort");
			this._addFromProperty(oSettings, "topDepth");
			this._addFromProperty(oSettings, "upDepth");
			this._addFromProperty(oSettings, "valueField");
			return oSettings;
		},
	});
});