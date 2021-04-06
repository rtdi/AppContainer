sap.ui.define([
	"sap/ui/model/odata/v4/ODataModel",
	"ui5libs/ui5ajax"
], function (ODataModel, ui5ajax) {
	"use strict";    
   	return {
   		init : function (oView) {
   			this.setModelRecursive(oView);
   		},
   		setModelRecursive: function(oControl) {
   			var aCustomData = oControl.getCustomData();
   			if (aCustomData) {
   				for( var oCustomdata of aCustomData) {
   					if (oCustomdata instanceof ui5libs.controls.ODataContainer) {
		   				var oModel = new sap.ui.model.odata.v4.ODataModel({ 
		    					"serviceUrl" : oCustomdata.getUrl(),  
		    					"autoExpandSelect": true, 
								"operationMode": "Server", 
								"groupId": "$direct", 
								"synchronizationMode": "None" 
		    				}); 
						oControl.setModel(oModel);
					}
				}
   			}
   			if ('getContent' in oControl) {
   				var aContent = oControl.getContent();
   				if (aContent) {
   					for (var i = 0; i<aContent.length; i++) {
   						this.setModelRecursive(aContent[i]);
   					}
   				}
   			}
   			if ('getItems' in oControl) {
   				var aContent = oControl.getItems();
   				if (aContent) {
   					for (var i = 0; i<aContent.length; i++) {
   						this.setModelRecursive(aContent[i]);
   					}
   				}
   			}
   		} 
   	};   	
});
