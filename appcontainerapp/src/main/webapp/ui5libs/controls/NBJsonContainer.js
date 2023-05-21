sap.ui.define([
	'ui5libs/controls/ModelContainer',
	'ui5libs/contentcontrols/ContentBase',
], function(ModelContainer, ContentBase) {
  return ModelContainer.extend("ui5libs.controls.NBJsonContainer", {
		metadata : {
			properties: {
			},
		},
		createNewModel : function() {
			// Function to find this control's ContentBase control, if present
			var rec = function(control) {
				if (control.getParent()) {
					if (control.getParent() instanceof ContentBase) {
						return control.getParent();
					} else {
						return rec(control.getParent());
					}
				} else {
					return undefined;
				}
			};

			var contentbasecontrol = rec(this);
			if (contentbasecontrol) {
				var nbcell = contentbasecontrol.getParent();
				if (nbcell) {
					var items = nbcell.getParent().getItems();
					var findnext = false;
					// Go through all notebook cells from bottom to top, find our cell. Then find the first SQL cell.
					for ( var i = items.length-1; i>= 0; i--) {
						var c = items[i];
						if (findnext) {
							var editor = c.getContent();
							if (editor["getDataModel"]) {
								var oModel = editor.getDataModel();
					    		this.setModel(oModel);
								return oModel;
							}
						}
						if (c == nbcell) {
							findnext = true;
						}
					}
				}
			}
			return undefined;
		},
		reload : function() {
		},
	});
});
