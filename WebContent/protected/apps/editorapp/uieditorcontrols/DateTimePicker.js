sap.ui.define(
  [
	  'sap/m/DateTimePicker', 
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/TextDirection',
	  'sap/ui/core/ValueState',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(DateTimePicker, JSONModel, TextAlign, TextDirection, ValueState) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.DateTimePicker", {
			metadata : {
				properties: {
					minutesStep: {type: "int", group: "Misc", defaultValue: 1 },
					secondsStep: {type: "int", group: "Misc", defaultValue: 1 },
					
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
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.DateTimePicker(), false);
			}
		});
});