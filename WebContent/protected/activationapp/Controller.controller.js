sap.ui.define([ "sap/ui/core/mvc/Controller",
		"sap/ui/model/odata/v4/ODataModel"], function(Controller, ODataModel) {
	"use strict";

	return Controller.extend("io.rtdi.hanaappcontainer.browseapp.Controller", {

		onInit : function() {
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData("../rest/activationapp/activateall/RTDI");
			this.getView().setModel(oModel);
		},
	});

});
