sap.ui.define([
	'ui5libs/amcharts/base/ThemeRule',
	'ui5libs/amcharts/library',
], function(ThemeRule, library) {
	return ThemeRule.extend("ui5libs.amcharts.base.ThemeRuleNumber", {
		metadata: {
            properties: {
               propertyValue: { type: "float" },
            },
            aggregations: {
			},
		},
	});
});