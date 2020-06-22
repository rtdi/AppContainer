/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.DataProvider.extend("io.rtdi.amchartsui5controls.DataProviderOData", {
		metadata: {
            properties: {
                oDataEndpoint: {type : "string"},
                collection: {type : "string"},
            }, 
            aggregations: {
            },
		},
		setODataUrl : function(endpoint, collection) {
			this.setProperty("oDataEndpoint", endpoint, true);
			this.setProperty("collection", collection, true);
		},
		executeQuery : function() {
			var endpoint = this.getProperty("oDataEndpoint");
			var collection = this.getProperty("collection");
			var sUrl = endpoint + collection;
			var aFilters = this.getParentObject().getFilters();
			if (aFilters) {
				for (var i=0; i<aFilters.length; i++) {
					if (i == 0) {
						sUrl = sUrl + "?$filter=";
					} else {
						sUrl = sUrl + " AND ";
					}
					sUrl = sUrl + aFilters[i].toODataCondition();
				}
			}
			var that = this;
			var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		        if (this.readyState == 4 && this.status == 200) {
		        	var d = JSON.parse(this.responseText);
					that.getParentObject().getAm4ChartObject().data = d.value;
		        }
		    };
		    xhttp.open("GET", sUrl, true);
		    xhttp.setRequestHeader("Content-type", "application/json");
		    xhttp.send();
		}

	});
});
