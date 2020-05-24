sap.ui.define(
  [
	  'sap/m/MaskInput', 
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/TextDirection',
	  'sap/m/MaskInputRule',
	  'sap/ui/core/ValueState',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(MaskInput, JSONModel, TextAlign, TextDirection, MaskInputRule, ValueState) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.MaskInput", {
			metadata : {
				properties: {
					regex: { type: "string", defaultValue: "[^_]" },
					maskFormatSymbol: { type: "string", defaultValue: "*" },
					
					placeholderSymbol: {type: "string", group: "Misc", defaultValue: "_"},
					mask: {type: "string", group: "Misc", defaultValue: null},
					
					// InputBase
					value: { type: "string", group: "Data", defaultValue: null, bindable: "bindable" },
					width: { type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: null },
					enabled: { type: "boolean", group: "Behavior", defaultValue: true },
					valueState: { type: "sap.ui.core.ValueState", group: "Appearance", defaultValue: ValueState.None },
					name: { type: "string", group: "Misc", defaultValue: null },
					placeholder: { type: "string", group: "Misc", defaultValue: null },
					editable: { type: "boolean", group: "Behavior", defaultValue: true },
					valueStateText: { type: "string", group: "Misc", defaultValue: null },
					showValueStateMessage: { type: "boolean", group: "Misc", defaultValue: true },
					textAlign: { type: "sap.ui.core.TextAlign", group: "Appearance", defaultValue: TextAlign.Initial },
					textDirection: { type: "sap.ui.core.TextDirection", group: "Appearance", defaultValue: TextDirection.Inherit },
					required : {type : "boolean", group : "Misc", defaultValue : false}

				}
			},
			renderer : {},
			init : function() {
				var oChild = new sap.m.MaskInput();
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, oChild, false);
				var oRule = new sap.m.MaskInputRule( {regex: this.getRegex(), maskFormatSymbol: this.getMaskFormatSymbol() } );
				oChild.addRule(oRule);
			},
			setRegex : function(value) {
				this.setProperty('regex', value, true);
				var oChild = this.getAggregation("_control");
				if (!!oChild.getRules() && oChild.getRules().length > 0) {
					oChild.getRules()[0].setRegex(value);
				}
			}

		});
});