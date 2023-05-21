sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/controls/ActivationResultDialog",
	"ui5libs/controls/FileOperationDialog"
], function(Controller, ui5ajax, errorfunctions) {
	"use strict";

	var view;
	var filepath;

	return Controller.extend("io.rtdi.appcontainer.editorapp.Controller", {
		onInit : function() {
			this.oDialog = new ui5libs.controls.ActivationResultDialog();
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    filepath = urlParams.get('filename');
         	view = this.getView();
         	var oHeaderText = view.byId("headertext");
         	oHeaderText.setText("Editing:  " + filepath);
         	let p = filepath.lastIndexOf("/");
         	if (p != -1) {
         		document.title = filepath.substring(p+1);
         	} else {
         		document.title = filepath;
         	}  
         	var oEditorControl = view.byId("codeeditor");
         	oEditorControl.focus();
         	if (filepath.endsWith(".js")) {
         		oEditorControl.setType("javascript");
         	} else if (filepath.endsWith(".txt")) {
         		oEditorControl.setType("text");
          	} else if (filepath.endsWith(".xml")) {
         		oEditorControl.setType("xml");
          	} else if (filepath.endsWith(".sql")) {
         		oEditorControl.setType("sql");
         	}
         	this.doLoad();
		},
		onSave : function () {
         	if (filepath) {
				this.doSave();
			} else {
				var dialog = new ui5libs.controls.FileOperationDialog( {
					okayText: "Save",
					title: "Save query",
					path: null, 
					contentHeight: "40%",
					contentWidth: "50%",
					okay: this.doSave
				});
				dialog.open();
			}
		},
		doSave : function(event) {
         	var oEditorControl = view.byId("codeeditor");
         	var sContent = oEditorControl.getValue();
			if (event) {
			 	filepath = event.getParameter("value");
				if (filepath && !filepath.endsWith(filesuffix)) {
					filepath += filesuffix;
				}
			 }
			if (filepath) {
				ui5ajax.postJsonString("/repo/file/" + filepath, sContent, "ui5rest")
					.then(
						data => {
							errorfunctions.uiSuccess(view, { message: 'Saved' } );
						},
						error => {
							errorfunctions.uiError(view, error);
						}
					);
			} else {
				errorfunctions.uiError(view, "No file path specified");
			}
		},

		onActivate: function () {
			ui5ajax.ajaxGet("/activation/activate/" + filepath, "ui5rest")
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
		},
		onLoad : function(event) {
			var dialog = new ui5libs.controls.FileOperationDialog( {
				okayText: "Load",
				title: "Load query",
				path: null, 
				contentHeight: "40%",
				contentWidth: "50%",
				okay: this.doLoad
			});
			dialog.open();
		},
		doLoad : function(event) {
			if (event) {
				filepath = event.getParameter("value");
				if (!filepath.endsWith(filesuffix)) {
					filepath += filesuffix;
				}
			}
			if (filepath) {
	         	var oEditorControl = view.byId("codeeditor");
				ui5ajax.getJsonString("/repo/file/" + filepath, "ui5rest")
					.then(
						data => {
							oEditorControl.setValue(JSON.parse(data.text).content);
						},
						error => {
							errorfunctions.uiError(view, error);
						}
					);
			} else {
				errorfunctions.uiError(view, "No file path specified");
			}
		},

	});

});
