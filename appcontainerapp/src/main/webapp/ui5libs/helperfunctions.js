sap.ui.define([
	"./helperfunctions"
], function () {
	"use strict";    
   	return {
   		encodeURIfull : function (sUri) {
   			if (sUri) {
   				return encodeURIComponent(sUri.replace("/", "%2f"));
   			} else {
   				return sUri; // null
   			}
   		}
   	};   	
});
