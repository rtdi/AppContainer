sap.ui.require([
	'ui5libs/amcharts/dist/geodata/worldLow'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/GeoJson',
	'ui5libs/amcharts/dist/geodata/worldLow'
], function(GeoJson) {
	return GeoJson.extend("ui5libs.amcharts.base.mapdata.WorldLow", {
		metadata: {
            properties: {
            },
		},
		getData : function() {
			return am5geodata_worldLow;
		},
	});
});