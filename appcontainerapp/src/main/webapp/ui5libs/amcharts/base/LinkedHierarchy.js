sap.ui.define([
	'ui5libs/amcharts/base/Hierarchy',
], function(Hierarchy) {
	return Hierarchy.extend("ui5libs.amcharts.base.LinkedHierarchy", {
		metadata: {
            properties: {
				linkWithField : {type: "string"},
            },
		},
		_buildSettings : function() {
			var oSettings = Hierarchy.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "linkWithField");
			return oSettings;
		},

	});
});