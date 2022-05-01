sap.ui.define([
	'ui5libs/amcharts/base/MapSeries',
	'ui5libs/amcharts/library',
], function(MapSeries, library) {
	return MapSeries.extend("ui5libs.amcharts.base.MapPolygonSeries", {
		metadata: {
            properties: {
            },
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5map.MapPolygonSeries.new", oSettings);
			return am5map.MapPolygonSeries.new(root, oSettings);
		},
	});
});