sap.ui.define(
  [
	  'sap/m/Carousel',
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/HBox'
	  ],
  function(Carousel, JSONModel, dHBox) {
  return sap.m.Carousel.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Carousel", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					pages: { type: "int", defaultValue: "" }
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.m.Carousel.prototype.init.apply(this, arguments);
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
					{ "propertyname": "arrowsPlacement" },
					{ "propertyname": "height" },
					{ "propertyname": "width" },
					{ "propertyname": "pageIndicatorPlacement" },
					{ "propertyname": "pages" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.addStyleClass("uieditorbox");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    this.fireEvent("showProperties", undefined, true, false);
				    event.stopPropagation();
				}, this);			
			},
			setPages : function(value) {
				if (value > 1) {
					this.setProperty("pages", value, true);
					var count = 0;
					if (!!this.getPages()) {
						count = this.getPages().length;
					}
					while (count < value) {
						var oRow = new dHbox();
						this.addPage(oRow);
						count++;
					}
					while (count > value) {
						this.removePage(count-1);
						count--;
					}
				}
			},
			getParentProperties : function() {
				return sap.m.Carousel.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.Carousel.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.Carousel.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.Carousel.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});