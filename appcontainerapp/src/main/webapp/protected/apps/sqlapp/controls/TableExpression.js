sap.ui.define([
	'sap/ui/core/Control',
	'ui5app/controls/JoinCondition',
	'ui5app/libs/SharedFunctions',
	'ui5libs/helperfunctions'
], function(Control, JoinCondition, SharedFunctions, helperfunctions) {
	/*
	  A TableExpression is a tables with join clause
	  
	*/
  return Control.extend("ui5app.controls.TableExpression", {
		metadata : {
			properties : {
				joinVisible: {type: "boolean" },
				schemaname: {type: "string" },
				objectname: {type: "string" },
				objecttype: {type: "string" },
				targetschemaname: {type: "string" },
				targetobjectname: {type: "string" },
				targetobjecttype: {type: "string" },
				table: {type: "string" },
			},
			aggregations : {
				_table : {
					type : "sap.m.Input",
					multiple : false,
					hidden: true
				},
				_alias : {
					type : "sap.m.Input",
					multiple : false,
					hidden: true
				},
				_jointype : {
					type : "sap.m.Select",
					multiple : false,
					hidden: true
				},
				joinconditions : {
					type : "ui5app.controls.JoinCondition",
					multiple : true
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			this.setAggregation("_table", new sap.m.Input( {
				value: "{value}",
				width: "20em",
				showSuggestion: true,
				filterSuggests: false,
				suggestionItems: {
					path: "/",
					model: "tablesuggestions",
					template: new sap.ui.core.ListItem( { text: "{tablesuggestions>qualifiershort}" /*, additionalText: "{tablesuggestions>match}"*/ } ),
					templateShareable: false,
					sorter: new sap.ui.model.Sorter("match", true)
				},
				suggest: this.showTableSuggestion,
				change: this.onChangeTable
			} ));
			this.setAggregation("_alias", new sap.m.Input( {
				width: "5em", value: "{alias}" 
			} ));
			this.setAggregation("_jointype", new sap.m.Select( { selectedKey: "{jointype}", forceSelection: false, items: [
				 new sap.ui.core.Item( { key: "", text: ""}),
				 new sap.ui.core.Item( { key: "JOIN", text: "JOIN"}),
				 new sap.ui.core.Item( { key: "LEFT OUTER", text: "LEFT OUTER"}),
				 new sap.ui.core.Item( { key: "FULL OUTER", text: "FULL OUTER"}) ]  } ));
			this.bindProperty("joinVisible", "joinVisible");
			this.bindAggregation("joinconditions", {
					path: "on",
					template: new ui5app.controls.JoinCondition(),
					templateShareable: false
				});
		},
		setTable : function(value) {
			this.getAggregation("_table").setValue(value);
			this.refreshTable(value);
		},
		getTable : function() {
			return this.getAggregation("_table").getValue();
		},
		setAlias : function(value) {
			this.getAggregation("_alias").setValue(value);
		},
		getAlias : function() {
			return this.getAggregation("_alias").getValue();
		},
		showTableSuggestion : function(event) {
			var oControl = event.getSource();
			var oContext = oControl.getBindingContext();
			var sPath = oContext.getPath();
			// The filter function is not cloned, hence set it always as workaround
			oControl.setFilterFunction(function (sTerm, oItem) {
					return oItem.getText().match(new RegExp(sTerm, "i"));
				});
			oControl.getModel("tablesuggestions").setProperty("/", []);
			oControl.getParent().addTableSuggestions(
				event.getParameter("suggestValue"),
				oControl.getModel("tablesuggestions"),
				SharedFunctions.rankTables,
				sPath);
		},
		addTableSuggestions : function(text, model, rankfunction, forpath) {
			this.getParent().addTableSuggestions(text, model, rankfunction, forpath);
		},
		getTableSuggestion : function(qualifier) {
			return this.getParent().getTableSuggestion(qualifier);
		},
		addColumnSuggestions : function(text, model, rankfunction) {
			var columnmodel = this.getModel("columns");
			if (columnmodel) {
				var qualifier = this.getAlias();
				if (!qualifier) {
					qualifier = SharedFunctions.minimalQuotedStringOf(this.getObjectname(), undefined, undefined);
				}
				for (var item of columnmodel.getProperty("/")) {
					var rank = rankfunction.call(this, text, item);
					if (rank > 0) {
						model.addArrayProperty("/", { qualifiershort: qualifier + "." + SharedFunctions.minimalQuotedStringOf(item.name, undefined, undefined), match: rank, name: item.name } );
					}
				}
			}
		},
		getColumnSuggestion : function(qualifier) {
			var columnmodel = this.getModel("columnsuggestions");
			if (columnmodel) {
				return columnmodel.getProperty("/").find(element => element.qualifier === qualifier);
			} else {
				return undefined;
			}
		},
		onChangeTable : function(event) {
			var oControl = event.getSource();
			var tableexpressioncontrol = oControl.getParent();
			var oContext = oControl.getBindingContext();
			var sPath = oContext.getPath();
			var oModel = oControl.getModel();
			var frompath = oModel.getParentPath(sPath);
			var selected = event.getParameter("value");
			if (selected) {
				if (oModel.isLastProperty(sPath)) {
					oModel.addArrayProperty(frompath, { value: "", jointype: "JOIN", joinVisible: true, on: [ {left: "", op: "=", right: ""} ] });
				}
				var tableexpressionpath = oModel.getParentPath(frompath);
				if (!oModel.getProperty(tableexpressionpath + "/projections")) {
					oModel.setProperty(tableexpressionpath + "/projections", [
								{ value: "", order: "NONE", orderVisible: tableexpressionpath === "/subquery"}
							]
					);
				}
				if (!oModel.getProperty(tableexpressionpath + "/where")) {
					oModel.setProperty(tableexpressionpath + "/where", [
								{ left: "", op: "=", right: "" }
							]
					);
				}
				tableexpressioncontrol.refreshTable(selected);
			}
		},
		refreshTable : function(tablename) {
			if (tablename) {
				var columnmodel = this.getModel("columns");
				if (!columnmodel) {
					columnmodel = new sap.ui.model.json.JSONModel();
					this.setModel(columnmodel, "columns");
				}
				var selectedrow = this.getTableSuggestion(tablename);
				if (selectedrow) {
					if (selectedrow.objecttype === "CTE") {
						columnmodel.setData(this.getSubQueryColumns(selectedrow.qualifier))
					} else {
						this.setSchemaname(selectedrow.schemaname);
						this.setObjectname(selectedrow.objectname);
						this.setObjecttype(selectedrow.objecttype);
						this.setTargetschemaname(selectedrow.targetschemaname);
						this.setTargetobjectname(selectedrow.targetobjectname);
						this.setTargetobjecttype(selectedrow.targetobjecttype);
						columnmodel.loadData("../../rest/catalog/schemas/" + helperfunctions.encodeURIfull(selectedrow.targetschemaname) 
								+ "/" + helperfunctions.encodeURIfull(selectedrow.targetobjectname) + "/columns");
					}
				}
			}
		},
		getSubQueryColumns : function(alias) {
			return this.getParent().getSubQueryColumns(alias);
		},
		refreshAllColumnModels : function() {
			this.refreshTable(this.getTable());
		}
	});
});
