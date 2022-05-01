sap.ui.define([
	'ui5libs/amcharts/base/Entity'
], function(Entity) {
	return Entity.extend("ui5libs.amcharts.base.DateFormatter", {
		metadata: {
            properties: {
				capitalize : {type: "boolean"},
				dateFields : {type: "string[]"},
				dateFormat : {type: "string"},
				intlLocales : {type: "string"},
            },
		},
		_buildSettings : function() {
			var oSettings = Entity.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "capitalize");
			this._addFromProperty(oSettings, "dateFields");
			this._addFromProperty(oSettings, "dateFormat");
			this._addFromProperty(oSettings, "intlLocales");
			return oSettings;
		},

	});
});