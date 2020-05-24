/* global am4core:true */
/* global am4charts:true */
sap.ui.define([
	'jquery.sap.global',
	'sap/ui/core/library'],
    function(jQuery, library) {
        "use strict";

        sap.ui.getCore().initLibrary({
            name : "io.rtdi.amchartsui5controls",
            dependencies : ["sap.ui.core"],
            types: [],
            interfaces: [],
            controls: [
                "io.rtdi.amchartsui5controls.RadarChart"
            ],
            elements: [
            	"io.rtdi.amchartsui5controls.Container",
            	"io.rtdi.amchartsui5controls.Component",
            	"io.rtdi.amchartsui5controls.ComponentDataFields",
            	"io.rtdi.amchartsui5controls.DataSource",
            	"io.rtdi.amchartsui5controls.CategoryAxisDataFields",
            	"io.rtdi.amchartsui5controls.ColumnSeriesDataFields",
            	"io.rtdi.amchartsui5controls.ColumnSeries",
            	"io.rtdi.amchartsui5controls.Tooltip",
            	"io.rtdi.amchartsui5controls.DataItem",
            	"io.rtdi.amchartsui5controls.Label",
            	"io.rtdi.amchartsui5controls.LegendSettings",
            	"io.rtdi.amchartsui5controls.LegendDataItem",
            	"io.rtdi.amchartsui5controls.AxisLabel",
            	"io.rtdi.amchartsui5controls.AxisRenderer",
            	"io.rtdi.amchartsui5controls.AxisLine",
            	"io.rtdi.amchartsui5controls.AxisDataFields",
            	"io.rtdi.amchartsui5controls.AxisRendererCircular",
            	"io.rtdi.amchartsui5controls.ListTemplate",
            	"io.rtdi.amchartsui5controls.RadarSeries",
            	"io.rtdi.amchartsui5controls.RadarColumn",
            	"io.rtdi.amchartsui5controls.RoundedRectangle",
            	"io.rtdi.amchartsui5controls.Column",
            	"io.rtdi.amchartsui5controls.LineSeries",
            	"io.rtdi.amchartsui5controls.ValueAxisDataFields",
            	"io.rtdi.amchartsui5controls.XYSeries",
            	"io.rtdi.amchartsui5controls.XYSeriesDataFields",
            	"io.rtdi.amchartsui5controls.RadarColumnSeriesDataFields",
            	"io.rtdi.amchartsui5controls.RadarSeriesDataFields",
            	"io.rtdi.amchartsui5controls.LineSeriesDataFields",
            	"io.rtdi.amchartsui5controls.CategoryAxis",
            	"io.rtdi.amchartsui5controls.ValueAxis",
            	"io.rtdi.amchartsui5controls.RadarSeries",
            	"io.rtdi.amchartsui5controls.RadarColumnSeries",
            	"io.rtdi.amchartsui5controls.Chart",
            	"io.rtdi.amchartsui5controls.SerialChart",
            	"io.rtdi.amchartsui5controls.XYChart",
            	"io.rtdi.amchartsui5controls.DateFormatter",
            	"io.rtdi.amchartsui5controls.Bullet",
            	"io.rtdi.amchartsui5controls.Circle"],
            noLibraryCSS: true,
            version: "0.8.3"
        });

        return io.rtdi.amchartsui5controls;
    });