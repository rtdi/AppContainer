sap.ui.define([
	'sap/f/ShellBar',
	'sap/f/Avatar'
], function(ShellBar) {
  return ShellBar.extend("ui5libs.controls.ShellBar", {
		metadata : {
		},
		renderer : {},
		init : function() {
			ShellBar.prototype.init.call(this);
			this.setHomeIcon(sap.ui.require.toUrl("ui5libs/controls/homeIcon.png"));
			this.setProfile(new sap.f.Avatar({initials: "User"}));
			this.attachAvatarPressed(this._showLogoutMenu);
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
			window.location.href = "/HanaAppContainer/logout";
		}
	});
});
