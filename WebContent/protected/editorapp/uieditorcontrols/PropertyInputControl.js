sap.ui.define(
  ['sap/m/ComboBox', 'sap/m/InputType', 'sap/ui/core/Item', 'sap/ui/model/odata/v4/ODataMetaModel'],
  function(Control) {
  return sap.m.ComboBox.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.PropertyInputControl", {
			metadata : {
				properties: {
					datatype: { type: "Object", defaultValue: undefined },
					objectValue: {type: "Object", defaultValue: undefined },
					showModelColumns: { type: "Boolean", defaultValue: false },
					showBindingColumns: { type: "Boolean", defaultValue: false }
				}
			},
			renderer : {},
			init : function() {
				sap.m.ComboBox.prototype.init.apply(this, arguments);
			},
			setObjectValue : function(fValue) {
				this.setProperty("objectValue", fValue, true);
				var sDatatype = this.getDatatype();
				sap.m.ComboBox.prototype.setValue.call(this, String(fValue));
			},
			setValue : function(fValue) {
				sap.m.ComboBox.prototype.setValue.apply(this, arguments);
				var sBaseTypeName = this._getBaseDataTypeName(this.getDatatype());
				if (!!sBaseTypeName) {
					switch (sBaseTypeName) {
					case "int":
						this.setProperty("objectValue", Number(fValue), true);
						break;
					case "float":
						this.setProperty("objectValue", parseFloat(fValue), true);
						break;
					case "boolean":
						this.setProperty("objectValue", fValue === "true", true);
						break;
					default:
						this.setProperty("objectValue", fValue, true);
					}
				}
			},
			setShowModelColumns : function(b) {
				this.setProperty("showModelColumns", b, true);		
				if (b === 1) {
					this._addModelColumns();
				} else if (b === 2) {
					this._addBaseModelColumns();
				}
			},
			_addModelColumns : function() {
				/*
				 * Add the column if this control's model, e.g. the items collection of a list
				 */
				var that = this;
				var oCurrentControl = this.getParent().getParent().data("control");
				var oModelColumns = oCurrentControl.getProperty("modelColumns");
				if (oModelColumns) {
					oModelColumns.forEach(function(sItem) {
						that.addItem(new sap.ui.core.Item( {text: "\\{" + sItem + "\\}", key: sItem} ) );
					});
				}
			},
			_addBaseModelColumns : function() {
				/*
				 * Add all columns from the parent model, e.g. a table has a model, the template is a 
				 * HBox within is a Text and its text property should be the table model column COL1.
				 */
				var oView = sap.ui.getCore().byId("mainview");
				var oPropertiesTable = oView.byId("properties");
				var oParentControl = oPropertiesTable.data("control").getParent();
				while (oParentControl && !oParentControl.getModel() ) {
					if ("oDataURL" in oParentControl) {
						/*
						 * Only go as deep as the next potential model container, e.g. down to the table
						 */
						oDataURL = undefined;
					} else if ("data" in oParentControl && oParentControl.data("templateFor")) {
						/*
						 * Switch from template collection to table
						 */
						oParentControl = oParentControl.data("templateFor");
					} else {
						oParentControl = oParentControl.getParent();
					}
				}
				if (oParentControl && "getModelColumns" in oParentControl) {
					/*
					 * Okay, so we found a model, hence need to show all columns of the model
					 */
					var that = this;
					var oModelColumns = oParentControl.getProperty("modelColumns");
					if (oModelColumns) {
						oModelColumns.forEach(function(sItem) {
							that.addItem(new sap.ui.core.Item( {text: "\\{" + sItem + "\\}", key: sItem} ) );
						});
					}
				}
			},
			_getBaseDataTypeName : function(oDatatype) {
				var oBaseType = oDatatype.getBaseType();
				if (oBaseType) {
					return oBaseType.getName();
				} else {
					return oDatatype.getName();
				}					
			},
			setDatatype : function(oDatatype) {
				this.setProperty("datatype", oDatatype, true);
				var that = this;
				if (oDatatype) {
					var aEnumValues = oDatatype.getEnumValues();
					var sBaseTypeName = this._getBaseDataTypeName(oDatatype);
					if (aEnumValues) {
						Object.keys(aEnumValues).forEach(function(sItem) {
							that.addItem(new sap.ui.core.Item( {text: sItem, key: sItem} ) );
						});
					} else if (sBaseTypeName === "int") {
					} else if (sBaseTypeName === "boolean") {
						this.addItem( new sap.ui.core.Item( { text: "true", key: "true" } ) )
						this.addItem( new sap.ui.core.Item( { text: "false", key: "false" } ) )
					/* } else if (Array.isArray(sDatatype)) {
						sDatatype.forEach(function(sItem) {
							that.addItem(new sap.ui.core.Item( {text: "\\{" + sItem + "\\}", key: sItem} ) );
						}); */
					} else {
						
					}
				} else {
					this.destroyItems();
				}
			},
			setModelColumns : function(vODataModel) {
				var root = vODataModel.requestObject("/");
			}
		});
});