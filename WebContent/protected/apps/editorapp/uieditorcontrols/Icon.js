sap.ui.define(
  [
	  'sap/ui/core/Icon',
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Icon, JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.Icon", {
			metadata : {
				properties: {
					src : {type : "sap.ui.core.URI", group : "Data", defaultValue : null},
					size : {type : "sap.ui.core.CSSSize", group : "Dimension", defaultValue : null},
					color : {type : "string", group : "Appearance", defaultValue : null},
					hoverColor : {type : "string", group : "Appearance", defaultValue : null},
					activeColor : {type : "string", group : "Appearance", defaultValue : null},
					width : {type : "sap.ui.core.CSSSize", group : "Dimension", defaultValue : null},
					height : {type : "sap.ui.core.CSSSize", group : "Dimension", defaultValue : null},
					backgroundColor : {type : "string", group : "Appearance", defaultValue : null},
					hoverBackgroundColor : {type : "string", group : "Appearance", defaultValue : null},
					activeBackgroundColor : {type : "string", group : "Appearance", defaultValue : null},
					decorative : {type : "boolean", group : "Accessibility", defaultValue : true},
					useIconTooltip : {type : "boolean", group : "Accessibility", defaultValue : true},
					alt : {type : "string", group : "Accessibility", defaultValue : null},
					noTabStop : {type : "boolean", group : "Accessibility", defaultValue : false}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.ui.core.Icon());
			}

		});
});