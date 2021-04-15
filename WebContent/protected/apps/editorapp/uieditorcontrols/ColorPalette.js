sap.ui.define(
  [
	  'sap/m/ColorPalette', 
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(ColorPalette, JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.ColorPalette", {
			metadata : {
				properties: {
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.ColorPalette(), false);
			}
		});
});