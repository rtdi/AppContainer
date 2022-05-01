sap.ui.define([
	'sap/ui/core/Element'
], function(Element) {
  return Element.extend("ui5libs.libs.model.mt.ct.ColumnTransformation", {
		metadata : {
			properties: {
				formatter : {type: "function"},
				field : {type: "string"},
			},
		},
		applyTransformation: function(oData) {
			oData[this.getField()] = formatter.call(this, oData);
		},
	});
});
