sap.ui.define([
	'ui5libs/amcharts/base/Graphics'
], function(Graphics) {
	return Graphics.extend("ui5libs.amcharts.base.AxisRenderer", {
		metadata: {
            properties: {
				cellEndLocation : {type: "float"},
				cellStartLocation : {type: "float"},
				inversed : {type: "boolean"},
				minGridDistance : {type: "int"},
				pan : {type: "ui5libs.amcharts.Pan"},
            },
            aggregations: {
				grid: {type: "ui5libs.amcharts.base.Grid", multiple: false},
				labels: {type: "ui5libs.amcharts.base.AxisLabel", multiple: false},
				ticks: {type: "ui5libs.amcharts.base.AxisTicks", multiple: false},
			},
		},
		_buildSettings : function() {
			var oSettings = Graphics.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "cellEndLocation");
			this._addFromProperty(oSettings, "cellStartLocation");
			this._addFromProperty(oSettings, "inversed");
			this._addFromProperty(oSettings, "minGridDistance");
			this._addFromProperty(oSettings, "pan");
			return oSettings;
		},
		applyAxisRendererTemplates : function() {
			if (this.container) {
				if (this.getGrid()) {
						this.container.get("renderer").grid.template.setAll(this.getGrid()._buildSettings.apply(this.getGrid()));
				}
				if (this.getLabels()) {
						this.container.get("renderer").labels.template.setAll(this.getLabels()._buildSettings.apply(this.getLabels()));
				}
				if (this.getTicks()) {
						this.container.get("renderer").ticks.template.setAll(this.getTicks()._buildSettings.apply(this.getTicks()));
				}
			}
		}

	});
});