sap.ui.define(
  [
	  'sap/m/TimePickerSliders', 
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(TimePickerSliders, JSONModel) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.TimePickerSliders", {
			metadata : {
				properties: {
					// selectedValue: {type: "string", defaultValue: null},
					isCyclic: {type: "boolean", defaultValue: true},
					label: {type: "string", defaultValue: null},
					isExpanded: {type: "boolean", defaultValue: false}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.TimePickerSliders(), false);
			}
		});
});