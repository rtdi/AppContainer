sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library',
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.axisranges.AxisRange", {
		metadata: {
            properties: {
				step : {type: "int"},
            },
		},
		_buildSettings : function() {
			oSettings = {};
			library._addFromProperty(this, oSettings, "step")
			return oSettings;
		},
	});
});