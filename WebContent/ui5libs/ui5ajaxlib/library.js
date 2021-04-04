sap.ui.define([
	"sap/ui/core/library"
], function(library) {
	"use strict";

	sap.ui.getCore().initLibrary({
		name : "ui5libs.ui5ajaxlib",
		version: "${version}",
		dependencies : ["sap.ui.core"],
		controls: [
			"ui5libs.ui5ajaxlib.ui5ajax"
		],
		modules: [
		]
	});
	
	function postJson(sUri, sJson, okText) {
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.open("POST", sUri);
			xmlhttp.setRequestHeader("Content-Type", "application/json");
			xmlhttp.onreadystatechange = function() {
			    if (xmlhttp.readyState == 4) {
			    	if (xmlhttp.status == 200) {
						sap.m.MessageToast.show(okText);
				    } else {
				    	sap.m.MessageToast.show('Call failed with message "' + this.responseText + '"');
				    }
				}
			}
			xmlhttp.send(sJson);
   	};
   		
    function postText(sUri, sText, okText) {
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.open("POST", sUri);
			xmlhttp.setRequestHeader("Content-Type", "text/plain");
			xmlhttp.onreadystatechange = function() {
			    if (xmlhttp.readyState == 4) {
			    	if (xmlhttp.status == 200) {
						sap.m.MessageToast.show(okText);
				    } else {
				    	sap.m.MessageToast.show('Call failed with message "' + this.responseText + '"');
				    }
				}
			}
			xmlhttp.send(sText);
   	};
   	
   	function postModel(sUri, oJsonModel, okText) {
   			this.postJson(sUri, oJsonModel.getJSON(), okText);
   	};
	

	return ui5libs.ui5ajaxlib;
}, /* bExport= */ false);