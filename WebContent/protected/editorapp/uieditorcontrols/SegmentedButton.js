sap.ui.define(
  [
	  'sap/m/SegmentedButton',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/Element',
	  'sap/m/SegmentedButtonItem'],
  function(SegmentedButton, JSONModel, Element) {
  return sap.m.SegmentedButton.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.SegmentedButton", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					buttonCount: { type: "int", defaultValue: "3" },
					buttonIcon: { type: "String", defaultValue: "" },
					buttonKey: { type: "String", defaultValue: "" },
					buttonText: { type: "String", defaultValue: "" }
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.m.SegmentedButton.prototype.init.apply(this, arguments);
				var oView = sap.ui.getCore().byId("mainview");
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "controls" });
				var dropinfo = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "controls", 
							"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
							"drop": oView.getController().onDropControl 
						}
				);
				var oModel = new JSONModel();
				oModel.setData({ "list": [
					{ "propertyname": "controlid" },
					{ "propertyname": "selectedKey" },
					{ "propertyname": "width" },
					{ "propertyname": "buttonCount" },
					{ "propertyname": "buttonIcon" },
					{ "propertyname": "buttonKey" },
					{ "propertyname": "buttonText" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    this.fireEvent("showProperties", undefined, true, false);
				    event.stopPropagation();
				}, this);			
			},
			setButtonCount : function(value) {
				if (value > 1) {
					this.setProperty("buttonCount", value, true);
					var count = 0;
					if (!!this.getItems()) {
						count = this.getItems().length;
					}
					while (count < value) {
						var oButton = new sap.m.SegmentedButtonItem( {text: "Button" + String(count+1)} );
						this.addItem(oButton);
						count++;
					}
					var aItems = this.getItems();
					while (count > value) {
						this.removeItem(aItems[count-1]);
						count--;
					}
				}
			},
			setButtonIcon : function(value) {
				this.setProperty("buttonIcon", value, true);
				var oItem = Element.registry.get(this.getSelectedItem());
				if (!!oItem) {
					oItem.setIcon(value);
				}
			},
			setButtonKey : function(value) {
				this.setProperty("buttonKey", value, true);
				var oItem = Element.registry.get(this.getSelectedItem());
				if (!!oItem) {
					oItem.setKey(value);
				}
			},
			setButtonText : function(value) {
				this.setProperty("buttonText", value, true);
				var oItem = Element.registry.get(this.getSelectedItem());
				if (!!oItem) {
					oItem.setText(value);
				}
			},
			getParentProperties : function() {
				return sap.m.SegmentedButton.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.SegmentedButton.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.SegmentedButton.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.SegmentedButton.prototype.getMetadata.apply(this, arguments).getName();
			}

		});
});