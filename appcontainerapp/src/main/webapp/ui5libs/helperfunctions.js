sap.ui.define([
	"./helperfunctions"
], function () {
	"use strict";    
   	return {
   		encodeURIfull : function (sUri) {
   			if (sUri) {
   				return encodeURIComponent(sUri.replace("/", "%2f"));
   			} else {
   				return sUri; // null
   			}
   		},
		getNativeEditorLink : function (spath) {
			if (!spath) {
				return "";
			} else if (spath.endsWith(".view.xml")) {
				return "../editorapp/uieditorapp/index.html?filename=" + encodeURI(spath);
			} else if (spath.endsWith(".sql")) {
				return "../sqltextapp/index.html?filename=" + encodeURI(spath);
			} else if (spath.endsWith(".sql.json")) {
				return "../sqlapp/index.html?filename=" + encodeURI(spath);
			} else if (spath.endsWith(".nb.json")) {
				return "../sqlnotebook/index.html?filename=" + encodeURI(spath);
			} else {
				return "";
			}
		},
		isTextFile : function (spath) {
			if (!spath) {
				return false;
			}
			spath = spath.toLowerCase();
			if (spath.endsWith(".png")) {
				return false;
			} else if (spath.endsWith(".gif")) {
				return false;
			} else if (spath.endsWith(".jpeg")) {
				return false;
			} else if (spath.endsWith(".sql")) {
				return true;
			} else if (spath.endsWith(".js")) {
				return true;
			} else if (spath.endsWith(".css")) {
				return true;
			} else if (spath.endsWith(".xml")) {
				return true;
			} else if (spath.endsWith(".json")) {
				return true;
			} else if (spath.endsWith(".csv")) {
				return true;
			} else {
				return true;
			}
		}
   	};   	
});
