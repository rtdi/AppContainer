sap.ui.require([
	'ui5libs/amcharts/dist/index',
], function() {
});

sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library',
	'ui5libs/amcharts/dist/index'
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.Entity", {
		metadata: {
            properties: {
				stateAnimationDuration : {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = {};
			this._addFromProperty(oSettings, "stateAnimationDuration")
			return oSettings;
		},
		updateData : function() {
		},
		_addToSetting : function(oSettings, name, value) {
			library._addToSetting(oSettings, name, value);
		},
		_addFromProperty : function(oSettings, name) {
			library._addFromProperty(this, oSettings, name);
		},
		_addNumberPercentFromProperty : function(oSettings, name) {
			library._addNumberPercentFromProperty(this, oSettings, name);
		},
	});
});