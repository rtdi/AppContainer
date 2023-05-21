sap.ui.define([],
	function() {
	"use strict";

	var renderer = {
	};

	renderer.render = function(oRm, oControl) {
		oRm.openStart("div", oControl);
		oRm.addClass("sqlsubquery")
		oRm.writeStyles();
		oRm.openEnd();
		
		oRm.write("<button type='button' class=\"sqlcollabsiblekeyword\" onclick=\"this.classList.toggle('active'); " + 
		"var content = this.nextElementSibling; if (content.style.display === 'none') { content.style.display = 'flex';  } else { content.style.display = 'none'; }\">SELECT</button>");
		oRm.write("<div class='sqlsubqueryunit'>");
			for (var oprojections of oControl.getProjections()) {
				oRm.renderControl(oprojections);
			}
			
			oRm.write("<div class='sqlfrom'>");
				oRm.write("<button type='button' class=\"sqlcollabsiblekeyword\" onclick=\"this.classList.toggle('active'); " + 
				"var content = this.nextElementSibling; if (content.style.display === 'none') { content.style.display = 'flex';  } else { content.style.display = 'none'; }\">FROM</button>");
				oRm.write("<div class='sqlfromunit'>");
					for (var oTable of oControl.getTableexpressions()) {
						oRm.renderControl(oTable);
					}
				oRm.write("</div>");
			oRm.write("</div>");
			
			oRm.write("<div class='sqlwhere'>");
				oRm.write("<button type='button' class=\"sqlcollabsiblekeyword\" onclick=\"this.classList.toggle('active'); " + 
				"var content = this.nextElementSibling; if (content.style.display === 'none') { content.style.display = 'flex';  } else { content.style.display = 'none'; }\">WHERE</button>");
				oRm.write("<div class=\"sqlwhereunit\">");
					for (var oCondition of oControl.getWhereconditions()) {
						oRm.renderControl(oCondition);
					}
				oRm.write("</div>");
			oRm.write("</div>");
		oRm.write("</div>");
		
		oRm.close("div");

	};

	return renderer;

}, /* bExport= */ true);