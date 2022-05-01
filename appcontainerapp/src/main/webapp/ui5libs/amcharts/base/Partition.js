sap.ui.define([
	'ui5libs/amcharts/base/Hierarchy',
	'ui5libs/amcharts/library'
], function(Hierarchy, library) {
	return Hierarchy.extend("ui5libs.amcharts.base.Partition", {
		metadata: {
            properties: {
				orientation : {type: "ui5libs.amcharts.Orientation"},
				nodePadding : {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = Hierarchy.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "orientation");
			this._addFromProperty(oSettings, "nodePadding");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5hierarchy.Partition.new", oSettings);
			return am5hierarchy.Partition.new(root, oSettings);
		},

	});
});