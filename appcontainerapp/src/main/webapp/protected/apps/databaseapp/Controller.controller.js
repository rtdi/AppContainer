sap.ui.define([
	"ui5libs/controls/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/helperfunctions",
	"ui5libs/controls/ResultSetTable"],
function(Controller, ui5ajax, errorfunctions, helperfunctions) {
	"use strict";
	return Controller.extend("io.rtdi.appcontainer.browseapp.Controller", {
		init : function() {
			var oTreeModel = this.getView().byId("idTree").getModel();
			oTreeModel.attachRequestCompleted(function(oEvent) {
				for (var i=0; i<oTreeModel.getProperty("/").length; i++) {
					oTreeModel.setProperty("/" + i + "/sources", [{name:""}]);
				}
			});
			var oColumnModel = new ui5libs.libs.model.json.JSONModelE();
			oColumnModel.setData([]);
			this.getView().byId("idColumns").setModel(oColumnModel);
			
			var oChartControl = this.getView().byId("dependencychart");
			var oDependencyModel = new ui5libs.libs.model.json.JSONModelE();
			oChartControl.setModel(oDependencyModel);
			var oDataPreview = new ui5libs.libs.model.json.JSONModelE();
			var tabledatacontrol = this.getView().byId("idTableData");
			tabledatacontrol.setModel(oDataPreview);
		},
		iconFormatter : function(sObjectType) {
			// "TABLE","VIEW", "SYSTEM TABLE", "ALIAS", "SYNONYM"
			switch (sObjectType) {
				case "TABLE":
					return "sap-icon://table-view";
				case "VIEW":
					return "sap-icon://my-view";
				case "SYSTEM TABLE":
					return "sap-icon://database";
				case "ALIAS":
				case "SYNONYM":
					return "sap-icon://mirrored-task-circle";
				default:
					return "sap-icon://person-placeholder";
			}
		},
		onRefresh : function() {
			var oTreeModel = this.getView().byId("idTree").data("model");
			if (oTreeModel) {
				var oTree = this.getView().byId("idTree");
				oTree.collapseAll();
				oTreeModel.reload();
			}
		},
		onSourceSelect : function(oEvent) {
			var oSelected = oEvent.getParameter("rowContext");
			if (oSelected && oSelected.getObject().objectname) {
				var oColumnModel = this.getView().byId("idColumns").getModel();
				var sSchema = oSelected.getObject().schema;
				var sName = oSelected.getObject().objectname;
				this._schemaname = sSchema;
				this._objectname = sName;
				oColumnModel.loadData("ui5rest/catalog/schemas/" + helperfunctions.encodeURIfull(sSchema) + "/" + helperfunctions.encodeURIfull(sName) + "/columns");
				
				var oChartControl = this.getView().byId("dependencychart");
				oChartControl.getModel().loadData("ui5rest/catalog/schemas/" + helperfunctions.encodeURIfull(this._schemaname) + "/" + helperfunctions.encodeURIfull(this._objectname) + "/dependencies");
				
				var tabcontainer = this.getView().byId("idTableData");
				var datamodel = tabcontainer.getModel();
				ui5ajax.getJsonObject("/query/"+ helperfunctions.encodeURIfull(sSchema) + "/" + helperfunctions.encodeURIfull(sName) + "?$limit=100", "ui5rest", tabcontainer)
					.then(
						data => {
							var oData = JSON.parse(data.text);
							datamodel.setData(oData);
							tabcontainer.display();
						},
						error => {
							var oData = JSON.parse(error.text);
							datamodel.setData(undefined);
							tabcontainer.displayError(oData.message);
						}
					);

			}
		},
		onOpen : function(oEvent) {
			if (oEvent.getParameter("expanded")) {
				var oNode = oEvent.getParameter("rowContext");
				if (oNode.getObject()["schemaname"]) {
					var oTreeModel = this.getView().byId("idTree").getModel();
					ui5ajax.ajaxGet("/catalog/schemas/" + helperfunctions.encodeURIfull(oNode.getObject().schemaname), "ui5rest", this.getView())
						.then(
							data => {
								var oChild = JSON.parse(data.text);
								oTreeModel.setProperty(oNode.getPath() + "/sources", oChild);
							}, 
							error => {
								errorfunctions.addError(thisControl.getView(), error);
							}
						);
				}
			}
		},
		onItemClose : function(oEvent) {
			oEvent.preventDefault();
		},
		onFreeFormSQL : function() {
			var sqltext = "select ";
			var columns = this.getView().byId("idColumns").getModel().getProperty("/");
			for (var i=0; i<columns.length; i++) {
				if (i != 0) {
					sqltext += ", ";
				}
				sqltext += helperfunctions.minimalQuotedStringOf(columns[i].name);
			}
			sqltext += "\nfrom " + helperfunctions.minimalQuotedStringOf(this._schemaname + "." + this._objectname, this._schemaname, this._objectname);
			sap.m.URLHelper.redirect("../sqltextapp/index.html?$select=" + helperfunctions.encodeURIfull(sqltext), true);
		},
	});
});
