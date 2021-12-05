sap.ui.define( [
  'ui5app/controls/ControlWrapper',
  'ui5app/controls/ToolPaletteButton',
  'ui5app/controls/ToolPaletteImage'
], function(ControlWrapper) {
	"use strict";    
	return ControlWrapper.extend("ui5app.controls.TableCell", {
		metadata : {
			defaultAggregation : "wrappedControl"
		},
		init : function() {
			ControlWrapper.prototype.init.apply(this, arguments);
			this.setSupportModel(false);
			// jQuery.sap.includeStyleSheet(sap.ui.require.toUrl("ui5app/controls/css/ControlWrapper.css"));
			/*
			 * A TableCell cannot be moved or deleted, only its conents
			 */
			var dropinfo = new sap.ui.core.dnd.DropInfo(
				{ 
					"groupName": "controls", 
					"dropPosition": sap.ui.core.dnd.DropPosition.On,
					"drop": this.onDropControl.bind(this)
				}
			);
			this.addDragDropConfig(dropinfo);
		},
		renderer : {
		},
		getLabelText : function() {
			return "TableCell";
		},
		hasProperties : function() {
			return false;
		},
		hasOptionalWrappedControl : function() {
			return true;
		},
		/*
		 * A TableCell is a virtual object, just needed as placeholder. Therefore it does not generate any XML by itself.
		*/
		getDropTarget : function() {
			return this;
		}

	});
});