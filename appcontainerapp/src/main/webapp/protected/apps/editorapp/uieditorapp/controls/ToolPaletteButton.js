sap.ui.define(
  ['sap/m/Button'],
  function(Button) {
  return sap.m.Button.extend(
		"ui5app.controls.ToolPaletteButton", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties : {
					controlType: { type: "String", defaultValue: "" },
					dndGroupName: { type: "String", defaultValue: "controls" },
				}
			},
			renderer : {},
			init : function() {
				sap.m.Button.prototype.init.apply(this, arguments);
				this.setType(sap.m.ButtonType.Transparent);
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": this.getDndGroupName() });
				this.insertDragDropConfig(draginfo);
			},
			setDndGroupName : function(sName) {
				this.setProperty("dndGroupName", sName);
				this.removeDragDropConfig(0);
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": sName });
				this.insertDragDropConfig(draginfo);
			}
		});
});
