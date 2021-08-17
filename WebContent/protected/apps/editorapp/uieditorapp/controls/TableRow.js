sap.ui.define( [
  'sap/m/ColumnListItem',
  'ui5libs/errorfunctions',
  'ui5app/controls/ToolPaletteButton'
], function(ColumnListItem, errorfunctions) {
	"use strict";    

	return ColumnListItem.extend("ui5app.controls.TableRow", {
		metadata : {
			dnd : {
				draggable : true,
				droppable : true
			},
			properties: {
				linkToTemplate: { type: "string", defaultValue: undefined },
			},
			aggregations: {
				wrappedControl : {type : "sap.ui.core.Control", multiple : false},
			},
			events : {
			},
		},
		renderer : {
			
		},
		init : function() {
			ColumnListItem.prototype.init.apply(this, arguments);
			jQuery.sap.includeStyleSheet(sap.ui.require.toUrl("ui5app/controls/css/ControlWrapper.css"));
			this.setLinkToTemplate(this.getId());
		},
		getLinkToTemplateObject : function() {
			var o = sap.ui.getCore().byId(this.getLinkToTemplate());
			return o;
		},
		findTemplate : function(oControl) {
			/*
			 * If the modified control is part of a template, we want to modify the template instead of the clone
			 */
			if (oControl instanceof ui5app.controls.ControlWrapper) {
				var oTemplate = oControl.getLinkToTemplateObject();
				if (oTemplate) {
					return oTemplate;
				}
			}
			return oControl;
		},
		findListBindingOwner : function(oControl) {
			var o = oControl;
			while (o) {
				if (o instanceof ui5app.controls.ControlWrapper) {
					var oTemplate = o.getControlTemplate();
					if (oTemplate) {
						return o;
					}
				}
				o = o.getParent();
			}
		},
	});
});