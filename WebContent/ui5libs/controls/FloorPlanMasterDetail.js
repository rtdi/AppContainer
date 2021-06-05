sap.ui.define([
	'sap/ui/core/Control',
	'ui5libs/controls/ShellBar'
], function(Control, AppContainerShellBar) {
  return Control.extend("ui5libs.controls.FloorPlanMasterDetail", {
		metadata : {
			properties : {
				pageTitle: {type : 'string' },
				detailFilter: {type : 'object' },
			},
			aggregations : {
				master : {
					type : "sap.ui.core.Control",
					multiple : false
				},
				detail : {
					type : "sap.ui.core.Control",
					multiple : false
				},
				detailModel : {
					type : "ui5libs.controls.ODataContainer",
					multiple : false
				},
				_shellbar : {
					type : "ui5libs.controls.ShellBar",
					multiple : false,
					visibility: "hidden"
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			var oShellBar = new AppContainerShellBar( { id: "ShellBar" } );
			this.setAggregation("_shellbar", oShellBar);
		},
		setDetailFilter : function(oFilter) {
			this.setProperty("detailFilter", oFilter);
			if (this.getDetailModel() && oFilter) {
				var oBinding = this.getAggregation("detail").getBinding("items");
				var aFilterElements = [];
				for( const [sName, sValue] of Object.entries(oFilter)) {
					aFilterElements.push(new sap.ui.model.Filter(sName, sap.ui.model.FilterOperator.EQ, sValue));
				}
				oBinding.filter(aFilterElements, "Application");
			}
		},
		setDetailModel : function(oCustomdata) {
			if (oCustomdata) {
				this.setAggregation("detailModel", oCustomdata);
				var url = oCustomdata.getUrl();
				var name = oCustomdata.getModelName();
				var oModel = new sap.ui.model.odata.v4.ODataModel({ 
						"serviceUrl" : sap.ui.require.toUrl(url),  
						"autoExpandSelect": true, 
						"operationMode": "Server", 
						"groupId": "$direct", 
						"synchronizationMode": "None" 
					});
    			if (oCustomdata.getSizeLimit()) {
    				oModel.setSizeLimit(oCustomdata.getSizeLimit());
    			}
				var oControl = this.getAggregation("detail");
				if (oControl) {
					oControl.setModel(oModel, name);
				}
			}
		},
		setDetail : function(oControl) {
			this.setAggregation("detail", oControl);
			this.setDetailModel(this.getAggregation("detailModel"));
		},
		setPageTitle: function(sText) {
			this.getAggregation("_shellbar").setSecondTitle(sText);
		},
		getPageTitle: function() {
			return this.getAggregation("_shellbar").getSecondTitle();
		},
	});
});
