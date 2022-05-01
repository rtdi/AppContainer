sap.ui.define([
	'ui5libs/libs/model/mt/ct/ColumnTransformation'
], function(ColumnTransformation) {
  return ColumnTransformation.extend("ui5libs.libs.model.mt.ct.FirstDayOfWeek", {
		metadata : {
			properties: {
				formatter : {type: "function"},
				inputField : {type: "string"},
				field : {type: "string"},
			},
		},
		applyTransformation: function(oData) {
			function firstMonday(ts) {
				var dateObject = new Date(ts);
				var dayOfWeek = dateObject.getDay(),
					firstDayOfWeek = new Date(dateObject),
					diff = dayOfWeek >= 1 ? dayOfWeek - 1 : 6 - dayOfWeek
				
				firstDayOfWeek.setDate(dateObject.getDate() - diff)
				firstDayOfWeek.setHours(0,0,0,0)
				
				return firstDayOfWeek.getTime();
			}
			oData[this.getField()] = firstMonday(oData[this.getInputField()]);
		},
	});
});
