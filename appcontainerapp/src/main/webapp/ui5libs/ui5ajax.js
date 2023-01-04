sap.ui.define([
	
], function () {
	"use strict";    
   	return {
   		postJsonString : function (sUri, sJson, sNamespace) {
   			return this.ajaxSend(sUri, sJson, "application/json", "POST", sNamespace);
   		},
   		getJsonString : function (sUri, sNamespace) {
   			return this.ajaxGet(sUri, sNamespace);
   		},
   		postText : function (sUri, sText, sNamespace) {
   			return this.ajaxSend(sUri, sText, "text/plain", "POST", sNamespace);
   		},
   		postJsonModel : function (sUri, oJsonModel, sNamespace) {
   			return this.postJsonString(sUri, oJsonModel.getJSON(), sNamespace);
   		},
   		postJsonObject : function (sUri, oObject, sNamespace) {
   			return this.postJsonString(sUri, JSON.stringify(oObject), sNamespace);
   		},
   		/*
   		 * 	ui5ajax.ajaxGet("/method1", "ui5rest")
		 *	.then(
		 *		data => {
		 *			...
		 *		}, 
		 *		error => {
		 *			...
		 *		}
		 *	);
   		 */
   		ajaxGet : function (sUri, sNamespace) {
   			return this.ajaxSend(sUri, undefined, undefined, "GET", sNamespace);
   		},
   		ajaxSend : function (sUri, sText, sPayloadType, sMethod, sNamespace) {
		    return new Promise((resolve, reject) => {
		        let xhr = new XMLHttpRequest();
		        if (sNamespace) {
					sUri = sap.ui.require.toUrl(sNamespace) + (sUri.startsWith("/")?"":"/") + sUri
				}
		        xhr.open(sMethod, sUri);
		        if (sMethod !== "GET") {
					xhr.setRequestHeader("Content-Type", sPayloadType);
				}
		        xhr.onload = () => {
		            if (xhr.status >= 200 && xhr.status < 300) {
		                resolve( { text: xhr.response, code: xhr.status } );
		            } else {
		                reject( { text: xhr.response, code: xhr.status } );
		            }
		        };
		        xhr.onerror = () => reject( { text: xhr.response, code: xhr.status } );
		        xhr.send(sText);
		    });
		},
   		getJsonObject : function (sUri, sNamespace) {
		    return new Promise((resolve, reject) => {
		        let xhr = new XMLHttpRequest();
		        if (sNamespace) {
					sUri = sap.ui.require.toUrl(sNamespace) + (sUri.startsWith("/")?"":"/") + sUri
				}
		        xhr.open("GET", sUri);
		        xhr.onload = () => {
		            if (xhr.status >= 200 && xhr.status < 300) {
		                resolve( { text: xhr.response, code: xhr.status, obj: JSON.parse(xhr.response) } );
		            } else {
		                reject( { text: xhr.response, code: xhr.status } );
		            }
		        };
		        xhr.onerror = () => reject( { text: xhr.response, code: xhr.status } );
		        xhr.send();
		    });
   		},
   	};   	
});

