sap.ui.define(
  [	  'sap/m/Switch',
	  'sap/ui/model/json/JSONModel',
	  'sap/m/SwitchType',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Switch, JSONModel) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Switch", {
			metadata : {
				properties: {
					state: { type: "boolean", group: "Misc", defaultValue: false },
					customTextOn: { type: "string", group: "Misc", defaultValue: "" },
					customTextOff: { type: "string", group: "Misc", defaultValue: "" },
					enabled: { type: "boolean", group: "Data", defaultValue: true },
					name: { type: "string", group: "Misc", defaultValue: "" },
					type: { type : "sap.m.SwitchType", group: "Appearance", defaultValue: sap.m.SwitchType.Default }
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.Switch(), false);
			}

		});
});