## Floor plans

A floor plan is a basic layout of a page. It must not be used in the XML View of UI5 but it provides some help.

Common to all floor plans is that the `ui5libs/controls/ShellBar` with the notifications, logout, etc is on top and below an area to add custom controls.

### FloorPlanSingle

This is the most basic layout. The content of the page must be provided by a single layout control and set using the default `content` aggregation.
This floor plan is using a UI5 FlexBox as frame with the content area maximized to the available space.

Example:

```
<mvc:View height="100vh"
	xmlns:mvc="sap.ui.core.mvc" 
	xmlns="sap.m"
	xmlns:ui5libs.controls="ui5libs.controls">
	<ui5libs.controls:FloorPlanSingle pageTitle="Hello World">
		<Text text="Hello World" />
	</ui5libs.controls:FloorPlanSingle>
</mvc:View>
```

### FloorPlanMasterDetail

This is a layout that has a master area on top and a maximized detail area. Using the `detailFilter` property (see `setDetailFilter()`) the values to view in the details area can be filtered. Master and Detail must be a single (layout) control.
For that the detail area gets and oDataModel assigned via the `detailModel` aggregation.

Example:

```
<mvc:View height="100vh"
    controllerName="ui5app.Controller"
    xmlns:mvc="sap.ui.core.mvc" 
    xmlns:core="sap.ui.core" 
    xmlns="sap.m"
    xmlns:ui5libs.controls="ui5libs.controls">
    <ui5libs.controls:FloorPlanMasterDetail 
        pageTitle="Storage Usage"
        masterFormTitle="Select Schema">
        <ui5libs.controls:master>
            <Select change=".onSchemaChange" ... />
        </ui5libs.controls:master>
        <ui5libs.controls:detail>
            ....
        </ui5libs.controls:detail>
        <ui5libs.controls:detailModel>
            <ui5libs.controls:ODataContainer url="ui5odata/...." />
        </ui5libs.controls:detailModel>
    </ui5libs.controls:FloorPlanMasterDetail>
</mvc:View>
```

In the view controller, when the user did change the value in above Select control, the filter values are assigned.

```
onSchemaChange : function(oEvent) {
  var oFloorPlan = this.getView().byId("FloorPlan");
  oFloorPlan.setDetailFilter( {
  	"TABLE_SCHEMA": 
  	oEvent.getParameter('selectedItem').getKey() 
  } );
}
```

This causes the model to get a new filter with each property name and value. Here `TABLE_SCHEMA == 'DATA'` assuming that 'DATA' was the selected key.


### FloorPlanMasterFormDetail

Often the master area of the FloorPlanMasterDetail will be a SimpleForm control to align the labels and selectors properly.
The FloorPlanMaster**Form**Detail does not have a `master` aggregation but a `content` aggregation where all elements of the SimpleForm can be put into, usually as Label and a selector pair.

```
<mvc:View height="100vh"
    controllerName="ui5app.Controller"
    xmlns:mvc="sap.ui.core.mvc" 
    xmlns:core="sap.ui.core" 
    xmlns="sap.m"
    xmlns:ui5libs.controls="ui5libs.controls">
    <ui5libs.controls:FloorPlanMasterFormDetail 
        pageTitle="Storage Usage"
        masterFormTitle="Select Schema">
        <ui5libs.controls:content>
            <Label text="Schema name" />
            <Select change=".onSchemaChange" ... />
        </ui5libs.controls:content>
        <ui5libs.controls:detail>
            ....
        </ui5libs.controls:detail>
        <ui5libs.controls:detailModel>
            <ui5libs.controls:ODataContainer url="ui5odata/...." />
        </ui5libs.controls:detailModel>
    </ui5libs.controls:FloorPlanMasterFormDetail>
</mvc:View>
```