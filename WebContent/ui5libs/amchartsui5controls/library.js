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
            	// Charts
            	"io.rtdi.amchartsui5controls.Chart",
            	"io.rtdi.amchartsui5controls.SerialChart",
            	"io.rtdi.amchartsui5controls.XYChart",
            	// Axis
            	"io.rtdi.amchartsui5controls.Axis",
            	"io.rtdi.amchartsui5controls.AxisCategory",
            	"io.rtdi.amchartsui5controls.AxisDate",
            	"io.rtdi.amchartsui5controls.AxisValue",
            	"io.rtdi.amchartsui5controls.RadarChartYearAxis",
            	// Series
            	"io.rtdi.amchartsui5controls.Series",
            	// Data
            	"io.rtdi.amchartsui5controls.DataProvider",
            	"io.rtdi.amchartsui5controls.DataProviderOData",
            	"io.rtdi.amchartsui5controls.DataProviderFilter",
            	"io.rtdi.amchartsui5controls.DataProviderFilterEqual"],
            noLibraryCSS: true,
            version: "0.8.3"
        });

        return io.rtdi.amchartsui5controls;
    });