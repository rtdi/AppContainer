sap.ui.define(
  [
	  'sap/m/Select',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'sap/m/SelectType',
	  'sap/ui/core/ValueState',
	  'sap/ui/core/ListItem',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapperWithListItem'],
  function(Select, JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapperWithListItem.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.Select", {
			metadata : {
				properties: {
					itemIcon: { type: "string", defaultValue: "", itemSetting: "icon" },
					itemText: { type: "string", defaultValue: "", showmodelcolumns: 1, itemSetting: "text" },
					itemAdditionalText: { type: "string", defaultValue: "", showmodelcolumns: 1, itemSetting: "additionalText" },
					name: { type: "string", group: "Misc", defaultValue: "" },
					// enabled: { type: "boolean", group: "Behavior", defaultValue: true },
					// editable: { type: "boolean", group: "Behavior", defaultValue: true },
					width: { type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: "auto" },
					maxWidth: { type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: "100%" },
					// selectedKey: { type: "string", group: "Data", defaultValue: "" },
					// selectedItemId: { type: "string", group: "Misc", defaultValue: "" },
					icon: { type: "sap.ui.core.URI", group: "Appearance", defaultValue: "" },
					type: { type: "sap.m.SelectType", group: "Appearance", defaultValue: sap.m.SelectType.Default },
					autoAdjustWidth: { type: "boolean", group: "Appearance", defaultValue: false },
					textAlign: { type: "sap.ui.core.TextAlign", group: "Appearance", defaultValue: sap.ui.core.TextAlign.Initial },
					textDirection: { type: "sap.ui.core.TextDirection", group: "Appearance", defaultValue: sap.ui.core.TextDirection.Inherit },
					valueState: { type: "sap.ui.core.ValueState", group: "Appearance", defaultValue: sap.ui.core.ValueState.None },
					valueStateText: { type: "string", group: "Misc", defaultValue: "" },
					showSecondaryValues: { type: "boolean", group: "Misc", defaultValue: false },
					forceSelection: { type: "boolean", group: "Behavior", defaultValue: true },
					wrapItemsText: { type: "boolean", group: "Behavior", defaultValue: false },
					required : {type : "boolean", group : "Misc", defaultValue : false}

				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapperWithListItem.prototype.init.call(this, new sap.m.Select(), true);
			}

		});
});