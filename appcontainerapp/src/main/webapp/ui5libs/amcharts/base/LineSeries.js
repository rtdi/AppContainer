sap.ui.define([
	'ui5libs/amcharts/base/XYSeries',
	'ui5libs/amcharts/library'
], function(XYSeries, library) {
	return XYSeries.extend("ui5libs.amcharts.base.LineSeries", {
		metadata: {
            properties: {
				autoGapCount: {type: "float" },
				connect: {type: "boolean" },
            },
            aggregations: {
				strokes: {type: "ui5libs.amcharts.base.Graphics", multiple: false, singularName: "strokes"},
				fills: {type: "ui5libs.amcharts.base.Graphics", multiple: false, singularName: "fills"},
			},
		},
		_buildSettings : function() {
			var oSettings = XYSeries.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "autoGapCount");
			this._addFromProperty(oSettings, "connect");
			return oSettings;
		},
		applyTemplates : function() {
			XYSeries.prototype.applyTemplates.apply(this);
			if (this.getStrokes()) {
				var oSettings = this.getStrokes()._buildSettings.apply(this.getStrokes());
				this.container.strokes.template.setAll(oSettings);
			}
			if (this.getFills()) {
				var oSettings = this.getFills()._buildSettings.apply(this.getFills());
				this.container.fills.template.setAll(oSettings);
			}
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.LineSeries.new", oSettings);
			return am5xy.LineSeries.new(root, oSettings);
		},
		getDefaultTemplate : function() {
			return this.container.strokes.template;
		},
	});
});