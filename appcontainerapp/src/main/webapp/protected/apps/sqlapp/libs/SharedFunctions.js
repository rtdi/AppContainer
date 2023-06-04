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

   	};   	
});