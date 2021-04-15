sap.ui.define(
  [
	  'sap/m/MultiInput',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign', 
	  'sap/m/InputTextFormatMode',
	  'sap/m/InputType', 
	  'sap/ui/core/ValueState',
	  'sap/ui/core/Item',
	  'sap/m/Token',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(MultiInput, JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.MultiInput", {
			metadata : {
				properties: {
					enableMultiLineMode: {type: "boolean", group: "Behavior", defaultValue: false},
					maxTokens: {type: "int", group: "Behavior"},
					
					// Input
					type : {type : "sap.m.InputType", group : "Data", defaultValue : sap.m.InputType.Text},
					maxLength : {type : "int", group : "Behavior", defaultValue : 0},
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
					// selectedKey: {type: "string", group: "Data", defaultValue: ""},
					textFormatMode: {type: "sap.m.InputTextFormatMode", group: "Misc", defaultValue: sap.m.InputTextFormatMode.Value},
					textFormatter: {type: "any", group: "Misc", defaultValue: ""},
					// suggestionRowValidator: {type: "any", group: "Misc", defaultValue: ""},
					enableSuggestionsHighlighting: {type: "boolean", group: "Behavior", defaultValue: true},
					autocomplete: {type: "boolean", group: "Behavior", defaultValue: true},

					// InputBase
					value: { type: "string", group: "Data", defaultValue: null, bindable: "bindable" },
					width: { type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: null },
					enabled: { type: "boolean", group: "Behavior", defaultValue: true },
					valueState: { type: "sap.ui.core.ValueState", group: "Appearance", defaultValue: sap.ui.core.ValueState.None },
					name: { type: "string", group: "Misc", defaultValue: null },
					placeholder: { type: "string", group: "Misc", defaultValue: null },
					editable: { type: "boolean", group: "Behavior", defaultValue: true },
					valueStateText: { type: "string", group: "Misc", defaultValue: null },
					showValueStateMessage: { type: "boolean", group: "Misc", defaultValue: true },
					textAlign: { type: "sap.ui.core.TextAlign", group: "Appearance", defaultValue: sap.ui.core.TextAlign.Initial },
					textDirection: { type: "sap.ui.core.TextDirection", group: "Appearance", defaultValue: sap.ui.core.TextDirection.Inherit },
					required : {type : "boolean", group : "Misc", defaultValue : false}

				}
			},
			renderer : {},
			init : function() {
				var oChild = new sap.m.MultiInput();
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, oChild, true);
				oChild.setTokens([
					new sap.m.Token({text: "Token 1", key: "0001"}),
					new sap.m.Token({text: "Token 2", key: "0002"})
				]);
				oChild.addValidator(function(args){
					var text = args.text;
					return new sap.m.Token({key: text, text: text});
				});
				
				for (var i=1; i<5; i++) {
					oChild.addSuggestionItem(new sap.ui.core.Item( { text: "Token " + i, key: "000" + i } ));
				}
			}
		});
});