sap.ui.define([
	'sap/f/ShellBar',
	'sap/f/Avatar',
	'sap/m/MessagePopover',
	'ui5libs/controls/ErrorMessageItem'
], function(ShellBar) {
  return ShellBar.extend("ui5libs.controls.ShellBar", {
		metadata : {
			properties : {
			},
			aggregations : {
				_popover : {
					type : "sap.m.MessagePopover",
					multiple : false,
					visibility : "hidden"
				},
				notifications : {
					type : "ui5libs.controls.ErrorMessageItem",
					multiple : true,
					singularName : "notification",
					forwarding: {
						getter: "_getPopover",
						aggregation: "items"
					}
				}
			},
			events : {}
		},
		renderer : {},
		init : function() {
			ShellBar.prototype.init.call(this);
			this.setHomeIcon(sap.ui.require.toUrl("ui5libs/controls/homeIcon.png"));
			this.setProfile(new sap.f.Avatar({initials: "User"}));
			this.attachAvatarPressed(this._showLogoutMenu);
			this.setShowNotifications(true);
			this.attachNotificationsPressed(this._onPopoverPress);
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
