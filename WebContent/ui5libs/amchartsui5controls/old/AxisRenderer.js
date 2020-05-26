/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library" ], function(jQuery, library) {
	return io.rtdi.amchartsui5controls.Container.extend("io.rtdi.amchartsui5controls.AxisRenderer", {
		metadata: {
            properties: {
            	axisFills : {type : "io.rtdi.amchartsui5controls.ListTemplate"},
            	cellEndLocation : {type : "float"},
            	cellStartLocation : {type : "float"},
            	fullWidthTooltip : {type : "boolean"},
            	grid : {type : "io.rtdi.amchartsui5controls.ListTemplate"},
            	inside : {type : "boolean"},
            	inversed : {type : "boolean"},
            	labels : {type : "io.rtdi.amchartsui5controls.ListTemplate"},
            	line : {type : "io.rtdi.amchartsui5controls.AxisLine"},
            	maxLabelPosition : {type : "float"},
            	minGridDistance : {type : "float"},
            	minLabelPosition : {type : "float"},
            	opposite : {type : "boolean"},
            	ticks : {type : "io.rtdi.amchartsui5controls.ListTemplate"},
            	tooltipLocation : {type : "float"},
            	tooltipLocation2 : {type : "float"},
            },
		},
		constructor: function(mSettings) {
			io.rtdi.amchartsui5controls.Container.apply(this, arguments);
		},
		_getAxisLabel : function() {
			return undefined;
		},
		_getGrid : function() {
			return undefined;
		},
		getLabels : function() {
			var l = this.getProperty("labels")
			if (!l) {
				l = new io.rtdi.amchartsui5controls.ListTemplate();
				l.setTemplate(this._getAxisLabel());
				this.setProperty("labels", l, true);
			}
			return l;
		},
		getGrid : function() {
			var o = this.getProperty("grid");
			if (!o) {
				o = this._getGrid();
				this.setProperty("grid", o, true);
			}
			return o;
		},
		getLine : function() {
			var o = this.getProperty("line");
			if (!o) {
				o = new io.rtdi.amchartsui5controls.AxisLine();
				this.setProperty("line", o, true);
			}
			return o;
		},

	});
});


