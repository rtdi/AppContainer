sap.ui.define([
	'ui5libs/amcharts/base/Hierarchy',
	'ui5libs/amcharts/library'
], function(Hierarchy, library) {
	return Hierarchy.extend("ui5libs.amcharts.base.Treemap", {
		metadata: {
            properties: {
				layoutAlgorithm : {type: "ui5libs.amcharts.LayoutAlgorithm"},
				nodePaddingBottom : {type: "int"},
				nodePaddingInner : {type: "int"},
				nodePaddingLeft : {type: "int"},
				nodePaddingOuter : {type: "int"},
				nodePaddingRight : {type: "int"},
				nodePaddingTop : {type: "int"},
            },
		},
		_buildSettings : function() {
			var oSettings = Hierarchy.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "layoutAlgorithm");
			this._addFromProperty(oSettings, "nodePaddingBottom");
			this._addFromProperty(oSettings, "nodePaddingInner");
			this._addFromProperty(oSettings, "nodePaddingLeft");
			this._addFromProperty(oSettings, "nodePaddingOuter");
			this._addFromProperty(oSettings, "nodePaddingRight");
			this._addFromProperty(oSettings, "nodePaddingTop");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5hierarchy.Treemap.new", oSettings);
			return am5hierarchy.Treemap.new(root, oSettings);
		},

	});
});