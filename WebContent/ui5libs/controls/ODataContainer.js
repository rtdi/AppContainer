sap.ui.define([
	'sap/ui/core/CustomData'
], function(CustomData, ODataModel) {
  return CustomData.extend("ui5libs.controls.ODataContainer", {
		metadata : {
			properties: {
				name : {type : "string", defaultValue : null},
				url : {type : "string"},
			}
		},
		setName : function(oValue) {
			this.setProperty("name", oValue);
			this.setValue(oValue); // just to make sure a customdata element has some value
		},
	});
});
