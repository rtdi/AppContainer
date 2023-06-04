sap.ui.define([
	'ui5libs/amcharts/common/ChartControl',
	'ui5libs/amcharts/base/PieChart',
	'ui5libs/amcharts/library',
	'ui5libs/amcharts/base/PieSeries',
	'ui5libs/amcharts/base/ColorSet'
], function(ChartControl, PieChart, library) {
	return ChartControl.extend("ui5libs.amcharts.common.charts_1c_1m.PieChartControl", {
		metadata: {
            properties: {
				endAngle: {type: "int"},
				innerRadius: {type: "sap.ui.core.CSSSize"},
				radius: {type: "sap.ui.core.CSSSize"},
				startAngle: {type: "int"},
            },
		},
		renderer: {},
		init : function() {
			ChartControl.prototype.init.call(this);
			var props = this.getMetadata().getProperties();
			var that = this;
		},
		createChart : function() {
			return new PieChart();
		},
		onModelChange : function(event) {
			var control = event.getSource();
			var piechart = control.getChart();
			var model = control.getModel();
			if (model) {
				var categories = model.getCategoryColumns();
				var measures = model.getMeasureColumns();
				piechart.removeAllSeries();
				if (categories && measures) {
					for ( var i = 0; i < categories.length && i < measures.length; i++) {
						piechart.addSeries( new ui5libs.amcharts.base.PieSeries( {
							name: "Series",
							categoryField: categories[i].name,
							valueField: measures[i].name,
							componentData: "{/resultsets/0/rows}",
							colors: new ui5libs.amcharts.base.ColorSet( { baseColor: 'rgba(1,100,133,0.4)' }),
						}) );
					}
				}
			}
		},
		setEndAngle : function(value) {
			this.setProperty("endAngle", value);
			this.getChart().setEndAngle(value);
		},
		setStartAngle : function(value) {
			this.setProperty("startAngle", value);
			this.getChart().setStartAngle(value);
		},
		setRadius : function(value) {
			this.setProperty("radius", value);
			this.getChart().setRadius(value);
		},
		setInnerRadius : function(value) {
			this.setProperty("innerRadius", value);
			this.getChart().setInnerRadius(value);
		},
	});
});

