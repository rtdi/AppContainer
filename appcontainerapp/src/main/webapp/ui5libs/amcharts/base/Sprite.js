sap.ui.define([
	'ui5libs/amcharts/base/Entity'
], function(Entity) {
	return Entity.extend("ui5libs.amcharts.base.Sprite", {
		metadata: {
            properties: {
				active : {type: "boolean"},
				centerX : {type: "sap.ui.core.CSSSize"},
				centerY : {type: "sap.ui.core.CSSSize"},
				cursorOverStyle : {type: "string"},
				dateFormatter : {type: "function"}, // TODO
				disabled : {type: "boolean"},
				draggable : {type: "boolean"},
				durationFormatter : {type: "function"}, // TODO
				dx : {type: "int"},
				dy : {type: "int"},
				exportable : {type: "boolean"},
				forceHidden : {type: "boolean"},
				forceInactive : {type: "boolean"},
				height : {type: "sap.ui.core.CSSSize"},
				interactive : {type: "boolean"},
				isMeasured : {type: "boolean"},
				layer : {type: "int"},
				marginBottom : {type: "int"},
				marginLeft : {type: "int"},
				marginRight : {type: "int"},
				marginTop : {type: "int"},
				maxHeight : {type: "int"},
				maxWidth : {type: "int"},
				minHeight : {type: "int"},
				minWidth : {type: "int"},
				numberFormatter : {type: "function"},
				opacity : {type: "float"},
				position : {type: "ui5libs.amcharts.Position"},
				rotation : {type: "int"},
				scale : {type: "float"},
				showTooltipOn : {type: "ui5libs.amcharts.ShowTooltipOn"},
				toggleKey : {type: "ui5libs.amcharts.ToggleKey"},
				tooltipPosition : {type: "ui5libs.amcharts.TooltipPosition"},
				tooltipText : {type: "string"},
				tooltipX : {type: "sap.ui.core.CSSSize"},
				tooltipY : {type: "sap.ui.core.CSSSize"},
				visible : {type: "boolean"},
				wheelable : {type: "boolean"},
				width : {type: "sap.ui.core.CSSSize"},
				x : {type: "sap.ui.core.CSSSize"},
				y : {type: "sap.ui.core.CSSSize"},
            },
            aggregations: {
				tooltip: {type: "ui5libs.amcharts.base.Tooltip", multiple: false},
			},
		},
		_buildSettings : function() {
			var oSettings = Entity.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "active");
			this._addNumberPercentFromProperty(oSettings, "centerX");
			this._addNumberPercentFromProperty(oSettings, "centerY");
			this._addFromProperty(oSettings, "cursorOverStyle");
			this._addFromProperty(oSettings, "disabled");
			this._addFromProperty(oSettings, "draggable");
			this._addFromProperty(oSettings, "dx");
			this._addFromProperty(oSettings, "dy");
			this._addFromProperty(oSettings, "exportable");
			this._addFromProperty(oSettings, "forceHidden");
			this._addFromProperty(oSettings, "forceInactive");
			this._addNumberPercentFromProperty(oSettings, "height");
			this._addFromProperty(oSettings, "interactive");
			this._addFromProperty(oSettings, "isMeasured");
			this._addFromProperty(oSettings, "layer");
			this._addFromProperty(oSettings, "marginBottom");
			this._addFromProperty(oSettings, "marginLeft");
			this._addFromProperty(oSettings, "marginRight");
			this._addFromProperty(oSettings, "marginTop");
			this._addFromProperty(oSettings, "maxHeight");
			this._addFromProperty(oSettings, "maxWidth");
			this._addFromProperty(oSettings, "opacity");
			this._addFromProperty(oSettings, "position");
			this._addFromProperty(oSettings, "rotation");
			this._addFromProperty(oSettings, "scale");
			this._addFromProperty(oSettings, "showTooltipOn");
			this._addFromProperty(oSettings, "toggleKey");
			this._addFromProperty(oSettings, "tooltipPosition");
			this._addFromProperty(oSettings, "tooltipText");
			this._addNumberPercentFromProperty(oSettings, "tooltipX");
			this._addNumberPercentFromProperty(oSettings, "tooltipY");
			this._addFromProperty(oSettings, "visible");
			this._addFromProperty(oSettings, "wheelable");
			this._addNumberPercentFromProperty(oSettings, "width");
			this._addNumberPercentFromProperty(oSettings, "x");
			this._addNumberPercentFromProperty(oSettings, "y");
			if (this.getTooltip()) {
				var instance = this.getTooltip()._newInstance(this._root, this.getTooltip()._buildSettings());
				this._addToSetting(oSettings, "tooltip", instance);
			}
			return oSettings;
		},

	});
});