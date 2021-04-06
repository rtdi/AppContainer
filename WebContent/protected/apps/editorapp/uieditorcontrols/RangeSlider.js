sap.ui.define(
  ['sap/m/RangeSlider',
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(RangeSlider, JSONModel) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.RangeSlider", {
			metadata : {
				properties: {
                    value2: {type: "float", group: "Data", defaultValue: 100},
                    range: {type: "float[]", group: "Data", defaultValue: [0,100]},
                    
					width: { type: "sap.ui.core.CSSSize", group: "Appearance", defaultValue: "100%" },
					enabled: { type: "boolean", group: "Behavior", defaultValue: true },
					name: { type: "string", group: "Misc", defaultValue: "" },
					min: { type: "float", group: "Data", defaultValue: 0 },
					max: { type: "float", group: "Data", defaultValue: 100 },
					step: { type: "float", group: "Data", defaultValue: 1 },
					progress: { type: "boolean", group: "Misc", defaultValue: true },
					value: { type: "float", group: "Data", defaultValue: 0 },
					showHandleTooltip: { type: "boolean", group: "Appearance", defaultValue: true},
					showAdvancedTooltip: { type: "boolean", group: "Appearance", defaultValue: false},
					inputsAsTooltips: {type: "boolean", group: "Appearance", defaultValue: false},
					enableTickmarks: {type: "boolean", group: "Appearance", defaultValue: false}

				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.RangeSlider());
			}

		});
});