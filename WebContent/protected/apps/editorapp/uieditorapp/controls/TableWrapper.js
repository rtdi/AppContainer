sap.ui.define(
  [
	'ui5app/controls/ControlWrapper',
	'ui5app/controls/TableCell',
	'ui5app/controls/TableRow',
	'ui5app/controls/TableColumn'
	  ],
  function(ControlWrapper) {
	"use strict";    

	return ControlWrapper.extend("ui5app.controls.TableWrapper", {
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
		setWrappedControl : function(oTable) {
			ControlWrapper.prototype.setWrappedControl.apply(this, arguments);
			/*
			 * A Table allows to drag/drop elements from the columns in addition to drag/drop on the control itself
			 */
			var draginfo1 = new sap.ui.core.dnd.DragInfo({ "groupName": "movecolumn", "sourceAggregation": "columns" });
			/*
			 * A Table allows to drag/drop rows.
			 */
			var draginfo2 = new sap.ui.core.dnd.DragInfo({ "groupName": "moverow", "sourceAggregation": "items" });
			var dropinfo1 = new sap.ui.core.dnd.DropInfo(
					{ 
						"groupName": "TableColumn", 
						"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
						"drop": this.onDropColumn.bind(this),
						"targetAggregation": "columns"
					}
			);
			var dropinfo2 = new sap.ui.core.dnd.DropInfo(
					{ 
						"groupName": "TableRow", 
						"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
						"drop": this.onDropRow.bind(this),
						"targetAggregation": "items"
					}
			);
			var dropinfo3 = new sap.ui.core.dnd.DropInfo(
					{ 
						"groupName": "movecolumn", 
						"dropPosition": sap.ui.core.dnd.DropPosition.Between,
						"drop": this.onMoveColumn.bind(this),
						"targetAggregation": "columns"
					}
			);
			var dropinfo4 = new sap.ui.core.dnd.DropInfo(
					{ 
						"groupName": "moverow", 
						"dropPosition": sap.ui.core.dnd.DropPosition.Between,
						"drop": this.onMoveRow.bind(this),
						"targetAggregation": "items"
					}
			);
			// dropinfo5 with TableColumns is needed for the initial case, when there are no columns visible yet.
			var dropinfo5 = new sap.ui.core.dnd.DropInfo(
					{ 
						"groupName": "TableColumn", 
						"dropPosition": sap.ui.core.dnd.DropPosition.On,
						"drop": this.onDropColumn.bind(this)
					}
			);
			oTable.addDragDropConfig(draginfo1);
			oTable.addDragDropConfig(draginfo2);
			oTable.addDragDropConfig(dropinfo1);
			oTable.addDragDropConfig(dropinfo2);
			oTable.addDragDropConfig(dropinfo3);
			oTable.addDragDropConfig(dropinfo4);
			oTable.addDragDropConfig(dropinfo5);
		},
		allowControlDrop : function(oChildControl) {
			return false; // Don't use the default control drop, only very special controls are allowed to drop
		},
		onDropColumn : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			var sDropPosition = oEvent.getParameter("dropPosition");
			
			/*
			 * When the controls are part of a template, not the controls themselves
			 * are modified but their template structure.
			 */
			oTargetControl = this.findTemplate(oTargetControl);
			
			if (oSourceControl instanceof ui5app.controls.ToolPaletteButton) { // an element of the toolbar
				if (oSourceControl.getControlType() === "sap.m.Column") {
					var oTable = this.getWrappedControl();
					var index;
					if (sDropPosition === "On") {
						// Dropped onto the table --> add at the end
						index = oTable.getColumns().length;
					} else if (sDropPosition === "Before") {
						index = oTable.indexOfColumn(oTargetControl);
					} else {
						index = oTable.indexOfColumn(oTargetControl) + 1;
					}
					oTable.insertColumn(new sap.m.Column( { header: new ui5app.controls.TableColumn() }), index);
					if (this.getControlTemplate()) {
						var oTemplate = this.getControlTemplate();
						var oCell = new ui5app.controls.TableCell();
						oTemplate.insertCell(oCell, index);
						this.rebindTemplate(this);
					} else if (oTable.getItems()) {
						for (const oItem of oTable.getItems()) {
							oItem.insertCell(new ui5app.controls.TableCell(), index);
						}
					}
				}
			}
		},
		onDropRow : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			var sDropPosition = oEvent.getParameter("dropPosition");
			
			/*
			 * When the controls are part of a template, not the controls themselves
			 * are modified but their template structure.
			 */
			oTargetControl = this.findTemplate(oTargetControl);
			
			if (oSourceControl instanceof ui5app.controls.ToolPaletteButton) { // an element of the toolbar
				if (oSourceControl.getControlType() === "sap.m.ColumnListItem") {
					var oTable = this.getWrappedControl();
					var index;
					if (sDropPosition === "On") {
						// Dropped onto the table --> add at the bottom
						index = oTable.getItems().length;
					} else if (sDropPosition === "Before") {
						index = oTable.indexOfItem(oTargetControl);
					} else {
						index = oTable.indexOfItem(oTargetControl) + 1;
					}
					var oRow = new sap.m.ColumnListItem();
					if (oTable.getColumns()) {
						for (const oColumn of oTable.getColumns()) {
							oRow.addCell(new ui5app.controls.TableCell());
						}
					}
					oTable.insertItem(oRow, index);
				}
			}
		},
		onMoveColumn : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			var sDropPosition = oEvent.getParameter("dropPosition");
			
			/*
			 * When the controls are part of a template, not the controls themselves
			 * are modified but their template structure.
			 */
			oTargetControl = this.findTemplate(oTargetControl);
			
			oSourceControl = this.findTemplate(oSourceControl);
			var oTable = this.getWrappedControl();
			var oItemContainer = oSourceControl.getParent();
			if (oSourceControl == oTargetControl) {
				// Do nothing is the object is dropped over itself
			} else if (oItemContainer === oTargetControl.getParent()) {
				/*
				 * The source control was dropped over/between another control in the same list.
				 * This means it should be inserted at the correct place.
				 */
				var sourceindex = oItemContainer.indexOfColumn(oSourceControl);
				oItemContainer.removeColumn(oSourceControl);
				var index;
				if (sDropPosition === "On") {
					// Dropped onto the table --> add at the end
					index = oTable.getColumns().length;
				} else if (sDropPosition === "Before") {
					index = oTable.indexOfColumn(oTargetControl);
				} else {
					index = oTable.indexOfColumn(oTargetControl) + 1;
				}
				oItemContainer.insertColumn(oSourceControl, index);
				if (oTable.getItems()) {
					for (const oItem of oTable.getItems()) {
						var oCell = oItem.removeCell(sourceindex);
						oItem.insertCell(oCell, index);
					}
				}
			} else if (oItemContainer === oTargetControl.getWrappedControl()) {
				/*
				 * The dragged control is inside a parent container and was dropped into
				 * the parent container. That means it should be moved to the end of the list.
				 */
				var sourceindex = oItemContainer.indexOfColumn(oSourceControl);
				oItemContainer.removeColumn(oSourceControl);
				oItemContainer.addColumn(oSourceControl);				
				if (oTable.getItems()) {
					for (const oItem of oTable.getItems()) {
						var oCell = oItem.removeCell(sourceindex);
						oItem.addCell(oCell);
					}
				}
			}
		},
		onMoveRow : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			
			/*
			 * When the controls are part of a template, not the controls themselves
			 * are modified but their template structure.
			 */
			oTargetControl = this.findTemplate(oTargetControl);
			
			oSourceControl = this.findTemplate(oSourceControl);
			var oItemContainer = oSourceControl.getParent();
			if (oSourceControl == oTargetControl) {
				// Do nothing is the object is dropped over itself
			} else if (oItemContainer === oTargetControl.getParent()) {
				/*
				 * The source control was dropped over another control in the same list.
				 * This means it should be inserted before the control it was dropped onto.
				 */
				oItemContainer.removeItem(oSourceControl);
				var index = oItemContainer.indexOfItem(oTargetControl);
				oItemContainer.insertItem(oSourceControl, index);
			} else if (oItemContainer === oTargetControl.getWrappedControl()) {
				/*
				 * The dragged control is inside a parent container and was dropped into
				 * the parent container. That means it should be moved to the end of the list.
				 */
				oItemContainer.removeItem(oSourceControl);
				oItemContainer.addItem(oSourceControl);				
			}
		},
		deleteControl : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTable = this.getWrappedControl();
			if (oTable instanceof sap.m.Table) {
				// remove column
				if (oSourceControl instanceof sap.m.Column) {
					var index = oTable.indexOfColumn(oSourceControl);
					if (index != -1) {
						oTable.removeColumn(index);
						if (oTable.getItems()) {
							for (const oItem of oTable.getItems()) {
								oItem.removeCell(index);
							}
						}
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