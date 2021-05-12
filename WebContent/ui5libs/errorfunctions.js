sap.ui.define([
	"./errorfunctions"
], function () {
	"use strict";    
   	return {
   		addError : function ( oView, oError ) {
   			if (oError.code === 202) {
   				var oJSON = JSON.parse(oError.text); 
	   			if (oView.getContent()[0].getItems()[0].getMetadata().getName() === 'ui5libs.controls.ShellBar') {
	   				var oShellbar = oView.getContent()[0].getItems()[0];
	   				oShellbar.addNotification(new ui5libs.controls.ErrorMessageItem().setErrorJSON(oJSON));
	   			}
   				sap.m.MessageToast.show('Call failed with message "' + oJSON.message + '"');
   			} else {
   				sap.m.MessageToast.show('Call failed with http status code ' + oError.code + ' and error message "' + oError + '"');
   			}
   			oView.setBusy(false);
   		},
   		uiError : function ( oView, sText) {
   			sap.m.MessageToast.show(sText);
   		},
   		jsonModelError : function ( oView, oRespEvent) {
   			sap.m.MessageToast.show('Operation failed on the server ' + oRespEvent.getParameters().responseText);
   		},
   		uiSuccess : function ( oView, oJSON) {
   			sap.m.MessageToast.show(oJSON.message);
   		}
   	};   	
});
