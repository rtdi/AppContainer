sap.ui.define([
	"ui5libs/controls/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/helperfunctions",
	"ui5libs/controls/FileOperationDialog",
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
			view.byId("datatable").setModel(new sap.ui.model.json.JSONModel());
		    var queryString = window.location.search;
		    var urlParams = new URLSearchParams(queryString);
		    filepath = urlParams.get('filename');
		    this.doLoad();
		},
		onTableDataRefresh : function(event) {
			var oTableData = view.byId("datatable");
			oTableData.unbindRows();
			oTableData.removeAllColumns();
			var querymodel = view.byId("query").getModel();
			var datamodel = oTableData.getModel();
			var sqltext = view.byId("sqltext");
			ui5ajax.postJsonObject("../../rest/query", querymodel.getData())
				.then(
					data => {
						var oData = JSON.parse(data.text);
						for (var oCol of oData.columns) {
							var oColumn = new sap.ui.table.Column({
								resizable: true,
								autoResizable: true,
								minWidth: 80,
								label: [new sap.m.Label({ text: oCol.name })],
								template: [new sap.m.Text({ text: "{ path: '" + oCol.name + "', targetType:'any'}", wrapping: false })]
							});
							oTableData.addColumn(oColumn);
						}
						oTableData.bindRows("/rows");
						datamodel.setData(oData);
						sqltext.setValue(oData.sql);
					},
					error => {
						var oData = JSON.parse(error.text);
						sqltext.setValue(oData.message + "\n" + oData.sqlstatement.replace("\\r\\n", "\n"));
					}
				);
		},
		onTableDataResizeColumns : function(oEvent) {
			var oTableData = view.byId("datatable");
			for (var i=0; i<oTableData.getColumns().length; i++) {
				oTableData.autoResizeColumn(i);
			}
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
				var q = view.byId("query");
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
		onFreeFormSQL : function(event) {
			var sqltext = view.byId("sqltext");
			var sql = sqltext.getValue();
			sap.m.URLHelper.redirect("../sqltextapp/index.html?$select=" + helperfunctions.encodeURIfull(sql), true);
		},
		

	});
});
