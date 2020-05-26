/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Grid.extend("io.rtdi.amchartsui5controls.GridCircular", {
		metadata: {
            properties: {
            	innerRadius : {type : "any"},
            	radius : {type : "any"},
            },
		},
		constructor: function(mSettings) {
			io.rtdi.amchartsui5controls.Container.apply(this, arguments);
		},
		setRadiusPercent : function(value) {
			this.setRadius(am4core.percent(value));
		},
		setInnerRadiusPercent : function(value) {
			this.setInnerRadius(am4core.percent(value));
		},

	});
});


