sap.ui.define(
  [
	  'sap/m/List', 
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/Text', 
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/HBox', 
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/OverflowToolbar', 
	  'sap/ui/model/json/JSONModel',
	  'sap/m/ListGrowingDirection',
	  'sap/m/ListHeaderDesign',
	  'sap/m/ListMode',
	  'sap/m/ListSeparators',
	  'sap/m/StandardListItem',
	  'sap/ui/core/MessageType',
	  'sap/ui/core/ValueState',
	  'sap/m/ListType',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapperWithListItem'
	  ],
  function(
		  List, 
		  dText, 
		  dHBox, 
		  dOverflowToolbar,
		  JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapperWithListItem.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.List", {
			metadata : {
				properties: {
					showHeaderToolbar: {type: "boolean", defaultValue: false},
					showInfoToolbar: {type: "boolean", defaultValue: false},
					
					// List
					backgroundDesign : {type : "sap.m.BackgroundDesign", group : "Appearance", defaultValue : sap.m.BackgroundDesign.Solid},
					
					// ListBase
					inset : {type : "boolean", group : "Appearance", defaultValue : false},
					headerText : {type : "string", group : "Misc", defaultValue : null},
					footerText : {type : "string", group : "Misc", defaultValue : null},
					mode : {type : "sap.m.ListMode", group : "Behavior", defaultValue : sap.m.ListMode.None},
					width : {type : "sap.ui.core.CSSSize", group : "Dimension", defaultValue : "100%"},
					includeItemInSelection : {type : "boolean", group : "Behavior", defaultValue : false},
					showUnread : {type : "boolean", group : "Misc", defaultValue : false},
					noDataText : {type : "string", group : "Misc", defaultValue : null},
					showNoData : {type : "boolean", group : "Misc", defaultValue : true},
					enableBusyIndicator : {type : "boolean", group : "Behavior", defaultValue : true},
					modeAnimationOn : {type : "boolean", group : "Misc", defaultValue : true},
					showSeparators : {type : "sap.m.ListSeparators", group : "Appearance", defaultValue : sap.m.ListSeparators.All},
					swipeDirection : {type : "sap.m.SwipeDirection", group : "Misc", defaultValue : sap.m.SwipeDirection.Both},
					growing : {type : "boolean", group : "Behavior", defaultValue : false},
					growingThreshold : {type : "int", group : "Misc", defaultValue : 20},
					growingTriggerText : {type : "string", group : "Appearance", defaultValue : null},
					growingScrollToLoad : {type : "boolean", group : "Behavior", defaultValue : false},
					growingDirection : {type : "sap.m.ListGrowingDirection", group : "Behavior", defaultValue : sap.m.ListGrowingDirection.Downwards},
					rememberSelections : {type : "boolean", group : "Behavior", defaultValue : true},
					keyboardMode : {type : "sap.m.ListKeyboardMode", group : "Behavior", defaultValue : sap.m.ListKeyboardMode.Navigation},
					// sticky : {type : "sap.m.Sticky[]", group : "Appearance"},


					itemTitle: {type: "string", defaultValue: null, showmodelcolumns: 1, itemSetting: "title"},
					itemDescription: {type: "string", defaultValue: null, showmodelcolumns: 1, itemSetting: "description"},
					itemCounter: {type: "int", defaultValue: null, itemSetting: "counter"},
					itemActiveIcon: {type: "sap.ui.core.URI", defaultValue: null, itemSetting: "activeIcon"},
					itemAdaptTitleSize: {type: "boolean", defaultValue: false, itemSetting: "adaptTitleSize"},
					itemHighlight: {type: "sap.ui.core.IndicationColor", defaultValue: null, itemSetting: "highlight"},
					itemHighlightText: {type: "string", defaultValue: null, showmodelcolumns: 1, itemSetting: "highlightText"},
					itemIcon: {type: "sap.ui.core.URI", defaultValue: null, itemSetting: "icon"},
					itemIconDensityAware: {type: "boolean", defaultValue: false, itemSetting: "iconDensityAware"},
					itemIconInset: {type: "boolean", defaultValue: false, itemSetting: "iconInset"},
					itemInfo: {type: "string", defaultValue: null, showmodelcolumns: 1, itemSetting: "info"},
					itemInfoState: {type: "sap.ui.core.ValueState", defaultValue: sap.ui.core.ValueState.None, itemSetting: "infoState"},
					itemInfoStateInverted: {type: "boolean", defaultValue: false, itemSetting: "infoStateInverted"},
					itemType: {type: "sap.m.ListType", defaultValue: sap.m.ListType.Inactive, itemSetting: "type"},
					itemUnread: {type: "boolean", defaultValue: false, itemSetting: "unread"},
					itemWrapping: {type: "boolean", defaultValue: false, itemSetting: "wrapping"}
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapperWithListItem.prototype.init.call(this, new sap.m.List(), true, sap.m.StandardListItem);
			},
			setShowHeaderToolbar : function(vToolbar) {
				this.setProperty("showHeaderToolbar", vToolbar, true);
				// The toolbar needs to be saved elsewhere and removed from the control, else it does not show the List text again
				var vToolbarControl = this.getHeaderToolbar();
				var vToolbarControlBackup = this.data("headertoolbar");
				if (vToolbar) {
					if (!!vToolbarControlBackup) {
						this.setHeaderToolbar(vToolbarControlBackup);
					} else {
						this.setHeaderToolbar(new dOverflowToolbar());
					}
				} else {
					this.data("headertoolbar", vToolbarControl);
					this.destroyHeaderToolbar();
				}
			},
			setShowInfoToolbar : function(vToolbar) {
				this.setProperty("showInfoToolbar", vToolbar, true);
				// The toolbar needs to be saved elsewhere and removed from the control, else it does not show the header text again
				var vToolbarControl = this.getInfoToolbar();
				var vToolbarControlBackup = this.data("infotoolbar");
				if (vToolbar) {
					if (!!vToolbarControlBackup) {
						this.setInfoToolbar(vToolbarControlBackup);
					} else {
						this.setInfoToolbar(new dOverflowToolbar());
					}
				} else {
					this.data("infotoolbar", vToolbarControl);
					this.destroyInfoToolbar();
				}
			}

		});
});