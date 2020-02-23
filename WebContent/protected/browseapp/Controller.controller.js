sap.ui.define([ "sap/ui/core/mvc/Controller",
		"sap/ui/model/odata/v4/ODataModel"], function(Controller, ODataModel) {
	"use strict";

	return Controller.extend("io.rtdi.hanaappcontainer.browseapp.Controller", {

		onInit : function() {
			this.onDirectoryRefresh();
		},
		onDirectoryRefresh : function() {
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData("../rest/browseapp/browse");
			this.getView().setModel(oModel);
			this.getView().byId("idFiles").setModel(new sap.ui.model.json.JSONModel()); // empty model
		},
		onSelectDir : function(oEvent) {
			var oContext = oEvent.getParameters().rowBindingContext;
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData("../rest/browseapp/files/" + oContext.getObject().path);
			this.getView().byId("idFiles").setModel(oModel);
		}
	});

});
