sap.ui.require([
	'ui5libs/amcharts/dist/xy'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/SerialChart',
	'ui5libs/amcharts/library',
	'ui5libs/amcharts/dist/xy'
], function(SerialChart, library) {
	return SerialChart.extend("ui5libs.amcharts.base.XYChart", {
		metadata: {
            properties: {
				arrangeTooltips: {type: "boolean"},
				maxTooltipDistance: {type: "int"},
				panX: {type: "boolean"},
				panY: {type: "boolean"},
				pinchZoomX: {type: "boolean"},
				pinchZoomY: {type: "boolean"},
				scrollbarX: {type: "object"},
				scrollbarY: {type: "object"},
				wheelStep: {type: "float"},
				wheelX: {type: "ui5libs.amcharts.Wheel"},
				wheelY: {type: "ui5libs.amcharts.Wheel"},
            },
            aggregations: {
				xAxis: {type: "ui5libs.amcharts.base.Axis", multiple: true, singularName: "xAxis"},
				yAxis: {type: "ui5libs.amcharts.base.Axis", multiple: true, singularName: "yAxis"},
				rendererX: {type: "ui5libs.amcharts.base.AxisRendererX", multiple: true},
				rendererY: {type: "ui5libs.amcharts.base.AxisRendererY", multiple: true},
				cursor: {type: "ui5libs.amcharts.base.XYCursor", multiple: false},
			},
		},
		_buildSettings : function() {
			var oSettings = SerialChart.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "arrangeTooltips");
			this._addFromProperty(oSettings, "maxTooltipDistance");
			this._addFromProperty(oSettings, "panX");
			this._addFromProperty(oSettings, "panY");
			this._addFromProperty(oSettings, "pinchZoomX");
			this._addFromProperty(oSettings, "pinchZoomY");
			this._addFromProperty(oSettings, "scrollbarX");
			this._addFromProperty(oSettings, "scrollbarY");
			this._addFromProperty(oSettings, "wheelStep");
			this._addFromProperty(oSettings, "wheelX");
			this._addFromProperty(oSettings, "wheelY");
			return oSettings;
		},
		buildContainer : function() {
			SerialChart.prototype.buildContainer.apply(this);
			if (this.getXAxis()) {
				for (var i=0; i<this.getXAxis().length; i++) {
					var axis = this.getXAxis()[i];
					axis.parentContainer = this.container;
					axis._root = this._root;
					var oAxisSettings = axis._buildSettings();
					var renderer;
					if (this.getRendererX() && this.getRendererX().length > i) {
						renderer = this.getRendererX()[i];
						var rendererSettings = renderer._buildSettings();
						oAxisSettings.renderer = renderer._newInstance(this._root, rendererSettings);
					} else {
						oAxisSettings.renderer = am5xy.AxisRendererX.new(this._root, {});
						library.logContainerNewInstance("am5xy.AxisRendererY.new", {});
					}
					var instance = axis._newInstance(this._root, oAxisSettings);
					var container = this.container.xAxes.push(instance);
					library.logContainerOp(this.container, instance, "xAxes.push");
					axis.container = container;
					axis.applyTemplates();
					if (renderer) {
						renderer.container = container;
						renderer._root = this._root;
						renderer.applyAxisRendererTemplates();
					}
				}
			}
			if (this.getYAxis()) {
				for (var i=0; i<this.getYAxis().length; i++) {
					var axis = this.getYAxis()[i];
					axis.parentContainer = this.container;
					axis._root = this._root;
					var oAxisSettings = axis._buildSettings();
					var renderer;
					if (this.getRendererY() && this.getRendererY().length > i) {
						renderer = this.getRendererY()[i];
						var rendererSettings = renderer._buildSettings();
						oAxisSettings.renderer = renderer._newInstance(this._root, rendererSettings);
					} else {
						oAxisSettings.renderer = am5xy.AxisRendererY.new(this._root, {});
						library.logContainerNewInstance("am5xy.AxisRendererY.new", {});
					}
					var instance = axis._newInstance(this._root, oAxisSettings);
					var container = this.container.yAxes.push(instance);
					library.logContainerOp(this.container, instance, "yAxes.push");
					axis.container = container;
					axis.applyTemplates();
					if (renderer) {
						renderer.container = container;
						renderer._root = this._root;
						renderer.applyAxisRendererTemplates();
					}
				}
			}
		},
		buildSubComponents : function() {
			SerialChart.prototype.buildSubComponents.apply(this);
			if (this.getCursor()) {
				var cursor = this.getCursor();
				cursor.parentContainer = this.container;
				cursor._root = this._root;
				var oCursorSettings = cursor._buildSettings();
				var c = cursor._newInstance(this._root, oCursorSettings);
				library.logContainerOp(this.container, c, "set(cursor");
				this.container.set("cursor", c);
			}
		},
		updateData : function() {
			SerialChart.prototype.updateData.apply(this);
			if (this.getXAxis()) {
				for (var axis of this.getXAxis()) {
					axis.updateData();
				}
			}
			if (this.getYAxis()) {
				for (var axis of this.getYAxis()) {
					axis.updateData();
				}
			}
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.XYChart.new", oSettings);
			return am5xy.XYChart.new(root, oSettings);
		},

	});
});