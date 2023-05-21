sap.ui.define([
	'sap/ui/core/Control',
	'ui5app/libs/SharedFunctions'
], function(Control, SharedFunctions) {
	/*
	  A Projection is an expression with an alias
	  
	*/
  return Control.extend("ui5app.controls.Projection", {
		metadata : {
			properties : {
				name: {type: "string"},
				datatype: {type: "string"},
				notnull: {type: "string"},
				position: {type: "int"},
				pkindex: {type: "int"},
				comment: {type: "string"},
				precision: {type: "int"},
				length: {type: "int"},
				qualifier: {type: "string"},
			},
			aggregations : {
				_expression : {
					type : "sap.m.Input",
					multiple : false,
					hidden: true
				},
				_alias : {
					type : "sap.m.Input",
					multiple : false,
					hidden: true
				},
				_order : {
					type : "sap.m.SegmentedButton",
					multiple : false,
					hidden: true
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			this.setAggregation("_expression", new sap.m.Input( {
				width: "20em",
				value: "{value}",
				showSuggestion: true,
				suggest: this.showColumnSuggestion,
				change: this.onProjectionChange,
				filterSuggests: false,
				suggestionItems: {
					path: "/",
					model: "columnsuggestions",
					template: new sap.ui.core.ListItem( { text: "{columnsuggestions>qualifiershort}" /*, additionalText: "{columnsuggestions>match}"*/ } ),
					templateShareable: false,
					sorter: new sap.ui.model.Sorter("match", true)
				}
			} ));
			this.setAggregation("_alias", new sap.m.Input( { width: "5em", value: "{alias}" } ));
			this.setAggregation("_order", new sap.m.SegmentedButton( {
				selectedKey: "{order}",
				visible: "{orderVisible}",
				items: [
					new sap.m.SegmentedButtonItem( { icon: "sap-icon://sort-ascending", key: "ASC" }),
					new sap.m.SegmentedButtonItem( { icon: "sap-icon://text-align-justified", key: "NONE" }),
					new sap.m.SegmentedButtonItem( { icon: "sap-icon://sort-descending", key: "DESC" })
				]
			}));

		},
		setValue : function(value) {
			this.getAggregation("_expression").setValue(value);
		},
		getValue : function() {
			return this.getAggregation("_expression").getValue();
		},
		setAlias : function(value) {
			this.getAggregation("_alias").setValue(value);
		},
		getAlias : function() {
			return this.getAggregation("_alias").getValue();
		},
		showColumnSuggestion : function(event) {
			var oControl = event.getSource();
			// The filter function is not cloned, hence set it always as workaround
			oControl.setFilterFunction(function (sTerm, oItem) {
					return oItem.getText().match(new RegExp(sTerm, "i"));
				});
			oControl.getModel("columnsuggestions").setProperty("/", []);
			oControl.getParent().addColumnSuggestions(event.getParameter("suggestValue"), oControl.getModel("columnsuggestions"), SharedFunctions.rankColumns);
		},
		addColumnSuggestions : function(text, model, rankfunction) {
			for (var tableexpression of this.getParent().getTableexpressions()) {
				tableexpression.addColumnSuggestions(text, model, rankfunction);
			}
		},
		getColumnSuggestion : function(qualifier) {
			for (var tableexpression of this.getParent().getTableexpressions()) {
				var item = tableexpression.getColumnSuggestion(qualifier);
				if (item) {
					return item;
				}
			}
			return undefined;
		},
		onProjectionChange : function(event) {
			var oControl = event.getSource();
			var projectioncontrol = oControl.getParent();
			var oContext = oControl.getBindingContext();
			var sPath = oContext.getPath();
			var oModel = oControl.getModel();
			var sProjectionsPath = oModel.getParentPath(sPath);
			if (oModel.isLastProperty(sPath) && !!event.getParameter("value")) {
				oModel.addArrayProperty(sProjectionsPath, { value: "", order: "NONE", orderVisible: sProjectionsPath === "/subquery" });
			}
			var selected = event.getParameter("value");
			if (selected) {
				var selectedrow = projectioncontrol.getColumnSuggestion(event.getParameter("value"));
				if (selectedrow) {
					projectioncontrol.setName(selectedrow.name);
					projectioncontrol.setDatatype(selectedrow.datatype);
					projectioncontrol.setNotnull(selectedrow.notnull);
					projectioncontrol.setPosition(selectedrow.position);
					projectioncontrol.setPkindex(selectedrow.pkindex);
					projectioncontrol.setComment(selectedrow.comment);
					projectioncontrol.setPrecision(selectedrow.precision);
					projectioncontrol.setLength(selectedrow.length);
					projectioncontrol.setQualifier(selectedrow.qualifier);
				}
			}
		}
	});
});
