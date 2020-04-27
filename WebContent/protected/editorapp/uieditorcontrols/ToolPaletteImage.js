sap.ui.define(
  ['sap/m/Image', 'sap/ui/model/json/JSONModel'],
  function(Image, JSONModel) {
  return sap.m.Image.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ToolPaletteImage", {
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
				this.setWidth("50px");
				var oView = sap.ui.getCore().byId("mainview");
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "controls" });
				var dropinfo = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "controls", 
							"dropPosition": sap.ui.core.dnd.DropPosition.On,
							"drop": oView.getController().onDropControl 
						}
				);
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
			}
		});
});

