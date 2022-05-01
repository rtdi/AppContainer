sap.ui.define([
	'ui5libs/amcharts/base/DateAxis',
	'ui5libs/amcharts/library'
], function(DateAxis, library) {
	return DateAxis.extend("ui5libs.amcharts.base.GaplessDateAxis", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = DateAxis.prototype._buildSettings.apply(this);
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.GaplessDateAxis.new", oSettings);
			return am5xy.GaplessDateAxis.new(root, oSettings);
		},
	});
});