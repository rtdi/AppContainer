/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/ValueAxis" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.ValueAxis.extend("io.rtdi.amchartsui5controls.DateAxis", {
		metadata: {
            properties: {
                baseInterval : {type : "object"},
                dateFormatsSetKey : {type : "object"},
                periodChangeDateFormatsSetKey : {type : "object"},
            }
		},
		init : function() {
		},
		_createNewAm4ChartsObject : function(oAxis) {
			return new am4charts.DateAxis();
		},
		_assignValues : function() {
			io.rtdi.amchartsui5controls.ValueAxis.prototype._assignValues.apply(this, arguments);
			this._setValue("baseInterval", "baseInterval");
			var key = this.getProperty("dateFormatsSetKey");
			if (key) {
				this.getAxis().dateFormats.setKey(key["key"], key["value"]);
			}
			key = this.getProperty("periodChangeDateFormatsSetKey");
			if (key) {
				this.getAxis().periodChangeDateFormats.setKey(key["key"], key["value"]);
			}
		},
	});
});



