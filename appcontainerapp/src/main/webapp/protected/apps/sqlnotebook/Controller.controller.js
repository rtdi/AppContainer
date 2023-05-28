sap.ui.define([
	"ui5libs/controls/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/helperfunctions",
	"ui5libs/controls/FileOperationDialog",
	"ui5app/controls/NotebookCell",
	"ui5libs/contentcontrols/SQLEditor",
	"ui5libs/contentcontrols/HTMLEditor",
	"ui5libs/contentcontrols/MDEditor",
	"ui5libs/contentcontrols/XMLFragmentEditor",
],
function(Controller, ui5ajax, errorfunctions, helperfunctions) {
	"use strict";
	
	var filesuffix = ".nb.json";
	var view;
	var filepath;
	
	return Controller.extend("io.rtdi.appcontainer.sqlapp.Controller", {
		init : function() {
			view = this.getView();
			this.menu = new sap.m.Menu( {
				itemSelected: this.onAddMenu,
				items : [
					new sap.m.MenuItem( { text: "SQL" } ),
					new sap.m.MenuItem( { text: "HTML" } ),
					new sap.m.MenuItem( { text: "MD" } ),
					new sap.m.MenuItem( { text: "XMLFragment" } ),
				]
			});
		    var queryString = window.location.search;
		    var urlParams = new URLSearchParams(queryString);
		    filepath = urlParams.get('filename');
		    this.doLoad();

		},
		onAddCell : function(event) {
			var oButton = event.getSource();
			this.menu.openBy(oButton);
		},			
		onAddMenu : function(event) {
			var item = event.getParameter("item");
			var editor = undefined;
			if (item.getText() === "SQL") {
				editor = new ui5libs.contentcontrols.SQLEditor( { useSplitter: false, codeEditorHeight: "200pt" } );
			} else if (item.getText() === "HTML") {
				editor = new ui5libs.contentcontrols.HTMLEditor( { useSplitter: false, codeEditorHeight: "200pt" } );
			} else if (item.getText() === "MD") {
				editor = new ui5libs.contentcontrols.MDEditor( { useSplitter: false, codeEditorHeight: "200pt" } );
			} else if (item.getText() === "XMLFragment") {
				editor = new ui5libs.contentcontrols.XMLFragmentEditor( { useSplitter: false, codeEditorHeight: "200pt" } );
			}
			if (editor) {
				var existingitems = view.byId('notebookcells').getItems();
				if (existingitems && existingitems.length > 0 && existingitems[0] instanceof sap.m.Text) {
					view.byId('notebookcells').removeItem(0);
				}
				view.byId('notebookcells').addItem(new ui5app.controls.NotebookCell( { content: editor, layoutData: new sap.m.FlexItemData({ maxWidth: "100%" }) }));
			}
		},
		onSave : function () {
         	if (filepath) {
				this.doSave();
			} else {
				var dialog = new ui5libs.controls.FileOperationDialog( {
					okayText: "Save",
					title: "Save Notebook",
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
			if (event) {
			 	filepath = event.getParameter("value");
				if (filepath && !filepath.endsWith(filesuffix)) {
					filepath += filesuffix;
				}
			 }
			if (filepath) {
				view.byId("headertext").setText(filepath);
				var data = [];
				for( var cell of view.byId('notebookcells').getItems()) {
					var item = cell.getContent();
					data.push( {type: item.getType(), value: item.getValue() });
				}
				window.document.title = "SQL Notebook: " + filepath;
				ui5ajax.postJsonObject("/repo/file/" + filepath, data, "ui5rest")
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
		onLoad : function(event) {
			var dialog = new ui5libs.controls.FileOperationDialog( {
				okayText: "Load",
				title: "Load Notebook",
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
				window.document.title = "SQL Notebook: " + filepath;
				ui5ajax.getJsonString("/repo/file/" + filepath, "ui5rest")
					.then(
						data => {
							var data = JSON.parse(JSON.parse(data.text).content);
							view.byId('notebookcells').removeAllItems();
							for (var item of data) {
								var cell = undefined;
								if (item.type === "HTML") {
									cell = new ui5app.controls.NotebookCell( {
										content: new ui5libs.contentcontrols.HTMLEditor( { useSplitter: false, codeEditorHeight: "200pt" } )
									});
								} else if (item.type === "Github flavored Markdown") {
									cell = new ui5app.controls.NotebookCell( {
										content: new ui5libs.contentcontrols.MDEditor( { useSplitter: false, codeEditorHeight: "200pt" } )
									});
								} else if (item.type === "SQL") {
									cell = new ui5app.controls.NotebookCell( {
										content: new ui5libs.contentcontrols.SQLEditor( { useSplitter: false, codeEditorHeight: "200pt" } )
									});
								} else if (item.type === "XMLFragment") {
									cell = new ui5app.controls.NotebookCell( {
										content: new ui5libs.contentcontrols.XMLFragmentEditor( { useSplitter: false, codeEditorHeight: "200pt" } )
									});
								}
								if (cell) {
									view.byId('notebookcells').addItem(cell);
									cell.getContent().setValue(item.value);
								}
							}
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
