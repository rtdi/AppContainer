sap.ui.define([
	'ui5libs/amcharts/base/Flow',
	'ui5libs/amcharts/library'
], function(Flow, library) {
	return Flow.extend("ui5libs.amcharts.base.Chord", {
		metadata: {
            properties: {
				nodeWidth: {type: "int" },
				padAngle: {type: "int" },
				radius: {type: "sap.ui.core.CSSSize" },
				sort: {type: "ui5libs.amcharts.Sort" },
				startAngle: {type: "int" },
            },
		},
		_buildSettings : function() {
			var oSettings = Flow.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "nodeWidth");
			this._addFromProperty(oSettings, "padAngle");
			this._addNumberPercentFromProperty(oSettings, "radius");
			this._addFromProperty(oSettings, "sort");
			this._addFromProperty(oSettings, "startAngle");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5flow.Chord.new", oSettings);
			return am5flow.Chord.new(root, oSettings);
		},
	});
});