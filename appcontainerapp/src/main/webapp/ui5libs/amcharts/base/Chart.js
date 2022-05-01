sap.ui.define([
	'ui5libs/amcharts/base/Container'
], function(Container) {
	return Container.extend("ui5libs.amcharts.base.Chart", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = Container.prototype._buildSettings.apply(this);
			return oSettings;
		},

	});
});