sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library'
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.ColorSet", {
		metadata: {
            properties: {
				baseColor : {type: "string"}
            },
		},
	});
});