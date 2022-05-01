sap.ui.define([
	'ui5libs/controls/ModelContainer'
], function(ModelContainer) {
  return ModelContainer.extend("ui5libs.controls.JsonContainer", {
		metadata : {
			properties: {
			},
		},
		createNewModel : function() {
			var oModel = new sap.ui.model.json.JSONModel(); 
			if (this.getSizeLimit()) {
				oModel.setSizeLimit(this.getSizeLimit());
			}
			var that = this;
			oModel.attachRequestCompleted(function() {
				if (that.getRowTransformations()) {
					for (var transformation of that.getRowTransformations()) {
						transformation.applyTransformation(oModel);
					}
				}
				if (that.getTransformations()) {
					for (var agg of that.getTransformations()) {
						agg.setTransformedData(oModel);
					}
				}
			});
    		this.setModel(oModel);
    		this.reload();
			return oModel;
		},
		reload : function() {
			if (this.getModel()) {
				var url = this.getUrl();
				if (url) {
				if (!url.startsWith("/") && !url.startsWith(".")) {
						url = sap.ui.require.toUrl(url);
					}
					this.getModel().loadData(url);
	    		}
			}
		}
	});
});
