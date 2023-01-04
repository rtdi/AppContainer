sap.ui.define([ "jquery.sap.global" ], function(jQuery) {
	return sap.m.MessageItem.extend("ui5libs.controls.ErrorMessageItem", {
		metadata : {
			properties : {
				timestamp: "int",
				message: "string",
				exception: "string",
				hint: "string",
				sourcecodeline: "string",
				sqlstatement: "string"
			},
			renderer: {}
		},
		init : function() {
			this.setType(sap.ui.core.MessageType.Error);
		},
		setErrorJSON : function(oJSON) {
			if (typeof(oJSON) === 'string') {
				if (!oJSON || oJSON.length === 0 ) {
					oJSON = undefined;
				} else {
					oJSON = JSON.parse(oJSON);
				}
			}
			if (oJSON) {
				this.setException(oJSON.type);
				this.setSqlstatement(oJSON.sqlstatement);
				this.setTimestamp(oJSON.timestamp);
				this.setMessage(oJSON.message);
				this.setHint(oJSON.hint);
				this.setSourcecodeline(oJSON.sourceCodeLine);
			} else {
				this.setMessage("Error thrown but no detail information coming from the server");
			}
			return this;
		},
		setException : function(value) {
			this.setProperty("exception", value, true);
			this.setTitle(value);
			var oLink = new sap.m.Link({ text: "more...", press: [this.onShowErrorDetails,this] });
			this.setLink(oLink);
		},
		setMessage : function(value) {
			this.setProperty("message", value, true);
			this.setDescription(value);
		},
		onShowErrorDetails : function(oEvent, oData) {
			// this = is the Link control of a message item
			var oDialog = this._getDialog(this);
			oDialog.open();
		},
		_getDialog : function(oItem) {
			var oDetailsDialog = new sap.m.Dialog({
				title: "Error details",
				contentWidth: "900px",
				contentHeight: "600px",
				resizable: true,
				content: [
					new sap.ui.layout.form.SimpleForm({
					 width: "100%",
					 layout: "ResponsiveGridLayout",
					 columnsL: 1,
					 columnsM: 1,
					 labelSpanXL: 3,
					 labelSpanL: 3,
					 labelSpanM: 2,
					 labelSpanS: 12,
					 singleContainerFullSize: false,
					 adjustLabelSpan: false,
					 title: "Error",
					 content: [
						new sap.m.Label( { text: "Exception type" } ), 
						new sap.m.Text( { text: oItem.getException() } ),
						new sap.m.Label( { text: "Time" } ), 
						new sap.m.Text( { text: new Date(oItem.getTimestamp()).toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'}) } ),
					] } ),

					new sap.ui.layout.form.SimpleForm({
					 width: "100%",
					 layout: "ResponsiveGridLayout",
					 columnsL: 1,
					 columnsM: 1,
					 labelSpanXL: 3,
					 labelSpanL: 3,
					 labelSpanM: 2,
					 labelSpanS: 12,
					 singleContainerFullSize: false,
					 adjustLabelSpan: false,
					 title: "Messages",
					 content: [					
						new sap.m.Label( { text: "Message" } ), 
						new sap.m.Text( { text: oItem.getMessage() } ),
						new sap.m.Label( { text: "Hint" } ), 
						new sap.m.Text( { text: oItem.getHint() } ),
						new sap.m.Label( { text: "SQL statement" } ), 
						new sap.m.Text( { text: oItem.getSqlstatement() } ),
					] } ),

					new sap.ui.layout.form.SimpleForm({
					 width: "100%",
					 layout: "ResponsiveGridLayout",
					 columnsL: 1,
					 columnsM: 1,
					 labelSpanXL: 12,
					 labelSpanL: 12,
					 labelSpanM: 12,
					 labelSpanS: 12,
					 singleContainerFullSize: false,
					 adjustLabelSpan: false,
					 title: "Source code line",
					 content: [
						new sap.m.Link( { href: oItem.getSourcecodeline(), text: "Show Source line", target: "_blank", visible: (!!oItem.getSourcecodeline()) } ),
					] } )
					
				],
				endButton: new sap.m.Button({
					text: "Close",
					press: function () {
						oDetailsDialog.close();
					}.bind(this)
				})
			});
			return oDetailsDialog;
		}
	});
});
