sap.ui.define(
  [
	  'sap/m/MaskInput', 
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'sap/m/MaskInputRule',
	  'sap/ui/core/ValueState'],
  function(MaskInput, JSONModel) {
  return sap.m.MaskInput.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.MaskInput", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					regex: { type: "string", defaultValue: "[^_]" },
					maskFormatSymbol: { type: "string", defaultValue: "*" }
					
					
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.m.MaskInput.prototype.init.apply(this, arguments);
				var oView = sap.ui.getCore().byId("mainview");
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "controls" });
				var dropinfo = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "controls", 
							"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
							"drop": oView.getController().onDropControl 
						}
				);
				var oRule = new sap.m.MaskInputRule( {regex: this.getRegex(), maskFormatSymbol: this.getMaskFormatSymbol() } );
				this.addRule(oRule);
				var oModel = new JSONModel();
				oModel.setData({ "list": [
					{ "propertyname": "controlid" },
					{ "propertyname": "mask" },
					{ "propertyname": "name" },
					{ "propertyname": "placeholder" },
					{ "propertyname": "placeholderSymbol" },
					{ "propertyname": "showValueStateMessage" },
					{ "propertyname": "textAlign" },
					{ "propertyname": "value", "showmodelcolumns" : 2 },
					{ "propertyname": "valueState" },
					{ "propertyname": "valueStateText" },
					{ "propertyname": "width" },
					{ "propertyname": "regex" },
					{ "propertyname": "maskFormatSymbol" }
				] });
				this.setProperty("propertiesModel", oModel, true);
				
				this.addStyleClass("uieditor");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo);
				this.attachBrowserEvent("dblclick", function(event) {
				    this.fireEvent("showProperties", undefined, true, false);
				    event.stopPropagation();
				}, this);			
			},
			setRegex : function(value) {
				this.setProperty('regex', value, true);
				if (!!this.getRules() && this.getRules().length > 0) {
					this.getRules()[0].setRegex(value);
				}
			},
			getParentProperties : function() {
				return sap.m.MaskInput.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.MaskInput.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.MaskInput.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.MaskInput.prototype.getMetadata.apply(this, arguments).getName();
			}

		});
});