sap.ui.define([
	'sap/m/FlexBox'
], function(FlexBox) {
  return FlexBox.extend("ui5libs.controls.ContainerParentChild", {
		metadata : {
			properties : {
				masterKeyField: {type : 'string' },
				detailFilterField: {type : 'string' },
				masterSelectedValue: {type : 'string' },
			},
			aggregations : {
				masteritem : {
					type : "sap.ui.core.Control",
					multiple : false
				},
				detailitem : {
					type : "sap.ui.core.Control",
					multiple : false
				},
			},
			events : {}
		},
		renderer : {},
		init : function() {
			FlexBox.prototype.init.call(this);
			this.addItem();
			var oPopover = new sap.m.MessagePopover();
		 	this.setAggregation("_popover", oPopover, true);	
		},
		_showLogoutMenu : function() {
			if (!this._oMenu) {
				this._oMenu = new sap.m.Menu({
					"items": [
						new sap.m.MenuItem({"text": "logout", "press": this.logout})
					]
				});
			}
			this._oMenu.openBy(this.getProfile());
		},
		logout: function() {
			window.location.href = "/AppContainer/logout";
		},
		_getPopover : function() {
			return this.getAggregation("_popover");
		},
		addNotification : function(oItem) {
			this.addAggregation("notifications", oItem, true);
			this._setMessagecount(this.getAggregation("notifications").length);
		},
		removeNotification : function(oItem) {
			this.removeAggregation("notifications", oItem, true);
			this._setMessagecount(this.getAggregation("notifications").length);
		},
		removeNotifications : function() {
			this.removeAllAggregation("notifications", true);
			this._setMessagecount(0);
		},
		_setMessagecount : function(value) {
			if (value === 0) {
				this.setNotificationsNumber(undefined);
			} else {
				this.setNotificationsNumber(value);
			}
		},
		_onPopoverPress : function(oEvent) {
			var oPopover = this._getPopover();
			oPopover.openBy(oEvent.getSource());
		},

	});
});
