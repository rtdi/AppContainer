sap.ui.define([
	'ui5libs/controls/ModelContainer'
], function(ModelContainer) {
  return ModelContainer.extend("ui5libs.controls.ODataContainer", {
		metadata : {
			properties: {
			},
			defaultAggregation: "filters",
			aggregations : {
				filters : {
					type : "ui5libs.controls.Filter",
					multiple : true,
					singularName: "filter"
				},
			}
		},
		setUrl : function(oValue) {
			if (oValue && oValue.endsWith('/') === false) {
				oValue = oValue + '/';
			}
			this.setProperty("url", oValue);
		},
		createNewModel : function() {
			var url = this.getUrl();
			if (url) {
				var oModel = new sap.ui.model.odata.v4.ODataModel({ 
						"serviceUrl" : sap.ui.require.toUrl(url),  
						"autoExpandSelect": true, 
						"operationMode": "Server", 
						"groupId": "$direct", 
						"synchronizationMode": "None" 
					});
    			if (this.getSizeLimit()) {
    				oModel.setSizeLimit(this.getSizeLimit());
    			}
    			return oModel;
    		} else {
    			return undefined;
    		}
		}
	});
});
