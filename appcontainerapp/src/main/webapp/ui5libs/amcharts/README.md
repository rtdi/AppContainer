# UI5 Chart XMLView for amCharts

When talking about data it is all about visualizations.
The number of chart types supported and the amount of data they can handle are the key metrics.

Therefore tools try to support as many chart types as possible, Barchart, Linechart, maybe even more complex things like Bubblecharts.
The [amCharts](https://www.amcharts.com/demos/) library is different because it does focus on the building blocks of a diagram instead of offering multiple chart types and some configuration options.

To make that point clear the BubbleChart is a good example:

![bubblechart](../../public/amcharts/bubblechart/thumpnail.png)

[demo](https://www.amcharts.com/demos/zoomable-bubble-chart/)

It consists of a chart that has two dimensions and one or many series. Hence the object model is `Chart -> SerialChart -> XYChart`.
The XYCharts gets Axes configured, these can be `DateAxis`,  `CategoryAxis`, `ValueAxis`, ....
The `Series` is an invisible `LineSeries`, otherwise lines would be drawn from each (x,y) position. The LineSeries is assigned with one `Circle` at each data point and the size of the circle is derived from the data.

The downside of this approach is quite a few lines of JavaScript coding - which I tried to get rid of with the power of UI5 XMLViews.

This library here consists of a single UI5 control called `Chart` and within all the amChart components are placed as UI5 aggregations.

Example:

	    <Chart>
			<children>
				<base.XYChart>
					<xAxis>
						<base.ValueAxis />
					</xAxis>
					<yAxis>
						<base.ValueAxis />
					</yAxis>
					<series>
						<base.LineSeries
							valueYField="y" 
							valueXField="x"
							valueField="value"
							componentData="{/}"
						>
						   ...
						</base.LineSeries>
					</series>
				</base.XYChart>
			</children>
	    </Chart>

Above XMLView does exactly that. Within the Chart Control an XYChart is added as sole child - other children could be a Legend, a chart heading (Label) and more.
The x and y axis are both ValueAxis (because x,y can be any decimal number).
Finally the series aggregation consists of a single LineSeries with the data values of x,y assigned to the X- and Y-Axis.

The UI5 JSONModel for this chart in this example looks like 

```
[
	{
		"y": 10,
		"x": 14,
		"value": 59,
	},
	...
	...
```

and the entire array is assigned to the LineSeries via an UI5 binding to the property `componentData`.


This would be enough for a normal XYChart, but this chart should utilize the `value` field in the data for a third variable.

Hence the line must be made invisible/transparent via the line `strokes` aggregation.

							<strokes>
								<base.Graphics strokeOpacity="0" />
							</strokes>

Each end point of the LineSeries should have a Bullet with a Circle graphic.

							<bullets>
								<base.Bullet templateName="Bullet">
									<sprite>
										<base.Circle />
									</sprite>
								</base.Bullet>
							</bullets>


Finally the LineSeries has a IHeatRule that has the capability to set properties of other elements, here the radius based on the LineSeries's valueField within a range.
Therefore the LineSeries above also got a `valueField` assigned  - although not used yet - together with `valueXField` and `valueYfield`.
But a heat rule might work on different components. In this example it modifies the Bullet, in others it might change the color of a pie chart slice based on the temperature. The link between those two is to specify a chart-unique templateName, here at the Bullet, and in the heat rule use the `targetTemplateName`.

							<heatRules>
								<base.IHeatRule
									min="3"
									max="50"
									dataField="value"
									key="radius"
									targetTemplateName="Bullet"
								/>
							</heatRules>

As a result the LineSeries draws at each x,y position a circle with the radius taken from the valueField. The minimum value is rendered as radius 3pt and the maximum value with radius 50pt.


With this approach of assembling a chart of components via UI5 XMLView parts, we have a much higher degree of freedom when it comes to creating visualizations.
By utilizing the UI5 features of Custom Controls and XMLFragments, standard charts can be built as well which require the bare minimum of settings.

