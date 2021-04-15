sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel"
], function (Controller, JSONModel) {
	"use strict";
	return Controller.extend("ui.app.Users", {
		onInit : function () {
			var oView = this.getView();
			var oTable = oView.byId("usertable");
		    var oModel = new sap.ui.model.odata.v4.ODataModel( {
		    	"groupId": "$direct",
		    	synchronizationMode : "None",
		    	"autoExpandSelect": true,
		    	"operationMode": "Server",
			    serviceUrl : "/AppContainer/protected/odata/SYS/USERS/"
		    } );
		    oTable.setModel(oModel);
		}
	});
});