sap.ui.define([
	'ui5libs/contentcontrols/ContentBase',
	'ui5libs/showdownjs/MDFormattedText',
	'sap/ui/codeeditor/CodeEditor'
], function() {
  return ui5libs.contentcontrols.ContentBase.extend("ui5libs.contentcontrols.MDEditor", {
		metadata : {
			properties : {
				codeEditorHeight: {type: "sap.ui.core.CSSSize", defaultValue: "auto" }
			},
			aggregations : {
			},
			events : {}
		},
		renderer: {},
		init : function() {
			ui5libs.contentcontrols.ContentBase.prototype.init.call(this);
			this.setEditorControl(new sap.ui.codeeditor.CodeEditor( { type: "text" }));
			var text = new ui5libs.showdownjs.MDFormattedText( {
				} );
			this.setDataControl(text);
		},
		setCodeEditorHeight : function(value) {
			this.setProperty("codeEditorHeight", value);
			this.getEditorControl().setHeight(value);
		},
		setValue: function(text) {
			this.setProperty("value", text);
			this.getEditorControl().setValue(text);
		},
		getValue: function() {
			return this.getEditorControl().getValue();
		},
		compile : function() {
			this.getDataControl().setValue(this.getEditorControl().getValue());
		},
		_setEditorVisible : function(isVisible) {
			this.getEditorControl().setVisible(isVisible);
		},
		getType : function() {
			return "Github flavored Markdown";
		}
	});
});