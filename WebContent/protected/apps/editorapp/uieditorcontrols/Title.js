sap.ui.define(
  [
	  'sap/m/Title',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'sap/ui/core/TitleLevel',
	  'sap/m/WrappingType',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'
  ],
  function(Title, JSONModel) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Title", {
			metadata : {
				properties: {
					text : {type : "string", group : "Appearance", defaultValue : null},
					level : {type : "sap.ui.core.TitleLevel", group : "Appearance", defaultValue : sap.ui.core.TitleLevel.Auto},
					titleStyle : {type : "sap.ui.core.TitleLevel", group : "Appearance", defaultValue : sap.ui.core.TitleLevel.Auto},
					width : {type : "sap.ui.core.CSSSize", group : "Dimension", defaultValue : null},
					textAlign : {type : "sap.ui.core.TextAlign", group : "Appearance", defaultValue : sap.ui.core.TextAlign.Initial},
					wrapping : {type : "boolean", group : "Appearance", defaultValue : false},
					wrappingType : {type: "sap.m.WrappingType", group : "Appearance", defaultValue : sap.m.WrappingType.Normal}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.Title(), true);
			}
		});
});