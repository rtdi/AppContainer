sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library',
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.IPoint", {
		metadata: {
            properties: {
				x : {type: "float"},
				y : {type: "float"},
            },
		},
		_buildSettings : function() {
			oSettings = {};
			library._addFromProperty(this, oSettings, "x")
			library._addFromProperty(this, oSettings, "y")
			return oSettings;
		},
	});
});