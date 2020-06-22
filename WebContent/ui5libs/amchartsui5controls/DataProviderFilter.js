/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'sap/ui/core/Element',
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(Element, jQuery, library) {
	return Element.extend("io.rtdi.amchartsui5controls.DataProviderFilter", {
		metadata: {
            properties: {
                field: {type : "string"},
                type: {type : "string"},
            }, 
		},
		toODataCondition : function() {
			return undefined;
		},
		setField : function(value) {
			this.setProperty("field", value, true);
		},
	});
});
