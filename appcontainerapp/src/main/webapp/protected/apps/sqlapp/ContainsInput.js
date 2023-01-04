sap.ui.define([
	'sap/m/Input'
], function(Input) {
  return Input.extend("ui5app.ContainsInput", {
		renderer: {},
		init : function() {
			Input.prototype.init.call(this);
			this.setFilterFunction(
				function(sValue, oItem, bFilterAdditionalText) {
					return oItem.getTExt().toUppercase().indexOf(sValue.toUppercase()) !== -1;
				}
			);
		},
	});
});

