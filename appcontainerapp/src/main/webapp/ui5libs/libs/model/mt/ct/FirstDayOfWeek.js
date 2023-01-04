sap.ui.define([
	'ui5libs/libs/model/mt/ct/ColumnTransformation'
], function(ColumnTransformation) {
  var c = ColumnTransformation.extend("ui5libs.libs.model.mt.ct.FirstDayOfWeek", {
		metadata : {
			properties: {
				inputField : {type: "string"},
			},
		},
		applyTransformation: function(oData) {
			
			oData[this.getField()] = ui5libs.libs.model.mt.ct.FirstDayOfWeek.firstMonday(oData[this.getInputField()]);
		},
	});
	c.firstMonday = function(ts) {
				var dateObject = new Date(ts);
				var dayOfWeek = dateObject.getDay(),
					firstDayOfWeek = new Date(dateObject),
					diff = dayOfWeek >= 1 ? dayOfWeek - 1 : 6 - dayOfWeek
				
				firstDayOfWeek.setDate(dateObject.getDate() - diff)
				firstDayOfWeek.setHours(0,0,0,0)
				
				return firstDayOfWeek.getTime();
			};
	
	return c;
});
