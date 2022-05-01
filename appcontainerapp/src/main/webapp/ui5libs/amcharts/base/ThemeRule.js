sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library',
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.ThemeRule", {
		metadata: {
            properties: {
               ruleName: { type: "string" },
               propertyName: { type: "string" },
               propertyValue: { type: "string" },
            },
            aggregations: {
			},
		},
	});
});