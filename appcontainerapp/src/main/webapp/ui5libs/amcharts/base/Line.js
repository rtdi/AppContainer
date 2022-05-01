sap.ui.define([
	'ui5libs/amcharts/base/Graphics'
], function(Graphics) {
	return Graphics.extend("ui5libs.amcharts.base.Line", {
		metadata: {
            properties: {
				points : {type: "ui5libs.amcharts.IPoint[]"},
				segments : {type: "ui5libs.amcharts.IPoint[]"},
            },
		},
		_buildSettings : function() {
			var oSettings = Graphics.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "points");
			this._addFromProperty(oSettings, "segments");
			return oSettings;
		},
	});
});