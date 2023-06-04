/**
 * The extended JSONModel adds functions to make the daily life with the JSONModel easier.
 * - Manipulate array nodes
 * - go to the parent node
 * - loadData supports ui5 namespaces
 * - apply row and structure transformations on the data
 * - find category, time and measure columns based in the datatype (requires the json to contain a /columns array with the metadata of the query columns)
 */
sap.ui.define([
	'sap/ui/model/json/JSONModel',
], function(JSONModel) {
  return JSONModel.extend("ui5libs.libs.model.json.JSONModelE", {
		metadata : {
			publicMethods : ["setJSON", "getJSON"]
		},
		/**
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
		/**
		 * Calls super.loadData() but checks the sURL
		 * - if sURL starts with a text, e.g. ui5rest/query the namespace ui5rest is transformed into the actual path on the webserver
		 * - if sURL starts with / or . it is considered an url without namespaces and paased to the super method as is
		 */
		loadData : function(sURL, oParameters, bAsync, sType, bMerge, bCache, mHeaders) {
			if (sURL) {
				if (!sURL.startsWith("/") && !sURL.startsWith(".")) {
					sURL = sap.ui.require.toUrl(sURL);
				}
				JSONModel.prototype.loadData.call(this, sURL, oParameters, bAsync, sType, bMerge, bCache, mHeaders);
    		}
		},
		/**
		 * assigns an array of ui5libs.libs.model.mt.RowTransformation rules to the model
		 */
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
		/**
		 * @return the list of all row transformations configured
		 */
		getRowTransformations : function() {
			return this._rowTransformations;
		},
		/**
		 * add a new ui5libs.libs.model.mt.RowTransformation to the array of transformations
		 */
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
		/**
		 * assigns an array of ui5libs.libs.model.mt.ModelTransformation rules to the model
		 */
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
		/**
		 * @return the list of all configured model transformations
		 */
		getModelTransformations : function() {
			return this._modelTransformations;
		},
		/**
		 * add a new ui5libs.libs.model.mt.ModelTransformation to the array of transformations
		 */
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
		/**
		 * Removes the upper element from the sPath, e.g. returns /rows/0 for sPath /rows/0/field1.
		 * Hence can return objects or arrays
		 */
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
		/**
		 * @return the parent object, skipping array items, e.g. returns /rows for sPath /rows/0/field1 if rows is an array
		 * see getParentPath()
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
		/**
		 * @return the parent property of the provided path.
		 * It takes the path, removes the top path and returns the property value of this new path
		 * see getParentPath()
		 */
		getParentProperty: function(sPath) {
			return this.getProperty(this.getParentPath(sPath));
		},
		/**
		 * deletes an object or array item in a way so the model change events are triggered properly
		 */
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
		/**
		 * inserts an object or array item in a way so the model change events are triggered properly
		 */
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
		/**
		 * add an additional property as last item of an array
		 */
		addArrayProperty: function(sPath, obj) {
			// Example: sPath = /children/1/children/0/children
			var index = this.getArrayPropertyLength(sPath);
			this.setProperty(sPath + "/" + index, obj);
		},
		/**
		 * Remove the item at position index from an array property
		 */
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
		/**
		 * @return true if the sPath points to the last item of an array property.
		 * Throws errors if the path does not point to an item of an array
		 */
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
		/**
		 * @return the length of an array property
		 */
		getArrayPropertyLength: function(sPath) {
			var a =  this.getArrayPropertyOf(sPath);
			if (a && Array.isArray(a)) {
				return a.length;
			} else {
				throw "The sPath argument (" + sPath + ") points to a property that is not an array";
			}
		},
		/**
		 * @return the parent path of an array property with validation the path was actually pointing to an item of an array
		 */
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
		/**
		 * @return the last item of an array property
		 */
		getLastArrayProperty : function(sPath) {
			var lastindex = this.getArrayPropertyLength(sPath) - 1;
			if (lastindex >= 0) {
				return this.getProperty(sPath + "/" + lastindex);
			} else {
				return undefined;
			} 
		},
		enforceEmptyLastArrayProperty : function(sPath, fieldname, obj) {
			var lastItem = this.getLastArrayProperty(sPath);
			if (!lastItem || !!lastItem[fieldname]) {
				this.addArrayProperty(sPath, obj);
			}
		},
		/**
		 * @param resultsetindex which resultset to be used, defaults to 0
		 * @return the /columns array in case this was a rest call against the rest/query endpoint or something similar
		 */
		getColumnMetadata : function(resultsetindex) {
			if (!resultsetindex) {
				resultsetindex = 0;
			}
			return this.getProperty("/resultsets/" + resultsetindex + "/columns");
		},
		/**
		 * Category columns are all short character columns.
		 * Meaning VARCHAR, NVARCHAR, CHAR, NCHAR but not their long equivalents
		 * 
		 * @return a list of columns of type varchar and similar
		 */
		getCategoryColumns : function(resultsetindex) {
			var metadata = this.getColumnMetadata(resultsetindex);
			if (metadata) {
				var a = [];
				var pos = 0;
				for( var col of metadata) {
					if (col.jdbctype == 1 /* CHAR */ || col.jdbctype == 12 /* VARCHAR */ || col.jdbctype == -15 /* NCHAR */ || col.jdbctype == -9 /* NVARCHAR */) {
						var o = Object.assign(col);
						o.pos = pos;
						a.push(o);
					}
					pos++;
				}
				return a;
			} else {
				return undefined;
			}
		},
		/**
		 * Measure columns are all number columns.
		 * 
		 * @return a list of columns of type int, float, decimal, etc
		 */
		getMeasureColumns : function(resultsetindex) {
			var metadata = this.getColumnMetadata(resultsetindex);
			if (metadata) {
				var a = [];
				var pos = 0;
				for( var col of metadata) {
					if (col.jdbctype == -5 /* BIGINT */ || col.jdbctype == -6 /* TINYINT */ || col.jdbctype == 5 /* SMALLINT */ ||
						col.jdbctype == 4 /* INT */ || col.jdbctype == 6 /* FLOAT */ || col.jdbctype == 7 /* REAL */ || col.jdbctype == 8 /* DOUBLE */ ||
						col.jdbctype == 2 /* NUMERIC */ || col.jdbctype == 3 /* DECIMAL */) {
						var o = Object.assign(col);
						o.pos = pos;
						a.push(o);
					}
					pos++;
				}
				return a;
			} else {
				return undefined;
			}
		},
		/**
		 * Date columns are all date/time related columns.
		 * 
		 * @return a list of columns of type date, time, timestamps in all their variations
		 */
		getDateColumns : function(resultsetindex) {
			var metadata = this.getColumnMetadata(resultsetindex);
			if (metadata) {
				var a = [];
				var pos = 0;
				for( var col of metadata) {
					if (col.jdbctype == 91 /* DATE */ || col.jdbctype == 92 /* TIME */ || col.jdbctype == 93 /* TIMESTAMP */ ||
						col.jdbctype == 2013 /* TIME_WITH_TIMEZONE */ || col.jdbctype == 2014 /* TIMESTAMP_WITH_TIMEZONE */) {
						var o = Object.assign(col);
						o.pos = pos;
						a.push(o);
					}
					pos++;
				}
				return a;
			} else {
				return undefined;
			}
		},
	});
});
