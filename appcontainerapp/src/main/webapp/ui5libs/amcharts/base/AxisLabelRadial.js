sap.ui.define([
	'ui5libs/amcharts/base/RadialLabel'
], function(RadialLabel) {
	return RadialLabel.extend("ui5libs.amcharts.base.AxisLabelRadial", {
		metadata: {
            properties: {
				location : {type: "float"},
				maxPosition : {type: "float"},
				minPosition : {type: "float"},
				multiLocation : {type: "float"},
            },
		},
		_buildSettings : function() {
			var oSettings = RadialLabel.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "location");
			this._addFromProperty(oSettings, "maxPosition");
			this._addFromProperty(oSettings, "minPosition");
			this._addFromProperty(oSettings, "multiLocation");
			return oSettings;
		},
	});
});