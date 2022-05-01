sap.ui.define([
	'ui5libs/amcharts/base/Hierarchy',
	'ui5libs/amcharts/library'
], function(Hierarchy, library) {
	return Hierarchy.extend("ui5libs.amcharts.base.Pack", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = Hierarchy.prototype._buildSettings.apply(this);
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5hierarchy.Pack.new", oSettings);
			return am5hierarchy.Pack.new(root, oSettings);
		},

	});
});