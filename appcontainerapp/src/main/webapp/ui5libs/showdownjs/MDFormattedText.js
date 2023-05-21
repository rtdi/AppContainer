sap.ui.require([
	'ui5libs/showdownjs/dist/showdown',
], function() {
});

sap.ui.define([
	'sap/ui/core/Control',
	'ui5libs/showdownjs/dist/showdown',
], function(Control) {
	return Control.extend("ui5libs.showdownjs.MDFormattedText", {
		_root: undefined,
		metadata: {
            properties: {
                width: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                height: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                value: { type: "string" }
            },
            aggregations: {
			},
            events: {
			}
		},
		init : function() {
			Control.prototype.init.call(this);
			this._converter = new showdown.Converter();
			this._converter.setFlavor('github');
		},
		/* onAfterRendering : function() {
			sap.ui.core.Control.prototype.onAfterRendering.apply(this, arguments);
		}, */
		getHtml : function() {
			return this._converter.makeHtml(this.getValue());
		}

	});
});
