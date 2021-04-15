sap.ui.define(
  [
	  'sap/m/TimePicker', 
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(TimePicker, JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.TimePicker", {
			metadata : {
				properties: {
					localeId: {type : "string", group: "Data"},
					title: {type: "string", group: "Misc", defaultValue: null},
					minutesStep: {type: "int", group: "Misc", defaultValue: 1},
					secondsStep: {type: "int", group: "Misc", defaultValue: 1},
					placeholderSymbol: {type: "string", group: "Misc", defaultValue: "_"},
					mask: {type: "string", group: "Misc", defaultValue: null},
					maskMode: {type: "sap.m.TimePickerMaskMode", group: "Misc", defaultValue: sap.m.TimePickerMaskMode.On},
					support2400: {type: "boolean", group: "Misc", defaultValue: false},
					
					// DateTimeField
					displayFormat: {type: "string", group: "Appearance", defaultValue: null},
					valueFormat: {type: "string", group: "Data", defaultValue: null},
					dateValue: {type: "object", group: "Data", defaultValue: null},
					initialFocusedDateValue: {type: "object", group: "Data", defaultValue: null},
					
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
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.TimePicker(), false);
			}
		});
});