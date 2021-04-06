sap.ui.define(
  [
	  'sap/m/Image',
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Image, JSONModel) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Image", {
			metadata : {
				properties: {
					src : {type : "sap.ui.core.URI", group : "Data", defaultValue : null},
					width : {type : "sap.ui.core.CSSSize", group : "Appearance", defaultValue : null},
					height : {type : "sap.ui.core.CSSSize", group : "Appearance", defaultValue : null},
					decorative : {type : "boolean", group : "Accessibility", defaultValue : true},
					alt : {type : "string", group : "Accessibility", defaultValue : null},
					useMap : {type : "string", group : "Misc", defaultValue : null},
					densityAware : {type : "boolean", group : "Misc", defaultValue : false},
					activeSrc : {type : "sap.ui.core.URI", group : "Data", defaultValue : ""},
					mode : {type : "sap.m.ImageMode", group : "Misc", defaultValue : "Image"},
					backgroundSize : {type : "string", group : "Appearance", defaultValue : "cover"},
					backgroundPosition : {type : "string", group : "Appearance", defaultValue : "initial"},
					backgroundRepeat : {type : "string", group : "Appearance", defaultValue : "no-repeat"}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.Image(), false);
			}

		});
});