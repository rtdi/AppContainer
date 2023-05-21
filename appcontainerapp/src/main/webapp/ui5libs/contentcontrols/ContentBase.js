sap.ui.define([
	'sap/ui/core/Control',
	'sap/ui/table/Table',
	'sap/ui/core/HTML',
	'sap/ui/layout/ResponsiveSplitter',
	'sap/ui/layout/PaneContainer',
	'sap/ui/layout/SplitPane',
], function(Control) {
  return Control.extend("ui5libs.contentcontrols.ContentBase", {
		metadata : {
			properties : {
				value: {type: "string" },
				showCode: { type: "boolean", defaultValue : true },
				useSplitter: { type: "boolean", defaultValue : true },
			},
			aggregations : {
				_splitter : {
					type : "sap.ui.layout.ResponsiveSplitter",
					multiple : false,
					hidden: true
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			this.setAggregation("_splitter", new sap.ui.layout.ResponsiveSplitter( {
				rootPaneContainer: new sap.ui.layout.PaneContainer( {
					orientation: "Vertical",
					panes: [ new sap.ui.layout.SplitPane(), new sap.ui.layout.SplitPane() ],
				})	
			}) );
		},
		setEditorControl : function(control) {
			this.getAggregation("_splitter").getRootPaneContainer().getPanes()[0].setContent(control);
		},
		setDataControl : function(control) {
			this.getAggregation("_splitter").getRootPaneContainer().getPanes()[1].setContent(control);
		},
		getEditorControl : function() {
			return this.getAggregation("_splitter").getRootPaneContainer().getPanes()[0].getContent();
		},
		getDataControl : function() {
			return this.getAggregation("_splitter").getRootPaneContainer().getPanes()[1].getContent();
		},
		compile : function() {
		},
		_setEditorVisible : function(isVisible) {
		},
		setShowCode : function(isVisible) {
			this.setProperty("showCode", isVisible);
			this._setEditorVisible(isVisible);
		},
		toggleShowCode : function() {
			var isVisible = this.getProperty("showCode");
			this.setShowCode(!isVisible);
		},
		getType : function() {
			return "???";
		}
	});
});
