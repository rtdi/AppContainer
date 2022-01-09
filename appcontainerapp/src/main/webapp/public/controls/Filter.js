sap.ui.define([
	'sap/ui/core/Element'
], function(Element) {
  return Element.extend("ui5libs.controls.Filter", {
		metadata : {
			properties: {
				path : {type : "string", defaultValue : null},
				operator : {type : "string", defaultValue : null},
				value1 : {type : "string", defaultValue : null},
				value2 : {type : "string", defaultValue : null},
				and : {type : "boolean", defaultValue : true},
			},
			defaultAggregation: "filters",
			aggregations : {
				filters: {
					type : "ui5libs.controls.Filter",
					multiple: true,
					singularName: "filter"
				}
			}
		},
	});
});
