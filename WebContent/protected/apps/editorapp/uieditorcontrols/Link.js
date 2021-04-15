sap.ui.define(
  [
	  'sap/m/Link', 
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/TextDirection',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Link, JSONModel, TextAlign, TextDirection) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.Link", {
			metadata : {
				properties: {
					text : {type : "string", group : "Data", defaultValue : ''},
					enabled : {type : "boolean", group : "Behavior", defaultValue : true},
					target : {type : "string", group : "Behavior", defaultValue : null},
					width : {type : "sap.ui.core.CSSSize", group : "Dimension", defaultValue : null},
					href : {type : "sap.ui.core.URI", group : "Data", defaultValue : null},
					validateUrl : {type : "boolean", group : "Data", defaultValue : false},
					wrapping : {type : "boolean", group : "Appearance", defaultValue : false},
					textAlign : {type : "sap.ui.core.TextAlign", group : "Appearance", defaultValue : TextAlign.Initial},
					textDirection : {type : "sap.ui.core.TextDirection", group : "Appearance", defaultValue : TextDirection.Inherit},
					subtle : {type : "boolean", group : "Behavior", defaultValue : false},
					emphasized : {type : "boolean", group : "Behavior", defaultValue : false}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.Link(), true, true);
			}
		});
});