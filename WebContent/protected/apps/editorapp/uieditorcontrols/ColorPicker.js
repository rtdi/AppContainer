sap.ui.define(
  [
	  'sap/ui/unified/ColorPicker', 
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/unified/ColorPickerMode',
	  'sap/ui/unified/ColorPickerDisplayMode',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(ColorPicker, JSONModel, ColorPickerMode, ColorPickerDisplayMode) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ColorPicker", {
			metadata : {
				properties: {
					colorString : {type: "string", group : "Misc", defaultValue : null},
					mode : {type: "sap.ui.unified.ColorPickerMode", group : "Appearance", defaultValue : ColorPickerMode.HSV},
					displayMode : {type: "sap.ui.unified.ColorPickerDisplayMode", group : "Appearance", defaultValue : ColorPickerDisplayMode.Default}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.ui.unified.ColorPicker());
			}
		});
});