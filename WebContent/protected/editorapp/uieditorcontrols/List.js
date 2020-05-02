sap.ui.define(
  [
	  'sap/m/List', 
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/Text', 
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/HBox', 
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/OverflowToolbar', 
	  'sap/ui/model/json/JSONModel',
	  'sap/m/ListGrowingDirection',
	  'sap/m/ListHeaderDesign',
	  'sap/m/ListMode',
	  'sap/m/ListSeparators',
	  'sap/m/StandardListItem',
	  'sap/ui/core/MessageType',
	  'sap/ui/core/ValueState',
	  'sap/m/ListType'
	  ],
  function(
		  List, 
		  dText, 
		  dHBox, 
		  dOverflowToolbar,
		  JSONModel) {
  return sap.m.List.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.List", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					oDataURL: { type: "string", defaultValue: "" },
					showHeaderToolbar: {type: "boolean", defaultValue: false},
					showInfoToolbar: {type: "boolean", defaultValue: false},
					
					itemActiveIcon: {type: "string", defaultValue: ""},
					itemAdaptTitleSize: {type: "boolean", defaultValue: false},
					itemDescription: {type: "string", defaultValue: ""},
					itemHighlight: {type: "String", defaultValue: ""},
					itemHighlightText: {type: "string", defaultValue: ""},
					itemIcon: {type: "string", defaultValue: ""},
					itemIconDensityAware: {type: "boolean", defaultValue: false},
					itemIconInset: {type: "boolean", defaultValue: false},
					itemInfo: {type: "string", defaultValue: ""},
					itemInfoState: {type: "string", defaultValue: ""},
					itemInfoStateInverted: {type: "boolean", defaultValue: false},
					itemType: {type: "string", defaultValue: ""},
					itemUnread: {type: "boolean", defaultValue: false},
					itemWrapping: {type: "boolean", defaultValue: false}
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.m.List.prototype.init.apply(this, arguments);
				var oView = sap.ui.getCore().byId("mainview");
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "controls" });
				var dropinfo = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "controls", 
							"dropPosition": sap.ui.core.dnd.DropPosition.On,
							"drop": oView.getController().onDropControl,
							"targetAggregation": "columns"
						}
				);
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				
				for (var i=1; i<5; i++) {
					this.addItem(new sap.m.StandardListItem( { title: "Item" + i} ));
				}

				var oModel = new JSONModel();
				oModel.setData({ "list": [
					{ "propertyname": "controlid" },
					{ "propertyname": "headerText", "showmodelcolumns" : 2 },
					{ "propertyname": "footerText", "showmodelcolumns" : 2 },
					{ "propertyname": "showHeaderToolbar" },
					{ "propertyname": "showInfoToolbar" },
					{ "propertyname": "oDataURL" },
					{ "propertyname": "growing" },
					{ "propertyname": "growingDirection" },
					{ "propertyname": "growingScrollToLoad" },
					{ "propertyname": "growingThreshold" },
					{ "propertyname": "headerDesign" },
					{ "propertyname": "includeItemInSelection" },
					{ "propertyname": "inset" },
					{ "propertyname": "mode" },
					{ "propertyname": "rememberSelections" },
					{ "propertyname": "showSeparators" },
					{ "propertyname": "showUnread" },
					{ "propertyname": "width" },
					
					{ "propertyname": "itemType" },
					{ "propertyname": "itemDescription", "showmodelcolumns" : 1 },
					{ "propertyname": "itemWrapping" },
					{ "propertyname": "itemIcon", "showmodelcolumns" : 1 },
					{ "propertyname": "itemInfo", "showmodelcolumns" : 1 },
					{ "propertyname": "itemActiveIcon" },
					{ "propertyname": "itemAdaptTitleSize" },
					{ "propertyname": "itemHighlight" },
					{ "propertyname": "itemHighlightText", "showmodelcolumns" : 1 },
					{ "propertyname": "itemIconDensityAware" },
					{ "propertyname": "itemIconInset" },
					{ "propertyname": "itemInfoState" },
					{ "propertyname": "itemInfoStateInverted" },
					{ "propertyname": "itemUnread" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.attachBrowserEvent("dblclick", function(event) {
				    event.stopPropagation();
				    this.fireEvent("showProperties", undefined, true, false);
				    return false;
				}, this);			
				this.attachEvent("showProperties", sap.ui.getCore().byId("mainview").getController().showProperties);
			},
			_updateAllItems : function(sSetterName, value) {
				var aItems = this.getItems();
				if (!!aItems) {
					aItems.forEach(function (oItem) {
						oItem[sSetterName].call(oItem, value);
					});
				}
			},
			setItemType : function(value) {
				this.setProperty("itemType", value, false);
				this._updateAllItems("setType", value);
			},
			setItemDescription : function(value) {
				this.setProperty("itemDescription", value, false);
				this._updateAllItems("setdescription", value);
			},
			setItemWrapping : function(value) {
				this.setProperty("itemWrapping", value, false);
				this._updateAllItems("setWrapping", value);
			},
			setItemIcon : function(value) {
				this.setProperty("itemIcon", value, false);
				this._updateAllItems("setIcon", value);
			},
			setItemActiveIcon : function(value) {
				this.setProperty("itemActiveIcon", value, false);
				this._updateAllItems("setActiveIcon", value);
			},
			setItemAdaptTitleSize : function(value) {
				this.setProperty("itemAdaptTitleSize", value, false);
				this._updateAllItems("setAdaptTitleSize", value);
			},
			setItemHighlight : function(value) {
				this.setProperty("itemHighlight", value, false);
				this._updateAllItems("setHighlight", value);
			},
			setItemHighlightText : function(value) {
				this.setProperty("itemHighlightText", value, false);
				this._updateAllItems("setHighlightText", value);
			},
			setItemIconDensityAware : function(value) {
				this.setProperty("itemIconDensityAware", value, false);
				this._updateAllItems("setIconDesityAware", value);
			},
			setItemIconInset : function(value) {
				this.setProperty("itemIconInset", value, false);
				this._updateAllItems("setIconInset", value);
			},
			setItemInfoState : function(value) {
				this.setProperty("itemInfoState", value, false);
				this._updateAllItems("setInfoState", value);
			},
			setItemInfoStateInverted : function(value) {
				this.setProperty("itemInfoStateInverted", value, false);
				this._updateAllItems("setInfoStateInverted", value);
			},
			setItemUnread : function(value) {
				this.setProperty("itemUnread", value, false);
				this._updateAllItems("setUnread", value);
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
			},
			getParentProperties : function() {
				return sap.m.List.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.List.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.List.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.List.prototype.getMetadata.apply(this, arguments).getName();
			}

		});
});