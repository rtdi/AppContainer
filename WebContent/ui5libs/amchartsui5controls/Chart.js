/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'sap/ui/core/Control',
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(Control, jQuery, library) {
	return Control.extend("io.rtdi.amchartsui5controls.Chart", {
		metadata: {
            properties: {
                width: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                height: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                _chart: {type : "any"},
            }, 
            aggregations: {
            },
		},
		constructor : function() {
			Control.prototype.constructor.apply(this, arguments);
			var chart = am4core.create(undefined, this._createNewChart());
			this.setProperty("_chart", chart, true);
		},
		renderer : function(oRm, oControl) {
			oRm.write("<div");
			oRm.write(" style=\"width: " + oControl.getWidth() + "; height: " + oControl.getHeight() + ";\" ");
            oRm.writeControlData(oControl);
            oRm.write(">");
			oRm.write("</div>");
		},
		_setValue : function (o, key, value) {
			var aPath = key.split("\\.");
			for (var i = 0; i < aPath.length; i++) {
				var sProperty = aPath[i];
				if (i == aPath.length-1) {
					o[sProperty] = value;
				} else {
					o = o[sProperty];
				}
			}
		},
		getChart : function() {
			return this.getProperty("_chart");
		},
		_createNewChart : function() {
			return undefined;
		},
		createCSSPercentNumber : function(value) {
			return am4core.percent(value);
		},
		createCSSColor : function(value) {
			return am4core.color(value);
		},
		onAfterRendering : function() {
			sap.ui.core.Control.prototype.onAfterRendering.apply(this, arguments);
			this.executeQuery();
			if (this.getProperty("_chart")) {
				this.getProperty("_chart").moveHtmlContainer(this.getDomRef());
			}
		},
		dispose : function() {
			if (this.getProperty("_chart")) {
				this.getProperty("_chart").dispose();
			}
		},
		executeQuery : function() {
		}
	});
});
