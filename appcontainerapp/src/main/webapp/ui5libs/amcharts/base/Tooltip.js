sap.ui.define([
	'ui5libs/amcharts/base/Container',
	'ui5libs/amcharts/library',
	'ui5libs/amcharts/base/IBounds',
	'ui5libs/amcharts/base/IPoint',
], function(Container, library) {
	return Container.extend("ui5libs.amcharts.base.Tooltip", {
		metadata: {
            properties: {
				animationDuration : {type: "int"},
				animationEasing : {type: "function"},
				autoTextColor : {type: "boolean"},
				bounds : {type: "ui5libs.amcharts.base.IBounds"},
				getFillFromSprite : {type: "boolean"},
				getLabelFillFromSprite : {type: "boolean"},
				getStrokeFromSprite : {type: "boolean"},
				labelText : {type: "string"},
				pointTo : {type: "ui5libs.amcharts.base.IPoint"},
				pointerOrientation : {type: "ui5libs.amcharts.PointerOrientation"},
				tooltipTarget : {type: "ui5libs.amcharts.base.Sprite"},
            },
		},
		setLabelText: function(value) {
			if (value) {
				// The XMLView turns a "\n" into a "\\n" for whatever reason
				this.setProperty("labelText", value.replaceAll("\\n", "\n"), true);
			} else {
				this.setProperty("labelText", value, true);
			}
		},
		_buildSettings : function() {
			var oSettings = Container.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "animationDuration");
			this._addFromProperty(oSettings, "animationEasing");
			this._addFromProperty(oSettings, "autoTextColor");
			this._addFromProperty(oSettings, "bounds");
			this._addFromProperty(oSettings, "getFillFromSprite");
			this._addFromProperty(oSettings, "getLabelFillFromSprite");
			this._addFromProperty(oSettings, "getStrokeFromSprite");
			this._addFromProperty(oSettings, "labelText");
			this._addFromProperty(oSettings, "pointTo");
			this._addFromProperty(oSettings, "pointerOrientation");
			this._addFromProperty(oSettings, "tooltipTarget");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5.Tooltip.new", oSettings);
			return am5.Tooltip.new(root, oSettings);
		},
	});
});