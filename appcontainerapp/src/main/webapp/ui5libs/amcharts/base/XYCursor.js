sap.ui.define([
	'ui5libs/amcharts/base/Container',
	'ui5libs/amcharts/library'
], function(Container, library) {
	return Container.extend("ui5libs.amcharts.base.XYCursor", {
		metadata: {
            properties: {
				alwaysShow : {type: "boolean"},
				behavior : {type: "ui5libs.amcharts.CursorBehavior"},
				positionX : {type: "float"},
				positionY : {type: "float"},
				// snapToSeries : {type: "ui5libs.amcharts.base.Series[]"},
				snapToSeriesBy : {type: "ui5libs.amcharts.SnapBy"},
				// syncWith : {type: "ui5libs.amcharts.base.XYCursor[]"},
				xAxisIndex : {type: "int"},
				yAxisIndex : {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = Container.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "alwaysShow");
			this._addFromProperty(oSettings, "behavior");
			this._addFromProperty(oSettings, "positionX");
			this._addFromProperty(oSettings, "positionY");
			this._addFromProperty(oSettings, "snapToSeriesBy");
			var xAxis = this.parentContainer.xAxes.getIndex(this.getXAxisIndex());
			var yAxis = this.parentContainer.yAxes.getIndex(this.getYAxisIndex());
			if (xAxis) {
				oSettings.xAxis = xAxis;
			}
			if (yAxis) {
				oSettings.yAxis = yAxis;
			}
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5xy.XYCursor.new", oSettings);
			return am5xy.XYCursor.new(root, oSettings);
		},
	});
});