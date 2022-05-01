sap.ui.define([
	'ui5libs/amcharts/base/Label'
], function(Label) {
	return Label.extend("ui5libs.amcharts.base.AxisLabel", {
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
			var oSettings = Label.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "inside");
			this._addFromProperty(oSettings, "location");
			this._addFromProperty(oSettings, "maxPosition");
			this._addFromProperty(oSettings, "minPosition");
			this._addFromProperty(oSettings, "multiLocation");
			return oSettings;
		},
	});
});