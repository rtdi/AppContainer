sap.ui.define([
	'ui5libs/amcharts/base/Tick'
], function(Tick) {
	return Tick.extend("ui5libs.amcharts.base.AxisTick", {
		metadata: {
            properties: {
				inside : {type: "boolean"},
				location : {type: "float"},
				maxPosition : {type: "float"},
				minPosition : {type: "float"},
				multiLocation : {type: "float"},
            },
		},
		_buildSettings : function() {
			var oSettings = Tick.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "inside");
			this._addFromProperty(oSettings, "location");
			this._addFromProperty(oSettings, "maxPosition");
			this._addFromProperty(oSettings, "minPosition");
			this._addFromProperty(oSettings, "multiLocation");
			return oSettings;
		},
	});
});