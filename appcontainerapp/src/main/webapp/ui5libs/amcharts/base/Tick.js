sap.ui.define([
	'ui5libs/amcharts/base/Line'
], function(Line) {
	return Line.extend("ui5libs.amcharts.base.Tick", {
		metadata: {
            properties: {
				length : {type: "int"},
				location : {type: "float"},
            },
		},
		_buildSettings : function() {
			var oSettings = Line.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "length");
			this._addFromProperty(oSettings, "location");
			return oSettings;
		},
	});
});