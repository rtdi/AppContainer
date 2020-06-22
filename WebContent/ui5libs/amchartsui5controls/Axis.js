/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'sap/ui/core/Element',
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(Element, jQuery, library) {
	return Element.extend("io.rtdi.amchartsui5controls.Axis", {
		metadata: {
            properties: {
                dataProvider: {type : "io.rtdi.amchartsui5controls.DataProvider"},
                _axis: {type : "any"},
            }, 
            aggregations: {
                filters : {type : "io.rtdi.amchartsui5controls.DataProviderFilter", multiple : true},
            },
		},
		initAxis : function() {
		},
		_setAm4ChartObject : function(series) {
			this.setProperty("_axis", series, true);
		},
		getAm4ChartObject : function() {
			return this.getProperty("_axis");
		},
		setData : function(data) {
			getAm4ChartSeries().data = data;
		},
		setDataProvider : function(p) {
			this.setProperty("dataProvider", p, true);
			p.setParentObject(this);
		},
		getFilters : function() {
			return this.getAggregation("filters");
		},
		executeQuery : function() {
			if (this.getDataProvider()) {
				this.getDataProvider().executeQuery();
			}
		},
		setODataUrl : function(endpoint, collection) {
   			var p = new io.rtdi.amchartsui5controls.DataProviderOData();
   			this.setDataProvider(p);
   			p.setODataUrl(endpoint, collection);
		}
	});
});
