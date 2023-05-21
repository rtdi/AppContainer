sap.ui.define([
	'sap/ui/core/Control',
	'ui5app/libs/SharedFunctions'
], function(Control, SharedFunctions) {
	/*
	  A JoinCondition is a left and right expression
	  
	*/
  return Control.extend("ui5app.controls.JoinCondition", {
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
				suggest: this.showColumnSuggestionLeft,
				change: this.onJoinChange,
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
				suggest: this.showColumnSuggestionRight,
				change: this.onJoinChange,
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
		showColumnSuggestionRight : function(event) {
			var oControl = event.getSource();
			// The filter function is not cloned, hence set it always as workaround
			oControl.setFilterFunction(function (sTerm, oItem) {
					return oItem.getText().match(new RegExp(sTerm, "i"));
				});
			oControl.getModel("columnsuggestions").setProperty("/", []);
			// add all columns from the left side and up the list until the current table
			var table = oControl.getParent().getParent();
			for (var item of table.getParent().getTableexpressions()) {
				if (table === item) {
					break;
				} else {
					item.addColumnSuggestions(event.getParameter("suggestValue"), oControl.getModel("columnsuggestions"), SharedFunctions.rankColumns);
				}
			}
		},
		showColumnSuggestionLeft : function(event) {
			var oControl = event.getSource();
			// The filter function is not cloned, hence set it always as workaround
			oControl.setFilterFunction(function (sTerm, oItem) {
					return oItem.getText().match(new RegExp(sTerm, "i"));
				});
			oControl.getModel("columnsuggestions").setProperty("/", []);
			oControl.getParent().getParent().addColumnSuggestions(event.getParameter("suggestValue"), oControl.getModel("columnsuggestions"), SharedFunctions.rankColumns);
		},
		onJoinChange : function(event) {
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
