sap.ui.define([
], function () {
	"use strict";    
   	return {
   		timestampToTime: function(oTimestamp) {
   			sap.ui.model.odata.type.DateTimeOffset
   			if (oTimestamp) {
	   			return oTimestamp;
   				return oTimestamp.toTimeString();
   			} else {
   				return oTimestamp;
   			}
   		},
   	};   	
});