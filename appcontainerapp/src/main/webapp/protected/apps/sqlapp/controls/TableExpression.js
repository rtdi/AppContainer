sap.ui.define([
	'sap/ui/core/Control',
	"ui5libs/ui5ajax",
	'ui5app/controls/JoinCondition',
	'ui5app/libs/SharedFunctions',
	'ui5libs/helperfunctions'
], function(Control, ui5ajax, JoinCondition, SharedFunctions, helperfunctions) {
	/*
	  A TableExpression is a tables with join clause
	  
	*/
  return Control.extend("ui5app.controls.TableExpression", {
		metadata : {
			properties : {
				joinVisible: {type: "boolean" },
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
			if (this.getTable()) {
				// TableExpressions without a tablename can be ignored. These are extra lines and tables that have been deleted
				var columnmodel = this.getModel();
				var qualifier = this.getAlias();
				var oContext = this.getBindingContext();
				var sPath = oContext.getPath();
				if (!qualifier) {
					var tabledetails = this.getModel().getProperty(sPath + "/metadata");
					qualifier = helperfunctions.minimalQuotedStringOf(tabledetails.objectname, undefined, undefined);
				}
				for (var item of columnmodel.getProperty(sPath + "/columns")) {
					var rank = rankfunction.call(this, text, item);
					if (rank > 0) {
						model.addArrayProperty("/", { qualifiershort: qualifier + "." + helperfunctions.minimalQuotedStringOf(item.name, undefined, undefined), match: rank, name: item.name } );
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
				tableexpressioncontrol.refreshTable(selected, sPath);
			}
		},
		refreshTable : function(tablename, frompath) {
			if (tablename) {
				var columnmodel = this.getModel();
				var selectedrow = this.getTableSuggestion(tablename);
				if (selectedrow) {
					if (selectedrow.objecttype === "CTE") {
						columnmodel.setProperty("columns", this.getSubQueryColumns(selectedrow.qualifier))
					} else {
						ui5ajax.getJsonString("/catalog/schemas/"
							+ helperfunctions.encodeURIfull(selectedrow.targetschemaname) + "/"
							+ helperfunctions.encodeURIfull(selectedrow.targetobjectname) + "/columns", "ui5rest", undefined)
							.then(
								data => {
									columnmodel.setProperty(frompath + "/columns", JSON.parse(data.text));
									columnmodel.setProperty(frompath + "/metadata", Object.assign({}, selectedrow) );
								},
								error => {
									errorfunctions.uiError(view, error);
								}
							);
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
