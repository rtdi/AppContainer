/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'sap/ui/core/Control',
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(Control, jQuery, library) {
	return Control.extend("io.rtdi.amchartsui5controls.Chart", {
		metadata: {
            properties: {
                width: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                height: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                _chart: {type : "any", visibility: "hidden"},
                _chartInitCallback: {type : "any", visibility: "hidden"}
            }, 
            aggregations: {
            },
		},
		init : function() {
		},
		renderer : function(oRm, oControl) {
			oRm.write("<div");
			oRm.write(" style=\"width: " + oControl.getWidth() + "; height: " + oControl.getHeight() + ";\" ");
            oRm.writeControlData(oControl);
            oRm.write(">");
			oRm.write("</div>");
		},
		_setValue : function (o, key, value) {
			var aPath = key.split("\\.");
			for (var i = 0; i < aPath.length; i++) {
				var sProperty = aPath[i];
				if (i == aPath.length-1) {
					o[sProperty] = value;
				} else {
					o = o[sProperty];
				}
			}
		},
		getChart : function() {
			return this.getProperty("_chart");
		},
		_createNewChart : function() {
			return undefined;
		},
		createCSSPercentNumber : function(value) {
			return am4core.percent(value);
		},
		createCSSColor : function(value) {
			return am4core.color(value);
		},
		onAfterRendering : function() {
			sap.ui.core.Control.prototype.onAfterRendering.apply(this, arguments); // run the super class's method first
			if (this.getProperty("_chart")) {
				/*
				 * Safety net
				 */
				this.getProperty("_chart").dispose();
			}
			var chart = am4core.create(this.getDomRef(), this._createNewChart());
			chart.dataSource.events.on("parseended", function(ev) {
				  // parsed data is assigned to data source's `data` property
				  var data = ev.target.data;
				  ev.target.data = data.value;
				});
			this.setProperty("_chart", chart, true);
			this.getProperty("_chartInitCallback").call(this, this, chart);
		},
		dispose : function() {
			if (this.getProperty("_chart")) {
				this.getProperty("_chart").dispose();
			}
		},
		setChartInitCallback : function(f) {
			this.setProperty("_chartInitCallback", f, true);
		}
	});
});
