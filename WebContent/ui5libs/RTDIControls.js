sap.ui.define(['jquery.sap.global', 
	'sap/ui/core/library', 
	'io/rtdi/hanaappcontainer/codemirror'],
    function(jQuery, library1, codemirror) {
        "use strict";

        sap.ui.getCore().initLibrary({
            name : "io.rtdi.hanaappcontainer",
            dependencies : ["sap.ui.core"],
            types: [],
            interfaces: [],
            controls: [
                "io.rtdi.hanaappcontainer.CodeMirror"
            ],
            elements: [],
            noLibraryCSS: true,
            version: "0.8.3"
        });

        return io.rtdi;
    });