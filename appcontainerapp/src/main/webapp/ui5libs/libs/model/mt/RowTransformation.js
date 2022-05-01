sap.ui.define([
	'sap/ui/core/Element'
], function(Element) {
  return Element.extend("ui5libs.libs.model.mt.RowTransformation", {
		metadata : {
			properties: {
				rootPropertyPath : {type: "string"},
			},
            aggregations: {
				transformations: {type: "ui5libs.libs.model.mt.ct.ColumnTransformation", multiple: true, singularName: "transformation"},
			},
			defaultAggregation: "transformations"
		},
		applyTransformation: function(oModel) {
			var source = this.getRootPropertyPath();
			if (source) {
				var sourcedata = oModel.getProperty(source);
				if (sourcedata && Array.isArray(sourcedata)) {
					for (var oItem of sourcedata) {
						for (var transformation of this.getTransformations()) {
							transformation.applyTransformation(oItem);
						}
					}
				}
			}
		},
	});
});
