sap.ui.define(
  [
	  'sap/m/SegmentedButton',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/Element',
	  'sap/m/SegmentedButtonItem',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(SegmentedButton, JSONModel, Element) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.SegmentedButton", {
			metadata : {
				properties: {
					buttonCount: { type: "int", defaultValue: "3" },
					buttonIcon: { type: "string", defaultValue: "" },
					buttonKey: { type: "string", defaultValue: "" },
					buttonText: { type: "string", defaultValue: "" },
					
					width : {type : "sap.ui.core.CSSSize", group : "Misc", defaultValue : "auto"},
					enabled : {type : "boolean", group : "Behavior", defaultValue : true},
					selectedKey: { type: "string", group: "Data", defaultValue: "", bindable: "bindable" }

				},
				aggregations : {
					items : { type : "sap.m.SegmentedButtonItem", multiple : true, singularName : "item", bindable : "bindable" },
				}

			},
			renderer : {},
			init : function() {
				var oChild = new sap.m.SegmentedButton();
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, oChild, false);
				this.setWidth("auto"); // Required workaround, else the style is width=100%
			},
			setButtonCount : function(value) {
				if (value > 1) {
					var oChild = this.getAggregation("_control");
					this.setProperty("buttonCount", value, true);
					var count = 0;
					if (!!oChild.getItems()) {
						count = oChild.getItems().length;
					}
					while (count < value) {
						var oButton = new sap.m.SegmentedButtonItem( {text: "Button" + String(count+1)} );
						oChild.addItem(oButton);
						count++;
					}
					var aItems = oChild.getItems();
					while (count > value) {
						oChild.removeItem(aItems[count-1]);
						count--;
					}
				}
			},
			getButtonIcon : function() {
				var oItem = Element.registry.get(this.getAggregation("_control").getSelectedItem());
				if (!!oItem) {
					return oItem.getIcon();
				}
			},
			getButtonKey : function() {
				var oItem = Element.registry.get(this.getAggregation("_control").getSelectedItem());
				if (!!oItem) {
					return oItem.getKey();
				}
			},
			getButtonText : function() {
				var oItem = Element.registry.get(this.getAggregation("_control").getSelectedItem());
				if (!!oItem) {
					return oItem.getText();
				}
			},
			setButtonIcon : function(value) {
				this.setProperty("buttonIcon", value, true);
				var oItem = Element.registry.get(this.getAggregation("_control").getSelectedItem());
				if (!!oItem) {
					oItem.setIcon(value);
				}
			},
			setButtonKey : function(value) {
				this.setProperty("buttonKey", value, true);
				var oItem = Element.registry.get(this.getAggregation("_control").getSelectedItem());
				if (!!oItem) {
					oItem.setKey(value);
				}
			},
			setButtonText : function(value) {
				this.setProperty("buttonText", value, true);
				var oItem = Element.registry.get(this.getAggregation("_control").getSelectedItem());
				if (!!oItem) {
					oItem.setText(value);
				}
			},
			/*
			 * Redirect all item-calls to the child control
			 */
			getItems : function() {
				return this.getAggregation("_control").getItems();
			},
			addItem : function(oItem) {
				return this.getAggregation("_control").addItem(oItem);
			},
			destroyItems : function() {
				return this.getAggregation("_control").destroyItems();
			},
			indexOfItem : function(oItem) {
				return this.getAggregation("_control").indexOfItem(oItem);
			},
			insertItem : function(oItem, iIndex) {
				return this.getAggregation("_control").insertItem(oItem, iIndex);
			},
			removeAllItems : function() {
				return this.getAggregation("_control").removeAllItems();
			},
			removeItem : function(oItem) {
				return this.getAggregation("_control").removeItem(oItem);
			}

		});
});