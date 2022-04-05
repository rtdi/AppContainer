sap.ui.define( [
  'sap/ui/core/Control',
  'ui5libs/errorfunctions',
  'ui5app/controls/ToolPaletteButton'
], function(Control, errorfunctions) {
	"use strict";    

	return Control.extend("ui5app.controls.ControlWrapper", {
		metadata : {
			dnd : {
				draggable : true,
				droppable : true
			},
			properties: {
				controlid: { type: "string", defaultValue: "" },
				maximize: { type: "boolean", defaultValue: false },
				showLabel: { type: "boolean", defaultValue: true },
				supportModel: { type: "boolean", defaultValue: true },
				oDataURL: { type: "string", defaultValue: "" },
				modelColumns: { type: "string[]", defaultValue: undefined },
				linkToTemplate: { type: "string", defaultValue: undefined },
				customProperties: { type: "object", defaultValue: undefined },
			},
			aggregations: {
				wrappedControl : {type : "sap.ui.core.Control", multiple : false},
				controlTemplate : {type : "sap.ui.core.Element", multiple : false},
			},
			events : {
				showProperties : {}
			}
		},
		renderer : function (oRm, oControl) {
			oRm.openStart("div", oControl);
			if (oControl.getMaximize()) {
				oRm.addStyle("width", "-webkit-fill-available");
				oRm.addStyle("height", "-webkit-fill-available");
			}
			oRm.writeStyles();
			oRm.addClass("wrappercontrol");
			oRm.writeClasses();
			
			oRm.openEnd();
			if (oControl.getShowLabel()) {
				oRm.write('<p style="font-size: 6px; margin: 0px;">');
				oRm.write(oControl.getLabelText());
				if (oControl.getODataURL()) {
					oRm.write(" (with model)");
				}
				oRm.write('</p>');
			}
			if (oControl.getAggregation("wrappedControl")) {
				oRm.renderControl(oControl.getAggregation("wrappedControl").addStyleClass("insidewrappercontrol"));
			}
			oRm.close("div");
		},
		init : function() {
			jQuery.sap.includeStyleSheet(sap.ui.require.toUrl("ui5app/controls/css/ControlWrapper.css"));
			/*
			 * All controls can be moved
			 */
			var draginfo = new sap.ui.core.dnd.DragInfo({ "groupName": "move" });
			var oView = sap.ui.getCore().byId("__xmlview0");
			var oController = oView.getController(); 
			this.insertDragDropConfig(draginfo);
			if (this.hasProperties()) {
				this.attachBrowserEvent("dblclick", function(event) {
				    event.stopPropagation();
				    this.fireEvent("showProperties", undefined, true, false);
				    return false;
				}, this);			
				this.attachEvent("showProperties", oController.showProperties);
			}
			// If an object is cloned by a model, the id is different than then template - hence attach the id as property.
			this.setLinkToTemplate(this.getId());
			
			
		},
		getHiddenProperties : function() {
			return hiddenProperties;
		},
		getLabelText : function() {
			if (this.getAggregation("wrappedControl")) {
				return this.getAggregation("wrappedControl").getMetadata().getName();
			} else {
				return undefined;
			}
		},
		hasProperties : function() {
			return true;
		},
		setSupportModel : function(bSupportModel) {
			this.setProperty("supportModel", bSupportModel);
			var oChildControl = this.getWrappedControl(); // a model is never for the wrapper itself, so if a control has no child yet it does not get a model.
			if (oChildControl) {
				var dropinfo2;
				var dropinfoListItem;
				var aConfigs = oChildControl.getDragDropConfig();
				// Find the current dragdrop settings
				if (aConfigs) {
					for( var index = 0; index < aConfigs.length; index++) {
						var oConfig = aConfigs[index];
						if (oConfig.getGroupName() === "model") {
							dropinfo2 = oConfig;
						} else if (oConfig.getGroupName() === "ListItem") {
							dropinfoListItem = oConfig;
						}
					}
				}
				if (bSupportModel) {
					if (this.allowModelDrop(oChildControl)) {
						/*
						 * Add DnD configs in case they have not been added yet
						 */
						if (!dropinfo2) {
							dropinfo2 = new sap.ui.core.dnd.DropInfo(
								{ 
									"groupName": "model", 
									"dropPosition": sap.ui.core.dnd.DropPosition.On,
									"drop": this.onDropModel.bind(this)
								}
							);
							this.addDragDropConfig(dropinfo2);
						}
					}
				} else {
					if (dropinfo2) {
						this.removeDragDropConfig(dropinfo2);
					}
					if (dropinfoListItem) {
						this.removeDragDropConfig(dropinfoListItem);
					}
				}
			}
		},
		setWrappedControl : function(oChildControl) {
			this.setAggregation("wrappedControl", oChildControl);
			if (oChildControl) {
				this.__name = "Wrapper for " + oChildControl.getMetadata().getName();
				/*
				 * All controls can be moved
				 */
				var dropinfomove = new sap.ui.core.dnd.DropInfo(
						{ 
							"groupName": "move", 
							"dropPosition": sap.ui.core.dnd.DropPosition.Between,
							"drop": this.onMoveControl.bind(this),
							"targetAggregation": oChildControl.getMetadata().getDefaultAggregationName()
						}
				);
				this.addDragDropConfig(dropinfomove);
				if (this.allowControlDrop(oChildControl)) {
					/*
					 * Elements can be dropped into the default aggregation, e.g. a table or a layout container but not into all controls
					 */
					var dropinfo = new sap.ui.core.dnd.DropInfo(
							{ 
								"groupName": "controls", 
								"dropPosition": sap.ui.core.dnd.DropPosition.OnOrBetween,
								"drop": this.onDropControl.bind(this),
								"dropEffect": sap.ui.core.dnd.DropEffect.Copy, 
								// "targetAggregation": oChildControl.getMetadata().getDefaultAggregationName() // Drag is prohibited if that is enabled - unknown why
							}
					);
					this.addDragDropConfig(dropinfo);
					/*
					 * ListItems can be dropped in case it is of the proper type
					 */
					if (oChildControl.getMetadata().getDefaultAggregation().type === "sap.m.ListItemBase") {
						var dropinfoListItem = new sap.ui.core.dnd.DropInfo(
								{ 
									"groupName": "ListItem", 
									"dropPosition": sap.ui.core.dnd.DropPosition.On,
									"drop": this.onDropDefaultAggregation.bind(this)
								}
						);
						this.addDragDropConfig(dropinfoListItem);
					}
					/*
					 * sap.ui.core.Item elements can be dropped in case it is of the proper type
					 */
					if (oChildControl.getMetadata().getDefaultAggregation().type === "sap.ui.core.Item") {
						var dropinfoListItem = new sap.ui.core.dnd.DropInfo(
								{ 
									"groupName": "CoreItem", 
									"dropPosition": sap.ui.core.dnd.DropPosition.On,
									"drop": this.onDropDefaultAggregation.bind(this)
								}
						);
						this.addDragDropConfig(dropinfoListItem);
					}
				}
				this.setSupportModel(this.getSupportModel()); // between wrappedControl and supportModel is a dependency, we don't know which one comes first
			}
		},
		allowControlDrop : function(oChildControl) {
			var bAllow = oChildControl && oChildControl.getMetadata().getDefaultAggregationName();
			if (oChildControl.data("defaultAggregation")) {
				/*
				 * Some controls do have a default aggregation but it should not be used, e.g. SegmentedButton
				 */
				return false;
			}
			return bAllow;
		},
		allowModelDrop : function(oChildControl) {
			if (oChildControl.getId().endsWith('editorcontent')) {
				return false;
			} else {
				return oChildControl && oChildControl.getMetadata().getDefaultAggregationName() && this.getSupportModel();
			}
		},
		setODataURL : function(sUrl) {
			this.setProperty("oDataURL", sUrl, false);
			/*
			 * The oData endpoint is the only element controlling if an odata model should be used or not.
			 * Thus it creates a model and removes it from the control.
			 */
			var oInnerControl = this.getDropTarget();
			if (oInnerControl) {
				var oDefaultAgg = oInnerControl.getMetadata().getDefaultAggregation();
				if (oDefaultAgg) {
					if (!!sUrl && sUrl !== "") {
						/*
						 * Does the control have a template aggregation already? 
						 */ 
						var oTemplate = this.getControlTemplate();
						if (!oTemplate) {
							/*
							 * No, it does not have a template aggregation already, hence create one for simple controls
							 * and convert the existing element to a template if it does not.
							 * If there is more than one control as child create an error, e.g. a list has more than one items, which should be the template??
							 *
							 * Example 1: FlexBox has text as sole element -> this becomes the template
							 * Example 2: FlexBox has many items -> error message as a template must be a single control, e.g. a HBox
							 */
							var a = oInnerControl.getAggregation(oDefaultAgg.name);
							if (!a || a.length == 0) {
								// this is just fine. The control has no template yet and the user will add one later.
							} else if (a.length == 1) {
								// convert
								oTemplate = a[0];
								this.setControlTemplate(oTemplate);
							} else {
								errorfunctions.uiError(undefined, "The control has multiple items already, hence cannot be converted into a template");
								return;
							}
						}
						if (oTemplate) {
							oInnerControl.setModel(undefined); // remove the model, create the template and further below set the model 
							this.rebindTemplate(this);
						} else {
							// Dropping a model on a none-configured container is just fine
							// errorfunctions.uiError(undefined, "The control has no template");
						}
						/*
						 * Assuming the oData Service used is one from the AppContainer, the 
						 * modelColumns property should be updated to support the user picking the
						 * proper binding. It does not refresh the properties pane, no event fired.
						 */
					    var oModel = this.createNewODataModel(sUrl);
					    oModel.setDefaultBindingMode(sap.ui.model.BindingMode.OneWay);
						oInnerControl.setModel(oModel);
						var oMetamodel = oModel.getMetaModel();
						var that = this;
						oMetamodel.requestObject("/DBOBJECT.ROW").then(
								function(meta) { 
									var oColumns = [];
									Object.keys(meta).forEach( function(item) {
										if (!item.startsWith("$")) {
											oColumns.push(item);
										}
									} );
									that.setProperty("modelColumns", oColumns, true);
								} );
					} else if (this.getModel()) {
						oInnerControl.setModel(undefined);
					}
				}
			}
		},
		createNewODataModel : function(sString) {
			return new sap.ui.model.odata.v4.ODataModel({
			    		serviceUrl : sString, 
			    		"autoExpandSelect": false,
						"operationMode": "Server",
						"groupId": "$direct",
						"synchronizationMode": "None"
			    });
		},
		getLinkToTemplateObject : function() {
			var o = sap.ui.getCore().byId(this.getLinkToTemplate());
			return o;
		},
		onDropControl : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			var oView = sap.ui.getCore().byId("__xmlview0");
			var oController = oView.getController();
			
			var oControl = null;
			/*
			 * When the controls are part of a template, not the controls themselves
			 * are modified but their template structure.
			 */
			oTargetControl = this.findTemplate(oTargetControl);
			
			oControl = oController.createNewControl(oSourceControl.getControlType());
			if (oControl != null) {
				var oInnerControl = oTargetControl.getDropTarget();
				var sDefaultAggregation = oInnerControl.getMetadata().getDefaultAggregationName();
				if (sDefaultAggregation) {
					if (oTargetControl.getODataURL()) {
						if (oTargetControl.getControlTemplate()) {
							errorfunctions.uiError(undefined, "The container has a template already, must be removed first");
						} else {
							/*
							 * If the control has a model, change the template, not the aggregation directly.
							 */
							oTargetControl.setControlTemplate(oControl);
							oTargetControl.rebindTemplate(oTargetControl);
						}
					} else {
						var sSetter = oInnerControl.getMetadata().getAggregation(sDefaultAggregation)._sMutator;
						oInnerControl[sSetter](oControl);
						oTargetControl.rebindTemplate(oTargetControl);
					}
				} else {
					errorfunctions.uiError(undefined, "Drop Target does not allow adding children");
				}
			} else {
				errorfunctions.uiError(undefined, "Control not yet supported");
			}
		},
		onDropDefaultAggregation : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			var oView = sap.ui.getCore().byId("__xmlview0");
			var oController = oView.getController();
			/*
			 * When the controls are part of a template, not the controls themselves
			 * are modified but their template structure.
			 */
			oTargetControl = this.findTemplate(oTargetControl);
			
			var oItem = oController.createNewControl(oSourceControl.getControlType());
			if (oItem != null) {
				var oInnerControl = oTargetControl.getDropTarget();
				var sDefaultAggregation = oInnerControl.getMetadata().getDefaultAggregationName();
				if (sDefaultAggregation) {
					if (oTargetControl.getODataURL()) {
						if (oTargetControl.getControlTemplate()) {
							errorfunctions.uiError(undefined, "The container has a template already, must be removed first");
						} else {
							/*
							 * If the control has a model, change the template, not the aggregation directly.
							 */
							oTargetControl.setControlTemplate(oItem);
							oTargetControl.rebindTemplate(oTargetControl);
						}
					} else {
						var sSetter = oInnerControl.getMetadata().getAggregation(sDefaultAggregation)._sMutator;
						oInnerControl[sSetter](oItem);
						oTargetControl.rebindTemplate(oTargetControl);
					}
				}
			}
		},
		onMoveControl : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			/*
			 * When the controls are part of a template, not the controls themselves
			 * are modified but their template structure.
			 */
			oTargetControl = this.findTemplate(oTargetControl);
			oSourceControl = this.findTemplate(oSourceControl);
			var oItemContainer = oSourceControl.getParent();
			if (oSourceControl == oTargetControl) {
				// Do nothing is the object is dropped over itself
			} else if (oItemContainer === oTargetControl.getParent()) {
				/*
				 * The source control was dropped over another control in the same list.
				 * This means it should be inserted before the control it was dropped onto.
				 */
				oItemContainer.removeAggregation(oSourceControl.sParentAggregation, oSourceControl);
				var index = oItemContainer.indexOfAggregation(oSourceControl.sParentAggregation, oTargetControl);
				oItemContainer.insertAggregation(oSourceControl.sParentAggregation, index, oSourceControl);
			} else if (oItemContainer === oTargetControl.getDropTarget()) {
				/*
				 * The dragged control is inside a parent container and was dropped into
				 * the parent container. That means it should be moved to the end of the list.
				 */
				oItemContainer.removeAggregation(oSourceControl.sParentAggregation, oSourceControl);
				oItemContainer.addAggregation(oSourceControl.sParentAggregation, oSourceControl);				
			} else {
				sap.m.MessageToast.show("Not a valid drop target");
			}
		},
		findTemplate : function(oControl) {
			/*
			 * If the modified control is part of a template, we want to modify the template instead of the clone
			 */
			if (oControl instanceof ui5app.controls.ControlWrapper) {
				var oTemplate = oControl.getLinkToTemplateObject();
				if (oTemplate) {
					return oTemplate;
				}
			}
			return oControl;
		},
		onDropModel : function(oEvent) {
			var oSourceControl = oEvent.getParameter("draggedControl");
			var oTargetControl = oEvent.getParameter("droppedControl");
			/*
			 * A oData model has been dropped over a control.
			 */
			var sEndpoint = oSourceControl.getCustomData()[0].getValue();
			oTargetControl.setODataURL(sap.ui.require.toUrl("ui5odata") + "/tables/" + sEndpoint + "/");
		},
		findListBindingOwner : function(oControl) {
			var o = oControl;
			while (o) {
				if (o instanceof ui5app.controls.ControlWrapper) {
					var oTemplate = o.getControlTemplate();
					if (oTemplate) {
						return o;
					}
				}
				o = o.getParent();
			}
		},
		hasOptionalWrappedControl : function() {
			return false;
		},
		deleteControl : function(oEvent) {
			/*
			 * This ControlWrapper's control has to remove the oEvent item
			 */
			var oControl = oEvent.getParameter("draggedControl");
			/*
			 * Find the control's parent here, before redirecting the control to the template.
			 * Otherwise the parent might be a direct descendant and the getParent().getParent()
			 * does not work.
			 */
			var oContainerWrapper = oControl.getParent();
			if (!(oContainerWrapper instanceof ui5app.controls.ControlWrapper)) {
				oContainerWrapper = oContainerWrapper.getParent();
			}
			if (oContainerWrapper instanceof ui5app.controls.ControlWrapper) {
				oControl = oControl.findTemplate(oControl);
				oContainerWrapper = oContainerWrapper.findTemplate(oContainerWrapper);
				if (oContainerWrapper.hasOptionalWrappedControl()) {
					/*
					 * The wrappedControl content is optional and its control is to be deleted.
				     */
					oContainerWrapper.setWrappedControl(undefined);
					oContainerWrapper.rebindTemplate(oContainerWrapper);
				} else {
					/*
					 * Normally an e.g. HBox items aggregation contains multiple elements and these are ControlWrappers.
					 * Therefore the itemcontainer is the HBox and the element is removed from here.
				     */
					var itemcontainer = oContainerWrapper.getDropTarget();
					var sDefaultAggregation = itemcontainer.getMetadata().getDefaultAggregationName();
					if (sDefaultAggregation) {
						if (oContainerWrapper.getControlTemplate() === oControl) {
							/*
							 * The control to delete is the template, hence remove the template.
							 * But first trigger rebind to remove all items.
							 */
							oContainerWrapper.setControlTemplate();
							oContainerWrapper.rebindTemplate(oContainerWrapper);
						} else {
							/*
							 * The control is part of a binding but not the template itself
							 * or it is a regular control in which case the rebindTempalte does nothing.
							 */
							var sRemover = itemcontainer.getMetadata().getAggregation(sDefaultAggregation)._sRemoveMutator;
							itemcontainer[sRemover](oControl);
							oContainerWrapper.rebindTemplate(oContainerWrapper);
						}
					}
				}
			}
		},
		rebindTemplate : function(oControl) {
			var oBindingOwner = oControl.findListBindingOwner(oControl);
			if (oBindingOwner) {
				var oInnerControl = oBindingOwner.getDropTarget();
				var sDefaultAggregation = oInnerControl.getMetadata().getDefaultAggregationName();
				var oTemplate = oBindingOwner.getControlTemplate();
				if (oTemplate) {
					oInnerControl.bindAggregation(sDefaultAggregation, {
						path: "/RS",
						template: oTemplate.clone(),
						templateShareable: false
					});
				} else {
					oInnerControl.unbindAggregation(sDefaultAggregation);
				}
			}
		},
		getModelColumns : function(oWrapperControl) {
			while (oWrapperControl) {
				if (oWrapperControl instanceof ui5app.controls.ControlWrapper) {
					var oModelColumns = oWrapperControl.getProperty("modelColumns");
					if (oModelColumns) {
						return oModelColumns;
					}
				}
				oWrapperControl = oWrapperControl.getParent();
			}
		},
		/*
		 * If the passed oControl is a normal control, create its XML representation.
		 * If it is a ControlWrapper call its generateXML method, so the wrapper has the option to do something control specific.
		 */
		generateXML: function(buffer, level = 0, oControl) {
			if (oControl) {
				var oView = sap.ui.getCore().byId("__xmlview0");
				var oController = oView.getController();
				return oController.generateXML(buffer, level, oControl);
			}
		},

		/*
		 * A ControlWrapper can either be a wrapped around the actual control, e.g. the wrapper for the InputText. In that case
		 * It allows dropping models and doubleclick event to show properties.
		 * Or it is a placeholder where other ControlWrappers are dropped into like the Table->TableRow->TableCell.
		*/
		getDropTarget : function() {
			return this.getWrappedControl();
		},


	});
});