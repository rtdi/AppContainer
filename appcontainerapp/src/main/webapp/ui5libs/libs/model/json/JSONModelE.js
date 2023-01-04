sap.ui.define([
	'sap/ui/model/json/JSONModel',
], function(JSONModel) {
  return JSONModel.extend("ui5libs.libs.model.json.JSONModelE", {
		metadata : {
			publicMethods : ["setJSON", "getJSON"]
		},
		/*
		 * Calls super.setData() after all input has been passed through the transformations
		 */
		setData : function(oData, bMerge) {
			this.oData = oData; // first set the data so the transformations can use get/setProperty() calls
			if (this.getRowTransformations()) {
				for (var transformation of this.getRowTransformations()) {
					transformation.applyTransformation(this);
				}
			}
			if (this.getModelTransformations()) {
				for (var agg of this.getModelTransformations()) {
					agg.applyTransformation(this);
				}
			}
			JSONModel.prototype.setData.call(this, oData, bMerge);
		},
		loadData : function(sURL, oParameters, bAsync, sType, bMerge, bCache, mHeaders) {
			if (sURL) {
				if (!sURL.startsWith("/") && !sURL.startsWith(".")) {
					sURL = sap.ui.require.toUrl(sURL);
				}
				JSONModel.prototype.loadData.call(this, sURL, oParameters, bAsync, sType, bMerge, bCache, mHeaders);
    		}
		},
		setRowTransformations : function(aTransformations) {
			if (aTransformations && Array.isArray(aTransformations)) {
				for (var t of aTransformations) {
					if (!(t instanceof ui5libs.libs.model.mt.RowTransformation)) {
						throw "The setRowTransformations() call got an array but not all children are of type ui5libs.libs.model.mt.RowTransformation";
					}
				}
				this._rowTransformations = aTransformations;
			}
		},
		getRowTransformations : function() {
			return this._rowTransformations;
		},
		addRowTransformation : function(oTransformation) {
			if (oTransformation && oTransformation instanceof ui5libs.libs.model.mt.RowTransformation) {
				if (!this._rowTransformations) {
					this._rowTransformations = [ oTransformation ];
				} else {
					this._rowTransformations.push(oTransformation);
				}
			} else {
				throw "The addRowTransformations() call got the object " + oTransformation;
			}
		},
		setModelTransformations : function(aTransformations) {
			if (aTransformations && Array.isArray(aTransformations)) {
				for (var t of aTransformations) {
					if (!(t instanceof ui5libs.libs.model.mt.ModelTransformation)) {
						throw "The setModelTransformations() call got an array but not all children are of type ui5libs.libs.model.mt.ModelTransformation";
					}
				}
				this._modelTransformations = aTransformations;
			}
		},
		getModelTransformations : function() {
			return this._modelTransformations;
		},
		addModelTransformation : function(oTransformation) {
			if (oTransformation && oTransformation instanceof ui5libs.libs.model.mt.ModelTransformation) {
				if (!this._modelTransformations) {
					this._modelTransformations = [ oTransformation ];
				} else {
					this._modelTransformations.push(oTransformation);
				}
			} else {
				throw "The addModelTransformations() call got the invalid object: " + oTransformation;
			}
		},
		getParentPath: function(sPath) {
			if (sPath && typeof sPath === 'string' ) {
				var pos = sPath.lastIndexOf("/");
				if (pos != -1) {
					return sPath.substring(0, pos);
				} else {
					return sPath;
				}
			} else {
				throw "The sPath argument is not a string (" + typeof sPath + ")";
			}
		},
		/*
		 * If the path is an array element, it does return the array owner, not the array as getParentPath() does
		 */
		getParentObjectPath: function(sPath) {
			var parentpath = this.getParentPath(sPath);
			var p = this.getProperty(parentpath);
			if (Array.isArray(p)) {
				return this.getParentPath(parentpath); // one level more
			} else {
				return parentpath;
			}
		},
		getParentProperty: function(sPath) {
			return this.getProperty(this.getParentPath(sPath));
		},
		deleteProperty: function(sPath) {
			// Example: sPath = /children/1/children/0/children/0
			if (sPath && typeof sPath === 'string' ) {
				var p = this.getProperty(sPath);
				if (p) {
					var pos = sPath.lastIndexOf("/");
					if (pos != -1) {
						var parent = this.getProperty(sPath.substring(0, pos));
						var sArrayPath = sPath.substring(pos+1);
						if (Array.isArray(parent)) {
							var index = parseInt(sArrayPath);
							parent.splice(index, 1); // remove item at position index
						} else {
							delete parent[sArrayPath];
						}
						this.setProperty(sPath.substring(0, pos), parent);
					}
				} else {
					throw "The sPath argument (" + sPath + ") is not valid";
				}
			} else {
				throw "The sPath argument is not a string (" + typeof sPath + ")";
			}
		},
		insertProperty: function(sPath, obj) {
			// Example: sPath = /children/1/children/0/children/0
			if (sPath && typeof sPath === 'string' ) {
				var pos = sPath.lastIndexOf("/");
				if (pos != -1) {
					var parent = this.getProperty(sPath.substring(0, pos));
					if (Array.isArray(parent)) {
						var sArrayPath = sPath.substring(pos+1);
						var index = parseInt(sArrayPath);
						parent.splice(index, 0, obj); // add item at position index
						this.setProperty(sPath.substring(0, pos), parent);
					} else {
						throw "The sPath argument (" + sPath + ") is not an offset of an array, e.g. ..../list/23";
					}
				} else {
					throw "The sPath argument (" + sPath + ") is not valid";
				}
			} else {
				throw "The sPath argument is not a string (" + typeof sPath + ")";
			}
		},
		addArrayProperty: function(sPath, obj) {
			// Example: sPath = /children/1/children/0/children
			var index = this.getArrayPropertyLength(sPath);
			this.setProperty(sPath + "/" + index, obj);
		},
		removeArrayProperty: function(sPath, index) {
			// Example: sPath = /children, index=1
			if (!index) {
				var pos = sPath.lastIndexOf('/');
				index = parseInt(sPath.substring(pos+1));
				sPath = sPath.substring(0, pos); 
			}
			var a = this.getArrayPropertyOf(sPath);
			if (a.length > index) {
				a.splice(index, 1);
				this.setProperty(sPath, a);
			}
		},
		isLastProperty: function(sPath) {
			if (sPath && typeof sPath === 'string' ) {
				var p = this.getProperty(sPath);
				if (p) {
					var pos = sPath.lastIndexOf("/");
					if (pos != -1) {
						var len = this.getArrayPropertyLength(sPath.substring(0, pos));
						var sArrayPath = sPath.substring(pos+1);
						var index = parseInt(sArrayPath);
						return (index == len-1);
					} else {
						throw "The sPath argument (" + sPath + ") is not valid";
					}
				} else {
					throw "The sPath argument (" + sPath + ") points to a non-existing item";
				}
			} else {
				throw "The sPath argument is not a string (" + typeof sPath + ")";
			}
		},
		getArrayPropertyLength: function(sPath) {
			var a =  this.getArrayPropertyOf(sPath);
			if (a && Array.isArray(a)) {
				return a.length;
			} else {
				throw "The sPath argument (" + sPath + ") points to a property that is not an array";
			}
		},
		getArrayPropertyOf: function(sPath) {
			if (sPath && typeof sPath === 'string' ) {
				var p = this.getProperty(sPath.substring(0, pos));
				if (Array.isArray(p)) {
					return p;
				} else {
					var pos = sPath.lastIndexOf("/");
					if (pos != -1) {
						p = this.getProperty(sPath.substring(0, pos));
						if (Array.isArray(p)) {
							return p;
						} else {
							throw "The sPath argument (" + sPath + ") is not an element of an array";
						}
					} else {
						throw "The sPath argument (" + sPath + ") is not valid";
					}
				}
			} else {
				throw "The sPath argument is not a string (" + typeof sPath + ")";
			}
		},
	});
});
