/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'sap/ui/core/Element',
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(Element, jQuery, library) {
	return Element.extend("io.rtdi.amchartsui5controls.DataProvider", {
		metadata: {
            properties: {
                name: {type : "string"},
                _parentobject: {type : "any"},
            }, 
            aggregations: {
            },
		},
		setParentObject : function(parent) {
			this.setProperty("_parentobject", parent, true);
		},
		getParentObject : function() {
			return this.getProperty("_parentobject");
		},
		executeQuery : function() {
		}
	});
});
