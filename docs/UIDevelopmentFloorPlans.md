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

This is a layout that has a master area on top and a maximized detail area. Both areas are single controls, usually container controls. In the example below a `Label` and a `Select` control should be rendered next to each other, so they are wrapped inside `SimpleForm`. A simpler version would use the `Select` control only.

For the master/detail area to be synced, the master are gets an empty JSONModel assigned (with `modelName="master"`). The `Select` updates the model whenever the control has a different value (see `selectedKey="{master>/schemaname}"`) and the default model of type oDataModel has a filter using that value (see `Filter path="TABLE_SCHEMA" operator="EQ" value1="{master>/schemaname}"`).

The rest is just describing what controls to use where and their properties.

Example:

```
<mvc:View height="100vh"
	controllerName="ui5app.Controller"
	xmlns:mvc="sap.ui.core.mvc" 
	xmlns:core="sap.ui.core" 
	xmlns:form="sap.ui.layout.form" 
	xmlns="sap.m"
	xmlns:ui5libs.am4charts="ui5libs.am4charts"
	xmlns:ui5libs.controls="ui5libs.controls">
    <ui5libs.controls:FloorPlanMasterDetail 
        pageTitle="Storage Usage">
        <ui5libs.controls:master>
            <form:SimpleForm editable="true" layout="ResponsiveGridLayout" title="Select Schema">
                <Label text="Schema name" />
                <Select
                        width="50%"
                        selectedKey="{master>/schemaname}"
                        items="{/schemas}">
                    <core:Item key="{schemaname}" text="{schemaname}" />
        	    	<customData>
        	    		<ui5libs.controls:JsonContainer url="ui5rest/catalog/schemas" />
        	    	</customData>
                </Select>
            </form:SimpleForm>
        </ui5libs.controls:master>
    	<ui5libs.controls:detail>
    		<ui5libs.am4charts:Chart
    		    charttype="TreeMap"
    		    config="ui5app/StorageDistribution.json"
                items="{/TABLE}">
                <core:Item key="{TABLE_NAME}" text="{BYTES}" />
            </ui5libs.am4charts:Chart>
        </ui5libs.controls:detail>
        <ui5libs.controls:customData>
            <ui5libs.controls:JsonContainer modelName="master" />
            <ui5libs.controls:ODataContainer url="ui5odata/INFORMATION_SCHEMA/TABLES" >
                <ui5libs.controls:Filter path="TABLE_SCHEMA" operator="EQ" value1="{master>/schemaname}" />
            </ui5libs.controls:ODataContainer>
        </ui5libs.controls:customData>
    </ui5libs.controls:FloorPlanMasterDetail>
</mvc:View>
```

