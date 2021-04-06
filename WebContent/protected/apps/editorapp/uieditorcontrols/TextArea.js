sap.ui.define(
  [
	  'sap/m/TextArea',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/Wrapping',
	  'sap/ui/core/ValueState',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'
  ],
  function(TextArea, JSONModel) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.TextArea", {
			metadata : {
				properties: {
					rows : {type : "int", group : "Appearance", defaultValue : 2},
					cols : {type : "int", group : "Appearance", defaultValue : 20},
					height : {type : "sap.ui.core.CSSSize", group : "Appearance", defaultValue : null},
					maxLength : {type : "int", group : "Behavior", defaultValue : 0},
					showExceededText: {type: "boolean", group: "Behavior", defaultValue: false},
					wrapping : {type : "sap.ui.core.Wrapping", group : "Behavior", defaultValue : sap.ui.core.Wrapping.None},
					valueLiveUpdate : {type : "boolean", group : "Behavior", defaultValue : false},
					growing : {type : "boolean", group : "Behavior", defaultValue : false},
					growingMaxLines : {type : "int", group : "Behavior", defaultValue : 0},
					
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
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.TextArea(), false);
			}
		});
});