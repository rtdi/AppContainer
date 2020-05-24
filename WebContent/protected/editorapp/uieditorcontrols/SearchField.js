sap.ui.define(
  [
	  'sap/m/SearchField',
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(SearchField, JSONModel) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.SearchField", {
			metadata : {
				properties: {
					value : {type : "string", group : "Data", defaultValue : null, bindable : "bindable"},
					width : {type : "sap.ui.core.CSSSize", group : "Appearance", defaultValue : null},
					enabled : {type : "boolean", group : "Behavior", defaultValue : true},
					visible : {type : "boolean", group : "Appearance", defaultValue : true},
					maxLength : {type : "int", group : "Behavior", defaultValue : 0},
					placeholder : {type : "string", group : "Misc", defaultValue : null},
					showRefreshButton : {type : "boolean", group : "Behavior", defaultValue : false},
					refreshButtonTooltip : {type : "string", group : "Misc", defaultValue : null},
					showSearchButton : {type : "boolean", group : "Behavior", defaultValue : true},
					enableSuggestions : {type : "boolean", group : "Behavior", defaultValue : false}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.m.SearchField(), false);
			}

		});
});