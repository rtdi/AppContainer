sap.ui.define([
	'ui5libs/amcharts/base/XYSeries'
], function(XYSeries) {
	return XYSeries.extend("ui5libs.amcharts.base.BaseColumnSeries", {
		metadata: {
            properties: {
				adjustBulletPosition : {type: "boolean"},
				clustered : {type: "boolean"},
            },
		},
		_buildSettings : function() {
			var oSettings = XYSeries.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "adjustBulletPosition");
			this._addFromProperty(oSettings, "clustered");
			return oSettings;
		},
		getDefaultTemplate : function() {
			return this.container.columns.template;
		},
	});
});