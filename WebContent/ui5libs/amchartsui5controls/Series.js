/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library",
	"io/rtdi/amchartsui5controls/Component",
	"io/rtdi/amchartsui5controls/HeatRule" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Component.extend("io.rtdi.amchartsui5controls.Series", {
		metadata: {
            properties: {
            	calculatePercent : {type : "boolean"},
            	hiddenInLegend : {type : "boolean"},
            	ignoreMinMax : {type : "boolean"},
            	itemReaderText : {type : "string"},
            	legendDataItem : {type : "io.rtdi.amchartsui5controls.LegendDataItem"},
            	legendSettings : {type : "io.rtdi.amchartsui5controls.LegendSettings"},
            	minBulletDistance : {type : "float"},
                name : {type : "string"},
            	simplifiedProcessing : {type : "boolean"},
            	skipFocusThreshold : {type : "int"},
            	usePercentHack : {type : "boolean"},
            },
            aggregations: {
            	bullets : {type : "io.rtdi.amchartsui5controls.Sprite"},
            	heatRules:  {type : "io.rtdi.amchartsui5controls.HeatRule", multiple : true},
            }
		},
		init : function() {
		},
		addHeatRule : function(value) {
			this.addAggregation("heatRules", value);
		},
		addBullets : function(value) {
			this.addAggregation("bullets", value);
		},
		createCircleBullets : function() {
			var o = new io.rtdi.amchartsui5controls.CircleBullet();
			this.addBullets(o);
			return o;
		},
		_link : function(o = this._getAm4ChartObject()) {
			io.rtdi.amchartsui5controls.Component.prototype._link(this, arguments);
			var aBullets = this.getAggregation("bullets");
			if (aBullets) {
				aBullets.forEach(function (item) {
					this._getAm4ChartObject().bullets.push(item._getAm4ChartObject());
					item._link();
				}, this);
			}
		},

	});
});
