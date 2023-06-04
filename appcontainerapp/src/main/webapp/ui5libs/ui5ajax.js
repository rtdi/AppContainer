sap.ui.define([
	
], function () {
	"use strict";    
   	return {
   		postJsonString : function (sUri, sJson, sNamespace, control) {
   			return this.ajaxSend(sUri, sJson, "application/json", "POST", sNamespace, control);
   		},
   		postBinary : function (sUri, payload, sNamespace, control) {
   			return this.ajaxSend(sUri, payload, "application/octet-stream", "POST", sNamespace, control);
   		},
   		getJsonString : function (sUri, sNamespace, control) {
   			return this.ajaxGet(sUri, sNamespace, control);
   		},
   		postText : function (sUri, sText, sNamespace, control) {
   			return this.ajaxSend(sUri, sText, "text/plain", "POST", sNamespace, control);
   		},
   		postJsonModel : function (sUri, oJsonModel, sNamespace, control) {
   			return this.postJsonString(sUri, oJsonModel.getJSON(), sNamespace, control);
   		},
   		postJsonObject : function (sUri, oObject, sNamespace, control) {
   			return this.postJsonString(sUri, JSON.stringify(oObject), sNamespace, control);
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
   		ajaxGet : function (sUri, sNamespace, control) {
   			return this.ajaxSend(sUri, undefined, undefined, "GET", sNamespace, control);
   		},
   		ajaxSend : function (sUri, sText, sPayloadType, sMethod, sNamespace, control) {
			if (control) {
				control.setBusy(true);
			}
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
					if (control) {
						control.setBusy(false);
					}
		            if (xhr.status >= 200 && xhr.status < 300) {
		                resolve( { text: xhr.response, code: xhr.status } );
		            } else {
		                reject( { text: xhr.response, code: xhr.status } );
		            }
		        };
		        xhr.onerror = () => {
					if (control) {
						control.setBusy(false);
					}
					reject( { text: xhr.response, code: xhr.status } );
				};
		        xhr.send(sText);
		    });
		},
   		getJsonObject : function (sUri, sNamespace, control) {
			if (control) {
				control.setBusy(true);
			}
		    return new Promise((resolve, reject) => {
		        let xhr = new XMLHttpRequest();
		        if (sNamespace) {
					sUri = sap.ui.require.toUrl(sNamespace) + (sUri.startsWith("/")?"":"/") + sUri
				}
		        xhr.open("GET", sUri);
		        xhr.onload = () => {
					if (control) {
						control.setBusy(false);
					}
		            if (xhr.status >= 200 && xhr.status < 300) {
		                resolve( { text: xhr.response, code: xhr.status, obj: JSON.parse(xhr.response) } );
		            } else {
		                reject( { text: xhr.response, code: xhr.status } );
		            }
		        };
		        xhr.onerror = () => {
					if (control) {
						control.setBusy(false);
					}
					reject( { text: xhr.response, code: xhr.status } );
				};
		        xhr.send();
		    });
   		},
   	};   	
});

