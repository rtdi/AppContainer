/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'sap/ui/base/ManagedObject',
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(ManagedObject, jQuery, library) {
	return ManagedObject.extend("io.rtdi.amchartsui5controls.RootWrapper", {
		metadata: {
            properties: {
                _o : {type : "object"},
            }
		},
		constructor: function(mSettings) {
			ManagedObject.apply(this, arguments);
			this.setProperty("_o", this._createNewAm4ChartsObject());
		},
		init : function() {
		},
		_createNewAm4ChartsObject : function(oAxis) {
			return undefined;
		},
		_setValue : function (propertyname, o) {
			var value = this.getProperty(propertyname)
			if (value) {
				if (value instanceof io.rtdi.amchartsui5controls.RootWrapper) {
					if (value._getAm4ChartObject()) {
						o[propertyname] = value._getAm4ChartObject();
					} else {
						value._link(o[propertyname]);
					}
				} else {
					o[propertyname] = value;
				}
			}

		},
		_getAm4ChartObject : function() {
			return this.getProperty("_o");
		},
		_link : function(o = this._getAm4ChartObject()) {
			Object.keys(this.getMetadata().getAllProperties()).forEach(function (name) {
				if (name.charAt(0) !== "_") {
					this._setValue(name, o);
				}
			}, this);
		},

	});
});
