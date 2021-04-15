sap.ui.define(['jquery.sap.global', 'sap/ui/core/library'],
    function(jQuery, library1) {
        "use strict";

        sap.ui.getCore().initLibrary({
            name : "io.rtdi.appcontainer.editorapp.uieditorcontrols",
            dependencies : ["sap.ui.core"],
            types: [],
            interfaces: [],
            controls: [
                "io.rtdi.appcontainer.editorapp.uieditorcontrols.Button"
            ],
            elements: [],
            noLibraryCSS: true,
            version: "0.8.3"
        });

        return io.rtdi.appcontainer.editorapp.uieditorcontrols;
    });