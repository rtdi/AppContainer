sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library',
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.Theme", {
		metadata: {
            properties: {
            },
            aggregations: {
				rules: {type: "ui5libs.amcharts.base.ThemeRule", multiple: true, singularName: "rule" },
			},
			defaultAggregation: "rules"
		},
		_newInstance : function(root) {
			var instance = am5.Theme.new(root);
			if (this.getRules()) {
				for (var rule of this.getRules()) {
					instance.rule(rule.getRuleName()).set(rule.getPropertyName(), rule.getPropertyValue());
				}
			}
			return instance;
		},
	});
});