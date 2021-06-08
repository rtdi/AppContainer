sap.ui.define([
	'sap/ui/core/Control',
	'ui5libs/controls/ShellBar'
], function(Control, AppContainerShellBar) {
  var thiscontrol;
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
			var oShellBar = new AppContainerShellBar();
			this.setAggregation("_shellbar", oShellBar);
			thiscontrol = this;
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
		_modifyDetailFilter : function(oEvent) {
			if (thiscontrol.getAggregation("detail")) {
				var oBinding = thiscontrol.getAggregation("detail").getBinding("items");
				var sName = this.getPath();
				if (sName && oBinding) {
					var sValue1 = oEvent.getSource().getValue();
					var aCurrentFilters = oBinding.aApplicationFilters;
					var aFilterElements = [];
					var bFound = false;
					for (var e of aCurrentFilters) {
						if (e.sPath === sName) {
							bFound = true;
							e.oValue1 = sValue1;
						}
						aFilterElements.push(e);
					}
					if (!bFound) {
						aFilterElements.push(new sap.ui.model.Filter(sName, sap.ui.model.FilterOperator.EQ, sValue1));
					}
					oBinding.filter(aFilterElements, "Application");
				}
			}
		},
		setModel : function(oModel, sModelName, oCustomdata) {
			if (sModelName !== "master" && oCustomdata instanceof ui5libs.controls.ODataContainer) {
				var oControl = this.getAggregation("detail");
				if (oControl) {
					/* 
					 * Create the first filter to make sure not the entire database table is read in the case the master model has no values yet
					 */ 
					var aFilterElements = [];
					if (oCustomdata.getFilters()) {
						for (var filter of oCustomdata.getFilters()) {
							var sName = filter.getPath();
							var sValue1 = filter.getValue1();
							aFilterElements.push(new sap.ui.model.Filter(sName, sap.ui.model.FilterOperator.EQ, sValue1));
							var b1 = filter.getBindingInfo("value1");
							if (b1 && b1.binding) {
								b1.binding.attachChange(this._modifyDetailFilter, filter);
							}
						}
						oControl.setModel(oModel, sModelName);
						var oBinding = oControl.getBinding("items");
						oBinding.filter(aFilterElements, "Application");
					}
				}
			} else {
				Control.prototype.setModel.call(this, oModel, sModelName);
			}
		},
		setMasterModel : function(oCustomdata) {
			if (oCustomdata) {
				this.setAggregation("masterModel", oCustomdata);
				/* var oModel = oCustomdata.createNewModel();
				var name = oCustomdata.getModelName();
				var oControl = this.getAggregation("master");
				if (oControl && oModel) {
					this.setModel(oModel, name);
				} */
			}
		},
		setDetailModel : function(oCustomdata) {
			if (oCustomdata) {
				this.setAggregation("detailModel", oCustomdata);
				var oModel = oCustomdata.createNewModel();
				var name = oCustomdata.getModelName();
				var oControl = this.getAggregation("detail");
				if (oControl) {
					/* 
					 * Create the first filter to make sure not the entire database table is read in the case the master model has no values yet
					 */ 
					var aFilterElements = [];
					for (var filter of oCustomdata.getFilters()) {
						var sName = filter.getPath();
						var sValue1 = filter.getValue1();
						aFilterElements.push(new sap.ui.model.Filter(sName, sap.ui.model.FilterOperator.EQ, sValue1));
						var b1 = filter.getBindingInfo("value1");
						if (b1 && b1.binding) {
							b1.binding.attachChange(this._modifyDetailFilter, filter);
						}
					}
					/* oControl.setModel(oModel, name);
					var oBinding = thiscontrol.getAggregation("detail").getBinding("items");
					oBinding.filter(aFilterElements, "Application"); */
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
		getShellBar : function() {
			return this.getAggregation("_shellbar");
		}

	});
});
