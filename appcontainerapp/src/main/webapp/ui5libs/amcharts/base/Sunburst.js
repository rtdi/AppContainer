sap.ui.define([
	'ui5libs/amcharts/base/Partition',
	'ui5libs/amcharts/library'
], function(Partition, library) {
	return Partition.extend("ui5libs.amcharts.base.Sunburst", {
		metadata: {
            properties: {
				endAngle: {type: "int"},
				innerRadius: {type: "sap.ui.core.CSSSize"},
				radius: {type: "sap.ui.core.CSSSize"},
				startAngle: {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = Partition.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "endAngle");
			this._addNumberPercentFromProperty(oSettings, "innerRadius");
			this._addNumberPercentFromProperty(oSettings, "radius");
			this._addFromProperty(oSettings, "startAngle");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5hierarchy.Sunburst.new", oSettings);
			return am5hierarchy.Sunburst.new(root, oSettings);
		},

	});
});