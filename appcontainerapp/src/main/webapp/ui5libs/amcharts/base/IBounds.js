sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library',
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.IBounds", {
		metadata: {
            properties: {
				bottom : {type: "float"},
				left : {type: "float"},
				right : {type: "float"},
				top : {type: "float"},
            },
		},
		_buildSettings : function() {
			oSettings = {};
			library._addFromProperty(this, oSettings, "bottom")
			library._addFromProperty(this, oSettings, "left")
			library._addFromProperty(this, oSettings, "right")
			library._addFromProperty(this, oSettings, "top")
			return oSettings;
		},
	});
});