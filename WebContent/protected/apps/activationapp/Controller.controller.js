sap.ui.define([ "sap/ui/core/mvc/Controller",
		"sap/ui/model/odata/v4/ODataModel"], function(Controller, ODataModel) {
	"use strict";

	return Controller.extend("io.rtdi.hanaappcontainer.browseapp.Controller", {
		resturl: sap.ui.require.toUrl("ui5rest"),

		onInit : function() {
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData(resturl+"/activationapp/activateall/RTDI");
			this.getView().setModel(oModel);
		},
	});

});
