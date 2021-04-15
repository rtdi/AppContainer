sap.ui.define(
  [
	  'sap/m/CheckBox',
	  'sap/ui/model/json/JSONModel', 
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/TextDirection',
	  'sap/ui/core/ValueState',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(CheckBox, JSONModel, TextAlign, TextDirection, ValueState) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.CheckBox", {
			metadata : {
				properties: {
					selected : {type : "boolean", group : "Data", defaultValue : false},
					partiallySelected : {type : "boolean", group : "Data", defaultValue : false},
					enabled : {type : "boolean", group : "Behavior", defaultValue : true},
					name : {type : "string", group : "Misc", defaultValue : null},
					text : {type : "string", group : "Appearance", defaultValue : null},
					textDirection : {type : "sap.ui.core.TextDirection", group : "Appearance", defaultValue : TextDirection.Inherit},
					textAlign : {type : "sap.ui.core.TextAlign", group : "Appearance", defaultValue : TextAlign.Begin},
					width : {type : "sap.ui.core.CSSSize", group : "Dimension", defaultValue : ''},
					useEntireWidth : {type : "boolean", group: "Appearance", defaultValue : false },
					activeHandling : {type : "boolean", group : "Misc", defaultValue : true},
					editable : {type : "boolean", group : "Behavior", defaultValue : true},
					valueState : {type : "sap.ui.core.ValueState", group : "Data", defaultValue : ValueState.None},
					valueStateText: { type: "string", group: "Misc", defaultValue: null, visibility: "hidden" },
					displayOnly : {type : "boolean", group : "Behavior", defaultValue : false},
					wrapping: {type : "boolean", group : "Appearance", defaultValue : false}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.CheckBox(), false);
			}

		});
});