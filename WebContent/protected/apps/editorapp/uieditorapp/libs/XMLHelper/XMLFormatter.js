sap.ui.define([
	'sap/ui/base/Object'
], function (BaseObject) {
	"use strict";
	
   	var lib =  BaseObject.extend("ui5app.libs.XMLHelper.XMLFormatter", { } );
   	   
	lib.generateXML = function(buffer, level = 0, oControl) {
		if (oControl instanceof ui5app.controls.ControlWrapper) {
			return oControl.generateXML(buffer, level, oControl.getWrappedControl());
		} else {
			return lib.generateXMLInnerControl(buffer, level, oControl);
		}
	};

   	lib.generateXMLInnerControl = function(buffer, level = 0, oControl) {
   	   	function indent(text, level) {
   	   		return " ".repeat(level*4) + text;
   	   	};
		function xmlEncode(text) {
			if (typeof(text) === 'string') {
		    	return text.replace(/&/g, '&amp;')
			               .replace(/</g, '&lt;')
			               .replace(/>/g, '&gt;')
			               .replace(/"/g, '&quot;')
			               .replace(/'/g, '&apos;');
			} else {
				return text;
			}
		};
   	   	
   	   	var hasdata = false;
   		var sClassname = oControl.getMetadata().getName();
		var vProperties = oControl.getMetadata().getAllProperties();
		var vAggregations = oControl.getMetadata().getAllAggregations();
		var vAssociations = oControl.getMetadata().getAllAssociations();
   		var xmlname;
   		var ns;
   		var p = sClassname.lastIndexOf(".");
   		if (p > 0) {
   			ns = sClassname.substring(0, p) + ":";
   			xmlname = sClassname.substring(p+1);
   		} else {
   			ns = "";
   			xmlname = sClassname;
   		}
		buffer.push(indent("<" + ns + xmlname + " ", level));
		
		if ('getControlid' in oControl && !!oControl.getControlid()) {
			buffer.push("\r\n" + indent("id=\"" + oControl.getControlid() + "\"", level+1));
		}
		// Add all properties to the XML node
		Object.keys(vProperties).forEach( function (sName) {
			/*
			 * Write properties only if the exist in the actual control and the wrapper control.
			 * This should avoid writing temporary properties like selectedid of the sap.m.select control.
			 */
			if (sName !== "propertiesModel" && sName in oControl.getMetadata().getAllProperties()) {
				var sMethodname = vProperties[sName]._sGetter;
				if (!vProperties[sName].deprecated) {
					var defaultvalue = vProperties[sName].defaultValue;
					if (defaultvalue === "" || (Array.isArray(defaultvalue) && defaultvalue.length == 0)) {
						defaultvalue = null;
					}
					/*
					 * Binding or literal text? Which one to use?
					 */
					var sBindingPath = oControl.getBindingPath(sName);
					var sValue;
					if (sBindingPath) {
						sValue = "{" + xmlEncode(sBindingPath) + "}";
					} else if (oControl[sMethodname]) {
						sValue = oControl[sMethodname].apply(oControl);
					} else {
						sValue = defaultvalue;
					}
					if (sValue === "" || (Array.isArray(sValue) && sValue.length == 0)) {
						sValue = null;
					}
					if (sValue !== defaultvalue) {
						hasdata = true;
						buffer.push("\r\n" + indent(sName + "=\"" + xmlEncode(sValue) + "\"", level+1));
					}
				}
			}
		});
		var bindingposition = buffer.length;
		buffer.push(">");

		/*
		 * Finally add the aggregation binding info.
		 * For the oDataModel there is no place in the XML View yet, hence need to use the customData aggregation.
		 */
		if (oControl.getParent() instanceof ui5app.controls.ControlWrapper && oControl.getParent().getODataURL()) {
			buffer.push("\r\n" + indent("<" + ns + "customData>", level+1));
			buffer.push("\r\n" + indent("<ui5libs.controls:ODataContainer url=\"" + oControl.getParent().getODataURL() + "\" />", level+2));
			buffer.push("\r\n" + indent("</" + ns + "customData>", level+1));
		}

		// Add some aggregations
		Object.keys(vAggregations).forEach( function (sName) {
			if (sName !== "customData" && sName !== "dragDropConfig") { // these two are used internally
				var sMethodname = vAggregations[sName]._sGetter;
				if (!vAggregations[sName].deprecated && oControl[sMethodname]) {
					var aElements = oControl[sMethodname].apply(oControl);
					var oBindingInfo = oControl.getBindingInfo(sName);
					if (oBindingInfo) {
						var oTemplate = oBindingInfo.template;
						/*
						 * Add the aggregation binding to the properties
						 */
						buffer.splice(bindingposition, 0, "\r\n" + indent(sName + "=\"{" + oBindingInfo.path + "}\"", level+1));
						buffer.push("\r\n" + indent("<" + ns + sName + ">\r\n", level+1 ));
						var ret = lib.generateXML(buffer, level+2, oTemplate);
						if (!ret) {
							buffer.pop(); // <tagname...>
						} else {
							buffer.push(indent("</" + ns + sName + ">", level+1) );
						}
						hasdata |= ret;
					} else if (!!aElements) {
						/*
						 * One of the features is that if a child does not have any data, it should not be added.
						 * That is easy for properties, but more difficult for nested data.
						 * For example a Button always has a layoutdata aggregation. But the content of this aggregation
						 * has only default values. Hence this child should not be rendered but if the 
						 * child is made non-existent, then the parent has to be removed as well.
						 * The hasdata=true/false tells that. And the buffer.pop() removes the previously
						 *  generated start tag when it is not needed due to no-data.
						 */
						if (Array.isArray(aElements)) {
							if (aElements.length != 0) {
								var ret = false;
								buffer.push("\r\n" + indent("<" + ns + sName + ">\r\n", level+1 ));
								aElements.forEach(function(oItem, index) {
									ret |= lib.generateXML(buffer, level+2, oItem);
								});
								if (!ret) {
									buffer.pop(); // <tagname...>
								} else {
									buffer.push(indent("</" + ns + sName + ">", level+1) );
								}
								hasdata |= ret;
							} else {
								// ignore empty arrays
							}
						} else {
							// ???? layoutdata aggregation for example
							buffer.push("\r\n" + indent("<" + ns + sName + ">\r\n", level+1 ));
							var ret = lib.generateXML(buffer, level+2, aElements);
							if (!ret) {
								buffer.pop(); // <tagname...>
							} else {
								buffer.push(indent("</" + ns + sName + ">", level+1) );
							}
							hasdata |= ret;
						}
					}
				}
			}
		});
		if (hasdata || oControl instanceof sap.ui.core.Control ) {
			// A control with all default should be added to the view of course
			buffer.push("\r\n" + indent("</" + ns + xmlname + ">\r\n", level));
		} else {
			buffer.pop(); // <tagname...
			buffer.pop(); // ...>
		}
		return hasdata;
	};
	
   	return lib;
}, /* bExport= */ true);
