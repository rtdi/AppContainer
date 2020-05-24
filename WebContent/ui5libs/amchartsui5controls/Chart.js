/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'sap/ui/core/Control',
	"jquery.sap.global",
	"io/rtdi/amchartsui5controls/library"], function(Control, jQuery, library) {
	return Control.extend("io.rtdi.amchartsui5controls.Chart", {
		metadata: {
            properties: {
            	// Component
                data : {type : "any" },
                dataFields : {type : "io.rtdi.amchartsui5controls.ComponentDataFields" },
                dataItems : {type : "io.rtdi.amchartsui5controls.DataItem"},
                dataSource : {type : "io.rtdi.amchartsui5controls.DataSource" },
                interpolationDuration : {type : "int" },
                maxZoomCount : {type : "int" },
                maxZoomFactor : {type : "float" },
                minZoomCount : {type : "int" },
                rangeChangeDuration : {type : "int" },
                sequencedInterpolation : {type : "boolean" },
                sequencedInterpolationDelay : {type : "int" },
                skipRangeEvent : {type : "boolean" },
                start : {type : "float" },

                // Container
            	contentAlign : {type : "string"},
            	contentValign : {type : "string"},
            	fixedWidthGrid : {type : "boolean"},
            	fontFamily : {type : "string"},
            	fontSize : {type : "any"},
            	fontWeight : {type : "any"},
            	layout : {type : "any"},
            	contentAlign : {type : "string"},
            	maxColumns : {type : "int"},
            	minHeight : {type : "float"},
            	minWidth : {type : "float"},
            	reverseOrder : {type : "boolean"},
            	setStateOnChildren : {type : "boolean"},
            	textDecoration : {type : "string"},

            	// Sprite
            	align : {type : "string"},
            	contextMenuDisabled : {type : "boolean"},
            	cursorDownStyle : {type : "string"},
            	cursorOverStyle : {type : "string"},
            	dateFormatterDateFormat : {type : "string"},
            	disabled : {type : "boolean"},
            	draggable : {type : "boolean"},
            	durationFormatter : {type : "any"},
            	dx : {type : "float"},
            	dy : {type : "float"},
            	fill : {type : "any"},
            	fillModifier : {type : "any"},
            	fillOpacity : {type : "float"},
            	focusable : {type : "boolean"},
            	// height : {type : "any"},
            	hidden : {type : "boolean"},
            	horizontalCenter : {type : "any"},
            	hoverOnFocus : {type : "boolean"},
            	hoverable : {type : "boolean"},
            	inert : {type : "boolean"},
            	interactionsEnabled : {type : "boolean"},
            	marginBottom : {type : "any"},
            	marginLeft : {type : "any"},
            	marginRight : {type : "any"},
            	marginTop : {type : "any"},
            	maxHeight : {type : "float"},
            	maxWidth : {type : "float"},
            	minHeight : {type : "any"},
            	minWidth : {type : "any"},
            	mouseOptions : {type : "any"},
            	nonScaling : {type : "boolean"},
            	nonScalingStroke : {type : "boolean"},
            	numberFormatterNumberFormat  : {type : "string"},
            	opacity : {type : "float"},
            	paddingBottom : {type : "any"},
            	paddingLeft : {type : "any"},
            	paddingRight : {type : "any"},
            	paddingTop : {type : "any"},
            	readerDescription : {type : "string"},
            	readerHidden : {type : "boolean"},
            	readerOrientation : {type : "string"},
            	readerTitle : {type : "string"},
            	readerValueNow : {type : "string"},
            	readerValueText : {type : "string"},
            	realFill : {type : "any"},
            	realStroke : {type : "any"},
            	resizable : {type : "string"},
            	rotation : {type : "float"},
            	rtl : {type : "string"},
            	scale : {type : "float"},
            	showOnInit : {type : "string"},
            	showSystemTooltip : {type : "boolean"},
            	showTooltipOn : {type : "string"},
            	stroke : {type : "any"},
            	strokeDasharray : {type : "string"},
            	strokeDashoffset : {type : "float"},
            	strokeLinecap : {type : "string"},
            	strokeLinejoin : {type : "string"},
            	strokeModifier : {type : "any"},
                strokeOpacity : {type : "float"},
                strokeWidth : {type : "float"},
                swipeable : {type : "boolean"},
                tabindex : {type : "int"},
                tooltip : {type : "io.rtdi.amchartsui5controls.Tooltip"},
                tooltipDataItem : {type : "io.rtdi.amchartsui5controls.DataItem"},
                tooltipHTML : {type : "string"},
                tooltipPosition : {type : "string"},
                tooltipText : {type : "string"},
                tooltipX : {type : "any"},
                tooltipY : {type : "any"},
                trackable : {type : "boolean"},
                url : {type : "string"},
                urlTarget : {type : "string"},
                valign : {type : "any"},
                verticalCenter : {type : "any"},
                visible : {type : "boolean"},
                wheelable : {type : "boolean"},
                // width : {type : "any"},
                x : {type : "float"},
                y : {type : "float"},
                zIndex : {type : "int"},

                width: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                height: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                titles : {type : "io.rtdi.amchartsui5controls.ListTemplate"},
                _chart: {type : "any", visibility: "hidden"}
            }, 
            aggregations: {
            },
		},
		init : function() {
		},
		renderer : function(oRm, oControl) {
			oRm.write("<div");
			oRm.write(" style=\"width: " + oControl.getWidth() + "; height: " + oControl.getHeight() + ";\" ");
            oRm.writeControlData(oControl);
            oRm.write(">");
			oRm.write("</div>");
		},
		_setValue : function (propertyname, o) {
			var value = this.getProperty(propertyname)
			if (value) {
				if (value instanceof io.rtdi.amchartsui5controls.RootWrapper) {
					if (value._getAm4ChartObject()) {
						o[propertyname] = value._getAm4ChartObject();
					} else {
						value._link(o[propertyname]);
					}
				} else {
					o[propertyname] = value;
				}
			}

		},
		getChart : function() {
			return this.getProperty("_chart");
		},
		chartRendering : function(chart) {
		},
		_link : function(o = this.getChart()) {
			Object.keys(this.getMetadata().getAllProperties()).forEach(function (name) {
				if (name.charAt(0) !== "_") {
					this._setValue(name, o);
				}
			}, this);
		},
		getDataSource : function() {
			var l = this.getProperty("dataSource");
			if (!l) {
				l = new io.rtdi.amchartsui5controls.DataSource();
				this.setProperty("dataSource", l, true);
			}
			return l;
		},
		_createNewChart : function() {
			return undefined;
		},
		onAfterRendering : function() {
			sap.ui.core.Control.prototype.onAfterRendering.apply(this, arguments); // run the super class's method first
			if (this.getProperty("_chart")) {
				/*
				 * Safety net
				 */
				this.getProperty("_chart").dispose();
			}
			var chart = am4core.create(this.getDomRef(), this._createNewChart());
			chart.dataSource.events.on("parseended", function(ev) {
				  // parsed data is assigned to data source's `data` property
				  var data = ev.target.data;
				  ev.target.data = data.value;
				});
			this.setProperty("_chart", chart, true);
			this._link();
			this.chartRendering(chart);
		},
		dispose : function() {
			if (this.getProperty("_chart")) {
				this.getProperty("_chart").dispose();
			}
		},
	});
});
