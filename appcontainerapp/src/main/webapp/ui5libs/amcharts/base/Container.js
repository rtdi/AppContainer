sap.ui.define([
	'ui5libs/amcharts/base/Sprite',
	'ui5libs/amcharts/library'
], function(Sprite, library) {
	return Sprite.extend("ui5libs.amcharts.base.Container", {
		metadata: {
            properties: {
				background : {type: "object"},
				layout : {type: "ui5libs.amcharts.Layout"},
				interactiveChildren : {type: "boolean"},
				mask : {type: "object"},
				paddingBottom : {type: "int"},
				paddingLeft : {type: "int"},
				paddingRight : {type: "int"},
				paddingTop : {type: "int"},
				reverseChildren : {type: "boolean"},
				setStateOnChildren : {type: "boolean"},
				verticalScrollbar : {type: "object"},
            },
            aggregations: {
				children: {type: "ui5libs.amcharts.base.Container", multiple: true, singularName: "child"},
				subelements: {type: "ui5libs.amcharts.base.Container", multiple: true, singularName: "subelement"}	
			},
		},
		prepareChart : function() {
			for (var child of getChildren()) {
				child.prepareChart();
			}
			for (var child of getSubelements()) {
				child.prepareChart();
			}
		},
		renderContainer : function() {
			this.buildContainer();
			this.buildSubComponents();
			this.applyTemplates();
		},
		buildContainer : function() {
			var oSettings = this._buildSettings();
			var instance = this._newInstance(this._root, oSettings); 
			this.container = this.parentContainer.children.push(instance);
			library.logContainerOp(this.parentContainer, instance, "children.push");
			if (this.getChildren()) {
				for (var container of this.getChildren()) {
					container.parentContainer = this.container;
					container._root = this._root;
					container.buildContainer();
				}
			}
		},
		buildSubComponents : function() {
			if (this.getChildren()) {
				for (var container of this.getChildren()) {
					container.buildSubComponents();
				}
			}
			if (this.getSubelements()) {
				for (var subelement of this.getSubelements()) {
					var owncontainer = this.getOwnContainer();
					if (owncontainer) {
						var oSettings = subelement._buildSettings();
						var instance = subelement._newInstance(this._root, oSettings); 
						subelement.container = owncontainer.children.push(instance);
						library.logContainerOp(this.parentContainer, instance, "radarContainer.children.push");
					}
				}
			}
		},
		applyTemplates : function() {
			if (this.getChildren()) {
				for (var container of this.getChildren()) {
					container.applyTemplates();
				}
			}
		},
		updateData : function() {
			if (this.getChildren()) {
				for (var container of this.getChildren()) {
					container.updateData();
				}
			}
		},
		_buildSettings : function() {
			var oSettings = Sprite.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "background");
			this._addFromProperty(oSettings, "interactiveChildren");
			this._addFromProperty(oSettings, "mask");
			this._addFromProperty(oSettings, "paddingBottom");
			this._addFromProperty(oSettings, "paddingLeft");
			this._addFromProperty(oSettings, "paddingRight");
			this._addFromProperty(oSettings, "paddingTop");
			this._addFromProperty(oSettings, "reverseChildren");
			this._addFromProperty(oSettings, "setStateOnChildren");
			this._addFromProperty(oSettings, "verticalScrollbar");
			if (this.getProperty("layout")) {
				switch (this.getProperty("layout")) {
				case ui5libs.amcharts.Layout.horizontalLayout:
					this._addToSetting(oSettings, "layout", this._root.horizontalLayout);
					break;
				case ui5libs.amcharts.Layout.verticalLayout:
					this._addToSetting(oSettings, "layout", this._root.verticalLayout);
					break;
				case ui5libs.amcharts.Layout.gridLayout:
					this._addToSetting(oSettings, "layout", this._root.gridLayout);
					break;
				}
			}
			return oSettings;
		},
		_newInstance : function(root, oSettings) {
			library.logContainerNewInstance("am5.Container.new", oSettings);
			return am5.Container.new(root, oSettings);
		},
	});
});