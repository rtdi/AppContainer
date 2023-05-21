sap.ui.define([
], function () {
	"use strict";    
   	return {
		rankColumns : function (sTerm, item) {
			var found = item.name.match(new RegExp(sTerm.replace(/[.*+?^${}()|[\]\\]/g, '\\$&'), "i"));
			if (!found) {
				// if the text is not contained at all, the match rank is 0%
				return 0;
			} else if (item.name.toLowerCase() === sTerm.toLowerCase()) {
				// if the text equals the objectname (ignoring case) it is a perfect match
				return 100;
			} else if (item.name.match(new RegExp(sTerm, "i"))) {
				// The text is part of the name gives a higer ranking. The closer the fit, the higher the rank.
				return Math.max(100 - item.name.length + sTerm.length, 0);
			} else {
				return 0;
			}
		},
		rankTables : function (sTerm, item) {
			var found = item.qualifiershort.match(new RegExp(sTerm.replace(/[.*+?^${}()|[\]\\]/g, '\\$&'), "i"));
			if (!found) {
				// if the text is not contained at all, the match rank is 0%
				return 0;
			} else if (item.objectname.toLowerCase() === sTerm.toLowerCase()) {
				// if the text equals the objectname (ignoring case) it is a perfect match
				return 100;
			} else if (item.objectname.match(new RegExp(sTerm, "i"))) {
				// The text is part of the objectname gives a higer ranking. The closer the fit, the higher the rank.
				return Math.max(100 - item.objectname.length + sTerm.length, 0);
			} else if (item.qualifiershort.toLowerCase() === sTerm.toLowerCase()) {
				// if the text equals the qualifiershort (ignoring case) it is a perfect match
				return 100;
			} else if (item.qualifiershort.match(new RegExp(sTerm, "i"))) {
				// The text is part of the qualifiershort gives a higer ranking. The closer the fit, the higher the rank.
				return Math.max(90 - item.objectname.length + sTerm.length, 0);
			} else {
				return 0;
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