sap.ui.define([
	'ui5libs/amcharts/base/LinkedHierarchy',
	'ui5libs/amcharts/library'
], function(LinkedHierarchy, library) {
	return LinkedHierarchy.extend("ui5libs.amcharts.base.Tree", {
		metadata: {
            properties: {
				orientation : {type: "ui5libs.amcharts.Orientation"},
            },
		},
		_buildSettings : function() {
			var oSettings = LinkedHierarchy.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "orientation");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5hierarchy.Tree.new", oSettings);
			return am5hierarchy.Tree.new(root, oSettings);
		},

	});
});