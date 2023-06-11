sap.ui.define([
	"ui5libs/ui5ajax",
	"ui5libs/helperfunctions",
	"ui5libs/controls/ResultSets",
	'ui5libs/contentcontrols/ContentBase',
	'ui5libs/controls/CodeEditorE'
], function(ui5ajax, helperfunctions) {
  return ui5libs.contentcontrols.ContentBase.extend("ui5libs.contentcontrols.SQLEditor", {
		metadata : {
			properties : {
				codeEditorHeight: {type: "sap.ui.core.CSSSize", defaultValue: "auto" },
				dataHeight: {type: "sap.ui.core.CSSSize", defaultValue: "auto" },
			},
			aggregations : {
			},
			events : {}
		},
		renderer: {},
		init : function() {
			ui5libs.contentcontrols.ContentBase.prototype.init.call(this);
			this.setEditorControl(new ui5libs.controls.CodeEditorE( {
				type: "sql",
				compile: function(event) {
					this.compile(event);
				}.bind(this)
			}));
			var tabcontainer = new ui5libs.controls.ResultSets( {
				layoutData: new sap.m.FlexItemData( {
					growFactor: 1
				}),
				execute: function(event) { this.compile(event) }.bind(this),
				enableScrolling: false
			});
			tabcontainer.setModel(new ui5libs.libs.model.json.JSONModelE());
			this.setDataControl( new sap.m.VBox( {
				items: [tabcontainer],
				height: "100%"
			}));
		},
		getDataModel : function() {
			/*
			 * Used by the NBJsonContainer to find the previous control with a data type
			 */
			return this.getDataControl().getItems()[0].getModel();
		},
		setValue: function(text) {
			this.setProperty("value", text);
			this.getEditorControl().setValue(text);
		},
		getValue: function() {
			return this.getEditorControl().getValue();
		},
		setCodeEditorHeight : function(value) {
			this.setProperty("codeEditorHeight", value);
			this.getEditorControl().setHeight(value);
		},
		setDataHeight : function(value) {
			this.setProperty("dataHeight", value);
			this.getDataControl().setHeight(value);
		},
		compile : function(event) {
			var sqltext = event.getParameter("text");
			if (!sqltext) {
				sqltext = this.getValue();
			}
			var tabcontainer = this.getDataControl().getItems()[0];
			var datamodel = tabcontainer.getModel();
			ui5ajax.getJsonObject("/query?$select="+ helperfunctions.encodeURIfull(sqltext), "ui5rest", tabcontainer)
				.then(
					data => {
						var oData = JSON.parse(data.text);
						datamodel.setData(oData);
						tabcontainer.display();
					},
					error => {
						var oData = JSON.parse(error.text);
						datamodel.setData(undefined);
						tabcontainer.displayError(oData.message);
					}
				);
		},
		_setEditorVisible : function(isVisible) {
			this.getEditorControl().setVisible(isVisible);
		},
		getType : function() {
			return "SQL";
		}
	});
});
