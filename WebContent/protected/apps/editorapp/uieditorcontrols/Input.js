sap.ui.define(
  [
	  'sap/m/Input',
	  'sap/ui/model/json/JSONModel', 
	  'sap/ui/core/TextAlign',
	  'sap/m/InputTextFormatMode',
	  'sap/m/InputType',
	  'sap/ui/core/TextDirection',
	  'sap/ui/core/ValueState',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Input, JSONModel, TextAlign, InputTextFormatMode, InputType, TextDirection, ValueState) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Input", {
			metadata : {
				properties: {
					type : {type : "sap.m.InputType", group : "Data", defaultValue : InputType.Text},
					maxLength : {type : "int", group : "Behavior", defaultValue : 0},
					dateFormat : {type : "string", group : "Misc", defaultValue : 'YYYY-MM-dd', deprecated: true},
					showValueHelp : {type : "boolean", group : "Behavior", defaultValue : false},
					showSuggestion : {type : "boolean", group : "Behavior", defaultValue : false},
					valueHelpOnly : {type : "boolean", group : "Behavior", defaultValue : false},
					filterSuggests : {type : "boolean", group : "Behavior", defaultValue : true},
					maxSuggestionWidth : {type : "sap.ui.core.CSSSize", group : "Appearance", defaultValue : null},
					startSuggestion : {type : "int", group : "Behavior", defaultValue : 1},
					showTableSuggestionValueHelp : {type : "boolean", group : "Behavior", defaultValue : true},
					description: { type: "string", group: "Misc", defaultValue: null },
					fieldWidth: { type: "sap.ui.core.CSSSize", group: "Appearance", defaultValue: '50%' },
					valueLiveUpdate : {type : "boolean", group : "Behavior", defaultValue : false},
					selectedKey: {type: "string", group: "Data", defaultValue: ""},
					textFormatMode: {type: "sap.m.InputTextFormatMode", group: "Misc", defaultValue: InputTextFormatMode.Value},
					textFormatter: {type: "any", group: "Misc", defaultValue: ""},
					suggestionRowValidator: {type: "any", group: "Misc", defaultValue: ""},
					enableSuggestionsHighlighting: {type: "boolean", group: "Behavior", defaultValue: true},
					autocomplete: {type: "boolean", group: "Behavior", defaultValue: true},
					
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
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.Input(), true);
			}

		});
});