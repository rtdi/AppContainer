sap.ui.define([
	'ui5libs/amcharts/base/Sprite',
	'ui5libs/amcharts/library'
], function(Sprite, library) {
	return Sprite.extend("ui5libs.amcharts.base.Graphics", {
		metadata: {
            properties: {
				fillColor : {type: "sap.ui.core.CSSColor"},
				fillGradient : {type: "object"},
				fillOpacity : {type: "float"},
				fillPattern : {type: "object"},
				shadowBlur : {type: "float"},
				shadowColor : {type: "sap.ui.core.CSSColor"},
				shadowOffsetX : {type: "float"},
				shadowOffsetY : {type: "float"},
				shadowOpacity : {type: "float"},
				stroke : {type: "object"},
				strokeDasharray : {type: "int[]"},
				strokeDashoffset : {type: "float"},
				strokeGradient : {type: "object"},
				strokeOpacity : {type: "float"},
				strokePattern : {type: "object"},
				strokeWidth : {type: "int"},
				svgPath : {type: "string"},
            },
		},
		_buildSettings : function() {
			var oSettings = Sprite.prototype._buildSettings.apply(this);
			if (this.getFillColor()) {
				library._addToSetting(oSettings, "fill", library._getColorFromProperty(this, "fillColor"));
			}
			this._addFromProperty(oSettings, "fillGradient");
			this._addFromProperty(oSettings, "fillOpacity");
			this._addFromProperty(oSettings, "fillPattern");
			this._addFromProperty(oSettings, "shadowBlur");
			library._addColorFromProperty(this, oSettings, "shadowColor");
			this._addFromProperty(oSettings, "shadowOffsetX");
			this._addFromProperty(oSettings, "shadowOffsetY");
			this._addFromProperty(oSettings, "shadowOpacity");
			this._addFromProperty(oSettings, "strokeDasharray");
			this._addFromProperty(oSettings, "strokeDashoffset");
			this._addFromProperty(oSettings, "strokeGradient");
			this._addFromProperty(oSettings, "strokeOpacity");
			this._addFromProperty(oSettings, "strokePattern");
			this._addFromProperty(oSettings, "strokeWidth");
			this._addFromProperty(oSettings, "svgPath");
			return oSettings;
		},

	});
});