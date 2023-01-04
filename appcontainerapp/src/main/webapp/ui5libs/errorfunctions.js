sap.ui.define([
	"./errorfunctions"
], function () {
	"use strict";    
   	return {
   		addError : function ( oView, oError ) {
			/*
			 * oError can either be an object from the ui5ajax call or from the JsonModel
			 */
			if (!oError.code) {
				oError.code = oError.statusCode;
				oError.text = oError.responseText;
			}
   			if (oError.code === 400) {
   				var oJSON = JSON.parse(oError.text);
   				var oContainerPage = oView.getContent()[0];
   				if (oContainerPage['getShellBar']) {
   					var oShellbar = oContainerPage.getShellBar();
		   			if (oShellbar) {
		   				oShellbar.addNotification(new ui5libs.controls.ErrorMessageItem().setErrorJSON(oJSON));
		   			}
		   		}
	   			sap.m.MessageToast.show('Call failed with message "' + oJSON.message + '"');
   			} else {
   				sap.m.MessageToast.show('Call failed with http status code ' + oError.code + ' and error message "' + oError.text + '"');
   			}
   			oView.setBusy(false);
   		},
   		uiError : function ( oView, sText) {
   			sap.m.MessageToast.show(sText);
   		},
   		jsonModelError : function ( oView, oRespEvent) {
   			sap.m.MessageToast.show('Operation failed on the server ' + oRespEvent.getParameters().responseText);
   		},
   		/*
   		 * uiSuccess allows as data parameter either the return value from the ui5ajax call ( { code: ..., text: ... } )
   		 * or an object with message property ( { message: <string> } )
   		 * or as a fall back a string as such.
   		 */
   		uiSuccess : function ( oView, data) {
   			var txt;
   			if (typeof data === 'object') {
   				if (data.message) {
   					txt = data.message;
   				} else {
	   				try {
	   					var oJSON = JSON.parse(data.text);
	   					txt = oJSON.message;
	   				} catch (e) {
	   					txt = data.text;
	   				}
   				}
   			} else {
   				txt = data;
  			}
   			sap.m.MessageToast.show(txt);
   		}
   	};   	
});
