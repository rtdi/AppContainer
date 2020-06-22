/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.DataProviderFilter.extend("io.rtdi.amchartsui5controls.DataProviderFilterEqual", {
		metadata: {
            properties: {
                path: {type : "string"},
            }, 
		},
		constructor : function(fieldname, path) {
			io.rtdi.amchartsui5controls.DataProviderFilter.prototype.constructor.apply(this);
			this.setField(fieldname);
			this.setPath(path);
		},
		toODataCondition : function() {
			var v = this.getValue();
			var r;
			if (typeof(v) === "number") {
				r = String(v);
			} else {
				r = "'" + v + "'";
			}
			return this.getField() + " eq " + r; 
		},
		setPath : function(path) {
			this.setProperty("path", path, true);
		},
		getValue : function() {
			var p = this.getProperty("path");
			return this.getModel().getProperty(p);
		},
	});
});
