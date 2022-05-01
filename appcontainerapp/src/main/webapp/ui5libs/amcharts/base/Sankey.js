sap.ui.define([
	'ui5libs/amcharts/base/Flow',
	'ui5libs/amcharts/library'
], function(Flow, library) {
	return Flow.extend("ui5libs.amcharts.base.Sankey", {
		metadata: {
            properties: {
				linkTension: {type: "float" },
				nodeAlign: {type: "ui5libs.amcharts.NodeAlign" },
				orientation: {type: "ui5libs.amcharts.Orientation" },
            },
		},
		_buildSettings : function() {
			var oSettings = Flow.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "linkTension");
			this._addFromProperty(oSettings, "nodeAlign");
			this._addFromProperty(oSettings, "orientation");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5flow.Sankey.new", oSettings);
			return am5flow.Sankey.new(root, oSettings);
		},
	});
});