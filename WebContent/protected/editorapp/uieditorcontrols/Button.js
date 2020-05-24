sap.ui.define(
  ['sap/m/Button', 'sap/ui/model/json/JSONModel', 'sap/m/ButtonType', 'sap/ui/core/TextDirection', 'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Button, JSONModel, ButtonType, TextDirection) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Button", {
			metadata : {
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					text : {type : "string", group : "Misc", defaultValue: "" },
					type : {type : "sap.m.ButtonType", group : "Appearance", defaultValue : ButtonType.Default},
					width : {type : "sap.ui.core.CSSSize", group : "Misc", defaultValue : null},
					enabled : {type : "boolean", group : "Behavior", defaultValue : true},
					icon : {type : "sap.ui.core.URI", group : "Appearance", defaultValue: "" },
					iconFirst : {type : "boolean", group : "Appearance", defaultValue : true},
					activeIcon : {type : "sap.ui.core.URI", group : "Misc", defaultValue : null},
					iconDensityAware : {type : "boolean", group : "Misc", defaultValue : true},
					textDirection : {type : "sap.ui.core.TextDirection", group : "Appearance", defaultValue : TextDirection.Inherit}
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.Button(), false);
			}

		});
});