sap.ui.define([
	"sap/ui/model/odata/v4/ODataModel",
	"ui5libs/ui5ajax",
	"ui5libs/controls/ODataContainer",
	"ui5libs/controls/JsonContainer"
], function (ODataModel, ui5ajax) {
	"use strict";    
   	return {
   		init : function (oView) {
   			this.setModelRecursive(oView);
   		},
   		setModelRecursive: function(oControl) {
   			if (oControl instanceof sap.ui.core.Element) { 
	   			var aCustomData = oControl.getCustomData();
	   			if (aCustomData) {
	   				for( var oCustomdata of aCustomData) {
	   					if (oCustomdata instanceof ui5libs.controls.ODataContainer) {
	   						var name = oCustomdata.getModelName();
			   				var oModel = oCustomdata.createNewModel();
							oControl.setModel(oModel, name, oCustomdata);
						} else if (oCustomdata instanceof ui5libs.controls.JsonContainer) {
	   						var name = oCustomdata.getModelName();
			   				var oModel = oCustomdata.createNewModel();
							oControl.setModel(oModel, name, oCustomdata);
						}
					}
	   			}
	   			var oMetadata = oControl.getMetadata();
	   			var oAggregations = oMetadata.getAllAggregations();
	   			for (const [sName, oSettings] of Object.entries(oAggregations)) {
	   				var fGetter = oControl[oSettings._sGetter].bind(oControl);
	   				var aContent = fGetter();
	   				if (aContent) {
	   					if (Array.isArray(aContent)) {
		   					for (var i = 0; i<aContent.length; i++) {
		   						this.setModelRecursive(aContent[i]);
		   					}
	   					} else {
	   						this.setModelRecursive(aContent);
		   				}
	   				}
	   			}
	   		}
   		} 
   	};   	
});
