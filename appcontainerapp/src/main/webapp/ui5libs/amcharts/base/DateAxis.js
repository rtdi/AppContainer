sap.ui.define([
	'ui5libs/amcharts/base/ValueAxis',
	'ui5libs/amcharts/library'
], function(ValueAxis, library) {
	return ValueAxis.extend("ui5libs.amcharts.base.DateAxis", {
		metadata: {
            properties: {
				dateFormats : {type: "object"},
				endLocation : {type: "int"},
				gridIntervals : {type: "object"},
				groupCount : {type: "int"},
				groupData : {type: "boolean"},
				groupInterval : {type: "object"},
				groupIntervals : {type: "object"},
				markUnitChange: {type: "boolean" },
				periodChangeDateFormats: {type: "object" },
				startLocation: {type: "int" },
				tooltipDateFormat: {type: "string" },
				tooltipDateFormats: {type: "object" },
				tooltipIntervalOffset: {type: "float" },
            },
            aggregations: {
				baseInterval: {type: "ui5libs.amcharts.base.ITimeInterval", multiple: false},
				ranges: {type: "ui5libs.amcharts.base.axisranges.DateAxisRange", multiple: true, singlularName: "range" },
			},
		},
		_buildSettings : function() {
			var oSettings = ValueAxis.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "dateFormats");
			this._addFromProperty(oSettings, "endLocation");
			this._addFromProperty(oSettings, "gridIntervals");
			this._addFromProperty(oSettings, "groupCount");
			this._addFromProperty(oSettings, "groupData");
			this._addFromProperty(oSettings, "groupInterval");
			this._addFromProperty(oSettings, "groupIntervals");
			this._addFromProperty(oSettings, "markUnitChange");
			this._addFromProperty(oSettings, "periodChangeDateFormats");
			this._addFromProperty(oSettings, "startLocation");
			this._addFromProperty(oSettings, "tooltipDateFormat");
			this._addFromProperty(oSettings, "tooltipDateFormats");
			this._addFromProperty(oSettings, "tooltipIntervalOffset");
			if (this.getBaseInterval()) {
				var s =  this.getBaseInterval();
				this._addToSetting(oSettings, "baseInterval",s._buildSettings.apply(s));
			}
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.DateAxis.new", oSettings);
			return am5xy.DateAxis.new(root, oSettings);
		},
	});
});