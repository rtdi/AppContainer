sap.ui.define([
	'sap/ui/core/Control',
	'ui5app/libs/SharedFunctions',
	'ui5app/controls/Subquery',
	'ui5app/controls/Projection',
	'ui5app/controls/WithEntry',
	'ui5app/controls/Limit'
], function(Control, SharedFunctions) {
	/*
	  A Query object is the primary frame of a database query 
	  
	  subquery
	    select_clause
	    from_clause
		  table_expression
	    where_clause
	    group_by_clause
	    having_clause

	*/
  return Control.extend("ui5app.controls.Query", {
		metadata : {
			properties : {
			},
			aggregations : {
				withexpressions : {
					type : "ui5app.controls.WithEntry",
					multiple : true
				},
				subqueryexpression : {
					type : "ui5app.controls.Subquery",
					multiple : false
				},
				_limitexpression : {
					type : "ui5app.controls.Limit",
					multiple : false
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			this.bindElement("/");
			this.setSubqueryexpression(new ui5app.controls.Subquery());
			this.bindAggregation("withexpressions", {
					path: "with",     
					template: new ui5app.controls.WithEntry()
				});
			var otablemodel = new sap.ui.model.json.JSONModel();
			otablemodel.attachRequestCompleted(function(event) { this.refreshAllColumnModels(event) }.bind(this) );
			otablemodel.loadData("../../rest/catalog/sources");
			this.setModel(otablemodel, "tables");
			this.setModel(new ui5libs.libs.model.json.JSONModelE(), "tablesuggestions");
			this.setModel(new ui5libs.libs.model.json.JSONModelE(), "columnsuggestions");
			this.setAggregation("_limitexpression", new ui5app.controls.Limit( ));
		},
		addTableSuggestions : function(text, model, rankfunction, forpath) {
			// Add WITH query names
			for (var item of this.getModel().getProperty("/with")) {
				var rank = rankfunction.call(this, text, { objectname: item.alias, qualifiershort: item.alias });
				if (rank > 0) {
					model.addArrayProperty("/", {
						qualifiershort: item.alias,
						match: rank,
						schemaname: item.schemaname,
						objectname: item.alias,
						objecttype: "CTE",
						targetschemaname: null,
						targetobjectname: null,
						targetobjecttype: "CTE",
						qualifier: item.alias
					} );
				}
			}
		},
		getTableSuggestion : function(qualifier) {
			var entries = this.getModel("tablesuggestions").getProperty("/");
			if (entries) {
				return entries.find(element => element.qualifiershort ===  qualifier || element.qualifier === qualifier);
			}
		},
		getSubQueryColumns : function(alias) {
			var cte = this.getModel().getProperty("/with").find(element => element.alias ===  alias);
			if (cte) {
				var ctecolumns = [];
				var adata = this.getModel().getProperty("/with/subquery/projections");
				if (adata) {
					for ( var i = 0; i < adata.length; i++) {
						var item = adata[i];
						var projectionname = item.alias;
						if (!projectionname) {
							projectionname = item.value;
						}
						ctecolumns.push({name: projectionname, position: i});
					}
					return ctecolumns;
				}
			}
			return undefined;
		},
		refreshAllColumnModels : function() {
			var that = this;
			this.getModel("tables").dataLoaded().then( prom => {
				if (that.getWithexpressions()) {
					for ( var item of that.getWithexpressions()) {
						item.refreshAllColumnModels();
					}
				}
				if (that.getSubqueryexpression()) {
					that.getSubqueryexpression().refreshAllColumnModels();
				}
			});
		}
	});
});
