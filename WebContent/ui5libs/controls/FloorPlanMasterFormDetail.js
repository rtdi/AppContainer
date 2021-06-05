sap.ui.define([
	'ui5libs/controls/FloorPlanMasterDetail',
	'sap/ui/layout/form/SimpleForm',
	'sap/ui/layout/form/SimpleFormLayout'
], function(FloorPlanMasterDetail, SimpleForm, SimpleFormLayout) {
  return FloorPlanMasterDetail.extend("ui5libs.controls.FloorPlanMasterFormDetail", {
		metadata : {
			properties : {
				masterFormTitle: {type : 'string' },
			},
			defaultAggregation : "content",
			aggregations : {
				content : {
					type : "sap.ui.core.Control",
					multiple : true,
					forwarding: {
						getter: "getSimpleForm",
						aggregation: "content"
					}
				},
			},
			events : {},
		},
		renderer : {},
		init : function() {
			FloorPlanMasterDetail.prototype.init.call(this);
			var oForm = new SimpleForm( { editable: true, layout: SimpleFormLayout.ResponsiveGridLayout } );
			this.setMaster(oForm);
		},
		setMasterFormTitle : function(sText) {
			this.getMaster().setTitle(sText);
		},
		getMasterFormTitle : function() {
			return this.getMaster().getTitle();
		},
		getSimpleForm : function() {
			return this.getMaster();
		}
	});
});
