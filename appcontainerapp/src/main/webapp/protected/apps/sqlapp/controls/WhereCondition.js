sap.ui.define([
	'sap/ui/core/Control',
	'ui5app/libs/SharedFunctions'
], function(Control, SharedFunctions) {
	/*
	  A JoinCondition is a left and right expression
	  
	*/
  return Control.extend("ui5app.controls.WhereCondition", {
		metadata : {
			properties : {
			},
			aggregations : {
				_left : {
					type : "sap.m.Input",
					multiple : false,
					hidden: true
				},
				_condition : {
					type : "sap.m.Select",
					multiple : false,
					hidden: true
				},
				_right : {
					type : "sap.m.Input",
					multiple : false,
					hidden: true
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			this.setAggregation("_left", new sap.m.Input( {
				width: "20em",
				value: "{left}",
				showSuggestion: true,
				suggest: this.showColumnSuggestion,
				change: this.onColumnChange,
				filterSuggests: false,
				suggestionItems: {
					path: "/",
					model: "columnsuggestions",
					template: new sap.ui.core.ListItem( { text: "{columnsuggestions>qualifiershort}" /*, additionalText: "{columnsuggestions>match}"*/ } ),
					templateShareable: false,
					sorter: new sap.ui.model.Sorter("match", true)
				}
				} ));
			this.setAggregation("_right", new sap.m.Input( {
				width: "20em",
				value: "{right}",
				showSuggestion: true,
				suggest: this.showColumnSuggestion,
				filterSuggests: false,
				suggestionItems: {
					path: "/",
					model: "columnsuggestions",
					template: new sap.ui.core.ListItem( { text: "{columnsuggestions>qualifiershort}" /*, additionalText: "{columnsuggestions>match}"*/ } ),
					templateShareable: false,
					sorter: new sap.ui.model.Sorter("match", true)
				}
				} ));
			this.setAggregation("_condition", new sap.m.Select( { selectedKey: "{op}", forceSelection: false, items: [
				 new sap.ui.core.Item( { key: "", text: ""}),
				 new sap.ui.core.Item( { key: "=", text: "="}),
				 new sap.ui.core.Item( { key: "<", text: "<"}),
				 new sap.ui.core.Item( { key: "<=", text: "<="}),
				 new sap.ui.core.Item( { key: ">", text: ">"}),
				 new sap.ui.core.Item( { key: ">=", text: ">="}),
				 new sap.ui.core.Item( { key: "<>", text: "<>"}),
				 new sap.ui.core.Item( { key: "in", text: "in"}),
				 new sap.ui.core.Item( { key: "not in", text: "not in"}),
				 new sap.ui.core.Item( { key: "between", text: "between"}),
				 new sap.ui.core.Item( { key: "is not null", text: "is not null"}),
				 new sap.ui.core.Item( { key: "is null", text: "is null"}),
				 new sap.ui.core.Item( { key: "like", text: "like"}),
				 new sap.ui.core.Item( { key: "not like", text: "not like"}),
				 new sap.ui.core.Item( { key: "exists", text: "exists"}),
				 new sap.ui.core.Item( { key: "not exists", text: "not exists"}),
			]  } ));
		},
		setLeft : function(value) {
			this.getAggregation("_left").setValue(value);
		},
		getLeft : function() {
			return this.getAggregation("_left").getValue();
		},
		setRight : function(value) {
			this.getAggregation("_right").setValue(value);
		},
		getRight : function() {
			return this.getAggregation("_right").getValue();
		},
		setCondition : function(value) {
			this.getAggregation("_condition").setValue(value);
		},
		getCondition : function() {
			return this.getAggregation("_condition").getValue();
		},
		showColumnSuggestion : function(event) {
			var oControl = event.getSource();
			// The filter function is not cloned, hence set it always as workaround
			oControl.setFilterFunction(function (sTerm, oItem) {
					return oItem.getText().match(new RegExp(sTerm, "i"));
				});
			oControl.getModel("columnsuggestions").setProperty("/", []);
			// add all columns from the tables
			var subquery = oControl.getParent().getParent();
			for (var item of subquery.getTableexpressions()) {
				item.addColumnSuggestions(event.getParameter("suggestValue"), oControl.getModel("columnsuggestions"), SharedFunctions.rankColumns);
			}
		},
		onColumnChange : function(event) {
			var oControl = event.getSource();
			var oContext = oControl.getBindingContext();
			var sPath = oContext.getPath();
			var oModel = oControl.getModel();
			var sProjectionsPath = oModel.getParentPath(sPath);
			if (oModel.isLastProperty(sPath) && !!event.getParameter("value")) {
				oModel.addArrayProperty(sProjectionsPath, { left: "", op: "=", right: ""});
			}
		},
	});
});
