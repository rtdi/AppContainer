sap.ui.define([
	'sap/ui/core/Control',
	'ui5libs/controls/ShellBar'
], function(Control, AppContainerShellBar) {
  return Control.extend("ui5libs.controls.AppContainerPage", {
		metadata : {
			properties : {
				pageTitle: {type : 'string' },
				helpUrl: {type : 'string' },
			},
			defaultAggregation: "content",
			aggregations : {
				_shellbar : {
					type : "ui5libs.controls.ShellBar",
					multiple : false,
					visibility: "hidden"
				},
				content : {
					type : "sap.ui.core.Control",
					multiple : false
				},
			},
			events : {}
		},
		init : function() {
			Control.prototype.init.call(this);
			var oShellBar = new AppContainerShellBar( );
			var helpbutton = new sap.m.OverflowToolbarButton( {
				tooltip: "Help",
				type: "Transparent",
				text: "Help",
				icon: "sap-icon://sys-help",
				press: function(event) { this.onHelp(event) }.bind(this)
			} );
			oShellBar.addAdditionalContent(helpbutton);
			this.setAggregation("_shellbar", oShellBar);
		},
		setPageTitle: function(sText) {
			this.getAggregation("_shellbar").setSecondTitle(sText);
		},
		getPageTitle: function() {
			return this.getAggregation("_shellbar").getSecondTitle();
		},
		getShellBar : function() {
			return this.getAggregation("_shellbar");
		},
		onHelp : function(event) {
			if (this.getHelpUrl()) {
				window.open(this.getHelpUrl(), '_blank');
			}
		}
	});
});
