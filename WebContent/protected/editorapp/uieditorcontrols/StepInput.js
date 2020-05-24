sap.ui.define(
  [   'sap/m/StepInput',
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(StepInput, JSONModel) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.StepInput", {
			metadata : {
				properties: {
					min: {type: "float", group: "Data"},
					max: {type: "float", group: "Data"},
					step: {type: "float", group: "Data", defaultValue: 1},
					stepMode: {type: "sap.m.StepInputStepModeType", group: "Data", defaultValue: sap.m.StepInputStepModeType.AdditionAndSubtraction},
					largerStep: {type: "float", group: "Data", defaultValue: 2},
					// value: {type: "float", group: "Data", defaultValue: 0},
					name: { type: "string", group: "Misc", defaultValue: null },
					placeholder: { type: "string", group: "Misc", defaultValue: null },
					required : {type : "boolean", group : "Misc", defaultValue : false},
					width: {type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: ""},
					valueState: {type: "sap.ui.core.ValueState", group: "Data", defaultValue: sap.ui.core.ValueState.None},
					valueStateText: { type: "string", group: "Misc", defaultValue: null },
					// editable: {type: "boolean", group: "Behavior", defaultValue: true},
					// enabled: {type: "boolean", group: "Behavior", defaultValue: true},
					displayValuePrecision: {type: "int", group: "Data", defaultValue: 0},
					description: {type : "string", group : "Misc", defaultValue : null},
					fieldWidth: {type : "sap.ui.core.CSSSize", group : "Appearance", defaultValue : '50%'},
					textAlign: {type: "sap.ui.core.TextAlign", group: "Appearance", defaultValue: sap.ui.core.TextAlign.End},
					validationMode: {type: "sap.m.StepInputValidationMode", group: "Misc", defaultValue: sap.m.StepInputValidationMode.FocusOut}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.StepInput(), true);
			}

		});
});