sap.ui.define(
  [
	  'sap/m/SelectList',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/ListItem',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapperWithListItem'],
  function(SelectList, JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapperWithListItem.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.SelectList", {
			metadata : {
				properties: {
					itemIcon: { type: "string", defaultValue: "", itemSetting: "icon" },
					itemText: { type: "string", defaultValue: "", showmodelcolumns: 1, itemSetting: "text" },
					itemAdditionalText: { type: "string", defaultValue: "", showmodelcolumns: 1, itemSetting: "additionalText" },
					
					// enabled: { type: "boolean", group: "Behavior", defaultValue: true },
					width: { type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: "auto" },
					maxWidth: { type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: "100%" },
					// selectedKey: { type: "string", group: "Data", defaultValue: "" },
					// selectedItemId: { type: "string", group: "Misc", defaultValue: "" },
					showSecondaryValues: { type: "boolean", group: "Misc", defaultValue: false }
					/* keyboardNavigationMode: { type: "sap.m.SelectListKeyboardNavigationMode", group: "Behavior",
						defaultValue: SelectListKeyboardNavigationMode.Delimited
					} */

				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapperWithListItem.prototype.init.call(this, new sap.m.SelectList(), false);
			}

		});
});