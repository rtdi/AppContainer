sap.ui.define([
	'ui5libs/contentcontrols/ContentBase',
	'sap/ui/codeeditor/CodeEditor'
], function() {
  return ui5libs.contentcontrols.ContentBase.extend("ui5libs.contentcontrols.XMLFragmentEditor", {
		metadata : {
			properties : {
				codeEditorHeight: {type: "sap.ui.core.CSSSize", defaultValue: "auto" }
			},
			aggregations : {
			},
			events : {}
		},
		renderer: {},
		init : function() {
			ui5libs.contentcontrols.ContentBase.prototype.init.call(this);
			this.setEditorControl(new sap.ui.codeeditor.CodeEditor( { type: "xml" }));
		},
		setCodeEditorHeight : function(value) {
			this.setProperty("codeEditorHeight", value);
			this.getEditorControl().setHeight(value);
		},
		setValue: function(text) {
			this.setProperty("value", text);
			this.getEditorControl().setValue(text);
		},
		getValue: function() {
			return this.getEditorControl().getValue();
		},
		compile : function() {
			var that = this; 
			if (that.getDataControl()) {
				that.getDataControl().destroy();
				that.setDataControl(undefined);
			}
			sap.ui.require(["sap/ui/core/Fragment"], function(Fragment){
			    Fragment.load({
			        type: "XML",
			        definition: that.getEditorControl().getValue()
			    }).then(
					control => {
				        that.setDataControl(control);
				        that.setModelRecursive(control);
				    },
				    error => {
						that.setDataControl( new sap.m.Text( { text: error }));
					}
				);
			});
		},
		_setEditorVisible : function(isVisible) {
			this.getEditorControl().setVisible(isVisible);
		},
		getType : function() {
			return "XMLFragment";
		},
   		setModelRecursive: function(oControl) {
   			if (oControl instanceof sap.ui.core.Element) { 
	   			var aCustomData = oControl.getCustomData();
	   			if (aCustomData) {
	   				for( var oCustomdata of aCustomData) {
	   					if (oCustomdata instanceof ui5libs.controls.ModelContainer) {
	   						var name = oCustomdata.getModelName();
			   				var oModel = oCustomdata.createNewModel();
							oControl.setModel(oModel, name, oCustomdata);
						}
					}
	   			}
	   			var oMetadata = oControl.getMetadata();
	   			var oAggregations = oMetadata.getAllAggregations();
	   			for (const [sName, oSettings] of Object.entries(oAggregations)) {
	   				var fGetter = oControl[oSettings._sGetter].bind(oControl);
	   				var aContent = fGetter();
	   				if (aContent) {
	   					if (Array.isArray(aContent)) {
		   					for (var i = 0; i<aContent.length; i++) {
		   						this.setModelRecursive(aContent[i]);
		   					}
	   					} else {
	   						this.setModelRecursive(aContent);
		   				}
	   				}
	   			}
	   		}
   		} 

	});
});
