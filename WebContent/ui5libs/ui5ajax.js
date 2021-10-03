sap.ui.define([
	
], function () {
	"use strict";    
   	return {
   		postJsonString : function (sUri, sJson) {
   			return this.ajaxSend(sUri, sJson, "application/json", "POST");
   		},
   		postText : function (sUri, sText) {
   			return this.ajaxSend(sUri, sText, "text/plain", "POST");
   		},
   		postJsonModel : function (sUri, oJsonModel) {
   			return this.postJsonString(sUri, oJsonModel.getJSON());
   		},
   		postJsonObject : function (sUri, oObject) {
   			return this.postJsonString(sUri, JSON.stringify(oObject));
   		},
   		ajaxGet : function (sUri) {
   			return this.ajaxSend(sUri, undefined, undefined, "GET");
   		},
   		ajaxSend : function (sUri, sText, sPayloadType, sMethod) {
		    return new Promise((resolve, reject) => {
		        let xhr = new XMLHttpRequest();
		        xhr.open(sMethod, sUri);
		        if (sMethod !== "GET") {
					xhr.setRequestHeader("Content-Type", sPayloadType);
				}
		        xhr.onload = () => {
		            if (xhr.status == 202) {
		                reject( { text: xhr.response, code: xhr.status } ); // http is fine but the rest call returned a ErrorMessage object
		            } else if (xhr.status >= 200 && xhr.status < 300) {
		                resolve( { text: xhr.response, code: xhr.status } );
		            } else {
		                reject( { text: xhr.response, code: xhr.status } );
		            }
		        };
		        xhr.onerror = () => reject( { text: xhr.response, code: xhr.status } );
		        xhr.send(sText);
		    });
		}
   	};   	
});

