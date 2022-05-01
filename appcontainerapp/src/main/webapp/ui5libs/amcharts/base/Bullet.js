sap.ui.define([
	'ui5libs/amcharts/base/Entity',
	'ui5libs/amcharts/library'
], function(Entity, library) {
	return Entity.extend("ui5libs.amcharts.base.Bullet", {
		metadata: {
            properties: {
				autoRotate : {type: "boolean"},
				autoRotateAngle : {type: "int"},
				dynamic : {type: "boolean"},
				locationX : {type: "float"},
				locationY : {type: "float"},
				templateName : {type: "string"},
            },
            aggregations: {
				sprite: {type: "ui5libs.amcharts.base.Sprite", multiple: false},
			},
		},
		_buildSettings : function() {
			var oSettings = Entity.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "autoRotate");
			this._addFromProperty(oSettings, "autoRotateAngle");
			this._addFromProperty(oSettings, "dynamic");
			this._addFromProperty(oSettings, "locationX");
			this._addFromProperty(oSettings, "locationY");
			if (this.getSprite()) {
				var sprite = this.getSprite()
				var spritesettings = sprite._buildSettings();
				spritesettings.fill = this.parentContainer.get("fill"); // Fill is the same as of the series
				this._addToSetting(oSettings, "sprite", sprite._newInstance(this._root, spritesettings, this._root.getTemplate(this.getTemplateName())));
			}
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			// library.logContainerNewInstance("am5.Bullet.new", oSettings);
			return am5.Bullet.new(root, oSettings);
		},

	});
});