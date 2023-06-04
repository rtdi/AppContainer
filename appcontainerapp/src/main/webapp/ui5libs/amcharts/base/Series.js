sap.ui.define([
	'ui5libs/amcharts/base/Component',
	'ui5libs/amcharts/library'
], function(Component, library) {
	return Component.extend("ui5libs.amcharts.base.Series", {
		metadata: {
            properties: {
				calculateAggregates : {type: "boolean"},
				fill : {type: "object"},
				idField : {type: "string"},
				legendLabelText : {type: "string"},
				legendValueText : {type: "string"},
				name : {type: "string"},
				sequencedDelay : {type: "int"},
				sequencedInterpolation : {type: "boolean"},
				stroke : {type: "object"},
				valueField: {type: "string" },
				templateName: {type: "string" },
            },
            aggregations: {
				legend: {type: "ui5libs.amcharts.base.Legend", multiple: false},
				heatRules: {type: "ui5libs.amcharts.base.IHeatRule", multiple: true},
				bullets: {type: "ui5libs.amcharts.base.Bullet", multiple: true},
			},
		},
		prepareChart : function() {
		},
		_buildSettings : function() {
			var oSettings = Component.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "calculateAggregates");
			this._addFromProperty(oSettings, "fill");
			this._addFromProperty(oSettings, "idField");
			this._addFromProperty(oSettings, "legendLabelText");
			this._addFromProperty(oSettings, "legendValueText");
			this._addFromProperty(oSettings, "name");
			this._addFromProperty(oSettings, "sequencedDelay");
			this._addFromProperty(oSettings, "sequencedInterpolation");
			this._addFromProperty(oSettings, "stroke");
			this._addFromProperty(oSettings, "valueField");
			return oSettings;
		},
		buildSubComponents : function() {
			Component.prototype.buildSubComponents.apply(this);
			if (this.getTemplateName()) {
				this._root.addTemplate(this.getTemplateName(), this.getDefaultTemplate());
			}
			if (this.getLegend()) {
				var legend = this.getLegend();
				legend.parentContainer = this.parentContainer; // legend is part of the chart, not the series
				legend._root = this._root;
				legend.buildContainer();
			}
			if (this.getBullets()) {
				for (var i=0; i<this.getBullets().length; i++) {
					var bullet = this.getBullets()[i];
					bullet.parentContainer = this.container;
					bullet._root = this._root;
					/*
					 * The bullet settings are created on demand but the template must be created upfront
					 */
					if (bullet.getTemplateName()) {
						var template = am5.Template.new({});
						this._root.addTemplate(bullet.getTemplateName(), template);
					}
					this.container.bullets.push( function() { 
						var bulletSettings = bullet._buildSettings();
						return bullet._newInstance(bullet._root, bulletSettings); 
					} );
					library.logContainerOp(this.container, undefined, "bullets.push");
				}
			}
			if (this.getHeatRules()) {
				var arulesettings = [];
				for (var i=0; i<this.getHeatRules().length; i++) {
					var rule = this.getHeatRules()[i];
					rule._root = this._root;
					rule.parentContainer = this.container;
					var rulesettings = rule._buildSettings();
					arulesettings.push(rulesettings);
					library.logContainerOp(this.container, rulesettings.target, "heatRules.push");
				}
				this.container.set("heatRules", arulesettings);
			}
		},
		_setComponentData : function() {
			Component.prototype._setComponentData.apply(this);
			if (this.getLegend()) {
				var legend = this.getLegend().container;
				if (legend) {
					if (this.getComponentData() && this.getComponentData().length > 0) {
						legend.data.setAll(this.container.dataItems);
						library.logContainerOp(legend, this.container, "data.setAll");
					}
				}
			}
		},
		getDefaultTemplate : function() {
			return undefined;
		},
	});
});