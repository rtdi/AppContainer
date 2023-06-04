sap.ui.define([
	"ui5libs/controls/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/controls/FileOperationDialog"
],
function(Controller, ui5ajax, errorfunctions) {
	"use strict";
	
	var filesuffix = ".sqlquery";
	var view;
	var filepath;

	return Controller.extend("io.rtdi.appcontainer.sqlapp.Controller", {
		init : function() {
			view = this.getView();
		    var queryString = window.location.search;
		    var urlParams = new URLSearchParams(queryString);
		    filepath = urlParams.get('filename');
		    var sql = urlParams.get('$select');
		    if (sql) {
				var oEditorControl = view.byId("sql");
				oEditorControl.setValue(sql);
			}
		    this.doLoad();
		},
		onCompile : function() {
         	var oEditorControl = view.byId("sql");
         	oEditorControl.compile();
         },
		onSave : function () {
         	if (filepath) {
				this.doSave();
			} else {
				var dialog = new ui5libs.controls.FileOperationDialog( {
					okayText: "Save",
					title: "Save query",
					path: null, 
					suffix: filesuffix, 
					contentHeight: "40%",
					contentWidth: "50%",
					okay: this.doSave
				});
				dialog.open();
			}
		},
		doSave : function(event) {
         	var oEditorControl = view.byId("sql");
         	var sContent = oEditorControl.getValue();
			if (event) {
			 	filepath = event.getParameter("value");
				if (filepath && !filepath.endsWith(filesuffix)) {
					filepath += filesuffix;
				}
			 }
			if (filepath) {
				view.byId("headertext").setText(filepath);
				window.document.title = "SQL: " + filepath;
				ui5ajax.postJsonString("/repo/file/" + filepath, sContent, "ui5rest", this.getView())
					.then(
						() => {
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
		onLoad : function() {
			var dialog = new ui5libs.controls.FileOperationDialog( {
				okayText: "Open",
				title: "Open query sql",
				path: null, 
				suffix: filesuffix, 
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
				view.byId("headertext").setText(filepath);
				window.document.title = "SQL: " + filepath;
         		var oEditorControl = view.byId("sql");
				ui5ajax.getJsonString("/repo/file/" + filepath, "ui5rest", this.getView())
					.then(
						data => {
							oEditorControl.setValue(JSON.parse(data.text).content);
						},
						error => {
							errorfunctions.uiError(view, error);
						}
					);
			} else {
				// errorfunctions.uiError(view, "No file path specified");
			}
		},
	});
});
