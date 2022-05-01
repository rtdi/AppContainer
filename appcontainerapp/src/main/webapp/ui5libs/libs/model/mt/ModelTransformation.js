sap.ui.define([
	'sap/ui/core/Element'
], function(Element) {
  return Element.extend("ui5libs.libs.model.mt.ModelTransformation", {
		metadata : {
			properties: {
				groupBy : {type: "string[]"},
				sum : {type: "string[]"},
				rootPropertyPath : {type: "string"},
				targetPropertyPath : {type: "string"},
				totalsPropertyPath : {type: "string"},
			},
		},
		setTransformedData: function(oModel) {
			var source = this.getRootPropertyPath();
			var target = this.getTargetPropertyPath();
			if (source && target) {
				var sourcedata = oModel.getProperty(source);
				if (sourcedata && Array.isArray(sourcedata)) {
					var result = this._getGroupedData(sourcedata);
					oModel.setProperty(target, result.data, true);
					if (this.getTotalsPropertyPath()) {
						oModel.setProperty(this.getTotalsPropertyPath(), result.totals, true);
					}
				}
			}
		},
		_getGroupedData: function(aItems) {
			var that = this;
			function dynamicSort(property) {
				return function (a,b) {
					var result = (a[property] < b[property]) ? -1 : (a[property] > b[property]) ? 1 : 0;
					return result;
				}
			}
			function dynamicSortMultiple(props) {
				return function (obj1, obj2) {
					var i = 0, result = 0, numprops = props.length;
					while (result === 0 && i < numprops) {
						result = dynamicSort(props[i])(obj1, obj2);
						i++;
					}
					return result;
				}
			}
			if (this.getGroupBy() && this.getGroupBy().length > 0) {
				aItems.sort(dynamicSortMultiple(this.getGroupBy()));
				var aGrouped = [];
				var oCurrentGroup = {};
				var isempty = true;
				var isGroupChange = false;
				var totals;
				if (this.getSum()) {
					totals = this.getSum().reduce(function(result, item, index, array) {
						result[item] = 0;
						return result;
					}, {});
				}
				for (var oItem of aItems) {
					for (var sField of this.getGroupBy()) {
						if (oCurrentGroup[sField] !== oItem[sField]) {
							isGroupChange = true;
							break;
						}
					}
					if (isGroupChange) {
						if (!isempty) {
							aGrouped.push(oCurrentGroup);
						} else {
							isempty = false;
						}
						oCurrentGroup = {};
						for (var sField of this.getGroupBy()) {
							oCurrentGroup[sField] = oItem[sField];
						}
						if (this.getSum()) {
							for (var sField of this.getSum()) {
								oCurrentGroup[sField] = oItem[sField];
								totals[sField] += oItem[sField];
							}
						}
						isGroupChange = false;
					} else {
						if (this.getSum()) {
							for (var sField of this.getSum()) {
								oCurrentGroup[sField] += oItem[sField];
								totals[sField] += oItem[sField];
							}
						}
					}
				}
				if (!isempty) {
					aGrouped.push(oCurrentGroup);
				} else {
					isempty = false;
				}
				return { data: aGrouped, totals: totals };
			} else {
				return { data: aItems, totals: undefined };
			}
		},
	});
});
