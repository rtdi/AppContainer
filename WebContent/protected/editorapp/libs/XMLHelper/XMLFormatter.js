sap.ui.define([
	'sap/ui/base/Object'
], function (BaseObject) {
	"use strict";    
   	var lib =  BaseObject.extend("io.rtdi.hanaappcontainer.editorapp.libs.XMLHelper.XMLFormatter", { } );
   	   	
   	lib.generateXML = function(oControl, buffer, level = 0) {
   	   	function indent(text, level) {
   	   		return " ".repeat(level*4) + text;
   	   	};
   	   	
   	   	var hasdata = false;
   		var sClassname;
		var vProperties;
		var vAggregations;
		var vAssociations;
   		if ('getParentProperties' in oControl) {
   			sClassname = oControl.getParentClassName();
   			vProperties = oControl.getParentProperties();
   			vAggregations = oControl.getParentAggregations();
   			vAssociations = oControl.getParentAssociations();
   		} else {
   			sClassname = oControl.getMetadata().getName();
   			vProperties = oControl.getMetadata().getAllProperties();
   			vAggregations = oControl.getMetadata().getAllAggregations();
   			vAssociations = oControl.getMetadata().getAllAssociations();
   		}
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
			if (sName !== "propertiesModel") {
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
						sValue = "{" + sBindingPath + "}";
					} else {
						sValue = oControl[sMethodname].apply(oControl);
					}
					if (sValue === "" || (Array.isArray(sValue) && sValue.length == 0)) {
						sValue = null;
					}
					if (sValue !== defaultvalue) {
						hasdata = true;
						buffer.push("\r\n" + indent(sName + "=\"" + sValue + "\"", level+1));
					}
				}
			}
		});
		/*
		 * Finally add the aggregation binding info
		 */
		var bindingposition = buffer.length;
		buffer.push(">");

		/* 
		 * For the oDataModel there is no place in the XML View yet, hence need to use the customData aggregation.
		 */
		if ("getODataURL" in oControl) {
			buffer.push("\r\n" + indent("<" + ns + "customData>", level+1));
			buffer.push("\r\n" + indent("<sap.ui.core:CustomData key=\"odataurl\" value=\"" + oControl.getODataURL() + "\" />", level+2));
			buffer.push("\r\n" + indent("</" + ns + "customData>", level+1));
		}

		// Add some aggregations
		Object.keys(vAggregations).forEach( function (sName) {
			if (sName !== "customData" && sName !== "dragDropConfig") { // these two are used internally
				var sMethodname = vAggregations[sName]._sGetter;
				if (!vAggregations[sName].deprecated) {
					var aElements = oControl[sMethodname].apply(oControl);
					var oBindingInfo = oControl.getBindingInfo(sName);
					if (oBindingInfo) {
						var oTemplate = oBindingInfo.template;
						/*
						 * Add the aggregation binding to the properties
						 */
						buffer.splice(bindingposition, 0, "\r\n" + indent(sName + "=\"{" + oBindingInfo.path + "}\"", level+1));
						buffer.push("\r\n" + indent("<" + ns + sName + ">\r\n", level+1 ));
						var ret = lib.generateXML(oTemplate, buffer, level+2);
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
									ret |= lib.generateXML(oItem, buffer, level+2);
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
							var ret = lib.generateXML(aElements, buffer, level+2);
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
		if (hasdata) {
			buffer.push("\r\n" + indent("</" + ns + xmlname + ">\r\n", level));
		} else {
			buffer.pop(); // <tagname...
			buffer.pop(); // ...>
		}
		return hasdata;
	};
   	return lib;
}, /* bExport= */ true);
