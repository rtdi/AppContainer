sap.ui.define([
	"ui5libs/controls/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/helperfunctions",
	"ui5libs/controls/FileOperationDialog",
	"ui5libs/controls/ResultSetTable",
],
function(Controller, ui5ajax, errorfunctions, helperfunctions) {
	"use strict";
	
    var filesuffix = ".sql.json";
    var view;
	var filepath;

	return Controller.extend("io.rtdi.appcontainer.sqlapp.Controller", {
		init : function() {
			var omodel = new ui5libs.libs.model.json.JSONModelE();
			view = this.getView();
			view.setModel(omodel);
			omodel.setData( {
				with: [
					{
						alias: "", 
						subquery: {
							from: [{ value: "", joinVisible: false }]
						}
					}
				],
				subquery: {
					from: [{ value: "", joinVisible: false }]
				}
			});
			view.byId("datatablecontainer").setModel(new sap.ui.model.json.JSONModel());
		    var queryString = window.location.search;
		    var urlParams = new URLSearchParams(queryString);
		    filepath = urlParams.get('filename');
		    this.doLoad();
		},
		onCompile : function() {
			var oTableData = view.byId("datatablecontainer");
			oTableData.unbindAggregation("items");
			var querymodel = view.byId("query").getModel();
			var datamodel = oTableData.getModel();
			var sqltext = view.byId("sqltext");
			ui5ajax.postJsonObject("/query", querymodel.getData(), "ui5rest", view)
				.then(
					data => {
						var oData = JSON.parse(data.text);
						datamodel.setData(oData);
						sqltext.setValue(oData.sql);
						oTableData.bindAggregation("items", {
							path: "/resultsets",
							template: new ui5libs.controls.ResultSetTable({
								selectionMode: "Single",
								enableSelectAll: false,
								selectionBehavior: "RowOnly",
								visibleRowCountMode: "Auto",
								layoutData: new sap.m.FlexItemData( {growFactor: 1} ),
							})
						});
					},
					error => {
						var oData = JSON.parse(error.text);
						sqltext.setValue(oData.message + "\n" + oData.sqlstatement.replace("\\r\\n", "\n"));
					}
				);
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
			var sContent = view.getModel().getJSON();
			if (event) {
			 	filepath = event.getParameter("value");
				if (filepath && !filepath.endsWith(filesuffix)) {
					filepath += filesuffix;
				}
			 }
			if (filepath) {
				view.byId("headertext").setText(filepath);
				window.document.title = "Query: " + filepath;
				ui5ajax.postJsonString("/repo/file/" + filepath, sContent, "ui5rest")
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
				okayText: "Load",
				title: "Load query",
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
				window.document.title = "Query: " + filepath;
				var model = view.getModel();
				ui5ajax.getJsonString("/repo/file/" + filepath, "ui5rest")
					.then(
						data => {
							model.setJSON(JSON.parse(data.text).content);
						},
						error => {
							errorfunctions.uiError(view, error);
						}
					);
			} else {
				// errorfunctions.uiError(view, "No file path specified");
			}
		},
		onFreeFormSQL : function() {
			var sqltext = view.byId("sqltext");
			var sql = sqltext.getValue();
			sap.m.URLHelper.redirect("../sqltextapp/index.html?$select=" + helperfunctions.encodeURIfull(sql), true);
		},
		

	});
});
