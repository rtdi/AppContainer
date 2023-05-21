sap.ui.define([
	'sap/ui/core/Control',
	'ui5libs/contentcontrols/ContentBase'
], function(Control) {
  return Control.extend("ui5app.controls.NotebookCell", {
		metadata : {
			properties : {
				title: { type: "string" },
			},
			aggregations : {
				content : {
					type : "ui5libs.contentcontrols.ContentBase",
					multiple : false,
				},
				_menu : {
					type : "sap.m.Toolbar",
					multiple : false,
					hidden: true
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			this.setAggregation("_menu", new sap.m.Toolbar( {
				content: [
					new sap.m.Text( {text: "Cell"}),
					new sap.m.Input( { width: "10rem"}),
					new sap.m.Text( {text: "Type" }),
					new sap.m.ToolbarSpacer(),
					new sap.m.Button( {
						text: "code",
						press: function (event) {
							this.onCode(event);
						}.bind(this)
					}),
					new sap.m.Button( {
						icon: "sap-icon://up",
						press: function (event) {
							this.onMoveUp(event);
						}.bind(this)
					}),
					new sap.m.Button( {
						icon: "sap-icon://down",
						press: function (event) {
							this.onMoveDown(event);
						}.bind(this)
					}),
					new sap.m.Button( {
						icon: "sap-icon://media-play",
						press: function (event) {
							this.onCompile(event);
						}.bind(this)
					}),
					new sap.m.Button( {
						icon: "sap-icon://collapse",
						press: function (event) {
							this.onCollapseExpand(event);
						}.bind(this)
					}),
				]
			}) );
		},
		onCollapseExpand : function(event) {
			var button = event.getSource();
			if (button.getIcon() === "sap-icon://collapse") {
				button.setIcon("sap-icon://expand");
				this.getContent().setVisible(false);
			} else {
				button.setIcon("sap-icon://collapse");
				this.getContent().setVisible(true);
			}
		},
		onMoveUp : function(event) {
			var cell = event.getSource().getParent().getParent();
			var vbox = cell.getParent();
			var index = vbox.indexOfItem(cell);
			if (index > 0) {
				vbox.removeItem(index);
				vbox.insertItem(cell, index-1);
			}
		},
		onMoveDown : function(event) {
			var cell = event.getSource().getParent().getParent();
			var vbox = cell.getParent();
			var index = vbox.indexOfItem(cell);
			if (index >= 0 && index < vbox.getItems().length-1) {
				vbox.removeItem(index);
				vbox.insertItem(cell, index+1);
			}
		},
		onCode : function(event) {
			this.getContent().toggleShowCode();
		},
		onCompile : function(event) {
			this.getContent().compile();
		},
		setContent : function(control) {
			this.setAggregation("content", control);
			this.getAggregation("_menu").getContent()[2].setText(control.getType());
		},
		getContent : function() {
			return this.getAggregation("content");
		},
		setTitle : function(text) {
			this.setProperty("title", text);
			this.getAggregation("_menu").getContent()[1].setValue(text);
		},
		getTitle : function() {
			return this.getAggregation("_menu").getContent()[1].getValue();
		},
	});
});
