sap.ui.define([
	'ui5libs/amcharts/base/Chord',
	'ui5libs/amcharts/library'
], function(Chord, library) {
	return Chord.extend("ui5libs.amcharts.base.ChordDirected", {
		metadata: {
            properties: {
            },
		},
		_buildSettings : function() {
			var oSettings = Chord.prototype._buildSettings.apply(this);
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5flow.ChordDirected.new", oSettings);
			return am5flow.ChordDirected.new(root, oSettings);
		},
	});
});