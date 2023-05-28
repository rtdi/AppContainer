sap.ui.define([
	"sap/m/Dialog",
	"ui5libs/ui5ajax",
	'ui5libs/errorfunctions'
], function(Dialog, ui5ajax, errorfunctions) {
  return Dialog.extend("ui5libs.controls.FileOperationDialog", {
		metadata : {
			properties: {
				okayText: { type: "string", defaultValue : "Okay" },
				path: { type: "string", defaultValue : null },
				filename: { type: "string", defaultValue : null },
				suffix: { type: "string", defaultValue : null },
			},
			events: {
				okay : {
					parameters : {
						value : {path : "string"}
					}
				}
			}
		},
		renderer : {},
		init : function() {
			Dialog.prototype.init.call(this);
			this.setResizable(true);
			var files = new sap.m.List( {
				"items": {
					path:'/files',
					sorter: "{ path: 'name' }",
					template: new sap.m.StandardListItem( { title: "{name}", icon: "{=${directory}?'sap-icon://folder-blank':'sap-icon://document-text'}" })
				},
				headerText: "All files in",
				selectionChange: function(event) { this.onSelectItem(event) }.bind(this),
				mode: "SingleSelectMaster",
			});
			this.addAggregation("content", files );
			
			var toolbar = new sap.m.Toolbar( { content: [
				new sap.m.Input(),
				new sap.m.Button({
					type: sap.m.ButtonType.Emphasized,
					text: "Okay",
					enabled: true,
					press: this.onOkay
				}),
				new sap.m.Button({
						text: "Close",
						press: function () {
							this.close();
						}.bind(this)
					})
			] });
			this.setSubHeader(toolbar);
			var datamodel = new sap.ui.model.json.JSONModel();
			files.setModel(datamodel);
			this.attachAfterClose(function () {
					this.destroy();
				}
			);
		},
		setOkayText: function(text) {
			this.setProperty("okayText", text);
			this.getSubHeader().getContent()[1].setText(text);
		},
		setPath: function(text) {
			this.setProperty("path", text);
			this.getAggregation("content")[0].removeSelections(true);
			this.getAggregation("content")[0].setHeaderText(text);
			if (!text) {
				text = "";
			}
			var datamodel = this.getAggregation("content")[0].getModel();
			ui5ajax.getJsonObject("repo/listall/" + text, "ui5rest")
				.then(
					data => {
						var oData = JSON.parse(data.text);
						datamodel.setData(oData);
					},
					error => {
						errorfunctions.uiError(view, error);
					}
				);
		},
		onSelectItem: function(event) {
			var item = event.getParameter("listItem");
			var control = event.getSource();
			var i = control.indexOfItem(item);
			var entry = control.getModel().getProperty("/files/" + i);
			if (entry) {
				var dialog = control.getParent();
				if (entry.directory) {
					var path = dialog.getPath();
					if (entry.name !== "..") {
						path = path + "/" + entry.name
					} else if (path && path.length !== 0) {
						var p = path.lastIndexOf("/");
						if (p === -1) {
							path = "";
						} else {
							path = path.substring(0, p);
						}
					}
					dialog.setPath(path);
				} else if (this.getSuffix() && entry.name.endsWith(this.getSuffix())) {
					dialog.getSubHeader().getContent()[0].setValue(entry.name);
				}
			}
		},
		setFilename : function(text) {
			this.getSubHeader().getContent()[0].setValue(text);
		},
		getFilename : function() {
			return this.getSubHeader().getContent()[0].getValue();
		},
		onOkay : function(event) {
			var control = event.getSource();
			var dialog = control.getParent().getParent();
			var path = dialog.getPath() + "/" + dialog.getFilename();
			dialog.fireEvent("okay", {
				value: path
			});
			dialog.close();
		},
	});
});