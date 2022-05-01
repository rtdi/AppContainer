sap.ui.define([
	'ui5libs/amcharts/base/Axis',
	'ui5libs/amcharts/library'
], function(Axis, library) {
	return Axis.extend("ui5libs.amcharts.base.CategoryAxis", {
		metadata: {
            properties: {
				categoryField : {type: "string"},
				endLocation : {type: "int"},
				fillRule : {type: "function"},
				startLocation : {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = Axis.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "categoryField");
			this._addFromProperty(oSettings, "endLocation");
			this._addFromProperty(oSettings, "fillRule");
			this._addFromProperty(oSettings, "startLocation");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.CategoryAxis.new", oSettings);
			return am5xy.CategoryAxis.new(root, oSettings);
		},
	});
});