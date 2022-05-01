sap.ui.define([
	'ui5libs/amcharts/base/Component'
], function(Component) {
	return Component.extend("ui5libs.amcharts.base.Axis", {
		metadata: {
            properties: {
				baseValue : {type: "float"},
				bullet : {type: "function"},
				end : {type: "float"},
				fixAxisSize : {type: "boolean"},
				maxDeviation : {type: "float"},
				maxZoomCount : {type: "int"},
				maxZoomFactor : {type: "float"},
				minZoomCount : {type: "float"},
				panX : {type: "boolean"},
				panY : {type: "boolean"},
				snapTooltip : {type: "boolean"},
				start: {type: "float" },
				tooltipLocation: {type: "float" },
				zoomX: {type: "boolean" },
				zoomY: {type: "boolean" },
            },
            aggregations: {
				ranges: {type: "ui5libs.amcharts.base.axisranges.AxisRange", multiple: true, singlularName: "range" },
			},
		},
		_buildSettings : function() {
			var oSettings = Component.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "baseValue");
			this._addFromProperty(oSettings, "bullet");
			this._addFromProperty(oSettings, "end");
			this._addFromProperty(oSettings, "fixAxisSize");
			this._addFromProperty(oSettings, "maxDeviation");
			this._addFromProperty(oSettings, "maxZoomCount");
			this._addFromProperty(oSettings, "maxZoomFactor");
			this._addFromProperty(oSettings, "minZoomCount");
			this._addFromProperty(oSettings, "panX");
			this._addFromProperty(oSettings, "panY");
			this._addFromProperty(oSettings, "snapTooltip");
			this._addFromProperty(oSettings, "start");
			this._addFromProperty(oSettings, "tooltipLocation");
			this._addFromProperty(oSettings, "zoomX");
			this._addFromProperty(oSettings, "zoomY");
			return oSettings;
		},
		_setComponentData : function() {
			Component.prototype._setComponentData.apply(this);
			if (this.getRanges() && this.container) {
				var that = this;
				this.container.events.on("boundschanged", function() {
					for (var range of that.getRanges()) {
						var start = that.container.getPrivate("min");
						var end = that.container.getPrivate("max");
						range.parentContainer = that.container;
						range._root = that._root;
						range.buildRanges(start, end);
					}
				});
			}
		},
	});
});