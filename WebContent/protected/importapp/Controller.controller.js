sap.ui.define([ "sap/ui/core/mvc/Controller",
		"sap/ui/model/odata/v4/ODataModel"], function(Controller, ODataModel) {
	"use strict";

	return Controller.extend("io.rtdi.hanappcontainer.importapp.Controller", {

		onInit : function() {
		},
		onImport : function(oEvent) {
			var cOwner = this.getView().byId("idOwner");
			var sSchemaName = cOwner.getSelectedKey();
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData("../rest/importapp/" + encodeURI(sSchemaName) + "?type=ADDITIVE");
			this.getView().setModel(oModel);
		}

	});

});
