sap.ui.define([
	'ui5libs/amcharts/base/Series'
], function(Series) {
	return Series.extend("ui5libs.amcharts.base.XYSeries", {
		metadata: {
            properties: {
				xAxisIndex: {type: "int", defaultValue: 0 },
				yAxisIndex: {type: "int", defaultValue: 0 },
				xBaseAxisIndex: {type: "int" },
				yBaseAxisIndex: {type: "int" },
				categoryXField : {type: "string"},
				categoryYField : {type: "string"},
				excludeFromTotal : {type: "boolean"},
				groupDataCallback : {type: "function"},
				groupDataDisabled : {type: "boolean"},
				groupDataWithOriginals : {type: "boolean"},
				highLocationX : {type: "float"},
				highLocationY : {type: "float"},
				highValueXField : {type: "string"},
				highValueXGrouped : {type: "ui5libs.amcharts.HighValueGrouped"},
				highValueXShow : {type: "ui5libs.amcharts.HighValueShow"},
				highValueYField : {type: "string"},
				highValueYGrouped : {type: "ui5libs.amcharts.HighValueGrouped"},
				highValueYShow : {type: "ui5libs.amcharts.HighValueShow"},
				ignoreMinMax: {type: "boolean" },
				legendRangeLabelText: {type: "string" },
				legendRangeValueText: {type: "string" },
				locationX: {type: "float" },
				locationY: {type: "float" },
				lowLocationX: {type: "float" },
				lowLocationY: {type: "float" },
				lowValueXField: {type: "string" },
				lowValueXGrouped : {type: "ui5libs.amcharts.HighValueGrouped"},
				lowValueXShow : {type: "ui5libs.amcharts.HighValueShow"},
				lowValueYField: {type: "string" },
				lowValueYGrouped : {type: "ui5libs.amcharts.HighValueGrouped"},
				lowValueYShow : {type: "ui5libs.amcharts.HighValueShow"},
				maskBullets: {type: "boolean" },
				minBulletDistance: {type: "int" },
				openCategoryXField: {type: "string" },
				openCategoryYField: {type: "string" },
				openLocationX: {type: "float" },
				openLocationY: {type: "float" },
				openValueXField: {type: "string" },
				openValueXGrouped : {type: "ui5libs.amcharts.HighValueGrouped"},
				openValueXShow : {type: "ui5libs.amcharts.HighValueShow"},
				openValueYField: {type: "string" },
				openValueYGrouped : {type: "ui5libs.amcharts.HighValueGrouped"},
				openValueYShow : {type: "ui5libs.amcharts.HighValueShow"},
				seriesTooltipTarget: {type: "ui5libs.amcharts.TooltipTarget" },
				snapTooltip: {type: "boolean" },
				stackToNegative: {type: "boolean" },
				stacked: {type: "boolean" },
				tooltipDataItem: {type: "object" },
				tooltipPositionX: {type: "ui5libs.amcharts.TooltipPosition" },
				tooltipPositionY: {type: "ui5libs.amcharts.TooltipPosition" },
				valueXField: {type: "string" },
				valueXGrouped : {type: "ui5libs.amcharts.HighValueGrouped"},
				valueXShow : {type: "ui5libs.amcharts.HighValueShow"},
				valueYField: {type: "string" },
				valueYGrouped : {type: "ui5libs.amcharts.HighValueGrouped"},
				valueYShow : {type: "ui5libs.amcharts.HighValueShow"},
            },
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			var xAxis = this.parentContainer.xAxes.getIndex(this.getXAxisIndex());
			var yAxis = this.parentContainer.yAxes.getIndex(this.getYAxisIndex());
			oSettings.xAxis = xAxis;
			oSettings.yAxis = yAxis;
			if (this.getXBaseAxisIndex()) {
				oSettings.baseAxis = this.parentContainer.xAxes.getIndex(this.getXBaseAxisIndex());
			} else if (this.getYBaseAxisIndex()) {
				oSettings.baseAxis = this.parentContainer.yAxes.getIndex(this.getYBaseAxisIndex());
			}
			this._addFromProperty(oSettings, "categoryXField");
			this._addFromProperty(oSettings, "categoryYField");
			this._addFromProperty(oSettings, "excludeFromTotal");
			this._addFromProperty(oSettings, "groupDataCallback");
			this._addFromProperty(oSettings, "groupDataDisabled");
			this._addFromProperty(oSettings, "groupDataWithOriginals");
			this._addFromProperty(oSettings, "highLocationX");
			this._addFromProperty(oSettings, "highLocationY");
			this._addFromProperty(oSettings, "highValueXField");
			this._addFromProperty(oSettings, "highValueXGrouped");
			this._addFromProperty(oSettings, "highValueXShow");
			this._addFromProperty(oSettings, "highValueYField");
			this._addFromProperty(oSettings, "highValueYGrouped");
			this._addFromProperty(oSettings, "highValueYShow");
			this._addFromProperty(oSettings, "ignoreMinMax");
			this._addFromProperty(oSettings, "legendRangeLabelText");
			this._addFromProperty(oSettings, "legendRangeValueText");
			this._addFromProperty(oSettings, "locationX");
			this._addFromProperty(oSettings, "locationY");
			this._addFromProperty(oSettings, "lowValueXField");
			this._addFromProperty(oSettings, "lowValueXGrouped");
			this._addFromProperty(oSettings, "lowValueXShow");
			this._addFromProperty(oSettings, "lowValueYField");
			this._addFromProperty(oSettings, "lowValueYGrouped");
			this._addFromProperty(oSettings, "lowValueYShow");
			this._addFromProperty(oSettings, "maskBullets");
			this._addFromProperty(oSettings, "minBulletDistance");
			this._addFromProperty(oSettings, "openCategoryXField");
			this._addFromProperty(oSettings, "openCategoryYField");
			this._addFromProperty(oSettings, "openLocationX");
			this._addFromProperty(oSettings, "openLocationY");
			this._addFromProperty(oSettings, "openValueXField");
			this._addFromProperty(oSettings, "openValueXGrouped");
			this._addFromProperty(oSettings, "openValueXShow");
			this._addFromProperty(oSettings, "openValueYField");
			this._addFromProperty(oSettings, "openValueYGrouped");
			this._addFromProperty(oSettings, "openValueYShow");
			this._addFromProperty(oSettings, "seriesTooltipTarget");
			this._addFromProperty(oSettings, "snapTooltip");
			this._addFromProperty(oSettings, "stackToNegative");
			this._addFromProperty(oSettings, "stacked");
			this._addFromProperty(oSettings, "tooltipDataItem");
			this._addFromProperty(oSettings, "tooltipPositionX");
			this._addFromProperty(oSettings, "tooltipPositionY");
			this._addFromProperty(oSettings, "valueXField");
			this._addFromProperty(oSettings, "valueXGrouped");
			this._addFromProperty(oSettings, "valueXShow");
			this._addFromProperty(oSettings, "valueYField");
			this._addFromProperty(oSettings, "valueYGrouped");
			this._addFromProperty(oSettings, "valueYShow");
			return oSettings;
		},
	});
});