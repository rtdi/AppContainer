sap.ui.define(
  [
	  'sap/m/Text', 
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign', 
	  'sap/m/WrappingType',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Text, JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.Text", {
			metadata : {
				properties: {
					text: { type: "string", defaultValue: '', bindable: "bindable", showmodelcolumns: 1 },
					textDirection: { type: "sap.ui.core.TextDirection", group: "Appearance", defaultValue: sap.ui.core.TextDirection.Inherit },
					wrapping: { type: "boolean", group: "Appearance", defaultValue: true },
					wrappingType : {type: "sap.m.WrappingType", group : "Appearance", defaultValue : sap.m.WrappingType.Normal},
					textAlign: { type: "sap.ui.core.TextAlign", group: "Appearance", defaultValue: sap.ui.core.TextAlign.Begin },
					width: { type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: null },
					maxLines: { type: "int", group: "Appearance", defaultValue: null },
					renderWhitespace: { type: "boolean", group: "Appearance", defaultValue: false }
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.Text(), true);
			}
		});
});