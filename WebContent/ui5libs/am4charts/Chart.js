sap.ui.require([
	"ui5libs/am4charts/library",
	'am4charts/core',
	'am4charts/charts',
	'am4charts/themes/animated',
	'am4charts/plugins/timeline',
	'am4charts/plugins/sunburst',
	'am4charts/plugins/venn',
	'am4charts/plugins/wordCloud',
	'am4charts/plugins/forceDirected'
], function(library, am4core, am4charts, am4themes_animated, am4plugins_timeline, am4plugins_sunburst, am4plugins_venn, am4plugins_wordCloud, am4plugins_forceDirected) {
});

sap.ui.define([
	'sap/ui/core/Control',
	"jquery.sap.global",
	"ui5libs/am4charts/library",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	'am4charts/core',
	'am4charts/charts',
	'am4charts/themes/animated',
	'am4charts/plugins/timeline',
	'am4charts/plugins/sunburst',
	'am4charts/plugins/venn',
	'am4charts/plugins/wordCloud',
	'am4charts/plugins/forceDirected'
], function(Control, jQuery, library, ui5ajax, errorfunctions, am4core, am4charts, am4themes_animated, am4plugins_timeline, am4plugins_sunburst, am4plugins_venn, am4plugins_wordCloud, am4plugins_forceDirected) {
	return Control.extend("ui5libs.am4charts.Chart", {
		_chart: undefined,
		metadata: {
            properties: {
                width: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                height: { type: "sap.ui.core.CSSSize", defaultValue: "100%" },
                charttype: { type: "string", defaultValue: undefined },
                config: { type: "any", defaultValue: undefined },
            }, 
            aggregations: {
            },
		},
		constructor : function() {
			Control.prototype.constructor.apply(this, arguments);
		},
		onAfterRendering : function() {
			sap.ui.core.Control.prototype.onAfterRendering.apply(this, arguments);
			var oConfig = this.getProperty("config");
			var oCharttype = this.getProperty("charttype");
			var that = this;
			if (typeof oCharttype === 'string') {
				oCharttype = this._getChartTypeObject(oCharttype);
			}
			if (oConfig && oCharttype) {
				am4core.useTheme(am4themes_animated);
				if (typeof oConfig === 'string') {
					ui5ajax.ajaxGet(sap.ui.require.toUrl(oConfig))
						.then(
							data => {
								oConfig = JSON.parse(data);
								if (oConfig) {
									if (oConfig.dataSource && oConfig.dataSource.url) {
										if (!oConfig.dataSource.url.startsWith("/")) {
											oConfig.dataSource.url = sap.ui.require.toUrl(oConfig.dataSource.url);
										}
									}
									if (oConfig.series) {
										for (let oSeries of oConfig.series) {
											if (oSeries.dataSource && oSeries.dataSource.url) {
												if (!oSeries.dataSource.url.startsWith("/")) {
													oSeries.dataSource.url = sap.ui.require.toUrl(oSeries.dataSource.url);
												}
											}
										}
									}
									if (oConfig.xAxis) {
										for (let oAxis of oConfig.xAxis) {
											if (oAxis.dataSource && oAxis.dataSource.url) {
												if (!oAxis.dataSource.url.startsWith("/")) {
													oAxis.dataSource.url = sap.ui.require.toUrl(oAxis.dataSource.url);
												}
											}
										}
									}
									if (oConfig.yAxis) {
										for (let oAxis of oConfig.yAxis) {
											if (oAxis.dataSource && oAxis.dataSource.url) {
												if (!oAxis.dataSource.url.startsWith("/")) {
													oAxis.dataSource.url = sap.ui.require.toUrl(oAxis.dataSource.url);
												}
											}
										}
									}
								}
								if (that._chart) {
									that._chart.moveHtmlContainer(that.getId());
								} else {
									that._chart = am4core.createFromConfig(oConfig, that.getId(), oCharttype);
								} 
							},
							error => {
								errorfunctions.addError(this.getView(), error);
							}
						);
				} else {
					if (this._chart) {
						this._chart.moveHtmlContainer(this.getId());
					} else {
						this._chart = am4core.createFromConfig(oConfig, this.getId(), oCharttype);
					}
				}
			}
		},
		_getChartTypeObject : function(sCharttype) {
			var l = library; 
			switch (sCharttype) {
				case "PieChart": return am4charts.PieChart;
				case "XYChart" : return am4charts.XYChart;
				case "MapChart": return am4charts.MapChart;
				case "RadarChart" : return am4charts.RadarChart;
				case "TreeMap" : return am4charts.TreeMap;
				case "SankeyDiagram" : return am4charts.SankeyDiagram;
				case "GaugeChart" : return am4charts.GaugeChart;
				case "ChordDiagram" : return am4charts.ChordDiagram;
				case "SlicedChart": return am4charts.SlicedChart;
				case "Sunburst": return am4plugins_sunburst.Sunburst;
				case "WordCloud": return am4plugins_wordCloud.WordCloud;
				case "ForceDirectedTree": return am4plugins_forceDirected.ForceDirectedTree;
				case "CurveChart": return am4plugins_timeline.CurveChart;
				case "VennDiagram": return am4plugins_venn.VennDiagram;
			}
		},
		getChart : function() {
			return this._chart;
		},
		dispose : function() {
			if (this._chart) {
				this._chart.dispose();
			}
		},
		getAm4charts : function() {
			return am4charts;
		},
		getAm4core : function() {
			return am4core;
		},
		setCharttype : function(oType) {
			this.setProperty("charttype", oType, false);
		},
		setConfig : function(oConfig) {
			this.setProperty("config", oConfig, false);
		},
	});
});