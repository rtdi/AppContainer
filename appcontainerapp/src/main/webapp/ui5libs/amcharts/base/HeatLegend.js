sap.ui.define([
	'ui5libs/amcharts/base/Container',
	'ui5libs/amcharts/library'
], function(Container, library) {
	return Container.extend("ui5libs.amcharts.base.HeatLegend", {
		metadata: {
            properties: {
				endColor : {type: "sap.ui.core.CSSColor"},
				endText : {type: "string"},
				endValue: {type: "float" },
				orientation: {type: "ui5libs.amcharts.Orientation" },
				startColor : {type: "sap.ui.core.CSSColor"},
				startText : {type: "string"},
				startValue: {type: "float" },
				stepCount: {type: "float" },
            },
		},
		setComponentData : function(data) {
			this.setProperty("componentData", data, true);
			this._setComponentData();
		},
		_buildSettings : function() {
			var oSettings = Container.prototype._buildSettings.apply(this);
			library._addColorFromProperty(this, oSettings, "endColor");
			this._addFromProperty(oSettings, "endText");
			this._addFromProperty(oSettings, "endValue");
			this._addFromProperty(oSettings, "orientation");
			library._addColorFromProperty(this, oSettings, "startColor");
			this._addFromProperty(oSettings, "startText");
			this._addFromProperty(oSettings, "startValue");
			this._addFromProperty(oSettings, "stepCount");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5.HeatLegend.new", oSettings);
			return am5.HeatLegend.new(root, oSettings);
		},

	});
});