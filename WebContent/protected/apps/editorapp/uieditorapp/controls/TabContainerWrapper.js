sap.ui.define(
  [
	'ui5app/controls/ControlWrapper',
	'ui5app/controls/TableCell'
	  ],
  function(ControlWrapper) {
	"use strict";    

	return ControlWrapper.extend("ui5app.controls.TabContainerWrapper", {
		metadata : {
			properties: {
			},
			events : {
			}
		},
		renderer : {},
		init : function() {
			ControlWrapper.prototype.init.apply(this, arguments);
		},
		setWrappedControl : function(oTabContainer) {
			ControlWrapper.prototype.setWrappedControl.apply(this, arguments);
			/*
			 * A TabContainerItem allows to drag/drop elements from the tabs in addition to drag/drop on the control itself
			 */
			var dropinfo1 = new sap.ui.core.dnd.DropInfo(
					{ 
						"groupName": "TabContainerItem", 
						"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
						"drop": this.onDropTab.bind(this),
						"targetAggregation": "items"
					}
			);
			// dropinfo5 with TabContainerItem is needed for the initial case, when there are no tabs visible yet.
			var dropinfo5 = new sap.ui.core.dnd.DropInfo(
					{ 
						"groupName": "TabContainerItem", 
						"dropPosition": sap.ui.core.dnd.DropPosition.On,
						"drop": this.onDropTab.bind(this)
					}
			);
			oTabContainer.addDragDropConfig(dropinfo1);
			oTabContainer.addDragDropConfig(dropinfo5);
		},
		allowControlDrop : function(oChildControl) {
			return false; // Don't use the default control drop, only very special controls are allowed to drop
		},
		onDropTab : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			var sDropPosition = oEvent.getParameter("dropPosition");
			
			/*
			 * When the controls are part of a template, not the controls themselves
			 * are modified but their template structure.
			 */
			oTargetControl = this.findTemplate(oTargetControl);
			
			if (oSourceControl instanceof ui5app.controls.ToolPaletteButton) { // an element of the toolbar
				if (oSourceControl.getControlType() === "sap.m.TabContainerItem") {
					var oContainer = this.getWrappedControl();
					var index;
					if (sDropPosition === "On") {
						// Dropped onto the table --> add at the end
						index = oContainer.getItems().length;
					} else if (sDropPosition === "Before") {
						index = oContainer.indexOfItem(oTargetControl);
					} else {
						index = oContainer.indexOfItem(oTargetControl) + 1;
					}
					var oTabItem = new sap.m.TabContainerItem( { content: [ new ui5app.controls.TableCell() ], name: "Tab" });
					/* var dropinfo1 = new sap.ui.core.dnd.DropInfo(
							{ 
								"groupName": "controls", 
								"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
								"drop": this.onDropTab.bind(this),
								"targetAggregation": "content"
							}
					);
					oTabItem.addDragDropConfig(dropinfo1); */
					oContainer.insertItem(oTabItem, index);
				}
			}
		},
		deleteControl : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTable = this.getWrappedControl();
			if (oTable instanceof sap.m.TabContainerItem) {
				// remove column
				if (oSourceControl instanceof sap.m.TabContainerItem) {
					var index = oTable.indexOfItem(oSourceControl);
					if (index != -1) {
						oTable.removeItem(index);
					}
				} else {
					ControlWrapper.prototype.deleteControl.apply(this, arguments);
				}
			} else {
				ControlWrapper.prototype.deleteControl.apply(this, arguments);
			}
		},
	});
});