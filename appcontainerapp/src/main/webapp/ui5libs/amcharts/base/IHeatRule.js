sap.ui.define([
	'sap/ui/core/Element',
	'ui5libs/amcharts/library'
], function(Element, library) {
	return Element.extend("ui5libs.amcharts.base.IHeatRule", {
		metadata: {
            properties: {
				customFunction : {type: "function"},
				dataField : {type: "string"},
				key : {type: "string"},
				logarithmic : {type: "boolean"},
				maxColor : {type: "sap.ui.core.CSSColor"},  // setting max is of type color
				max : {type: "float"},
				maxValue : {type: "float"},
				minColor : {type: "sap.ui.core.CSSColor"},
				min : {type: "float"},
				minValue : {type: "float"},
				targetTemplateName : {type: "string"},
            },
		},
		_buildSettings : function() {
			oSettings = {};
			library._addFromProperty(this, oSettings, "customFunction")
			library._addFromProperty(this, oSettings, "dataField")
			library._addFromProperty(this, oSettings, "key")
			library._addFromProperty(this, oSettings, "logarithmic")
			library._addFromProperty(this, oSettings, "maxValue")
			library._addFromProperty(this, oSettings, "minValue")
			
			if (this.getMaxColor()) {
				var color = library._getColorFromProperty(this, "maxColor");
				library._addToSetting(oSettings, "max", color);
			} else {
				library._addFromProperty(this, oSettings, "max")
			}
			if (this.getMinColor()) {
				var color = library._getColorFromProperty(this, "minColor");
				library._addToSetting(oSettings, "min", color);
			} else {
				library._addFromProperty(this, oSettings, "min")
			}
			if (this.getTargetTemplateName()) {
				library._addToSetting(oSettings, "target", this._root.getTemplate(this.getTargetTemplateName()));
			}
			return oSettings;
		},
	});
});