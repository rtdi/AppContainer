sap.ui.require([
	'ui5libs/amcharts/dist/flow'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/Series',
	'ui5libs/amcharts/dist/flow'
], function(Series) {
	return Series.extend("ui5libs.amcharts.base.Flow", {
		metadata: {
            properties: {
				minSize: {type: "float" },
				nodePadding: {type: "int" },
				nodeWidth: {type: "int" },
				sourceIdField: {type: "string" },
				targetIdField : {type: "string"},
            },
		},
		_buildSettings : function() {
			var oSettings = Series.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "minSize");
			this._addFromProperty(oSettings, "nodePadding");
			this._addFromProperty(oSettings, "nodeWidth");
			this._addFromProperty(oSettings, "sourceIdField");
			this._addFromProperty(oSettings, "targetIdField");
			return oSettings;
		},
	});
});