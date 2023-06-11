sap.ui.require([
	'ui5libs/amcharts/dist/index'
], function() {
});

sap.ui.define([
	"sap/ui/core/library",
	'ui5libs/amcharts/dist/index'
], function(library) {
	"use strict";

	sap.ui.getCore().initLibrary({
		name : "ui5libs.amcharts",
		version: "1.0",
		dependencies : ["sap.ui.core"],
		controls: [
		],
		elements: [
			"ui5libs.amcharts.base.ColorSet"
		],
		modules: [
		]
	});
	
	var thisLib = ui5libs.amcharts;
	
	thisLib.Orientation = {"horizontal": "horizontal", "vertical": "vertical"};
	thisLib.Layout = {"horizontalLayout": "horizontalLayout", "verticalLayout": "verticalLayout", "gridLayout": "gridLayout"};
	thisLib.Position = {"absolute": "absolute", "relative": "relative"};
	thisLib.ShowTooltipOn = {"hover": "hover", "always": "always"};
	thisLib.ToggleKey = {"disabled": "disabled", "active": "active", "none": "none"};
	thisLib.TooltipPosition = {"fixed": "fixed", "pointer": "pointer"};
	thisLib.Wheel = {"zoomX": "zoomX", "zoomY": "zoomY", "zoomXY": "zoomXY", "panX": "panX", "panY": "panY", "panXY": "panXY", "none": "none"};
	thisLib.HighValueGrouped = {"open": "open", "close": "close", "high": "high", "average": "average", "sum": "sum", "extreme": "extreme"};
	thisLib.HighValueShow = {"highValueXWorking": "highValueXWorking", "highValueXChange": "highValueXChange",
							"highValueXChangePercent": "highValueXChangePercent", "highValueXChangeSelection": "highValueXChangeSelection",
							"highValueXChangeSelectionPercent": "highValueXChangeSelectionPercent", "highValueXChangePrevious": "highValueXChangePrevious",
							"highValueXChangePreviousPercent": "highValueXChangePreviousPercent"};
	thisLib.TooltipTarget = {"series": "series", "bullet": "bullet"};
	thisLib.TooltipPosition = {"open": "open", "value": "value", "low": "low", "high": "high"};
	thisLib.DurationBaseUnit = {"millisecond": "millisecond", "second": "second", "minute": "minute", "hour": "hour",
							"day": "day", "week": "week", "month": "month", "year": "year"};
	thisLib.ValueIs = {"area": "area", "height": "height"};
	thisLib.LayoutAlgorithm = {"binary": "binary", "squarify": "squarify", "slice": "slice", "dice": "dice", "sliceDice": "sliceDice"};
	thisLib.NodeAlign = {"left": "left", "right": "right", "justify": "justify", "center": "center"};
	thisLib.Sort = {"ascending": "ascending", "descending": "descending", "none": "none"};
	thisLib.LinkType = {"curve": "curve", "line": "line"};
	thisLib.Pan = {"none": "none", "zoom": "zoom"};
	thisLib.TextDirection = {"ltr": "ltr", "rtl": "rtl"};
	thisLib.FontStyle = {"normal": "normal", "italic": "italic", "oblique": "oblique"};
	thisLib.FontVariant = {"normal": "normal", "small-caps": "small-caps"};
	thisLib.FontWeight = {"normal": "normal", "bold": "bold", "bolder": "bolder", "lighter": "lighter",
						"100": "100", "200": "200", "300": "300", "400": "400", "500": "500", "600": "600", "700": "700", "800": "800", "900": "900"};
	thisLib.OversizedBehavior = {"none": "none", "hide": "hide", "fit": "fit", "wrap": "wrap", "truncate": "truncate"};
	thisLib.TextAlign = {"left": "left", "right": "right", "start": "start", "end": "end", "center": "center"};
	thisLib.TextBaseline = {"top": "top", "hanging": "hanging", "middle": "middle", "alphabetic": "alphabetic",
							"ideographic": "ideographic", "bottom": "bottom"};
	thisLib.TextDecoration = {"underline": "underline"};
	thisLib.PointerOrientation = {"left": "left", "right": "right",
							"up": "up", "down": "down",
							"horizontal": "horizontal", "vertical": "vertical"};
	thisLib.CursorBehavior = {"zoomX": "zoomX", "zoomY": "zoomY",
							"zoomXY": "zoomXY", "selectX": "selectX",
							"selectY": "selectY", "selectXY": "selectXY", "none": "none"};
	thisLib.SnapBy = {"x": "x", "y": "y", "xy": "xy", "x!": "x!", "y!": "y!"};
	thisLib.ClickTarget = {"itemContainer": "itemContainer", "marker": "marker", "none": "none"};
	thisLib.RadialLabelTextType = {"regular": "regular", "circular": "circular", "radial": "radial", "aligned": "aligned", "adjusted": "adjusted"};
	thisLib.GeoPanX = {"none": "none", "rotateX": "rotateX", "translateX": "translateX"};
	thisLib.GeoPanY = {"none": "none", "rotateY": "rotateY", "translateY": "translateY"};
	thisLib.GeoProjection = {"geoAlbersUsa": "geoAlbersUsa", "geoEqualEarth": "geoEqualEarth", "geoEquirectangular": "geoEquirectangular",
							"geoMercator": "geoMercator", "geoNaturalEarth1": "geoNaturalEarth1", "geoOrthographic": "geoOrthographic"};
	thisLib.WheelGeoAction = {"none": "none", "zoom": "zoom", "rotateX": "rotateX", "rotateY": "rotateY"};
	thisLib.DateRanges = {"second": "second", "minute": "minute", "hour": "hour", "day": "day", "weekday": "weekday",
							 "week": "week", "month": "month", "year": "year", "quarter": "quarter"};
	
	
	thisLib._addToSetting = function(oSettings, name, value) {
		if (value !== undefined) {
			oSettings[name] = value;
		}
	};
	thisLib._addFromProperty = function(that, oSettings, name) {
		thisLib._addToSetting(oSettings, name, that.getProperty(name));
	};
	thisLib._addColorFromProperty = function(that, oSettings, name) {
		var value = thisLib.getColor(that.getProperty(name));
		if (value) {
			this._addToSetting(oSettings, name, value);
		}
	};
	thisLib.getColor = function(value) {
		if (value) {
			if (value.startsWith("#")) {
				var n = parseInt("0x" + value.substring(1));
				return am5.color(n);
			} else {
				return am5.Color.fromAny(value);
			}
		}
		return undefined;
	};
	thisLib._addColorSetFromAggregation = function(that, oSettings, name) {
		var prop = that.getAggregation(name);
		if (prop) {
			var value = thisLib.getColorSet(that._root, prop.getBaseColor());
			if (value) {
				this._addToSetting(oSettings, name, value);
			}
		}
	};
	thisLib.getColorSet = function(root, basecolor) {
		return am5.ColorSet.new(root, { "baseColor": thisLib.getColor(basecolor) } );
	};
	thisLib._addNumberPercentFromProperty = function(that, oSettings, name) {
		var value = that.getProperty(name);
		if (value) {
			if (value.endsWith("%")) {
				var n = parseInt(value.substring(0, value.length-1));
				thisLib._addToSetting(oSettings, name, am5.percent(n));
			} else if (value.endsWith("pt")) {
				var n = parseInt(value.substring(0, value.length-2));
				thisLib._addToSetting(oSettings, name, n);
			} else {
				var n = parseInt(value);
				thisLib._addToSetting(oSettings, name, n);
			}
		}
	};
	thisLib.logContainerOp = function(parentContainer, childContainer, operationtext) {
		var left = "id[" + parentContainer.uid + ", " + parentContainer.className + "]." + operationtext + "(";
		var middle = "";
		if (childContainer) {
			middle = childContainer.uid + ", " + childContainer.className;
		}
		console.info(left + middle);
	};

	thisLib.logContainerNewInstance = function(command, settings) {
		var text = "";
		if (settings === undefined) {
			// nothing
		} else if (typeof settings === 'object' ) {
			for (var [key, value] of Object.entries(settings)) {
				if (text.length > 0) {
					text += ", ";
				}
			 	text += key + ":" + value;
			}
		} else {
			text = settings;
		}
		console.info(command + "(" + text + ")");
	};

	return thisLib;
}, /* bExport= */ false);