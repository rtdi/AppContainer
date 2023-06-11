sap.ui.define([
	"ui5libs/helperfunctions",
	"ui5libs/controls/ResultSetTable",
	"./library"
], function(helperfunctions) {
  return sap.m.Page.extend("ui5libs.controls.ResultSets", {
		metadata : {
			properties : {
			},
			aggregations : {
			},
			events : {
				execute: {
					
				}
			}
		},
		renderer: {},
		init : function() {
			sap.m.Page.prototype.init.call(this);
			// this.attachModelContextChange(this.display);
			this.addContent(new sap.m.TabContainer());
			this.setCustomHeader(new sap.m.Toolbar({
				content: [
					new sap.m.ToolbarSpacer(),
					new sap.m.Button({ icon: "sap-icon://write-new-document", tooltip: "Open in FreeForm SQL", press: function(event) { this.onFreeFormSQL(event); }.bind(this) }),
					new sap.m.Button({ icon: "sap-icon://refresh", tooltip: "Refresh", press: function(event) { this.onRefresh(event); }.bind(this) }),
				]
			}));
			this.getContent()[0].addStyleClass("sapUiResponsiveContentPadding");
			this.getContent()[0].addStyleClass("sapUiResponsivePadding--header");
			this.getContent()[0].addStyleClass("noCloseButtons");
		},
		display : function() {
			this.getContent()[0].unbindItems();
			this.getContent()[0].removeAllItems();
			var table = new ui5libs.controls.ResultSetTable( {
					selectionMode: "Single",
					selectionBehavior: "RowOnly",
					enableSelectAll: false,
					visibleRowCountMode: "Auto",
				} );
			this.getContent()[0].bindItems({
				path: "/resultsets",
				template: new sap.m.TabContainerItem({
					content: table,
					name: "{name} ({= ${hasmore}?'&gt;':''} {rowcount} rows)"
				})
			});
		},
		displayError : function(text) {
			this.getContent()[0].unbindItems();
			this.getContent()[0].removeAllItems();
			this.getContent()[0].addItem(new sap.m.TabContainerItem({
					content: new sap.m.Text( {
						text: text,
						wrapping: true
					} ),
					name: "Error"
				})
			);
		},
		onFreeFormSQL : function(event) {
			var model = this.getModel();
			if (model) {
				var sql = model.getProperty("/sql");
				if (sql) {
					sap.m.URLHelper.redirect("../sqltextapp/index.html?$select=" + helperfunctions.encodeURIfull(sql), true);
				}
			}
		},
		onRefresh : function(event) {
			this.fireExecute();
		}		
	});
});


