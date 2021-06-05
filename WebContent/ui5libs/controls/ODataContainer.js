sap.ui.define([
	'sap/ui/core/CustomData'
], function(CustomData) {
  return CustomData.extend("ui5libs.controls.ODataContainer", {
		metadata : {
			properties: {
				modelName : {type : "string", defaultValue : null},
				url : {type : "string"},
				sizeLimit: {type : "int", defaultValue : 1000},
			}
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
		setUrl : function(oValue) {
			if (oValue && oValue.endsWith('/') === false) {
				oValue = oValue + '/';
			}
			this.setProperty("url", oValue);
		}
	});
});
