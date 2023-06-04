sap.ui.define([
	"ui5libs/controls/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/helperfunctions",
	"ui5libs/controls/ActivationResultDialog"],
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
			var oColumnModel = new sap.ui.model.json.JSONModel();
			oColumnModel.setData([]);
			this.getView().byId("idColumns").setModel(oColumnModel);
			
			var oChartControl = this.getView().byId("dependencychart");
			var oDependencyModel = new sap.ui.model.json.JSONModel();
			oChartControl.setModel(oDependencyModel);
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
		onTableDataRefresh : function() {
			var oTableData = this.getView().byId("idTableData");
			oTableData.unbindRows();
			oTableData.removeAllColumns();
			var oColumnModel = this.getView().byId("idColumns").getModel();
			for (var oCol of oColumnModel.getProperty("/")) {
				var oColumn = new sap.ui.table.Column({
					resizable:true,
					autoResizable: true,
					minWidth: 80,
					label: [new sap.m.Label({text: oCol.name})],
					template: [ new sap.m.Text( { text: "{ path: '" + oCol.name + "', targetType:'any'}", wrapping: false } ) ]
				});
				oTableData.addColumn(oColumn);
			}
			oTableData.bindRows("/RS");
		},
		onTableDataResizeColumns : function(oEvent) {
			var oTableData = this.getView().byId("idTableData");
			for (var i=0; i<oTableData.getColumns().length; i++) {
				oTableData.autoResizeColumn(i);
			}
		},
		onSourceSelect : function(oEvent) {
			var oTableData = this.getView().byId("idTableData");
			oTableData.unbindRows();
			oTableData.removeAllColumns();
			var oSelected = oEvent.getParameter("rowContext");
			if (oSelected && oSelected.getObject().objectname) {
				var oColumnModel = this.getView().byId("idColumns").getModel();
				var sSchema = oSelected.getObject().schema;
				var sName = oSelected.getObject().objectname;
				this._schemaname = sSchema;
				this._objectname = sName;
				oColumnModel.loadData(sap.ui.require.toUrl("ui5rest/catalog/schemas/" + helperfunctions.encodeURIfull(sSchema) + "/" + helperfunctions.encodeURIfull(sName) + "/columns"));
				
				var oTableDataModel = new sap.ui.model.odata.v4.ODataModel({ 
						"serviceUrl" : sap.ui.require.toUrl("ui5rest/odata/tables/" + helperfunctions.encodeURIfull(sSchema) + "/" + helperfunctions.encodeURIfull(sName) + "/"),  
						"autoExpandSelect": true, 
						"operationMode": "Server", 
						"groupId": "$direct", 
						"synchronizationMode": "None" 
					});
				oTableData.setModel(oTableDataModel);

				var oChartControl = this.getView().byId("dependencychart");
				oChartControl.getModel().loadData("ui5rest/catalog/schemas/" + helperfunctions.encodeURIfull(this._schemaname) + "/" + helperfunctions.encodeURIfull(this._objectname) + "/dependencies");
			}
		},
		onOpen : function(oEvent) {
			if (oEvent.getParameter("expanded")) {
				var oNode = oEvent.getParameter("rowContext");
				if (oNode.getObject()["schemaname"]) {
					var oTreeModel = this.getView().byId("idTree").getModel();
					ui5ajax.ajaxGet("/catalog/schemas/" + helperfunctions.encodeURIfull(oNode.getObject().schemaname), helperfunctions.encodeURIfull("ui5rest"), this.getView())
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
