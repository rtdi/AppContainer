sap.ui.define([
	'ui5libs/amcharts/base/Graphics',
	'ui5libs/amcharts/library'
], function(Graphics, library) {
	return Graphics.extend("ui5libs.amcharts.base.Circle", {
		metadata: {
            properties: {
				radius : {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = Graphics.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "radius");
			return oSettings;
		},
		_newInstance : function(root, oSettings, template) {
			// library.logContainerNewInstance("am5.Circle.new", oSettings);
			return am5.Circle.new(root, oSettings, template);
		},
	});
});