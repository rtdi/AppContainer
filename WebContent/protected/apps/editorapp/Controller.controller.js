sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/odata/v4/ODataModel",
	"ui5libs/ui5ajax"], function(Controller, ODataModel, ui5ajax) {
	"use strict";

	return Controller.extend("io.rtdi.hanaappcontainer.editorapp.Controller", {
		onInit : function() {
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
         	var oView = this.getView();
         	var oHeaderText = oView.byId("headertext");
         	oHeaderText.setText("Editing:  " + sFilename);
         	let p = sFilename.lastIndexOf("/");
         	if (p != -1) {
         		document.title = sFilename.substring(p+1);
         	} else {
         		document.title = sFilename;
         	}  
         	var oEditorControl = oView.byId("codeeditor");
         	oEditorControl.focus();
         	if (sFilename.endsWith(".js")) {
         		oEditorControl.setType("javascript");
         	} else if (sFilename.endsWith(".txt")) {
         		oEditorControl.setType("text");
          	} else if (sFilename.endsWith(".xml")) {
         		oEditorControl.setType("xml");
          	} else if (sFilename.endsWith(".sql")) {
         		oEditorControl.setType("sql");
         	}
			/* var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		        if (this.readyState == 4 && this.status == 200) {
		            oEditorControl.setValue(JSON.parse(this.responseText).content); 
		        }
		    };
		    xhttp.open("GET", sap.ui.require.toUrl("ui5rest")+"/editorapp/file/" + sFilename, true);
		    xhttp.setRequestHeader("Content-type", "application/json");
		    xhttp.send(); */
			ui5ajax.ajaxGet(sap.ui.require.toUrl("ui5rest")+"/editorapp/file/" + sFilename)
				.then(
					data => {
						oEditorControl.setValue(JSON.parse(data).content); 
					},
					error => {
						sap.m.MessageToast.show('Call failed with message "' + error + '"');
					}
				);
		},

		onSave : function () {
         	var oView = this.getView();
         	var oEditorControl = oView.byId("codeeditor");
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
			var sContent = oEditorControl.getValue();
			ui5ajax.postText(sap.ui.require.toUrl("ui5rest")+"/editorapp/file/" + sFilename, sContent)
				.then(
					data => {
						sap.m.MessageToast.show('Saved');
					},
					error => {
						sap.m.MessageToast.show('Call failed with message "' + error + '"');
					}
				);
		},

		onActivate: function () {
         	var oView = this.getView();
         	var oEditorControl = oView.byId("codeeditor");
			var sContent = oEditorControl.getValue();
		    const queryString = window.location.search;
		    const urlParams = new URLSearchParams(queryString);
		    const sFilename = urlParams.get('filename');
			ui5ajax.ajaxGet(sap.ui.require.toUrl("ui5rest")+"/activationapp/activate/" + sFilename)
				.then(
					data => {
						sap.m.MessageToast.show('Activated');
					},
					error => {
						sap.m.MessageToast.show('Call failed with message "' + error + '"');
					}
				);
		}

	});

});
