sap.ui.define([
	'ui5libs/controls/ModelContainer',
	'ui5libs/libs/model/json/JSONModelE'
], function(ModelContainer) {
  return ModelContainer.extend("ui5libs.controls.JsonContainer", {
		metadata : {
			properties: {
			},
		},
		createNewModel : function() {
			var oModel = new ui5libs.libs.model.json.JSONModelE(); 
			if (this.getSizeLimit()) {
				oModel.setSizeLimit(this.getSizeLimit());
			}
			oModel.setModelTransformations(this.getModelTransformations());
			oModel.setRowTransformations(this.getRowTransformations());
			var that = this;
			oModel.attachRequestCompleted(function() {
				if (that.getAfterLoad()) {
					that.getAfterLoad().call(this, oModel);
				}
			});
    		this.setModel(oModel);
			this.getModel().loadData(this.getUrl());
			return oModel;
		},
		reload : function() {
			this.getModel().loadData(this.getUrl());
		}
	});
});
