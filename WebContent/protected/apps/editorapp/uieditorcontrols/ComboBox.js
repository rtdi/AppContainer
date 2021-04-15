sap.ui.define(
  [
	  'sap/m/ComboBox',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapperWithListItem'],
  function(ComboBox, JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapperWithListItem.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.ComboBox", {
			metadata : {
				properties: {
					itemIcon: { type: "string", defaultValue: "", itemSetting: "icon" },
					itemText: { type: "string", defaultValue: "", showmodelcolumns: 1, itemSetting: "text" },
					itemAdditionalText: { type: "string", defaultValue: "", showmodelcolumns: 1, itemSetting: "additionalText" },

					selectedKey: { type: "string", group: "Data", defaultValue: "" },
					selectedItemId: { type: "string", group: "Misc", defaultValue: "" },
					filterSecondaryValues: { type: "boolean", group: "Misc", defaultValue: false },

					// ComboBoxBase
					showSecondaryValues: { type: "boolean", group: "Misc", defaultValue: false },

					// ComboBoxTextField
					maxWidth: { type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: "100%" },
					showButton: { type: "boolean", group: "Appearance", defaultValue: true },

					// InputBase
					value: { type: "string", group: "Data", defaultValue: null, bindable: "bindable" },
					width: { type: "sap.ui.core.CSSSize", group: "Dimension", defaultValue: null },
					enabled: { type: "boolean", group: "Behavior", defaultValue: true },
					valueState: { type: "sap.ui.core.ValueState", group: "Appearance", defaultValue: sap.ui.core.ValueState.None },
					name: { type: "string", group: "Misc", defaultValue: null },
					placeholder: { type: "string", group: "Misc", defaultValue: null },
					editable: { type: "boolean", group: "Behavior", defaultValue: true },
					valueStateText: { type: "string", group: "Misc", defaultValue: null },
					showValueStateMessage: { type: "boolean", group: "Misc", defaultValue: true },
					textAlign: { type: "sap.ui.core.TextAlign", group: "Appearance", defaultValue: sap.ui.core.TextAlign.Initial },
					textDirection: { type: "sap.ui.core.TextDirection", group: "Appearance", defaultValue: sap.ui.core.TextDirection.Inherit },
					required : {type : "boolean", group : "Misc", defaultValue : false}

				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapperWithListItem.prototype.init.call(this, new sap.m.ComboBox(), true);
			}

		});
});