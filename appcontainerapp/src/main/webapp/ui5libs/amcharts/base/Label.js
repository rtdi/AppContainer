sap.ui.define([
	'ui5libs/amcharts/base/Container',
	'ui5libs/amcharts/library'
], function(Container, library) {
	return Container.extend("ui5libs.amcharts.base.Label", {
		metadata: {
            properties: {
				baselineRatio : {type: "float"},
				breakWords : {type: "boolean"},
				direction : {type: "ui5libs.amcharts.TextDirection"},
				ellipsis : {type: "string"},
				fillColor : {type: "sap.ui.core.CSSColor"},
				fontFamily : {type: "string"},
				fontSize : {type: "sap.ui.core.CSSSize"},
				fontStyle : {type: "ui5libs.amcharts.FontStyle"},
				fontVariant : {type: "ui5libs.amcharts.FontVariant"},
				fontWeight : {type: "ui5libs.amcharts.FontWeight"},
				ignoreFormatting : {type: "boolean"},
				lineHeight : {type: "sap.ui.core.CSSSize"},
				minScale : {type: "float"},
				opacity: {type: "float" },
				oversizedBehavior : {type: "ui5libs.amcharts.OversizedBehavior"},
				populateText: {type: "boolean" },
				shadowBlur: {type: "float" },
				shadowColor: {type: "sap.ui.core.CSSColor" },
				shadowOffsetX: {type: "int" },
				shadowOffsetY: {type: "int" },
				shadowOpacity: {type: "float" },
				text: {type: "string" },
				textAlign: {type: "ui5libs.amcharts.TextAlign" },
				textBaseline: {type: "ui5libs.amcharts.TextBaseline" },
				textDecoration: {type: "ui5libs.amcharts.TextDecoration" },
            },
		},
		setText(value) {
			this.setProperty("text", value, true);
			if (this.container) {
				this.container.set("text", value);
			}
		},
		_buildSettings : function() {
			var oSettings = Container.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "baselineRatio");
			this._addFromProperty(oSettings, "breakWords");
			this._addFromProperty(oSettings, "direction");
			this._addFromProperty(oSettings, "ellipsis");
			if (this.getFillColor()) {
				library._addToSetting(oSettings, "fill", library._getColorFromProperty(this, "fillColor"));
			}
			this._addFromProperty(oSettings, "fontFamily");
			this._addFromProperty(oSettings, "fontSize"); // CSS String
			this._addFromProperty(oSettings, "fontStyle");
			this._addFromProperty(oSettings, "fontVariant");
			this._addFromProperty(oSettings, "fontWeight");
			this._addFromProperty(oSettings, "ignoreFormatting");
			this._addNumberPercentFromProperty(oSettings, "lineHeight");
			this._addFromProperty(oSettings, "minScale");
			this._addFromProperty(oSettings, "opacity");
			this._addFromProperty(oSettings, "oversizedBehavior");
			this._addFromProperty(oSettings, "populateText");
			this._addFromProperty(oSettings, "shadowBlur");
			library._addColorFromProperty(this, oSettings, "shadowColor");
			this._addFromProperty(oSettings, "shadowOffsetX");
			this._addFromProperty(oSettings, "shadowOffsetY");
			this._addFromProperty(oSettings, "shadowOpacity");
			this._addFromProperty(oSettings, "text");
			this._addFromProperty(oSettings, "textAlign");
			this._addFromProperty(oSettings, "textBaseline");
			this._addFromProperty(oSettings, "textDecoration");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5.Label.new", oSettings);
			return am5.Label.new(root, oSettings);
		},
	});
});