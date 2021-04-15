sap.ui.define([
	'sap/ui/core/Control'
], function(Control) {
	return Control.extend("ui5libs.am4charts.GaugeHand", {
		metadata: {
            properties: {
            	value: { type: "float", defaultValue: 0 },
            	fill: { type: "string", defaultValue: undefined },
            	stroke: { type: "string", defaultValue: undefined },
            	innerRadius: { type: "string", defaultValue: undefined },
            	radius: { type: "string", defaultValue: undefined },
            	startWidth: { type: "float", defaultValue: undefined },
            	tooltipText: { type: "string", defaultValue: undefined },
            }, 
            aggregations: {
            },
		},
		constructor : function() {
			Control.prototype.constructor.apply(this, arguments);
		},
		_setChartProperty : function(sName, oValue) {
			this.setProperty(sName, oValue, true);
			if (this.getParent()) {
				var oHand = this.getParent()._getHand(this);
				if (oHand) {
					oHand[sName] = oValue;
				}
			}
		},
		setValue : function(oValue) {
			this._setChartProperty("value", oValue);
		},
		setFill : function(oValue) {
			this._setChartProperty("fill", oValue);
		},
		setStroke : function(oValue) {
			this._setChartProperty("stroke", oValue);
		},
		setInnerRadius : function(oValue) {
			this._setChartProperty("innerRadius", oValue);
		},
		setRadius : function(oValue) {
			this._setChartProperty("radius", oValue);
		},
		setStartWidth : function(oValue) {
			this._setChartProperty("startWidth", oValue);
		},
		setTooltipText : function(oValue) {
			this._setChartProperty("tooltipText", oValue);
		},
	});
});
