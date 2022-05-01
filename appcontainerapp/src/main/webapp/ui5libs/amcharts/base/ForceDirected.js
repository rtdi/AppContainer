sap.ui.define([
	'ui5libs/amcharts/base/LinkedHierarchy',
	'ui5libs/amcharts/library'
], function(LinkedHierarchy, library) {
	return LinkedHierarchy.extend("ui5libs.amcharts.base.ForceDirected", {
		metadata: {
            properties: {
				centerStrength : {type: "float"},
				initialFrames : {type: "int"},
				linkWithStrength : {type: "float"},
				manyBodyStrength : {type: "int"},
				maxRadius : {type: "int"},
				minRadius : {type: "int"},
				nodePadding : {type: "int"},
				showOnFrame : {type: "int"},
				velocityDecay : {type: "float"},
				xField : {type: "string"},
				yField : {type: "string"},
            },
		},
		_buildSettings : function() {
			var oSettings = LinkedHierarchy.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "centerStrength");
			this._addFromProperty(oSettings, "initialFrames");
			this._addFromProperty(oSettings, "linkWithStrength");
			this._addFromProperty(oSettings, "manyBodyStrength");
			this._addFromProperty(oSettings, "maxRadius");
			this._addFromProperty(oSettings, "minRadius");
			this._addFromProperty(oSettings, "nodePadding");
			this._addFromProperty(oSettings, "showOnFrame");
			this._addFromProperty(oSettings, "velocityDecay");
			this._addFromProperty(oSettings, "xField");
			this._addFromProperty(oSettings, "yField");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5hierarchy.ForceDirected.new", oSettings);
			return am5hierarchy.ForceDirected.new(root, oSettings);
		},

	});
});