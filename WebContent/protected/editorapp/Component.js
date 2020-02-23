sap.ui.define([
    "sap/ui/core/UIComponent",
    "sap/ui/model/odata/v4/ODataModel"
], function(UIComponent, ODataModel) {
    "use strict";

    return UIComponent.extend("io.rtdi.hanaappcontainer.editorapp", {
        metadata: {
			manifest: "json"
		},
        init : function() {
            // call the init function of the parent
            UIComponent.prototype.init.apply(this, arguments);
        }
    });
});
