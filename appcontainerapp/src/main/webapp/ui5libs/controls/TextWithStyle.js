sap.ui.define([
	'sap/m/Text',
	'./library'
], function(Text) {
  return Text.extend("ui5libs.controls.TextWithStyle", {
		metadata : {
			properties : {
				fontstyle: {type: "ui5libs.controls.FontStyle"}
			},
			aggregations : {
			},
			events : {}
		},
		renderer : {},
		init : function() {
			Text.prototype.init.call(this);
		},
		setFontstyle : function(style) {
			this.setProperty("fontstyle", style);
			this.removeStyleClass("ui5libsItalic");
			this.removeStyleClass("ui5libsBold");
			this.removeStyleClass("ui5libsStrikeThrough");
			this.removeStyleClass("ui5libsSpelling");
			if (style === ui5libs.controls.FontStyle.Italic) {
				this.addStyleClass("ui5libsItalic");
			} else if (style === ui5libs.controls.FontStyle.Bold) {
				this.addStyleClass("ui5libsBold");
			} else if (style === ui5libs.controls.FontStyle.StrikeThrough) {
				this.addStyleClass("ui5libsStrikeThrough");
			} else if (style === ui5libs.controls.FontStyle.Spelling) {
				this.addStyleClass("ui5libsSpelling");
			}
		},

	});
});
