sap.ui.define([
	'ui5libs/amcharts/base/AxisRenderer',
	'ui5libs/amcharts/library'
], function(AxisRenderer, library) {
	return AxisRenderer.extend("ui5libs.amcharts.base.AxisRendererX", {
		metadata: {
            properties: {
				inside : {type: "boolean"},
				opposite : {type: "boolean"},
            },
		},
		_buildSettings : function() {
			var oSettings = AxisRenderer.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "inside");
			this._addFromProperty(oSettings, "opposite");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.AxisRendererX.new", oSettings);
			return am5xy.AxisRendererX.new(root, oSettings);
		},

	});
});