sap.ui.define([
], function () {
	"use strict";    
   	return {
   		timestampToTime: function(oTimestamp) {
   			if (oTimestamp) {
   				if (typeof oTimestamp === 'string') {
   					oTimestamp = new Date(oTimestamp);
	   				return oTimestamp.toLocaleTimeString();
	   			}
   			}
			return oTimestamp;
   		},
   	};   	
});