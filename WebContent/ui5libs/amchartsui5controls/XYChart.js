/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.SerialChart.extend("io.rtdi.amchartsui5controls.XYChart", {
		metadata: {
            properties: {
            }, 
            aggregations: {
                xAxes: {type : "io.rtdi.amchartsui5controls.Axis", multiple : true},
                yAxes: {type : "io.rtdi.amchartsui5controls.Axis", multiple : true},
            }
		},
		renderer : {},
		init : function() {
		},
		addXAxis : function(axis) {
			this.addAggregation("xAxes", axis);
			this.getChart().xAxes.push(axis.getAm4ChartObject());
			axis.initAxis();
			return axis;
		},
		addYAxis : function(axis) {
			this.addAggregation("yAxes", axis);
			this.getChart().yAxes.push(axis.getAm4ChartObject());
			axis.initAxis();
			return axis;
		},
		addNewCategoryXAxis : function() {
			return this.addXAxis(new io.rtdi.amchartsui5controls.AxisCategory());
		},
		addNewCategoryYAxis : function() {
			return this.addYAxis(new io.rtdi.amchartsui5controls.AxisCategory());
		},
		addNewDateXAxis : function() {
			return this.addXAxis(new io.rtdi.amchartsui5controls.AxisDate());
		},
		addNewDateYAxis : function() {
			return this.addYAxis(new io.rtdi.amchartsui5controls.AxisDate());
		},
		addNewValueXAxis : function() {
			return this.addXAxis(new io.rtdi.amchartsui5controls.AxisValue());
		},
		addNewValueYAxis : function() {
			return this.addYAxis(new io.rtdi.amchartsui5controls.AxisValue());
		},
		createCircleBullet : function() {
			return new am4charts.CircleBullet();
		},
		executeQuery : function() {
			io.rtdi.amchartsui5controls.SerialChart.prototype.executeQuery.apply(this, arguments);
			var aXAxes = this.getAggregation("xAxes");
			if (aXAxes) {
				aXAxes.forEach(function(axis) {
					axis.executeQuery();
				}, this);
			};
			var aYAxes = this.getAggregation("yAxes");
			if (aYAxes) {
				aYAxes.forEach(function(axis) {
					axis.executeQuery();
				}, this);
			};
		}

	});
});
