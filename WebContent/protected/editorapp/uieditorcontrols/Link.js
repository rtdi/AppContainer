sap.ui.define(
  [
	  'sap/m/Link', 
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign'],
  function(Link, JSONModel) {
  return sap.m.Link.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Link", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" }
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.m.Link.prototype.init.apply(this, arguments);
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
					{ "propertyname": "href", "showmodelcolumns" : 2 },
					{ "propertyname": "text", "showmodelcolumns" : 2 },
					{ "propertyname": "width" },
					{ "propertyname": "emphasized" },
					{ "propertyname": "subtle" },
					{ "propertyname": "target" },
					{ "propertyname": "textAlign" },
					{ "propertyname": "wrapping" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.addStyleClass("uieditor");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachEvent('press', this._donothing);
				this.attachBrowserEvent("dblclick", function(event) {
					event.preventDefault();
				    this.fireEvent("showProperties", undefined, true, false);
				    event.stopPropagation();
				}, this);			
			},
			_donothing : function() {
				
			},
			getParentProperties : function() {
				return sap.m.Link.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.Link.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.Link.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.Link.prototype.getMetadata.apply(this, arguments).getName();
			}
		});
});