sap.ui.define(
  [	  'sap/m/RatingIndicator',
	  'sap/ui/model/json/JSONModel',
	  'sap/m/RatingIndicatorVisualMode',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper' ],
  function(RatingIndicator, JSONModel, RatingIndicatorVisualMode) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.RatingIndicator", {
			metadata : {
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					iconHovered: {type: "sap.ui.core.URI", group: "Behavior", defaultValue: null},
					iconSelected: {type: "sap.ui.core.URI", group: "Behavior", defaultValue: null},
					iconSize: {type: "sap.ui.core.CSSSize", group: "Behavior", defaultValue: null},
					iconUnselected: {type: "sap.ui.core.URI", group: "Behavior", defaultValue: null},
					maxValue: {type: "int", group: "Behavior", defaultValue: 5},
					visualMode: {type: "sap.m.RatingIndicatorVisualMode", group: "Behavior", defaultValue: RatingIndicatorVisualMode.Half},
					enabled: {type: "boolean", group: "Behavior", defaultValue: true},
					value: {type: "float", group: "Behavior", defaultValue: 0, bindable: "bindable"},
					displayOnly : {type : "boolean", group : "Behavior", defaultValue : false},
					editable : {type : "boolean", group : "Behavior", defaultValue : true}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.RatingIndicator());
			}

		});
});