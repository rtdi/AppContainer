sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/odata/v4/ODataModel",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/controls/ActivationResultDialog"
], function(Controller, ODataModel, ui5ajax, errorfunctions) {
	"use strict";

	return Controller.extend("io.rtdi.appcontainer.editorapp.Controller", {
		onInit : function() {
			this.oDialog = new ui5libs.controls.ActivationResultDialog();
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
         	var oView = this.getView();
         	var oHeaderText = oView.byId("headertext");
         	oHeaderText.setText("Editing:  " + sFilename);
         	let p = sFilename.lastIndexOf("/");
         	if (p != -1) {
         		document.title = sFilename.substring(p+1);
         	} else {
         		document.title = sFilename;
         	}  
         	var oEditorControl = oView.byId("codeeditor");
         	oEditorControl.focus();
         	if (sFilename.endsWith(".js")) {
         		oEditorControl.setType("javascript");
         	} else if (sFilename.endsWith(".txt")) {
         		oEditorControl.setType("text");
          	} else if (sFilename.endsWith(".xml")) {
         		oEditorControl.setType("xml");
          	} else if (sFilename.endsWith(".sql")) {
         		oEditorControl.setType("sql");
         	}
			ui5ajax.ajaxGet("/repo/file/" + sFilename, "ui5rest")
				.then(
					data => {
						oEditorControl.setValue(JSON.parse(data.text).content); 
					},
					error => {
						errorfunctions.addError(this.getView(), error);
					}
				);
		},

		onSave : function () {
         	var oView = this.getView();
         	var oEditorControl = oView.byId("codeeditor");
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
			var sContent = oEditorControl.getValue();
			ui5ajax.postText("/repo/file/" + sFilename, sContent, "ui5rest")
				.then(
					data => {
						errorfunctions.uiSuccess(this.getView(), { message: 'Saved' } );
					},
					error => {
						errorfunctions.addError(this.getView(), error);
					}
				);
		},

		onActivate: function () {
         	var oView = this.getView();
         	var oEditorControl = oView.byId("codeeditor");
			var sContent = oEditorControl.getValue();
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
			ui5ajax.ajaxGet("/activation/activate/" + sFilename, "ui5rest")
				.then(
					data => {
						this.oDialog.getModel().setJSON(data.text);
						this.oDialog.getModel().refresh();
						this.oDialog.open();
					}, 
					error => {
						if (error.code === 400) {
							errorfunctions.addError(this.getView(), error);
						} else {
							this.oDialog.getModel().setJSON(error.text);
							this.oDialog.getModel().refresh();
							this.oDialog.open();
						}
					}
				);
		}

	});

});
