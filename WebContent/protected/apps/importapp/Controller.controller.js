sap.ui.define([ "sap/ui/core/mvc/Controller",
		"sap/ui/model/odata/v4/ODataModel"], function(Controller, ODataModel) {
	"use strict";

	return Controller.extend("io.rtdi.appcontainer.importapp.Controller", {
		resturl: sap.ui.require.toUrl("ui5rest"),

		onInit : function() {
			var oModel = new ODataModel({
		        serviceUrl : "../odata/SYS/SCHEMAS/",
				autoExpandSelect: true,
				operationMode: "Server",
				groupId: "$direct",
		        synchronizationMode : "None"
		    });
			this.getView().setModel(oModel, "ObjectOwner");
		},
		onImport : function(oEvent) {
			var cOwner = this.getView().byId("idOwner");
			var sSchemaName = cOwner.getSelectedKey();
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData(resturl + "/importapp/" + encodeURI(sSchemaName) + "?type=ADDITIVE");
			this.getView().setModel(oModel);
		}

	});

});
