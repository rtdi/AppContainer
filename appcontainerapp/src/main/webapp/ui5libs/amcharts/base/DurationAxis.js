sap.ui.define([
	'ui5libs/amcharts/base/ValueAxis',
	'ui5libs/amcharts/library'
], function(ValueAxis, library) {
	return ValueAxis.extend("ui5libs.amcharts.base.DurationAxis", {
		metadata: {
            properties: {
				baseUnit : {type: "ui5libs.amcharts.DurationBaseUnit"},
            },
		},
		_buildSettings : function() {
			var oSettings = ValueAxis.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "baseUnit");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.DurationAxis.new", oSettings);
			return am5xy.DurationAxis.new(root, oSettings);
		},
	});
});