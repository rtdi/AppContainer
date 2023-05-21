sap.ui.define([
	'sap/ui/core/Control',
	'ui5app/libs/SharedFunctions',
	'ui5app/controls/Subquery'
], function(Control, SharedFunctions) {
	/*
	  A Projection is an expression with an alias
	  
	*/
  return Control.extend("ui5app.controls.WithEntry", {
		metadata : {
			properties : {
			},
			aggregations : {
				_expression : {
					type : "ui5app.controls.Subquery",
					multiple : false,
					hidden: true
				},
				_alias : {
					type : "sap.m.Input",
					multiple : false,
					hidden: true
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			this.setAggregation("_expression", new ui5app.controls.Subquery( { visible: "{=!!${alias}}" } ));
			this.setAggregation("_alias", new sap.m.Input( { width: "5em", value: "{alias}", change: this.onAliasChange } ));
		},
		setAlias : function(value) {
			this.getAggregation("_alias").setValue(value);
		},
		getAlias : function() {
			return this.getAggregation("_alias").getValue();
		},
		getSubquery : function() {
			return this.getAggregation("_expression");
		},
		onAliasChange : function(event) {
			var oControl = event.getSource();
			var oModel = oControl.getModel();
			var oContext = oControl.getBindingContext();
			var sPath = oContext.getPath();
			if (oModel.isLastProperty(sPath) && !!event.getParameter("value")) {
				oModel.addArrayProperty(oModel.getParentPath(sPath), { 
					alias: "", 
					subquery: {
							from: [{ value: "", joinVisible: false }],
							where: [
								{left: "", op: "=", right: ""}
							]
						}
				});
			}
		},
		addTableSuggestions : function(text, model, rankfunction, forpath) {
			// Add privious WITH query names
			for (var i = 0; i < this.getModel().getProperty("/with").length; i++ ) {
				if (forpath.startsWith("/with/" + i)) {
					break;
				}
				var item = this.getModel().getProperty("/with")[i];
				var rank = rankfunction.call(this, text, { objectname: item.alias, qualifiershort: item.alias });
				if (rank > 0) {
					model.addArrayProperty("/", {
						qualifiershort: item.alias,
						match: rank,
						schemaname: "",
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
			return this.getParent().getTableSuggestion(qualifier);
		},
		refreshAllColumnModels : function() {
			if (this.getAggregation("_expression")) {
				this.getAggregation("_expression").refreshAllColumnModels();
			}
		}
	});
});
