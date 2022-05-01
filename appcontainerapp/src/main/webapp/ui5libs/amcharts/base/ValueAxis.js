sap.ui.define([
	'ui5libs/amcharts/base/Axis',
	'ui5libs/amcharts/library'
], function(Axis, library) {
	return Axis.extend("ui5libs.amcharts.base.ValueAxis", {
		metadata: {
            properties: {
				calculateTotals : {type: "boolean"},
				extraMax : {type: "float"},
				extraMin : {type: "float"},
				extraTooltipPrecision : {type: "int"},
				fillRule : {type: "function"},
				logarithmic : {type: "boolean"},
				max : {type: "float"},
				maxPrecision : {type: "int"},
				min: {type: "float" },
				numberFormat: {type: "string" },
				strictMinMax: {type: "boolean" },
				strictMinMaxSelection: {type: "boolean" },
				syncWithAxis: {type: "string" },
				tooltipNumberFormat: {type: "string" },
				treatZeroAs: {type: "float" },
            },
		},
		_buildSettings : function() {
			var oSettings = Axis.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "calculateTotals");
			this._addFromProperty(oSettings, "extraMax");
			this._addFromProperty(oSettings, "extraMin");
			this._addFromProperty(oSettings, "extraTooltipPrecision");
			this._addFromProperty(oSettings, "fillRule");
			this._addFromProperty(oSettings, "logarithmic");
			this._addFromProperty(oSettings, "max");
			this._addFromProperty(oSettings, "maxPrecision");
			this._addFromProperty(oSettings, "min");
			this._addFromProperty(oSettings, "numberFormat");
			this._addFromProperty(oSettings, "strictMinMax");
			this._addFromProperty(oSettings, "strictMinMaxSelection");
			this._addFromProperty(oSettings, "syncWithAxis");
			this._addFromProperty(oSettings, "tooltipNumberFormat");
			this._addFromProperty(oSettings, "treatZeroAs");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.ValueAxis.new", oSettings);
			return am5xy.ValueAxis.new(root, oSettings);
		},
	});
});