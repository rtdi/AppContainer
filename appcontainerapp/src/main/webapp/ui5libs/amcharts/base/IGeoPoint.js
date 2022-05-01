sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library',
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.IGeoPoint", {
		metadata: {
            properties: {
				latitude : {type: "float"},
				longitude : {type: "float"},
            },
		},
		_buildSettings : function() {
			oSettings = {};
			library._addFromProperty(this, oSettings, "latitude")
			library._addFromProperty(this, oSettings, "longitude")
			return oSettings;
		},
	});
});