sap.ui.define([
	'ui5libs/amcharts/base/Graphics'
], function(Graphics) {
	return Graphics.extend("ui5libs.amcharts.base.Grid", {
		metadata: {
            properties: {
				location : {type: "float"},
            },
		},
		_buildSettings : function() {
			var oSettings = Graphics.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "location");
			return oSettings;
		},
	});
});