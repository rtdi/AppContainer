sap.ui.define([
	'ui5libs/amcharts/base/axisranges/AxisRange',
	'ui5libs/amcharts/library',
], function(AxisRange, library) {
	return AxisRange.extend("ui5libs.amcharts.base.axisranges.DateAxisRange", {
		metadata: {
            properties: {
				step : {type: "ui5libs.amcharts.DateRanges"},
				locale : {type: "string", defaultValue: "en-us"},
            },
            aggregations: {
				grid: {type: "ui5libs.amcharts.base.Grid", multiple: false},
				label: {type: "ui5libs.amcharts.base.Label", multiple: false},
				fill: {type: "ui5libs.amcharts.base.AxisRenderer", multiple: false},
			}
		},
		buildRanges : function(min, max) {
			var dateAxis = this.parentContainer;
			var m = dateAxis.maxDeviation;
			if (!m) {
				m = 0.1;
			}
			var d = (max-min)*m;
			min = min - d;
			max = max + d;
			var colorSet = am5.ColorSet.new(this._root, {});
			
			getWeek = function(startts) {
				var date = new Date(startts);
				date.setHours(0, 0, 0, 0);
				// Thursday in current week decides the year.
				date.setDate(date.getDate() + 3 - (date.getDay() + 6) % 7);
				// January 4 is always in week 1.
				var week1 = new Date(date.getFullYear(), 0, 4);
				// Adjust to Thursday in week 1 and count number of weeks from date to week1.
				return 1 + Math.round(((date.getTime() - week1.getTime()) / 86400000
			                        - 3 + (week1.getDay() + 6) % 7) / 7);
			}
			
			var step = this.getStep();
			
			var startts = min;
			var index = 0;
			while ( startts < max && index < 100) { // no more than 100 ranges at max to deal with misconfigurations
				var axisRange = dateAxis.createAxisRange(
				    dateAxis.makeDataItem({ above: true })
				);
				var locale = this.getLocale();
				var name;
				var endts;
				var startDate = new Date(startts);
				switch (step) {
				case "second":
					name = startDate.toLocaleString(locale, {second: "2-digit"});
					endts = startts + 1000;
					break; 
				case "minute":
					name = startDate.toLocaleString(locale, {minute: "2-digit"});
					endts = startts + 60000;
					break; 
				case "hour":
					name = startDate.toLocaleString(locale, {hour: "2-digit"});
					endts = startts + 3600000;
					break; 
				case "day":
					name = startDate.toLocaleString(locale, {day: "2-digit"});
					endts = startts + 24*3600000;
					break; 
				case "week":
					name = "W" + getWeek(startts);
					endts = startts + 7*24*3600000;
					break; 
				case "weekday":
					name = startDate.toLocaleString(locale, {weekday: "short"});
					endts = startts + 3600000;
					break; 
				case "month":
					name = startDate.toLocaleString(locale, {month: "short"});
					var d = new Date(startts);
					endts = d.setMonth(d.getMonth()+1);
					break; 
				case "year":
					name = startDate.toLocaleString(locale, { year: "numeric"});
					var d = new Date(startts);
					endts = d.setYear(d.getYear()+1);
					break; 
				case "quarter":
					name = "Q" + (Math.floor(startDate.getMonth()/3)+1).toString();
					var d = new Date(startts);
					endts = d.setMonth(d.getMonth()+3);
					break; 
				}
				axisRange.get("label").setAll({ text: name });
				axisRange.set("value", startts);
				axisRange.set("endValue", endts);
				
				if (this.getFill()) {
					var fill = axisRange.get("axisFill");
					var fillsettings = this.getFill()._buildSettings();
					fillsettings.fill = colorSet.getIndex(index * 2);
					fill.setAll(fillsettings);
				}
				if (this.getGrid()) {
					var grid = axisRange.get("grid");
					grid.setAll(this.getGrid()._buildSettings());
				}
				if (this.getLabel()) {
					var label = axisRange.get("label");
					var labelsettings = this.getLabel()._buildSettings();
					labelsettings.text = name;
					label.setAll(labelsettings);
				}
				
				startts = endts;
				index += 1;
			}
		},
	});
});