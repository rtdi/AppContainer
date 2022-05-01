sap.ui.define([
	'sap/ui/core/CustomData',
	'sap/ui/model/ClientModel'
], function(CustomData) {
  return CustomData.extend("ui5libs.controls.ModelContainer", {
		metadata : {
			properties: {
				modelName : {type : "string", defaultValue : null},
				url : {type : "string"},
				sizeLimit: {type : "int", defaultValue : 1000},
				model : {type: "sap.ui.model.ClientModel"},
			},
            aggregations: {
				rowTransformations: {type: "ui5libs.libs.model.mt.RowTransformation", multiple: true, singularName: "rowTransformation"},
				transformations: {type: "ui5libs.libs.model.mt.ModelTransformation", multiple: true, singularName: "transformation"},
			},
		},
		setModelName : function(oValue) {
			this.setProperty("modelName", oValue);
		},
		getModelName : function() {
			var name = this.getProperty("modelName");
			if (name === "") {
				name = undefined;
			}
			return name;
		},
		reload : function() {
		},
		getValue : function() {
			return this;
		}
	});
});
