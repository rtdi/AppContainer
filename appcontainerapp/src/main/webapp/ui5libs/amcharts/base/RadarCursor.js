sap.ui.define([
	'ui5libs/amcharts/base/XYCursor',
	'ui5libs/amcharts/library'
], function(XYCursor, library) {
	return XYCursor.extend("ui5libs.amcharts.base.RadarCursor", {
		metadata: {
            properties: {
				endAngle: {type: "int"},
				innerRadius: {type: "sap.ui.core.CSSSize"},
				radius: {type: "sap.ui.core.CSSSize"},
				startAngle: {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = XYCursor.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "endAngle");
			this._addNumberPercentFromProperty(oSettings, "innerRadius");
			this._addNumberPercentFromProperty(oSettings, "radius");
			this._addFromProperty(oSettings, "startAngle");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5radar.RadarCursor.new", oSettings);
			return am5radar.RadarCursor.new(root, oSettings);
		},
	});
});