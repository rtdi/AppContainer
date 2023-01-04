sap.ui.define([
	"ui5libs/controls/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions"
],
function(Controller, ui5ajax, errorfunctions) {
	"use strict";
	return Controller.extend("io.rtdi.appcontainer.sqlapp.Controller", {
		WITHITEM : { "showText": false, "type": "withitem", "showDelete": true, },
		ORDERBYITEM: { "showText": false, "type": "orderbyitem", "showDelete": true, },
		PROJECTIONITEM: { "showText": false, "type": "column", "showDelete": true, },
		CONDITIONITEM: { "showText": false, "type": "condition", "showDelete": true, "op": "=" },
		GROUPBYITEM: { "showText": false, "type": "groupbycolumn", "showDelete": true, },
		FROMITEM: { "text": "join", "showText": true, "type": "table", "subtype": "join", "showDelete": true, },
		JOINITEM: {
								"text": "on", "showText": true, "type": "on", "showDelete": false,
								"children": undefined
							},
		CONDITIONLIST: { "text": "(... and ...)", "showText": true, "type": "whereitem", "showDelete": false, },
		getWithItem : function() {
			return $.extend({}, this.WITHITEM);
		},
		getOrderByItem : function() {
			return $.extend({}, this.ORDERBYITEM);
		},
		getProjectionItem : function() {
			return $.extend({}, this.PROJECTIONITEM);
		},
		getConditionList : function() {
			var o = $.extend({}, this.CONDITIONLIST);
			o.children = [ this.getConditionItem() ];
			return o;
		},
		getConditionItem : function() {
			return $.extend({}, this.CONDITIONITEM);
		},
		getGroupByItem : function() {
			return $.extend({}, this.GROUPBYITEM);
		},
		getFromItem : function() {
			return $.extend({}, this.FROMITEM);
		},
		getJoinItem : function() {
			var o = $.extend({}, this.JOINITEM);
			o.children = [ this.getConditionList(), this.getFromItem() ];
			return o;
		},
		init : function() {
			var oModel = new ui5libs.libs.model.json.JSONModelE();
			oModel.setProperty("/", this.getRootTree());
			var oTree = this.getView().byId("sqltree");
			oTree.setModel(oModel);
			oTree.expandToLevel(10);
			
			
			var oModelAC = new sap.ui.model.json.JSONModel();
			oModelAC.setSizeLimit(50000);
			var url = sap.ui.require.toUrl("ui5rest") + "/catalog/sources";
			oModelAC.loadData(url);
			this.getView().setModel(oModelAC, "tables");

			this.getView().setModel(new ui5libs.libs.model.json.JSONModelE(), "columns");
			
		},
		getRootTree: function() {
			return {"children": [
				/* {
					"text": "with", "showText": true, "type": "with", "showDelete": false,
					"children": [ this.getWithItem() ]
				}, */
				this.getSelectTree(),
				/* {
					"text": "order by", "showText": true, "type": "orderby", "showDelete": false,
					"children": [ this.getOrderByItem() ]
				},
				{
					"text": "limit", "showText": true, "type": "limit", "showDelete": true,
				}, */
			] };
		},
		getSelectTree: function() {
			return {
					"text": "select", "showText": true, "type": "select", "showDelete": false,
					"children": [
						{
							"text": "projection", "showText": true, "type": "projection", "showDelete": false,
									"children": [ this.getProjectionItem() ]
						},
						{
							"text": "from", "showText": true, "type": "table", "subtype": "root", "showDelete": false,
							"children": [
								this.getFromItem()
							]
						},
						{
							"text": "where", "showText": true, "type": "where", "showDelete": false,
							"children": [ this.getConditionList() ]
						},
						/* {
							"text": "group by", "showText": true, "type": "groupby", "showDelete": false,
							"children": [ this.getGroupByItem() ]
						},
						{
							"text": "set clause", "showText": true, "type": "setclause", "showDelete": false,
						}, */
					]
				};
		},
		onInputChangeTable: function(oEvent) {
			var control = oEvent.getSource();
			var binding = control.getBindingContext();
			var model = binding.getModel();
			
			var entity = model.getProperty(binding.getPath());
			if (entity.subtype === "join" ) {
				if (!model.getProperty(binding.getPath() + "/children")) {
					model.setProperty(binding.getPath() + "/children", [ this.getJoinItem() ]);
				}
			}
		},
		onInputChange: function(oEvent) {
			var control = oEvent.getSource();
			var binding = control.getBindingContext();
			var model = binding.getModel();
			
			var getNextSibilingPath = function(path) {
				var p = path.lastIndexOf('/');
				var sIndex = path.substring(p+1);
				var nextindex = parseInt(sIndex) + 1;
				return path.substring(0, p) + "/" + nextindex;
			}
			
			var entity = model.getProperty(binding.getPath());
			var sibling = getNextSibilingPath(binding.getPath());
			if (!model.getProperty(sibling)) {
				switch (entity.type) {
				case "groupbycolumn":
					model.setProperty(sibling, this.getGroupByItem());
					break;
				case "condition":
					model.setProperty(sibling, this.getConditionItem());
					break;
				case "column":
					model.setProperty(sibling, this.getProjectionItem());
					break;
				case "orderbyitem":
					model.setProperty(sibling, this.getOrderByItem());
					break;
				case "withitem":
					model.setProperty(sibling, this.getWithItem());
					break;
				}
			}
		},
		onHandleColumnSuggest: function(oEvent) {
			var sTerm = oEvent.getParameter("suggestValue");
			var aFilters = [];
			if (sTerm) {
				aFilters.push(new sap.ui.model.Filter("qualifier", sap.ui.model.FilterOperator.Contains, sTerm));
			}
			oEvent.getSource().getBinding("suggestionItems").filter(aFilters);
		},
		onHandleTableSuggest: function(oEvent) {
			var sTerm = oEvent.getParameter("suggestValue");
			var aFilters = [];
			if (sTerm) {
				aFilters.push(new sap.ui.model.Filter("qualifiershort", sap.ui.model.FilterOperator.Contains, sTerm));
			}
			oEvent.getSource().getBinding("suggestionItems").filter(aFilters);
		},
		quoteDBObject: function(name) {
			if (name === name.toUpperCase()) {
				return name;
			} else {
				return "\"" + name + "\"";
			}
		},
		onDragEnterTables: function(oEvent) {
			var oTargetPath = oEvent.getParameter("target").getBindingContext().getPath();
			var oTargetModel = oEvent.getParameter("target").getModel();
			var oSourceControl = oEvent.getParameter("dragSession").getDragControl();
			var o = oTargetModel.getProperty(oTargetPath);
			if (oSourceControl instanceof sap.m.Button) {
				switch (oSourceControl.getText()) {
				case "subselect":
					/*
					 * A subselect can be added when there is none yet, the first child is an "on" clause, not a select, or there are no children at all
					 */
					if (o && o.type === "table") {
						if (o.children && o.children.length > 0 && o.children[0].type === "select") {
							break;
						}
						return; // allowed
					}
					break;
				case "join":
				case "left outer join":
				case "right outer join":
				case "full outer join":
					if (o && o.subtype === "join") {
						// valid
						return
					}
					break;
				}
			}
			// everything else is invalid
			oEvent.preventDefault();
        },
		onDropTables: function(oEvent) {
			var oTargetPath = oEvent.getParameter("droppedControl").getBindingContext().getPath();
			var oTargetModel = oEvent.getParameter("droppedControl").getModel();
			var oSourceControl = oEvent.getParameter("draggedControl");
			if (oTargetModel.getProperty(oTargetPath + "/type") === "table") {
				if (oSourceControl instanceof sap.m.Button) {
					switch (oSourceControl.getText()) {
					case "subselect":
						var aNew;
						var s = this.getSelectTree();
						s.showDelete = true;
						var a = oTargetModel.getProperty(oTargetPath + "/children");
						if (a) {
							if (a[0].type === "select") {
								// This is a subselect already, do nothing
								return;
							} else {
								aNew = [ s, a[0] ];
							}
							
						} else {
							aNew = [s, this.getJoinItem() ];
						}
						oTargetModel.setProperty(oTargetPath + "/value", undefined );
						oTargetModel.setProperty(oTargetPath + "/children", aNew );
						break;
					case "join":
					case "left outer join":
					case "right outer join":
					case "full outer join":
						oTargetModel.setProperty(oTargetPath + "/text", oSourceControl.getText());
						break;
					} 
				}
			}
		},
		onDeleteSQLPart: function(oEvent) {
			var oSourceControl = oEvent.getSource();
			var oSourcePath = oSourceControl.getBindingContext().getPath();
			var oSourceModel = oSourceControl.getModel();
			var oSourceRow = oSourceModel.getProperty(oSourcePath);
			if (oSourceRow.type === 'table' && oSourceRow.subtype === 'join') {
				// Delete the table information from the join by setting the tablename to null
				oSourceModel.setProperty(oSourcePath + "/tablename", undefined);
				oSourceModel.deleteProperty(oSourcePath + "/children");
			} else if (oSourceRow.type === 'select') {
				// delete the subselect node from the parent node
				// subselect has level /children/0/children/1/children/0/children/1
				// sourcepath /children/0/children/1/children/0
				oSourceModel.removeArrayProperty(oSourcePath);
				this._removeColumnsFromSuggestionList(oSourcePath+ "/children/1"); // remove columns of subselect
			} else {
				var parentobjectpath = oSourceModel.getParentObjectPath(oSourcePath);
				var oParentRow = oSourceModel.getProperty(parentobjectpath);
				if (oParentRow) {
					if (oParentRow.type === 'projection') {
						/*
						 * Case 1: There is just a single project row, clear the text (and remove any children)
						 * Case 2: The last item is deleted - same as above
						 * Case 3: Remove the item and push all siblings one position higher 
						 */
						if (oSourceModel.isLastProperty(oSourcePath)) {
							oSourceModel.setProperty(oSourcePath + "/value", undefined);
							oSourceModel.setProperty(oSourcePath + "/children", undefined);
						} else {
							oSourceModel.deleteProperty(oSourcePath);
						}
					}
				}
			}
		},
		_removeColumnsFromSuggestionList: function(oSourcePath) {
			var oColumnModel = this.getView().getModel("columns");
			var oCurrent = oColumnModel.getProperty("/");
			var oNewData = [];
			if (oCurrent && Array.isArray(oCurrent)) { // initially this is an empty object, not an array
				// Remove all entries that belong to that level
				oNewData = oCurrent.filter(function(e) { return e.level !== oSourcePath })
			}
			oColumnModel.setProperty("/", oNewData);
		},
		onChangeTable: function(oEvent) {
			/*
			 * The user modifed the table selector field. Either changed the table name, added one in a previously empty field or deleted the table name 
			 */
			var findTable = function(sText) {
				var oTables = this.getView().getModel("tables");
				for (var t of oTables.getProperty("/")) {
					if (t.qualifiershort === sText) {
						return t;
					}
				}
			};
			var oColumnModel = this.getView().getModel("columns");
			var oSourceControl = oEvent.getSource();
			var oSourcePath = oSourceControl.getBindingContext().getPath();
			var oSourceModel = oSourceControl.getModel();
			var oSourceRow = oSourceModel.getProperty(oSourcePath);
			this._removeColumnsFromSuggestionList(oSourcePath);
			var oTableMetadata = findTable.call(this, oEvent.getParameter("value"));
			if (oTableMetadata) {
				var sSchema = oTableMetadata.targetschemaname;
				var sTable = oTableMetadata.targetobjectname;
				var sTableAlias = oSourceRow.alias;
				if (!sTableAlias) {
					sTableAlias = sTable;
				}
				ui5ajax.getJsonObject("catalog/schemas/" + sSchema + "/" + sTable + "/columns", "ui5rest")
					.then(
						data => {
							// replace the existing columns with the new table columns
							var oCurrent = oColumnModel.getProperty("/");
							for (var c of data.obj) {
								// Add all columns from that level
								c.qualifier = sTableAlias + "." + c.name;
								c.level = oSourcePath;
							}
							oCurrent.push(...data.obj);
							oColumnModel.setProperty("/", oCurrent);
						}, 
						error => {
						}
					);
			}
		},
		onChangeExpression: function(oEvent) {
			/*
			 * If a projection of a subselect is changed, modify the suggestion list tied to the parent's table, similar to onChangeTable
			 */
		},
		onChangeAlias: function(oEvent) {
			var oColumnModel = this.getView().getModel("columns");
			var oColumns = oColumnModel.getProperty("/");
			var oSourceControl = oEvent.getSource();
			var oSourcePath = oSourceControl.getBindingContext().getPath();
			var sTableAlias = oEvent.getParameter("value");
			var oTree = this.getView().byId("sqltree");
			var oModel = oTree.getModel();
			var oRow = oModel.getProperty(oSourcePath);
			if (oRow.type === "table") {
				if (!sTableAlias) {
					sTableAlias = oRow.tablename;
				}
				var sOldAlias = undefined;
				for (var c of oColumns) {
					if (c.level === oSourcePath) {
						if (!sOldAlias) {
							sOldAlias = c.qualifier.substring(0, c.qualifier.indexOf("."));
						}
						c.qualifier = sTableAlias + "." + c.name;
					}
				}
				oColumnModel.setProperty("/", oColumns);
				
				var changealias = function(aliasold, aliasnew, node) {
					if (node) {
						if (node.expression && node.expression.startsWith(aliasold + ".")) {
							node.expression = aliasnew + node.expression.substring(node.expression.indexOf("."));
						}
						if (node.leftexpression && node.leftexpression.startsWith(aliasold + ".")) {
							node.leftexpression = aliasnew + node.leftexpression.substring(node.leftexpression.indexOf("."));
						}
						if (node.rightexpression && node.rightexpression.startsWith(aliasold + ".")) {
							node.rightexpression = aliasnew + node.rightexpression.substring(node.rightexpression.indexOf("."));
						}
						if (node.children) {
							for (var n of node.children) {
								changealias(aliasold, aliasnew, n);
							}
						}
					}
				}
				changealias(sOldAlias, sTableAlias, oModel.getData());
				oModel.setData(oModel.getData());
			}
		},
		createSQL : function() {

			var createCondition = function(conditiontree) {
				var clause;
				var first = true;
				var operation = "and";
				switch (conditiontree.text) {
				case "(... and ...)": operation = "and"; break
				case "(... or ...)": operation = "or"; break
				}
				for (var cond of conditiontree.children) {
					if (cond.leftexpression && cond.op && cond.rightexpression) {
						if (first) {
							first = false;
							clause = cond.leftexpression + cond.op + cond.rightexpression;
						} else {
							clause += " "+ operation + " ";
							clause += cond.leftexpression + cond.op + cond.rightexpression;
						}
					} else if (cond.children) {
						clause += "(" + createCondition(cond.children[0]) + ")";
					}
				}
				return clause;
			}
					
			var createJoin = function(joinnode) {
				var joinclause;
				if (joinnode && joinnode.tablename) {
					joinclause = joinnode.text + " " + joinnode.tablename;
					if (joinnode.alias) {
						joinclause += " as " + joinnode.alias;
					}
					var conditiontree = joinnode.children[0];
					if (conditiontree.type === "on") {
						joinclause += " on ";
						joinclause += "(" + createCondition(conditiontree.children[0]) + ")";
					}
					var nextjoin = createJoin(conditiontree.children[1]);
					if (nextjoin) {
						joinclause += " " + nextjoin;
					}
				}
				return joinclause;
			}
			
			var createProjection = function(tree) {
				var projection;
				if (tree) {
					for (var element of tree) {
						switch (element.type) {
						case "column":
							if (element.expression) {
								if (projection === undefined) {
									projection = " ";
								} else {
									projection += ", ";
								}
								projection += element.expression;
							}
							break;
						}
					}
				}
				if (projection === undefined) {
					projection = " *";
				}
				return projection;
			}

			var createWhere = function(aConditions, operation) {
				var ret = "";
				if (aConditions) {
					for (var element of aConditions) {
						var text = undefined;
						if (element.type === "whereitem") { // it is a (..and..) node
							text = createWhere(element.children, element.text);
						} else if (element.type === "condition") { // left = right
							if (element.leftexpression || element.rightexpression) { // not empty
								text = element.leftexpression + " " + element.op + " " + element.rightexpression;
							}
						}
						if (text) {
							if (ret.length != 0) {
								switch (operation) {
								case "(... and ...)":
									ret += " and ";
									break;
								case "(... or ...)":
									ret += " or ";
									break;
								default:
								}
							}
							ret += text;
						}
					}
				}
				return ret;
			}

			var createSelect = function(tree) {
				var sql = "select";
				var projection;
				var whereclause = "";
				var from;
				for (var element of tree.children) {
					switch (element.type) {
					case "projection":
						projection = createProjection(element.children);
						break;
					case "table":
						if (element.tablename) {
							from = " from " + element.tablename;
							if (element.alias) {
								from += " as " + element.alias;
							}
							var joinclause = createJoin(element.children[0]);
							if (joinclause) {
								from += " " + joinclause;
							}
						}
						break;
					case "where":
						whereclause = createWhere(element.children, undefined);
						if (whereclause) {
							whereclause = " where " + whereclause;
						}
						break;
					}
				}
				sql += projection + from + whereclause;
				return sql;
			}
			
			var oTree = this.getView().byId("sqltree");
			var oModel = oTree.getModel();
			var data = oModel.getData().children;
			var selectclause = data[0];
			var sql = "";
			sql += createSelect(selectclause);
			var oLimitControl = this.getView().byId("limit");
			if (oLimitControl.getValue()) {
				sql += " limit " + oLimitControl.getValue();
			}
			return sql;
		},
		onExecuteQuery : function() {
			var oView = this.getView();
			var oTableData = oView.byId("idTableData");
			var oModel = new sap.ui.model.json.JSONModel();
			oTableData.unbindRows();
			oTableData.removeAllColumns();
			var sql = this.createSQL();
			var url = sap.ui.require.toUrl("ui5rest") + "/query?$select=" + encodeURIComponent(sql);
			oModel.attachRequestCompleted(function(oEvent) {
				if (oEvent.getParameter("success")) {
					var cols = oModel.getProperty("/columns");
					if (cols) {
						for (var oCol of cols) {
							var oColumn = new sap.ui.table.Column({
								resizable:true,
								autoResizable: true,
								minWidth: 80,
								label: [new sap.m.Label({text: oCol.name})],
								template: [ new sap.m.Text( { text: "{ path: '" + oCol.name + "', targetType:'any'}", wrapping: false } ) ]
							});
							oTableData.addColumn(oColumn);
						}
					}
					oTableData.bindRows("/rows");
				} else {
					var oError = oEvent.getParameter("errorobject");
					errorfunctions.addError(oView, oError);
				}
			});
			oModel.loadData(url);
			oTableData.setModel(oModel);
		},
		onTableDataResizeColumns : function(oEvent) {
			var oTableData = this.getView().byId("idTableData");
			for (var i=0; i<oTableData.getColumns().length; i++) {
				oTableData.autoResizeColumn(i);
			}
		},

	});
});
