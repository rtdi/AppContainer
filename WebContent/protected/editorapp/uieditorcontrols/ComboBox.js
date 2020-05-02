sap.ui.define(
  [
	  'sap/m/ComboBox',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign'],
  function(ComboBox, JSONModel) {
  return sap.m.ComboBox.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ComboBox", {
			metadata : {
				dnd : {
					draggable : true,
					droppable : true
				},
				properties: {
					propertiesModel: { type: "sap.ui.model.json.JSONModel", defaultValue: undefined },
					controlid: { type: "string", defaultValue: "" },
					oDataURL: { type: "string", defaultValue: "" },
					oDataItemPath: { type: "string", defaultValue: "" },
					itemIcon: { type: "string", defaultValue: "" },
					itemText: { type: "string", defaultValue: "" },
					itemAdditionalText: { type: "string", defaultValue: "" },
					modelColumns: { type: "object", defaultValue: undefined }
				},
				events : {
					showProperties : {}
				}
			},
			renderer : {},
			init : function() {
				sap.m.ComboBox.prototype.init.apply(this, arguments);
				var oView = sap.ui.getCore().byId("mainview");
				var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "controls" });
				var dropinfo1 = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "controls", 
							"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
							"drop": oView.getController().onDropControl 
						}
				);
				var dropinfo2 = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "model", 
							"dropPosition": sap.ui.core.dnd.DropPosition.On,
							"drop": oView.getController().onDropModel
						}
				);

				this.addStyleClass("uieditor");
				this.insertDragDropConfig(draginfo);
				this.insertDragDropConfig(dropinfo1);
				this.insertDragDropConfig(dropinfo2);
				
				var oModel = new JSONModel();
				oModel.setData({ "list": [
					{ "propertyname": "controlid" },
					{ "propertyname": "name" },
					{ "propertyname": "itemIcon", "showmodelcolumns" : 1 },
					{ "propertyname": "itemText", "showmodelcolumns" : 1 },
					{ "propertyname": "itemAdditionalText", "showmodelcolumns" : 1 },
					{ "propertyname": "oDataURL" },
					{ "propertyname": "oDataItemPath" },
					{ "propertyname": "width" },
					{ "propertyname": "maxWidth" },
					{ "propertyname": "showSecondaryValues" },
					{ "propertyname": "showValueStateMessage" },
					{ "propertyname": "textAlign" }
				] });
				this.setProperty("propertiesModel", oModel, true);

				this.attachBrowserEvent("dblclick", function(event) {
				    event.stopPropagation();
				    this.fireEvent("showProperties", undefined, true, false);
				    return false;
				}, this);			
				this.attachEvent("showProperties", sap.ui.getCore().byId("mainview").getController().showProperties);
			},
			_updateItems : function() {
				/*
				 * This method is called whenever something changed, oData endpoint, aggregation or one of the item
				 * properties.
				 * As the order, when the properties are being set, cannot be controlled this method will be called
				 * after any change and should do minimal operations.
				 */
				if (this.getModel()) {
					/*
					 * A model exists, so either it is a new model or one of the settings changed:
					 * - ODataItemPath
					 * - ItemText
					 * - ItemIcon
					 */
					if (!!this.getODataItemPath()) {
						/*
						 * Without the item path being set, creating the aggregation does not make sense.
						 * Likely the setODataItemPath() method will be called shortly after.
						 */
						this.bindAggregation("items", this.getODataItemPath(), new sap.ui.core.ListItem( 
								{ 
									text: this.getItemText(), 
									additionalText: this.getItemAdditionalText(), 
									key: this.getItemText(), 
									icon: this.getItemIcon()
								} ) );
					}
				} else {
					/* 
					 * Either the model got just removed and the five default items have to be added or
					 * they exist already and one of their properties got changed.
					 * 
					 * At this point in time the binding has to be removed already via this.unbindAggregation("items");
					 */
					var aItems = this.getItems();
					var that = this;
					if (!!aItems && aItems.length > 0) {
						aItems.forEach(function (oItem) {
							oItem.setText(that.getItemText());
							oItem.setAdditionalText(that.getItemAdditionalText());
							oItem.setKey(that.getItemText());
							oItem.setIcon(that.getItemIcon());
						});
					} else {
						this.destroyItems();
						for (var i=1; i<5; i++) {
							this.addItem(new sap.ui.core.ListItem( 
									{
										text: that.getItemText(), 
										additionalText: that.getItemAdditionalText(), 
										key: that.getItemText(), 
										icon: that.getItemIcon() 
									} ));
						}
					}					
				}
			},
			setODataURL : function(sUrl) {
				this.setProperty("oDataURL", sUrl, false);
				/*
				 * The oData endpoint is the only element controlling if an odata model should be used or not.
				 * Thus it creates a model and removes it from the control.
				 */
				if (!!sUrl && sUrl !== "") {
					var that = this;
				    var oModel = new sap.ui.model.odata.v4.ODataModel({
			    		serviceUrl : sUrl, 
			    		"autoExpandSelect": true,
						"operationMode": "Server",
						"groupId": "$direct",
						"synchronizationMode": "None"
				    });
				    /*
				     * Need to reset the other item values as they would throw errors when the new model
				     * does not have the corresponding column of the old model. Changing the values
				     * without triggering an update via _updateItems().
				     * These values will be set to defaults further below, when the model metadata was read.
				     */
					this.setProperty("oDataItemPath", null, true);
					this.setProperty("itemText", "", true);
					this.setProperty("itemAdditionalText", "", true);
					this.setProperty("itemIcon", "", true);
					/*
					 * Remove any previous binding, else the new model would use the old binding elements.
					 */
					this.unbindAggregation("items"); 
					this.setModel(oModel);
					/*
					 * Assuming the oData Service used in one from the HanaAppContainer, the 
					 * modelColumns property should be updated to support the user picking the
					 * proper binding. It does not refresh the properties pane, no event fired.
					 */
					var oMetamodel = oModel.getMetaModel();
					/* oMetamodel.requestObject("/").then(
							function(meta) { 
								 *
								 * returns
								 * {
								 *   $kind: "EntityContainer",
								 *   TABLE: {
								 *     $Type: "HANAOBJECT.ROW"
							  	 *     $kind: "EntitySet"
							  	 *   }
							  	 * }
								 *
							} ); */
					oMetamodel.requestObject("/HANAOBJECT.ROW").then(
							function(meta) { 
								var oColumns = [];
								Object.keys(meta).forEach( function(item) {
									if (!item.startsWith("$")) {
										oColumns.push(item);
									}
								} );
								that.setProperty("modelColumns", oColumns, true);
								if (oColumns.length > 0) {
									that.setItemText("{" + oColumns[0] + "}");
								}
								that.setODataItemPath("/TABLE");
							} );
					this._updateItems();
				} else if (this.getModel()) {
					this.unbindAggregation("items");
					this.setModel(undefined);
					this.setProperty("oDataItemPath", null, true);
					this.setProperty("itemText", "Item", true);
					this.setProperty("itemAdditionalText", "moreText", true);
					this.setProperty("itemIcon", "", true);
					this._updateItems();
				} else {
					this._updateItems();
				}
			},
			setODataItemPath : function(sPath) {
				this.setProperty("oDataItemPath", sPath, false);
				this._updateItems();
			},
			setItemText : function(value) {
				this.setProperty("itemText", value, false);
				this._updateItems();
			},
			setItemAdditionalText : function(value) {
				this.setProperty("itemAdditionalText", value, false);
				this._updateItems();
			},
			setItemIcon : function(value) {
				this.setProperty("itemIcon", value, false);
				this._updateItems();
			},
			getParentProperties : function() {
				return sap.m.ComboBox.prototype.getMetadata.apply(this, arguments).getAllProperties();
			},
			getParentAggregations : function() {
				return sap.m.ComboBox.prototype.getMetadata.apply(this, arguments).getAllAggregations();
			},
			getParentAssociations : function() {
				return sap.m.ComboBox.prototype.getMetadata.apply(this, arguments).getAllAssociations();
			},
			getParentClassName : function() {
				return sap.m.ComboBox.prototype.getMetadata.apply(this, arguments).getName();
			}

		});
});