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
			} else if (spath.endsWith(".sql")) {
				return "../sqltextapp/index.html?filename=" + encodeURI(spath);
			} else if (spath.endsWith(".sql.json")) {
				return "../sqlapp/index.html?filename=" + encodeURI(spath);
			} else if (spath.endsWith(".nb.json")) {
				return "../sqlnotebook/index.html?filename=" + encodeURI(spath);
			} else {
				return "../editorapp/index.html?filename=" + encodeURI(spath);
			}
		}
   	};   	
});
