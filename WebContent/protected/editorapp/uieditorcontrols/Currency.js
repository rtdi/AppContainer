sap.ui.define(
  [
	  'sap/ui/unified/Currency', 
	  'sap/ui/model/json/JSONModel',
	  'io/rtdi/hanaappcontainer/editorapp/uieditorcontrols/ControlWrapper'],
  function(Currency, JSONModel) {
  return io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.extend(
		"io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.Currency", {
			metadata : {
				properties: {
					value : {type : "float", group : "Appearance", defaultValue : 0},
					stringValue : {type : "string", group : "Appearance", defaultValue : null},
					currency : {type : "string", group : "Appearance", defaultValue : null},
					maxPrecision : {type : "int", group : "Appearance", defaultValue : 3},
					useSymbol : {type : "boolean", group : "Appearance", defaultValue : true}
				}
			},
			renderer : {},
			init : function() {
				io.rtdi.hanaappcontainer.editorapp.uieditorcontrols.ControlWrapper.prototype.init.call(this, new sap.ui.unified.Currency(), false);
			}
		});
});