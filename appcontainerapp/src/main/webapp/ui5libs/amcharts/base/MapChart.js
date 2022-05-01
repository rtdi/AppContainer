sap.ui.require([
	'ui5libs/amcharts/dist/map'
], function() {
});

sap.ui.define([
	'ui5libs/amcharts/base/SerialChart',
	'ui5libs/amcharts/library',
	'ui5libs/amcharts/dist/map'
], function(SerialChart, library) {
	return SerialChart.extend("ui5libs.amcharts.base.MapChart", {
		metadata: {
            properties: {
				animationDuration: {type: "int"},
				animationEasing: {type: "function"},
				homeZoomLevel: {type: "float"},
				maxPanOut: {type: "float"},
				maxZoomLevel: {type: "float"},
				minZoomLevel: {type: "float"},
				panX: {type: "ui5libs.amcharts.GeoPanX"},
				panY: {type: "ui5libs.amcharts.GeoPanY"},
				pinchZoom: {type: "boolean"},
				projection: {type: "ui5libs.amcharts.GeoProjection"},
				rotationX: {type: "float"},
				rotationY: {type: "float"},
				rotationZ: {type: "float"},
				wheelDuration: {type: "int"},
				wheelEasing: {type: "function"},
				wheelSensitivity: {type: "float"},
				wheelX: {type: "ui5libs.amcharts.WheelGeoAction"},
				wheelY: {type: "ui5libs.amcharts.WheelGeoAction"},
				zoomLevel: {type: "float"},
				zoomStep: {type: "float"},
            },
            aggregations: {
				homeGeoPoint: {type: "ui5libs.amcharts,base.IGeoPoint", multiple: false},
				zoomControl: {type: "ui5libs.amcharts,base.ZoomControl", multiple: false},
			},
		},
		_buildSettings : function() {
			var oSettings = SerialChart.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "animationDuration");
			this._addFromProperty(oSettings, "animationEasing");
			this._addFromProperty(oSettings, "homeZoomLevel");
			this._addFromProperty(oSettings, "maxPanOut");
			this._addFromProperty(oSettings, "maxZoomLevel");
			this._addFromProperty(oSettings, "minZoomLevel");
			this._addFromProperty(oSettings, "panX");
			this._addFromProperty(oSettings, "panY");
			this._addFromProperty(oSettings, "pinchZoom");
			var projection = this.getProjection();
			if (projection) {
				switch (projection) {
				case "geoAlbersUsa":
					this._addToSetting(oSettings, "projection", am5map.geoAlbersUsa());
					break;
				case "geoEqualEarth":
					this._addToSetting(oSettings, "projection", am5map.geoEqualEarth());
					break;
				case "geoEquirectangular":
					this._addToSetting(oSettings, "projection", am5map.geoEquirectangular());
					break;
				case "geoMercator":
					this._addToSetting(oSettings, "projection", am5map.geoMercator());
					break;
				case "geoNaturalEarth1":
					this._addToSetting(oSettings, "projection", am5map.geoNaturalEarth1());
					break;
				case "geoOrthographic":
					this._addToSetting(oSettings, "projection", am5map.geoOrthographic());
					break;
				}
			}
			this._addFromProperty(oSettings, "rotationX");
			this._addFromProperty(oSettings, "rotationY");
			this._addFromProperty(oSettings, "rotationZ");
			this._addFromProperty(oSettings, "wheelDuration");
			this._addFromProperty(oSettings, "wheelEasing");
			this._addFromProperty(oSettings, "wheelSensitivity");
			this._addFromProperty(oSettings, "wheelX");
			this._addFromProperty(oSettings, "wheelY");
			this._addFromProperty(oSettings, "zoomLevel");
			this._addFromProperty(oSettings, "zoomStep");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5map.MapChart.new", oSettings);
			return am5map.MapChart.new(root, oSettings);
		},

	});
});