sap.ui.define([
	'ui5libs/amcharts/Chart',
], function(Chart) {
	return Chart.extend("ui5libs.amcharts.common.ChartControl", {
		metadata: {
            properties: {
            },
		},
		renderer: {},
		init : function() {
			Chart.prototype.init.call(this);
			this.addChild( this.createChart() );
			this.attachModelContextChange(this.onModelChange);
		},
		createChart : function() {
		},
		onModelChange : function(event) {
		},
		getChart : function() {
			return this.getChildren()[0];
		},
		getSeries : function() {
			return getChart().getSeries();
		},
	});
});

