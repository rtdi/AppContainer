sap.ui.define(
  [
	  'sap/m/Select',
	  'sap/ui/model/json/JSONModel',
	  'sap/ui/core/TextAlign',
	  'sap/m/SelectType',
	  'sap/ui/core/ValueState',
	  'sap/ui/core/ListItem',
	  'io/rtdi/appcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Select, JSONModel) {
  return io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapperWithListItem", {
			metadata : {
				properties: {
					oDataURL: { type: "string", defaultValue: "" },
					oDataItemPath: { type: "string", defaultValue: "" },
					modelColumns: { type: "Object", defaultValue: undefined },
					_itemfactory: { type: "Object", defaultValue: undefined }
				},
				aggregations: {
					items: {
						type: "sap.ui.core.Item",
						multiple: true,
						singularName: "item",
						bindable: "bindable",
						forwarding: {
							getter: "getList",
							aggregation: "items"
						}
					}
				}
			},
			renderer : {},
			init : function(oChild, bAnchor = false, oItemClass = sap.ui.core.ListItem) {
				io.rtdi.appcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, oChild, bAnchor);
				this.setProperty("_itemfactory", oItemClass, true);
				var oView = sap.ui.getCore().byId("mainview");
				var dropinfo2 = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "model", 
							"dropPosition": sap.ui.core.dnd.DropPosition.On,
							"drop": oView.getController().onDropModel
						}
				);
				this.insertDragDropConfig(dropinfo2);
				
				Object.keys(this.getMetadata().getAllProperties()).forEach(function (sName) {
					var oMetadata = this.getMetadata().getAllProperties()[sName];
					if (oMetadata.appData && oMetadata.appData.itemSetting) {
						this[oMetadata._sMutator] = function (value) {
							if (this.getProperty(sName) !== value) {
								this.setProperty(sName, value, false);
								this._updateItems();
							}							
						};
					}
				}, this);
			},
			_updateItems : function() {
				createItem = function() {
					var oClass = this.getProperty("_itemfactory");
					var oSettings = {};
					Object.keys(this.getMetadata().getAllProperties()).forEach(function (sName) {
						var oMetadata = this.getMetadata().getAllProperties()[sName];
						if (oMetadata.appData && oMetadata.appData.itemSetting) {
							oSettings[oMetadata.appData.itemSetting] = this.getProperty(sName);
						}
					}, this);
					return new oClass( oSettings );
				};
				var oChild = this.getAggregation("_control");
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
						oChild.bindAggregation("items", this.getODataItemPath(), createItem.call(this) );
					}
				} else {
					/* 
					 * Either the model got just removed and the five default items have to be added or
					 * they exist already and one of their properties got changed.
					 * 
					 * At this point in time the binding has to be removed already via this.unbindAggregation("items");
					 */
					oChild.unbindAggregation("items");
					var aItems = oChild.getItems();
					if (!!aItems && aItems.length > 0) {
						aItems.forEach(function (oItem) {
							Object.keys(this.getMetadata().getAllProperties()).forEach(function (sName) {
								var oMetadata = this.getMetadata().getAllProperties()[sName];
								if (oMetadata.appData && oMetadata.appData.itemSetting) {
									var oItemMetadata = oItem.getMetadata().getAllProperties()[oMetadata.appData.itemSetting];
									oItem[oItemMetadata._sMutator].call(oItem, this.getProperty(sName));
								}
							}, this);
						}, this);
					} else {
						oChild.destroyItems();
						for (var i=1; i<5; i++) {
							oChild.addItem(createItem.call(this));
						}
					}					
				}
			},
			setODataURL : function(sUrl) {
				// this._getDefaultsFromSettings();
				var oChild = this.getAggregation("_control");
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
				    oModel.setDefaultBindingMode(sap.ui.model.BindingMode.OneWay);
					/*
					 * Remove any previous binding, else the new model would use the old binding elements.
					 */
					oChild.unbindAggregation("items");
					
					this.setModel(oModel);
					/*
					 * Assuming the oData Service used in one from the AppContainer, the 
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
								 *     $Type: "DBOBJECT.ROW"
							  	 *     $kind: "EntitySet"
							  	 *   }
							  	 * }
								 *
							} ); */
					oMetamodel.requestObject("/DBOBJECT.ROW").then(
							function(meta) { 
								var oColumns = [];
								Object.keys(meta).forEach( function(item) {
									if (!item.startsWith("$")) {
										oColumns.push(item);
									}
								} );
								that.setProperty("modelColumns", oColumns, true);
								that.setProperty("oDataItemPath", "/TABLE", false);
							    /*
							     * Need to check the item values if they are valid to avoid errors in the console.
							     */
								checkItemValue = function(sName, aColumns, sDefault = null, sReplaceIf = "") {
									if (!oColumns || oColumns.length === 0) {
										/*
										 * Case #1: The model has no columns. Should not happen but then set the value
										 * to the default.
										 */
										that.setProperty(sName, sDefault, true);
									} else if (!that.getProperty(sName) || that.getProperty(sName) === sReplaceIf) {
										/*
										 * Case #2: The current value is the control's value for an unbound element.
										 * In that case replace the value by the oData model column
										 */
										that.setProperty(sName, sDefault, true);
									} else if (that.getProperty(sName).startsWith("{")) {
										/*
										 * Case #3: The value is a bound value, check if the column exists in the model.
										 * If not, reset it to the default
										 */
										var sPath = that.getProperty(sName)
										if (sPath.startsWith("{")) {
											sPath = sPath.substring(1, sPath.length-1);
										}
										if (!aColumns.includes(sPath)) {
											that.setProperty(sName, sDefault, true);
										}
									}
								};
								var sDefaultPath = "Item";
								if (oColumns && oColumns.length > 0) {
									sDefaultPath = "{" + oColumns[0] + "}";
								}
								Object.keys(that.getMetadata().getAllProperties()).forEach(function (sName) {
									var oMetadata = that.getMetadata().getAllProperties()[sName];
									if (oMetadata.appData && oMetadata.appData.itemSetting) {
										if (oMetadata.appData.showmodelcolumns) {
											checkItemValue(sName, oColumns, sDefaultPath, sDefaultPath);
										} else {
											checkItemValue(sName, oColumns);
										}
									}
								}, that);

								that._updateItems(); // Update binding after the metadata has been read
							} );
				} else if (this.getModel()) {
					/*
					 * Empty url means removing the model
					 */
					oChild.unbindAggregation("items");
					this.setModel(undefined);
					this._updateItems();
				} else {
					this._updateItems();
				}
			},
			/*
			 * Setters for the items have to trigger the updateItems logic but only if something changed
			 */
			setODataItemPath : function(sPath) {
				if (this.getProperty("oDataItemPath") !== sPath) {
					this.setProperty("oDataItemPath", sPath, false);
					this._updateItems();
				}
			},
			/*
			 * Redirect all item-calls to the child control
			 */
			getItems : function() {
				return this.getAggregation("_control").getItems();
			},
			addItem : function(oItem) {
				return this.getAggregation("_control").addItem(oItem);
			},
			destroyItems : function() {
				return this.getAggregation("_control").destroyItems();
			},
			indexOfItem : function(oItem) {
				return this.getAggregation("_control").indexOfItem(oItem);
			},
			insertItem : function(oItem, iIndex) {
				return this.getAggregation("_control").insertItem(oItem, iIndex);
			},
			removeAllItems : function() {
				return this.getAggregation("_control").removeAllItems();
			},
			removeItem : function(oItem) {
				return this.getAggregation("_control").removeItem(oItem);
			}

		});
});