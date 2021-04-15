sap.ui.define([
	'sap/ui/core/Control',
	'ui5libs/am4charts/Chart',
	'ui5libs/am4charts/GaugeHand'
], function(Control, Chart, GaugeHand) {
	return Chart.extend("ui5libs.am4charts.Gauge", {
		metadata: {
            properties: {
            }, 
            aggregations: {
            	"items": { "type": "ui5libs.am4charts.GaugeHand", "multiple": true, "singularName": "item" }
            },
            events: {
            	"mergeConfig": {}
            }
		},
		renderer: {
		},
		constructor : function() {
			Control.prototype.constructor.apply(this, arguments);
			this.setCharttype("GaugeChart");
		},
		addItem : function(oItem) {
			this.addAggregation("items", oItem, true);
		},
		removeItem : function(oItem) {
			this.removeAggregation("items", oItem, true);
		},
		addCustomData : function(oItem) {
			this.addAggregation("customData", oItem, true);
		},
		removeCustomData : function(oItem) {
			this.removeAggregation("customData", oItem, true);
		},
		_getHand : function(oItem) {
			var oChart = this.getChart();
			var aItems = this.getItems();
			if (aItems && oChart) {
				for (let i=0; i<aItems.length; i++) {
					var oHand;
					if (aItems[i] === oItem) {
						if (i < oChart.hands.values.length) {
							oHand = oChart.hands.values[i];
						} else {
							while (i < oChart.hands.values.length) {
								oHand = oChart.hands.push(new am4charts.ClockHand());
							}
						}
					}
					return oHand;
				}
			}
			return undefined;
		},

	});
});
