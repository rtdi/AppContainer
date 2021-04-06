sap.ui.define(
  ['sap/m/Button', 'sap/ui/model/json/JSONModel'],
  function(Button, JSONModel) {
  return sap.m.Button.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ToolPaletteButton", {
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
				sap.m.Button.prototype.init.apply(this, arguments);
				this.setType(sap.m.ButtonType.Transparent);
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
