sap.ui.require([
	'ui5libs/amcharts/dist/radar'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/XYChart',
	'ui5libs/amcharts/library',
	'ui5libs/amcharts/dist/radar'
], function(XYChart, library) {
	return XYChart.extend("ui5libs.amcharts.base.RadarChart", {
		metadata: {
            properties: {
				endAngle: {type: "int"},
				innerRadius: {type: "sap.ui.core.CSSSize"},
				radius: {type: "sap.ui.core.CSSSize"},
				startAngle: {type: "int"},
            },
            aggregations: {
				rendererX: {type: "ui5libs.amcharts.base.AxisRendererCircular", multiple: true},
				rendererY: {type: "ui5libs.amcharts.base.AxisRendererRadial", multiple: true},
				cursor: {type: "ui5libs.amcharts.base.RadarCursor", multiple: false},
			},
		},
		_buildSettings : function() {
			var oSettings = XYChart.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "endAngle");
			this._addNumberPercentFromProperty(oSettings, "innerRadius");
			this._addNumberPercentFromProperty(oSettings, "radius");
			this._addFromProperty(oSettings, "startAngle");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5radar.RadarChart.new", oSettings);
			return am5radar.RadarChart.new(root, oSettings);
		},
		getOwnContainer : function() {
			return this.container.radarContainer;
		}
	});
});