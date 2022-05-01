sap.ui.define([
	'ui5libs/amcharts/base/AxisRenderer',
	'ui5libs/amcharts/library'
], function(AxisRenderer, library) {
	return AxisRenderer.extend("ui5libs.amcharts.base.AxisRendererCircular", {
		metadata: {
            properties: {
				axisAngle: {type: "int"},
				endAngle: {type: "int"},
				innerRadius: {type: "sap.ui.core.CSSSize"},
				dRadius: {type: "int"},
				radius: {type: "sap.ui.core.CSSSize"},
				startAngle: {type: "int"},
            },
            aggregations: {
				labels: {type: "ui5libs.amcharts.base.AxisLabelRadial", multiple: false},
			},
		},
		_buildSettings : function() {
			var oSettings = AxisRenderer.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "axisAngle");
			this._addFromProperty(oSettings, "endAngle");
			this._addNumberPercentFromProperty(oSettings, "innerRadius");
			this._addFromProperty(oSettings, "dRadius");
			this._addNumberPercentFromProperty(oSettings, "radius");
			this._addFromProperty(oSettings, "startAngle");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5radar.AxisRendererCircular.new", oSettings);
			return am5radar.AxisRendererCircular.new(root, oSettings);
		},

	});
});