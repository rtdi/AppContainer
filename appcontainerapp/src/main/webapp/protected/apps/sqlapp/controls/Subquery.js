sap.ui.define([
	'sap/ui/core/Control',
	'ui5app/libs/SharedFunctions',
	'ui5app/controls/TableExpression',
	'ui5app/controls/WhereCondition'
], function(Control, SharedFunctions) {
	/*
	  A subquery is a select statement that can be used as primary SQL or embedded as subquery, cte, nested query
	  
	  subquery
	    select_clause
	    from_clause
		  table_expression
	    where_clause
	    group_by_clause
	    having_clause

	*/
  return Control.extend("ui5app.controls.Subquery", {
		metadata : {
			properties : {
			},
			aggregations : {
				projections : {
					type : "ui5app.controls.Projection",
					multiple : true
				},
				tableexpressions : {
					type : "ui5app.controls.TableExpression",
					multiple : true
				},
				whereconditions : {
					type : "ui5app.controls.WhereCondition",
					multiple : true
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			this.bindAggregation("projections", {
					path: "subquery/projections",     
					template: new ui5app.controls.Projection(),
					templateShareable: false
				});
			this.bindAggregation("tableexpressions", {
					path: "subquery/from",     
					template: new ui5app.controls.TableExpression(),
					templateShareable: false
				});
			this.bindAggregation("whereconditions", {
					path: "subquery/where",     
					template: new ui5app.controls.WhereCondition(),
					templateShareable: false
				});
		},
		addTableSuggestions : function(text, model, rankfunction, forpath) {
			this.getParent().addTableSuggestions(text, model, rankfunction, forpath);
			// Go through all tables and add their suggestions
			for (var item of this.getModel("tables").getProperty("/")) {
				var rank = rankfunction.call(this, text, item);
				if (rank > 0) {
					model.addArrayProperty("/", {
						qualifiershort: SharedFunctions.minimalQuotedStringOf(item.qualifiershort, item.schemaname, item.objectname),
						match: rank,
						schemaname: item.schemaname,
						objectname: item.objectname,
						objecttype: item.objecttype,
						targetschemaname: item.targetschemaname,
						targetobjectname: item.targetobjectname,
						targetobjecttype: item.targetobjecttype,
						qualifier: SharedFunctions.minimalQuotedStringOf(item.qualifier, item.schemaname, item.objectname)
					} );
				}
			}
		},
		getTableSuggestion : function(qualifier) {
			return this.getParent().getTableSuggestion(qualifier);
		},
		getSubQueryColumns : function(alias) {
			return this.getParent().getSubQueryColumns(alias);
		},
		refreshAllColumnModels : function() {
			if (this.getAggregation("tableexpressions")) {
				for ( var item of this.getAggregation("tableexpressions")) {
					item.refreshAllColumnModels();
				}
			}
		}
	});
});
