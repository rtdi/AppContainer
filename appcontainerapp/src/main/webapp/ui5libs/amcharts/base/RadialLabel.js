sap.ui.define([
	'ui5libs/amcharts/base/Label'
], function(Label) {
	return Label.extend("ui5libs.amcharts.base.RadialLabel", {
		metadata: {
            properties: {
				baseRadius : {type: "sap.ui.core.CSSSize"},
				inside : {type: "boolean"},
				kerning : {type: "float"},
				labelAngle : {type: "int"},
				orientation : {type: "float"},
				radius : {type: "int"},
				textType : {type: "ui5libs.amcharts.RadialLabelTextType"},
            },
		},
		_buildSettings : function() {
			var oSettings = Label.prototype._buildSettings.apply(this);
			this._addNumberPercentFromProperty(oSettings, "baseRadius");
			this._addFromProperty(oSettings, "inside");
			this._addFromProperty(oSettings, "kerning");
			this._addFromProperty(oSettings, "labelAngle");
			this._addFromProperty(oSettings, "orientation");
			this._addFromProperty(oSettings, "radius");
			this._addFromProperty(oSettings, "textType");
			return oSettings;
		},
	});
});