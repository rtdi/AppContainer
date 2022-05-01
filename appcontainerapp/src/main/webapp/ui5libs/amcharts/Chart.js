sap.ui.require([
	'ui5libs/amcharts/dist/index',
	'ui5libs/amcharts/dist/themes/Animated',
], function() {
});

sap.ui.define([
	'sap/ui/core/Control',
	'ui5libs/amcharts/base/Container',
	'ui5libs/amcharts/dist/index',
	'ui5libs/amcharts/dist/themes/Animated'
], function(Control) {
	return Control.extend("ui5libs.amcharts.Chart", {
		_root: undefined,
		metadata: {
            properties: {
                width: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                height: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                localeFirstDayOfWeek: { type: "int" },
            },
            aggregations: {
				children: {type: "ui5libs.amcharts.base.Container", multiple: true, singularName: "child" },
				themes: {type: "ui5libs.amcharts.base.Theme", multiple: true, singularName: "theme" },
				dateFormatter: {type: "ui5libs.amcharts.base.DateFormatter", multiple: false }	
			},
            events: {
				buildChart : {
					parameters : {
						root : {type : "object"}
					}
				}
			}
		},
		onAfterRendering : function() {
			sap.ui.core.Control.prototype.onAfterRendering.apply(this, arguments);
			if (this._root) {
				this._root.dispose();
			}
			this._root = am5.Root.new(this.getId());
			var aThemes = [ am5themes_Animated.new(this._root) ];
			if (this.getThemes()) {
				for ( var t of this.getThemes()) {
					aThemes.push(t._newInstance(this._root));
				}
			}
			this._root.setThemes( aThemes );
			if (this.getLocaleFirstDayOfWeek()) {
				this._root.locale.firstDayOfWeek = this.getLocaleFirstDayOfWeek();
			}
			
			var templatedir = {};
			this._root.__templatedir = templatedir;
			this._root.getTemplate = function(templatename) {
				return templatedir[templatename];
			};
			this._root.addTemplate = function(templatename, link) {
				templatedir[templatename] = link;
			};
			
			if (this.getChildren()) {
				for (var container of this.getChildren()) {
					container.parentContainer = this._root.container;
					container._root = this._root;
					container.renderContainer();
				}
			}
			/*
			 * After the chart is built completely, set the data
			 */
			if (this.getChildren()) {
				for (var container of this.getChildren()) {
					container.updateData();
				}
			}
			this.fireEvent("buildChart", {
				root: this._root
			});
		},
		getRoot : function() {
			return this._root;
		},
		dispose : function() {
			if (this._root) {
				this._root.dispose();
			}
		},
		getam5 : function() {
			return am5;
		},

	});
});