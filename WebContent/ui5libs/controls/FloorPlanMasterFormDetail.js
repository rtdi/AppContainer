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
				master : {
					type : "sap.ui.core.Control",
					multiple : false,
					visible: false
				},
				masterForm : {
					type : "sap.ui.core.Control",
					multiple : true,
					forwarding: {
						getter: "getSimpleForm",
						aggregation: "content",
						forwardBinding: true
					}
				},
			},
			events : {},
		},
		renderer : {},
		init : function() {
			FloorPlanMasterDetail.prototype.init.call(this);
			if (this.getMaster()) {
				this.setMaster(getSimpleForm());
			}
		},
		setMasterFormTitle : function(sText) {
			if (this.getSimpleForm()) {
				this.getSimpleForm().setTitle(sText);
			}
		},
		getMasterFormTitle : function() {
			return this.getSimpleForm().getTitle();
		},
		getSimpleForm : function() {
			var oForm = this.getMaster();
			if (!oForm) {
				oForm = new SimpleForm( { editable: true, layout: SimpleFormLayout.ResponsiveGridLayout } );
				this.setMaster(oForm);
			}
			return oForm;
		}
	});
});
