sap.ui.define([ "sap/ui/core/mvc/Controller",
		"sap/ui/model/odata/v4/ODataModel"], function(Controller, ODataModel) {
	"use strict";

	return Controller.extend("io.rtdi.hanaappcontainer.editorapp.Controller", {

		onInit : function() {
			this.onRefresh();
		},
		onRefresh : function() {
			var sFilename = jQuery.sap.getUriParameters().get("filename");
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData("../rest/editorapp/read/" + encodeURI(sFilename));
			this.getView().setModel(oModel);
		}
	});

});
