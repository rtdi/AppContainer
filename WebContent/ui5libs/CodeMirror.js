/* global am4core:true */
sap.ui.define([ 'sap/ui/core/Control', "jquery.sap.global", "io/rtdi/hanaappcontainer/codemirror/lib/codemirror" ], function(Control, jQuery, library, CodeMirror) {
	return Control.extend("io.rtdi.hanaappcontainer.CodeMirror", {
		metadata: {
            properties: {
                width: {
                    type: "sap.ui.core.CSSSize",
                    defaultValue: "100%"
                },
                height: {
                    type: "sap.ui.core.CSSSize",
                    defaultValue: "100%"
                },
                plugin: {
                    type: "string"
                }
            },
            aggregations : {},
		},
		renderer : function(oRm, oControl) {
			oRm.write("<textarea");
			oRm.write(" style=\"display: none;\" ");
            oRm.writeControlData(oControl);
            oRm.write(">");
			oRm.write("</textarea>");
		},
		onBeforeRendering : function() {
		},
		onAfterRendering : function() {
			// if I need to do any post render actions, it will happen here
			if (sap.ui.core.Control.prototype.onAfterRendering) {
				sap.ui.core.Control.prototype.onAfterRendering.apply(this, arguments); // run the super class's method first
			}
			
			var te = this.getDomRef();
			te.value = "Hello World";

			this._editor = CodeMirror.fromTextArea(te, {
				lineNumbers : true,
				lineWrapping : true 
			});
		},
		dispose : function() {
		}
	});
});
