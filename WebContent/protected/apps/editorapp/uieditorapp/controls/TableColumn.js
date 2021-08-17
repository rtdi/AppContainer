sap.ui.define( [
  'ui5app/controls/ControlWrapper',
  'ui5libs/errorfunctions',
  'ui5app/controls/ToolPaletteButton',
  'ui5app/controls/ToolPaletteImage'
], function(ControlWrapper, errorfunctions) {
  return ControlWrapper.extend("ui5app.controls.TableColumn", {
		init : function() {
			ControlWrapper.prototype.init.apply(this, arguments);
			this.setSupportModel(false);
			// jQuery.sap.includeStyleSheet(sap.ui.require.toUrl("ui5app/controls/css/ControlWrapper.css"));
			var dropinfo = new sap.ui.core.dnd.DropInfo(
				{ 
					"groupName": "controls", 
					"dropPosition": sap.ui.core.dnd.DropPosition.On,
					"drop": this.onDropControl.bind(this)
				}
			);
			this.addDragDropConfig(dropinfo);
			var dropinfomove = new sap.ui.core.dnd.DropInfo(
					{ 
						"groupName": "TableColumnMove", 
						"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
						"drop": this.onMoveControl.bind(this)
					}
			);
			this.addDragDropConfig(dropinfomove);
			var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "TableColumnMove" });
			this.insertDragDropConfig(draginfo);
		},
		renderer : {
		},
		getLabelText : function() {
			return "TableColumn";
		},
		hasProperties : function() {
			return false;
		},
		onDropControl : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			var oControl = this.createNewControl(oSourceControl.getControlType());
			if (oControl) {
				this.setWrappedControl(oControl);
			}
		},
		hasOptionalWrappedControl : function() {
			return true;
		}
	});
});