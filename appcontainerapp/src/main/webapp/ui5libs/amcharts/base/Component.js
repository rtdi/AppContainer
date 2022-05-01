sap.ui.define([
	'ui5libs/amcharts/base/Container'
], function(Container) {
	return Container.extend("ui5libs.amcharts.base.Component", {
		metadata: {
            properties: {
				interpolationDuration : {type: "int"},
				interpolationEasing : {type: "object"},
				componentData: {type: "object" }
            },
		},
		setComponentData : function(data) {
			this.setProperty("componentData", data, true);
			this._setComponentData();
		},
		_buildSettings : function() {
			var oSettings = Container.prototype._buildSettings.apply(this);
			this._addFromProperty(oSettings, "interpolationDuration");
			this._addFromProperty(oSettings, "interpolationEasing");
			return oSettings;
		},
		updateData : function() {
			Container.prototype.updateData.apply(this);
			this._setComponentData();
		},
		_setComponentData : function() {
			if (this.container) {
				var data = this.getComponentData();
				if (data && data.length > 0) {
					if (Array.isArray(data)) {
						this.container.data.setAll(data);
						console.info("id[" + this.container.uid + ", " + this.container.className + "].data.setAll(data)" );
					} else {
						this.container.data.setAll( [ data ] );
						console.info("id[" + this.container.uid + ", " + this.container.className + "].data.setAll([data])" );
					}
				}
			}
		}

	});
});