sap.ui.define(
  ['sap/m/Image'],
  function(Image) {
  return sap.m.Image.extend(
		"ui5app.controls.ToolPaletteImage", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties : {
					controlType: { type: "String", defaultValue: "" }
				}
			},
			renderer : {},
			init : function() {
				sap.m.Image.prototype.init.apply(this, arguments);
				this.setDensityAware(false);
				this.setDecorative(false);
				this.addStyleClass("sapUiTinyMargin");
				this.addStyleClass("uieditorbox");
				this.setWidth("70px");
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "controls" });
				this.insertDragDropConfig(draginfo);
			}
		});
});

