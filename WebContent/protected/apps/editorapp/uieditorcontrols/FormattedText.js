sap.ui.define(
  [
	  'sap/m/FormattedText',
	  'sap/ui/model/json/JSONModel', 
	  'sap/m/LinkConversion'],
  function(FormattedText, JSONModel, LinkConversion) {
  return sap.m.FormattedText.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.FormattedText", {
			metadata : {
				properties: {
					htmlText: {type: "string", group: "Misc", defaultValue: ""},
					width: {type : "sap.ui.core.CSSSize", group : "Appearance", defaultValue : null},
					convertLinksToAnchorTags: {type: "sap.m.LinkConversion", group: "Behavior", defaultValue: LinkConversion.None},
					convertedLinksDefaultTarget: {type: "string", group: "Behavior", defaultValue: "_blank"},
					height: {type : "sap.ui.core.CSSSize", group : "Appearance", defaultValue : null}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.FormattedText(), false);
			}
		});
});