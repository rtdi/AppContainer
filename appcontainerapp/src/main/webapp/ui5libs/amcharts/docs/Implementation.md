# Implementation

The concept of this integration is to shadow the amcharts building blocks with UI5 Elements. 
This way the entire chart can be described in an XMLView.

When the control is rendered, each Element creates its amcharts object and places it in the canvas. The control also gets the amcharts object it is part of assigned in the `this.parentContainer` and the instance of itself in `this.container`.

One particular issue is the order with which the chart components are built.
The normal case is that e.g. a chart is created and it contains a label. The chart is the parent object, the label the child and the two objects are built in the proper order.
Templates of objects must be set after the main components have been created.
And Bullets use functions to create the graphical elements once the data was assigned. So they are rendered much later.

A consequence of this approach is that every property change later causes a re-render of the chart unless the code explicitly takes care of that.
The mechanism to do that is to use the `setProperty(<name>, <value>, true);` in the setter to tell that no re-render must be triggered and take the corresponding actions in the chart library as well.

Example: Component.js (simplified)

```
		setComponentData : function(data) {
			this.setProperty("componentData", data, true);
			if (this.container) {
				this.container.data.setAll(data);
			}
		},
```

When the data is set, update the UI5 property without a render event. Instead of rendering everything from scratch set the data for the amcharts container.
As this method is called multiple times, once with the default value, later with the value from the XMLView and finally when the data is explicitly set, e.g. via a binding, the chart might not have been built at this point in time, then `this.container` is not set.