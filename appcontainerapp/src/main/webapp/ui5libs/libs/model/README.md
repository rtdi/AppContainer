# Model Transformations

Often the backend does expose data in a natural way but the UI control requires it in a different format. 
For simple things UI5 provides [formatters](https://help.sap.com/doc/saphelp_nw75/7.5.5/de-DE/0f/8626ed7b7542ffaa44601828db20de/content.htm?no_cache=true) but they might not be sufficient. In those cases the data itself can be transformed before assigning it to the UI5 Model.

For example the JSONModel.loadData() fetches the data from the backend, it has a function attached to the RequestCompleted event which does the manipulation of the data.

The goal if this library is to streamline the experience.
Its general approach is to take the data and add additional properties. 
Column Transformations add new columns to each row with the calculated value.
Model Transformations add a new property with the transformed data.

Note: Column transformations are always executed before Model transformations.

## Example ColumnTransformation

The input data looks like this:

```
{
	"data": [
		{
			"Activity Date": "2019-04-07",
			"Distance": 16901.30078125
		},
		{
			"Activity Date": "2019-04-08",
			"Distance": 10051.400390625
		},
		...
		...
```

and the UI requires two more fields, the day as a `Date.getTime()` and the weekday.

```
{
	"data": [
		{
			"Activity Date": "2019-04-07",
			"Distance": 16901.30078125,
			"day": 1554595200000,
			"weekday": "Sun",
			"firstdayofweek": 1554595200000
		},
		{
			"Activity Date": "2019-04-08",
			"Distance": 10051.400390625,
			"day": 1554681600000,
			"weekday": "Mon",
			"firstdayofweek": 1554595200000
		},
		...
		...
```

The code to do that is

```
	var myDayFunction = function(oRow) { return ... };
	var myWeekDayFunction = function(oRow) { return ... };
	
	var oRowTransformation = new ui5libs.libs.model.mt.RowTransformation( { rootPropertyPath: "/data" } );
	oTransformation.addTransformation(new ui5libs.libs.model.mt.ct.ColumnTransformation( {formatter: myDayFunction, field: "day" } ));
	oTransformation.addTransformation(new ui5libs.libs.model.mt.ct.ColumnTransformation( {formatter: myWeekDayFunction, field: "weekday" } ));
	oTransformation.addTransformation(new ui5libs.libs.model.mt.ct.FirstDayOfWeek( {inputField: "day", field: "weekday" } ));
	
	var oModel = new ui5libs.libs.model.JSONModelE();
	oModel.addRowTransformation(oRowTransformation);
```

The `RowTransformation` defines the path of the array property to transform and it has one `ColumnTransformation` for each additional field to create.


## Example ModelTransformation

Above data is shown in a list but one control should show the sum per week and the header the grant total.
Hence above code gets extended by

```
	var oAggregation = new ui5libs.libs.model.mt.ModelTransformation( {
			groupBy: "firstdayofweek"
			sum: "Distance"
			rootPropertyPath: "/data"
			targetPropertyPath: "/weeklytotals"
			totalsPropertyPath: "/totals"
	} );
	oModel.addModelTransformation(oRowTransformation);
```


## Next steps

- Modeltransformation from a flat table into a nested structure as required by the `sap.ui.table.TreeTable ` control.
- Modeltransformation from a parent-child relational table into a nested structure.
- More formatters for datetime related operations.
- Document the use of all column formatters as UI5 formatter functions.

