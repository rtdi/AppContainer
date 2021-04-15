sap.ui.define(
  [
	  'sap/m/Label', 
	  'sap/ui/model/json/JSONModel',
	  'sap/m/LabelDesign', 
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/TextDirection',
	  'sap/ui/core/VerticalAlign',
	  'sap/m/WrappingType',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Label, JSONModel, LabelDesign, TextAlign, TextDirection, VerticalAlign, WrappingType) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.Label", {
			metadata : {
				properties: {
					design : {type : "sap.m.LabelDesign", group : "Appearance", defaultValue : LabelDesign.Standard},
					text : {type : "string", group : "Misc", defaultValue : null},
					textAlign : {type : "sap.ui.core.TextAlign", group : "Appearance", defaultValue : TextAlign.Begin},
					textDirection : {type : "sap.ui.core.TextDirection", group : "Appearance", defaultValue : TextDirection.Inherit},
					width : {type : "sap.ui.core.CSSSize", group : "Dimension", defaultValue : ''},
					required : {type : "boolean", group : "Misc", defaultValue : false},
					displayOnly : {type : "boolean", group : "Appearance", defaultValue : false},
					wrapping: {type : "boolean", group : "Appearance", defaultValue : false},
					wrappingType : {type: "sap.m.WrappingType", group : "Appearance", defaultValue : WrappingType.Normal},
					vAlign : {type : "sap.ui.core.VerticalAlign", group : "Appearance", defaultValue : VerticalAlign.Inherit}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.Label(), true);
			}
		});
});