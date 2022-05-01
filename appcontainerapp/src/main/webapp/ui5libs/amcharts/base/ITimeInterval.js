sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library',
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.ITimeInterval", {
		metadata: {
            properties: {
				count : {type: "float"},
				timeUnit : {type: "ui5libs.amcharts.DurationBaseUnit"},
            },
		},
		_buildSettings : function() {
			oSettings = {};
			library._addFromProperty(this, oSettings, "count")
			library._addFromProperty(this, oSettings, "timeUnit")
			return oSettings;
		},
	});
});