/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'sap/ui/core/Control',
	"jquery.sap.global",
	"ui5libs/am4charts/library"], function(Control, jQuery, library) {
	return Control.extend("ui5libs.am4charts.Chart", {
		_chart: undefined,
		metadata: {
            properties: {
                width: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                height: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
            }, 
            aggregations: {
            },
		},
		constructor : function() {
			Control.prototype.constructor.apply(this, arguments);
		},
		renderer : function(oRm, oControl) {
			oRm.write("<div");
			oRm.write(" style=\"width: " + oControl.getWidth() + "; height: " + oControl.getHeight() + ";\" ");
            oRm.writeControlData(oControl);
            oRm.write(">");
			oRm.write("</div>");
		},
		onAfterRendering : function() {
			sap.ui.core.Control.prototype.onAfterRendering.apply(this, arguments);
			this._chart = am4core.create(this.getId(), am4charts.PieChart);
			var series = this._chart.series.push(new am4charts.PieSeries());
			series.dataFields.value = "litres";
			series.dataFields.category = "country";
			this._chart.data = [{
				  "country": "Lithuania",
				  "litres": 501.9
				}, {
				  "country": "Czech Republic",
				  "litres": 301.9
				}, {
				  "country": "Ireland",
				  "litres": 201.1
				}, {
				  "country": "Germany",
				  "litres": 165.8
				}, {
				  "country": "Australia",
				  "litres": 139.9
				}, {
				  "country": "Austria",
				  "litres": 128.3
				}, {
				  "country": "UK",
				  "litres": 99
				}, {
				  "country": "Belgium",
				  "litres": 60
				}, {
				  "country": "The Netherlands",
				  "litres": 50
				}];
			this._chart.legend = new am4charts.Legend();
		},
		dispose : function() {
			this._chart.destroy();
		},
		executeQuery : function() {
		}
	});
});