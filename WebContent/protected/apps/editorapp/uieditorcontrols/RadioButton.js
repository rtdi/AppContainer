sap.ui.define(
  [
	  'sap/m/RadioButton',
	  'sap/ui/model/json/JSONModel', 
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/TextDirection',
	  'sap/ui/core/ValueState',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(RadioButton, JSONModel, TextAlign, TextDirection, ValueState) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.RadioButton", {
			metadata : {
				properties: {
					enabled : {type : "boolean", group : "Behavior", defaultValue : true},
					selected : {type : "boolean", group : "Data", defaultValue : false},
					groupName : {type : "string", group : "Behavior", defaultValue : 'sapMRbDefaultGroup'},
					text : {type : "string", group : "Appearance", defaultValue : null},
					textDirection : {type : "sap.ui.core.TextDirection", group : "Appearance", defaultValue : TextDirection.Inherit},
					width : {type : "sap.ui.core.CSSSize", group : "Dimension", defaultValue : ''},
					useEntireWidth : {type : "boolean", group: "Appearance", defaultValue : false },
					activeHandling : {type : "boolean", group : "Appearance", defaultValue : true},
					editable : {type : "boolean", group : "Behavior", defaultValue : true},
					valueState : {type : "sap.ui.core.ValueState", group : "Data", defaultValue : ValueState.None},
					textAlign : {type : "sap.ui.core.TextAlign", group : "Appearance", defaultValue : TextAlign.Begin}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.RadioButton(), false);
			}

		});
});