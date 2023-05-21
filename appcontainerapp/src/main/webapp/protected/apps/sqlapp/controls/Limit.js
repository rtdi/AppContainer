sap.ui.define([
	'sap/ui/core/Control'
], function(Control) {
	/*
	  A Projection is an expression with an alias
	  
	*/
  return Control.extend("ui5app.controls.Limit", {
		metadata : {
			properties : {
				limit: {type: "int"},
				offset: {type: "int"}
			},
			aggregations : {
				_limit : {
					type : "sap.m.Input",
					multiple : false,
					hidden: true
				},
				_offset : {
					type : "sap.m.Input",
					multiple : false,
					hidden: true
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			this.setAggregation("_limit", new sap.m.Input( {
				width: "5em",
				value: "{limit}",
				showSuggestion: false,
			} ));
			this.setAggregation("_offset", new sap.m.Input( {
				width: "5em",
				value: "{offset}",
				showSuggestion: false,
			} ));

		},
		setLimit : function(value) {
			this.getAggregation("_limit").setValue(value);
		},
		getLimit : function() {
			return this.getAggregation("_limit").getValue();
		},
		setOffset : function(value) {
			this.getAggregation("_offset").setValue(value);
		},
		getOffset : function() {
			return this.getAggregation("_offset").getValue();
		},
	});
});
