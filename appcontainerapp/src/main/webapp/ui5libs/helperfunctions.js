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
			} else if (spath.endsWith(".sqlquery")) {
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
			} else if (spath.endsWith(".sqlquery")) {
				return false;
			} else if (spath.endsWith(".js")) {
				return true;
			} else if (spath.endsWith(".css")) {
				return true;
			} else if (spath.endsWith(".xml")) {
				return true;
			} else if (spath.endsWith(".nb.json")) {
				return false;
			} else if (spath.endsWith(".sql.json")) {
				return false;
			} else if (spath.endsWith(".json")) {
				return true;
			} else if (spath.endsWith(".csv")) {
				return true;
			} else {
				return true;
			}
		},
		isActivateable : function (spath) {
			if (!spath) {
				return false;
			}
			spath = spath.toLowerCase();
			if (spath.endsWith(".png")) {
				return true;
			} else if (spath.endsWith(".gif")) {
				return true;
			} else if (spath.endsWith(".jpeg")) {
				return true;
			} else if (spath.endsWith(".sql")) {
				return true;
			} else if (spath.endsWith(".sqlquery")) {
				return false;
			} else if (spath.endsWith(".js")) {
				return true;
			} else if (spath.endsWith(".css")) {
				return true;
			} else if (spath.endsWith(".xml")) {
				return true;
			} else if (spath.endsWith(".nb.json")) {
				return false;
			} else if (spath.endsWith(".sql.json")) {
				return false;
			} else if (spath.endsWith(".json")) {
				return true;
			} else if (spath.endsWith(".csv")) {
				return true;
			} else {
				return true;
			}
		},
		minimalQuotedStringOf : function(qualifier, schema, name) {
			/*
			 * Three cases:
			 * 1. qualifer does not need to be quoted
			 * 2. qualifier must be quoted and consists of the name only
			 * 3. qualifier must be quoted and consists of schema.name and schema must be quoted
			 * 4. qualifier must be quoted and consists of schema.name and name must be quoted
			 * 5. qualifier must be quoted and consists of schema.name and both must be quoted
			 * 6. qualifier must be quoted and schema is empty because the caller provided a single name only
			 */
			var regex = new RegExp('.*?([a-z\\$\\ /]+).*', 'gm');
			if (qualifier.match(regex)) {
				if (!schema) {
					return '"' + qualifier + '"'; // case 6
				} else if (qualifier.startsWith(schema)) {
					if (schema.match(regex)) {
						schema = '"' + schema + '"'; // case 3, 5
					}
					if (name.match(regex)) {
						name = '"' + name + '"'; // case 4, 5
					}
					return schema + "." + name;
				} else {
					return '"' + qualifier + '"'; // case 2
				}
			} else {
				return qualifier; // case 1
			}
		}

   	};   	
});
