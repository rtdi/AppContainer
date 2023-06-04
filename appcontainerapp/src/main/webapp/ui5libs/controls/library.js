sap.ui.define(['jquery.sap.global', 
	'sap/m/library',
	'sap/ui/core/library'], // library dependency
	function() {

	"use strict";

	/**
	 * Suite controls library.
	 *
	 * @namespace
	 * @alias ui5libs.controls
	 * @author rtdi.io GmbH
	 * @version ${version}
	 * @public
	 */
	
	var thisLib = sap.ui.getCore().initLibrary({
		name : "ui5libs.controls",
		version: "${version}",
		dependencies : ["sap.ui.core", "sap.m"],
		types: [
			"ui5libs.controls.FontStyle"
		],
		interfaces: [],
		controls: [
			"ui5libs.controls.TextWithStyle",
			"ui5libs.controls.ResultSetTable"
		],
		elements: []
	});
	
	
	/**
	 * Define font styles
	 *
	 * @version ${version}
	 * @enum {string}
	 * @public
	 */
	thisLib.FontStyle = {
	
		/**
		 * Normal
		 * @public
		 */
		Normal : "Normal",
	
		/**
		 * Italic
		 * @public
		 */
		Italic : "Italic",
	
		/**
		 * Bold
		 * @public
		 */
		Bold : "Bold",
	
		/**
		 * Strike through
		 * @public
		 */
		StrikeThrough : "StrikeThrough",
	
		/**
		 * Wavy underline
		 * @public
		 */
		Spelling : "Spelling"
	
	};

	return thisLib;

});