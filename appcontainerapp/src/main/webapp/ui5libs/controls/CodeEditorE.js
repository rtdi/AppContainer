sap.ui.define([
	'sap/ui/codeeditor/CodeEditor',
], function(CodeEditor) {
  return CodeEditor.extend("ui5libs.controls.CodeEditorE", {
		metadata : {
			properties : {
			},
			aggregations : {
			},
			events : {
				compile: {
					parameters : {
						text: {type: "string"}
					}
				}
			}
		},
		renderer : {},
		init : function() {
			CodeEditor.prototype.init.call(this);
			var that = this;
			this._oEditor.commands.addCommand({
			    name: 'compile',
			    bindKey: {win: 'F8',  mac: 'F8'},
			    exec: function() {
						that.fireEvent("compile", {
							text: that._oEditor.getValue()
					});
			    }.bind(this),
			    readOnly: true, // false if this command should not apply in readOnly mode
			    // multiSelectAction: "forEach", optional way to control behavior with multiple cursors
			    // scrollIntoView: "cursor", control how cursor is scolled into view after the command
			});
			this._oEditor.setOption("showPrintMargin", false);
			// this._oEditor.setOption("useSoftTabs", true);
			// this._oEditor.setOption("enableSnippets", false);
			// this._oEditor.setOption("enableLiveAutocompletion", false);
		},
		setValue : function(value) {
			CodeEditor.prototype.setValue.call(this, value);
		}

	});
});
