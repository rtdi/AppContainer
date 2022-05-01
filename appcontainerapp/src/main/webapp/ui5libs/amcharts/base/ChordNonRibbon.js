sap.ui.define([
	'ui5libs/amcharts/base/Chord',
	'ui5libs/amcharts/library'
], function(Chord, library) {
	return Chord.extend("ui5libs.amcharts.base.ChordNonRibbon", {
		metadata: {
            properties: {
				linkType: {type: "ui5libs.amcharts.LinkType" },
            },
		},
		_buildSettings : function() {
			var oSettings = Chord.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "linkType");
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5flow.ChordNonRibbon.new", oSettings);
			return am5flow.ChordNonRibbon.new(root, oSettings);
		},
	});
});