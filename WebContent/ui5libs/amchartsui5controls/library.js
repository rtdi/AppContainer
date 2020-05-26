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
            	"io.rtdi.amchartsui5controls.Chart",
            	"io.rtdi.amchartsui5controls.SerialChart",
            	"io.rtdi.amchartsui5controls.XYChart"],
            noLibraryCSS: true,
            version: "0.8.3"
        });

        return io.rtdi.amchartsui5controls;
    });