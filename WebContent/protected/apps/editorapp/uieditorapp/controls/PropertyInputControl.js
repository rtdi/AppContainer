sap.ui.define(
  ['sap/m/ComboBox', 'sap/m/InputType', 'sap/ui/core/Item', 'sap/ui/model/odata/v4/ODataMetaModel'],
  function(Control) {
  return sap.m.ComboBox.extend(
		"ui5app.controls.PropertyInputControl", {
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
				var sValue;
				if (!!!fValue) {
					sValue = "";
				} else {
					sValue = String(fValue);
				}
				sap.m.ComboBox.prototype.setValue.call(this, sValue);
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
			},
		});
});