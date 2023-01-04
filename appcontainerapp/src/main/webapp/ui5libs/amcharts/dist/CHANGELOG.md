# amCharts 5 Changelog

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/).

Please note, that this project, while following numbering syntax, it DOES NOT
adhere to [Semantic Versioning](http://semver.org/spec/v2.0.0.html) rules.

## [5.2.45] - 2022-12-20

### fixed
- `ZigZag` indicator was always using 5% deviation even if user set a different value.
- If data of a legend was updated, labels of a legend were not updated properly in all cases.
- A tooltip for a `ColumnSeries`/`CandlestickSeries` was not being hidden if a cursor was used and mouse was moved away from the chart.


## [5.2.44] - 2022-12-20

### Fixed
- If a `ForceDirected` node with `topDepth` set to `1` was clicked to hide children and then clicked again to reveal them, the clicked node was hidden. (since 5.2.42)
- `ValueAxis` with `min` and `max` set could result in an empty chart. (since 5.2.43)


## [5.2.43] - 2022-12-19

### Added
- An event `groupintervalchanged` added to `DateAxis`. Kicks in when data grouping is on, and current group interval changes, e.g. via zooming the chart.

### Fixed
- Setting `min` and `max` on a `DateAxis` which was not base axis of a series could result in a stack overflow error in some specific cases.
- `PeriodSelector` was not always highlighting the period button when period was selected via `selectPeriod()` method.
- `PeriodSelector` was not selecting proper start position on some platforms when data grouping was on and `selectPeriod()` was called immediately after initialization of the chart.


## [5.2.42] - 2022-12-16

### Added
- `reverseGeodata` setting added to `MapPolygonSeries`. If set to `true`, will reverse direction of polygon corners in GeoJSON.
- `linechanged` event added to MapLine.

### Fixed
- If a chart had multiple vertically stacked Y axes and `snapToSeries` was set, moving mouse to series in the bottom could cause chart cursor to disappear.
- A legend label for a `ZigZag` indicator was showning "NaN" instead of its `depth` value.
- Hierarchy series' `topDepth` setting was not working properly if set to `>1`.
- If a `Sprite` was hidden, it hid it's tooltip even if the tooltip at the moment was used by other element. This caused some wrong behavior with Axis tooltips, as all axis elements share the same tooltip.
- If a `MapLine` was changed and some `MapPoint` was assigned to this line, `MapPoint` was not always updating its position.
- Map with `geoAlbersUsa` projection was not working if `GraticuleSeries` was added to it.
- `MapLine` was showing tooltips in a wrong position (in case lines were not straight).
- `PeriodSelector` was not properly zooming whe data grouping was enabled.


## [5.2.41] - 2022-12-08

### Fixed
- Canvas left/top position was not set correctly (since 5.2.39).
- `Root`'s setting `tooltipContainerBounds` was not positioning itself outside of the chart if there was space in the chart itself (since 5.2.39).


## [5.2.40] - 2022-12-08

### Fixed
- `Root`'s setting `tooltipContainerBounds` was being ignored on an `XYChart` (since 5.2.39).
- HTML content was clipped to chart's dimensions even if `tooltipContainerBounds` was used.


## [5.2.39] - 2022-12-07

### Added
- `fillOpacity` setting added to `Label`.

### Changed
- The whole under-the-hood implementation of the `Root`'s setting `tooltipContainerBounds`. The change should be transparent, but please inform us if the functionality broke in some way.

### Fixed
- `GraticuleSeries` was not being redrawn if its `clipExtent` was being set after series was already rendered.
- `idField` was not being respected in some cases in a `MapSeries`.
- `MapPointSeries` was not setting map bounds properly if it did not contain any geometries (just points with lat/long).
- `keepTargetHover` on a `Tooltip` was not working when `tooltipContainerBounds` was used in `Root`.


## [5.2.38] - 2022-11-29

### Added
- `clipExtent` added to `GraticuleSeries`. If set to `true`, graticules will be drawn only within bounds of the polygons.

### Fixed
- `ZoomControl` position was wrong sice 5.2.36.


## [5.2.37] - 2022-11-29

### Fixed
- `neutral` is now optional in `IHeatRule`.


## [5.2.36] - 2022-11-29

### Added
- `affectsBounds` setting added to `MapSeries`. Previously only `MapPolygonSeries` affected chart bounds. Now you can tell `MapPointSeries` or `MapLineSeries` to affect map bounds. Or turn off bound checking for some `MapPolygonSeries`, e.g. for background/water.
- `neutral` setting added to `IHeatRule`. If you set some value (color for example), it will be used for items that do not have any value.

### Fixed
- If the last slice of a percent (pie) series slice was hidden, `valueSum` was calculated incorrectly (was using last items value instead of 0).
- `geoPoint()` method of `MapChart` was not working properly.
- `keepTargetHover: true` was not working on all `Hierarchy` charts.
- `ZoomControl` used to override its positional settings like `centerX`, `x`, etc.
- Fix for occasional "Value is not of type 'long'" error.


## [5.2.35] - 2022-11-24

### Fixed
- `exclude` and `include` were not working properly is set on a `MapLineSeries` or `MapPointSeries` (since last release only).


## [5.2.34] - 2022-11-24

### Added
- `backgroundOpacity` setting added to `Exporting`.
- `fixed` property added to `MapPointSeriesDataItem`. Allows sticking a point to screen coordinates, rather than to lat/long on the map.

### Changed
- Various containers in amCharts 5 div (HTML content, tooltips, alerts) will now have class names applied (`"am5-html-container"`, `"am5-reader-container"`, `"am5-focus-container"`, `"am5-tooltip-container"`) so that they can be targeted via CSS, e.g. `.am5-html-container { z-index: -1 }`.
- amCharts will no longer fail if `StyleRule` is created with unparsable selector.

### Fixed
- Labels on `Sunburst` full circle slices were not being properly truncated/sized.
- `startLocation` and `endLocation` was being ignored by `GaplessDateAxis`.
- Dynamically-added heat rules (after series was already created) were not working.


## [5.2.33] - 2022-11-18

### Added
- New pattern type `PathPattern`. Allows using SVG paths as patterns. [More info](https://www.amcharts.com/docs/v5/concepts/colors-gradients-and-patterns/patterns/).

### Changed
- Circular labels (`RadialLabel` with `textType: "circular"`) now have a limited support for `oversizedBehavior`. `"hide"` and `"truncate"` are now supported. The latter will not respect `breakWords` setting, though.

### Fixed
- Hovering, clicking, and unhovering a `PieSeries` slice would not reset its size properly.
- `Label` background was not being sized properly when `fontWeight: bold` was set.
- Dynamically setting `include` or `exclude` on a `MapPolygonSeries` was not updating it until data was re-validated.
- Circular labels on a `Sunburst` diagram were not being positioned properly.


## [5.2.32] - 2022-11-15

### Added
- New global property `am5.registry.version` added. Contains the version of the library.
- `lineType` added to `IMapLineSeriesDataItem`. Allows setting `"straight"` or `"curved"` line type for each map line individually.

### Fixed
- `Label` was ignoring individually-set formatters when formatting number/date/duration values in its text.
- Invoking `PeriodSelector` method `selectPeriod` will now properly highlight related button in selector.
- setting wheelY and WheelX to "none" after the map chart was initialized did not remove wheel behavior.
- Fixed flag bug with `A` and `a` commands in SVG paths.


## [5.2.31] - 2022-10-18

### Changed
- The logic behind `"pro"` tag in `CandlestickSeries` has been updated to more commonly accepted standards. [More info](https://www.amcharts.com/docs/v5/charts/xy-chart/series/candlestick-series/#Professional_candlesticks).
- "Pro Candlesticks" was renamed to "Hollow Candlesticks" in series type switcher in `StockChart`.

### Fixed
- Stacked axis bullets were being positioned not right on the axis but somewhat higher, depending on the number of bullets.
- More ARIA errors fixed in `ExportingMenu`.
- Using arrows to move focused draggable elements was acting unpredictably if mouse was being used, too.
- Further improvements in cursor tooltip arrangement logic.


## [5.2.30] - 2022-10-14

### Added
- `"click"` option added to `showTooltipOn` setting. If set, tooltip will appear when clicking/tapping the element, rather than on hover.
- `ExportMenu` has two new private settings: `menuElement` and `listElement`. Holds actual DOM elements of the menu items.

### Changed
- Disposing `Exporting` object, will now dispose related `ExportingMenu`, if set.
- `Legend`'s item containers will now have `role="checkbox"` set by default.
- Setting `focusable: true` on `XYCursor`'s `lineX` and/or `lineY` will enable moving them with keyboard's arrow keys.
- Better arrangement of tooltips on an `XYChart` with multiple tooltips on the same data point and an `XYCursor` (less chances tooltips going off-screen).

### Fixed
- In some situations chart was not resizing correctly.
- If `sequencedAnimation` was set to `true` on a `LineSeries`, it was drawing line to 0 while animating series.
- `ExportMenu` was using a non-existent "aria" attribute.
- When `snapToSeries` was set on an `XYChart`, zooming to a selection with the cursor produced wrong zoom.
- `XYChart` with `DurationAxis` could freeze the browser in certain configurations and chart sizes.
- `LineSeries` used to draw a line to null values while series was animating (if `sequencedAnimation` was set to `true`).
- Eliminating warnings about `getImageData()` on the new Chrome.


## [5.2.29] - 2022-10-07

### Added
- Additional option for `Label`'s `oversizedBehavior` setting: `"wrap-no-break"`. If set, the labels will wrap to `maxWidth`, but will not brak words even if they do not fit.

### Fixed
- If timezone was set in a chart with a `DateAxis` with `baseInterval` set to `"day"`, axis could show wrong date and axis tooltip could snap to a wring date on a DLS switch.


## [5.2.28] - 2022-10-06

### Added
- `stacked` setting added to `AxisBullet`. If set to `true` and multiple data items (axis ranges) were added to the same date/category, bullets will be stacked on top of each other.

### Fixed
- If a timezone was set and `baseInterval` was a `"month"`, tooltip could show incorrect date value on a month when DLS happened.
- If a new slice was added to `PercentChart` after the initial data was set, the new slice was using first color from colorset instead of the next one.
- Some sprites were not dispatching `boundschanged` event when their settings affecting the bounds were being changed.


## [5.2.27] - 2022-10-04

### Fixed
- `"average"` value of grouped data items was not being calculated properly.
- `WordCloud` was ignoring the `fill` value from label `templateField`.


## [5.2.26] - 2022-09-27

### Fixed
- Version bump.


## [5.2.25] - 2022-09-27

### Fixed
- Using `tooltipContainerBounds` could break layout for the whole document.


## [5.2.24] - 2022-09-27

### Added
- `lineType` (`"curved"`, `"straight"`) added to `MapLineSeries`. `"curved"` (default) connects points using shortest distance, which will result in curved lines based on map projection. `"straight"` connects points using visually straight lines, and will not cross the -180/180 longitude.
- `tooltipContainerBounds` added to `Root` settings. Allows defining margins around chart area for tooltips to go outside the chart itself.

### Changed
- If `tooltipLocation: 0` on a `DateAxis`, it will snap to the closest position now. Previously it snapped to the date over which mouse pointer was, this was not user-friendly in some setups. The same logic now applies to the `CategoryAxis` as well.

### Fixed
- WVAP indicator was showing ZigZag instead.
- Zoom-out button sometimes used to appear while initial animation was playing. Note: if `sequencedAnimation == true`, it will appear anyway.
- Fixed styles issue with date picker in `StockChart`.
- The last bullet of a series could become hidden if `baseInterval` was set to `"month"` on a related `DateAxis`.


## [5.2.23] - 2022-09-20

### Fixed
- On a chart with cursor and `tooltipText` set directly on series' columns, the tooltip was not being shown (since 5.2.19).
- On a chart with X axis `endLocation: 0`, Y axis was not autozooming properly.


## [5.2.22] - 2022-09-15

### Added
- ZigZag indicator added to `StockChart`.

### Changed
- `"%"` number formatting modifier will now consider locale when choosing whether percent sign goes before or after the number. At this moment only `tr_TR` (Turkish) locale is placing percent sign before number.
- `StockChart` indicators, that were using black (`0x000000`) color as a default series color now use `alternativeBackground` color of a theme (they'll now be white if "Dark" theme is used).

### Fixed
- Stock toolbar dropdown items will now display proper `title` attribute.
- HTML tooltips were flashing an unpositioned content briefly.
- The `"Z"` date formatting option was not taking into account Root element's `timezone` setting.
- If a timezone was set on a chart and data grouping was on, the grouping was not paying attention to the timezone.
- If a timezone which was not using DST was set on a chart, and user was in a timezone which used DST, the axis labels were shifted by 1 hour in some setups.
- `GaplessDateAxis` was not working properly with a timezone set.
- `DateAxis` fills that should have been visible were hidden in some cases.
- `StockChart` was incorrectly switching to percent mode when last of the compared series was removed.
- `"p"` number formatting modifier added. Works the same way as `"%"` except it treats numbers as absolute values and does not multiply them by 100.


## [5.2.21] - 2022-09-08

### Added
- Trix, Median Price, and Typical Price indicators added to `StockChart`.
- `valuePercent` was added to `Hierarchy` data items. Indicates percent value based on the value of its direct parent.

### Fixed
- Using relative height of the chart container within a fixed-width wrapper could cause flickering or scrollbars.
- Period values in a `StockChart` indicators were shown with decimal values.
- Fixed a typo in `StockChart` list controls.
- `valuePercentTotal` was not working in `Hierarchy` data items.


## [5.2.20] - 2022-09-05

### Added
- All indicator series will now have `"indicator"` theme tag set. Detect indicator series via `series.hasTag("indicator")`.
- `autoZoom` added to `ValueAxis` (default: `true`). If set to `false`, the axis won't be auto-zoomed to a selection (this works only if the other axis is a `DateAxis` or a `CategoryAxis`). This setting will be ignored if both X and Y axes are a `ValueAxis`.
- `StandardDeviation` indicator added.

### Changed
- Series edit modal on a `StockChart` would show incorrect controls if the main chart series was a `LineSeries`.

### Fixed
- Initial sizing of HTML tooltips fixed (again).
- Exporting a chart in a `<div>` with `height: auto` was not working properly.
- If a point in a `LineSeries` was way out of bounds (million times further than the bounds of plot area), the line could disappear.
- In some cases, if chart was using loadable fonts, it could go into non-stop flickering mode.
- `StockChart` with drawing mode disabled could start drawing new objects if clicked on points of an old drawing.
- `PointedRectangle`, mostly used by a `Tooltip` was drawn incorrectly if its stem size was bigger than height.
- Removing a `QuadrantLineSeries` drawing from a `StockChart` resulted an error.
- It was impossible to delete `Fibonacci` or `FibonacciTimezone` drawings one by one after switching to another drawing tool.


## [5.2.19] - 2022-08-26

### Added
- `geoPoint()` method added to `MapChart`. Returns a geoPoint of the current the center of the map viewport.
- `pancancelled` event added to `XYChart`. It will kick in if pointer is pressed down and released without moving. `panended` event will still kick in.
- `originalEvent` added to `panstarted`, `panended`, and `pancancelled` events.

### Fixed
- Tooltips were not working properly on an `XYChart` if they were placed in a separate root element.
- If an `XYChart` with a `CategoryAxis` had series with missing values, zooming to the part of a series with no data caused value axis not to zoom according to the selection.
- HTML-based tooltips were leaving a visible (albeit transparent) DOM element after tooltip was hidden.
- Clear and erase buttons were not clearing/erasing all the drawings of StockChart properly.


## [5.2.18] - 2022-08-24

### Added
- `disabled` key support added to `DropdownList` item interface.

### Fixed
- Removed leftover debug code in `IndicatorControl`.
- `selected` event in `IndicatorControl` was not firing.
- Adding an adapter on Y-axis' labels could cause flickers on the chart.
- `maxWidth`/`maxHeight` of a `Container` was ignored when arranging objects by Horizontal or Vertical layout.
- `maxWidth`/`maxHeight` of a `Container` was ignored when drawing background.


## [5.2.17] - 2022-08-17

### Added
- `IndicatorControl` setting `indicators` now accepts objects. [More info](https://www.amcharts.com/docs/v5/tutorials/creating-custom-indicators-for-a-stock-chart/#Adding_to_toolbar).
- `getArea()` method added to `MapChart`. Returns area of a `MapPolygon` in square pixels.


## [5.2.16] - 2022-08-16

### Changed
- A clicked `PeriodSelector` button will now stay highlighted until other button is clicked, or chart is zoomed in any other way.
- `SpriteResizer` class moved to main package. It's now accessible via `am5.SpriteResize`.

### Fixed
- Better initial sizing of HTML-content tooltips.
- `MapChart` pan bounds were incorrect after size of a chart's div changed significantly.
- If a panel with a volume series of `StockChart` or volume series itself was removed, adding indicators after this was resulting in an error.
- On a chart with a `CategoryAxis` and series with non-consistent data, some data items might become invisible in some cases.
- Removing a point from `MapPointSeries` was not affecting the `MapLineSeries` with lines that had this point in their `pointsToConnect` setting.
- A `Label` rotated at `-90` angle was not being properly hidden as per `oversizedBehavior: "hide"`.
- Opening a settings modal from `StockLegend` would cause chart to be panned/zoomed when modal was claused.


## [5.2.15] - 2022-08-06

### Added
- Added `PicturePattern` that allows using external images as patterns. [More info](https://www.amcharts.com/docs/v5/concepts/colors-gradients-and-patterns/patterns/#Image_patterns).

### Fixed
- Fixing issue where chart scrollbar would break when zooming.
- Fixing chart being too large and overflowing when zooming in ([Issue 471](https://github.com/amcharts/amcharts5/issues/471)).
- `pan:"zoom"` was not working on left-side Y Axis.
- Removing a panel from a `StockChart` was not removing indicator from charts `indicators` list.
- Zooming chart with custom timezone was resulting in errors in some cases.


## [5.2.14] - 2022-07-23

### Added
- New setting `keepTargetHover` added to `Tooltip` (default: `false`). If set to `true`, hovering the tooltip will be treated like hovering its target element itself.

### Fixed
- Removing `verticalScrollbar` from a `Container` was causing some issues.
- Labels with HTML content and horizontal padding were not being sized/centered properly.
- Date formatting code "EEEE" was producing weekday's short version ("Tue") instead of full one ("Tuesday").
- `Scrollbar` was not working after it was zoomed and clicked on a background to change position, if no animated theme was used.
- Paused animations will no longer obstruct chart export.


## [5.2.13] - 2022-07-19

### Fixed
- Only HTML content will be shown on a `Label` with both `text` and `html` set.
- HTML content will now respect `padding*` settings.
- `"click"` event now works on an element that uses HTML content.
- `snapToSeries` of `ChartCursor` was not working if target series had only one data item.
- Labels of a `PieSeries` were being arranged incorrectly when pie was a semi-circle and `alignLabels` was set to `true`.
- `ForcedDirected` and `Tree` charts were not working properly with `BreadcrumbBar` navigation.


## [5.2.12] - 2022-07-18

### Fixed
- HTML content in tooltips was not being resized properly.


## [5.2.11] - 2022-07-18

### Added
- A new setting `deactivateRoot` (default: `true`) added to `Modal`. Indicates if any interactivity on the underlying chart should be disabled when modal is open.
- A new setting `html` added to `Container`. Set it to a string with HTML to be used as container's content. Will work on any element inheriting from `Container`, e.g. `Label`. [More info](https://www.amcharts.com/docs/v5/concepts/common-elements/html-content/).
- A new setting `labelHTML` added to `Tooltip`. If set, will ne used as HTML content for the tooltip. [More info](https://www.amcharts.com/docs/v5/concepts/common-elements/html-content/).
- A new setting `tooltipHTML` added to `Sprite`. If set, will ne used as HTML content for the tooltip when element is hovered. [More info](https://www.amcharts.com/docs/v5/concepts/common-elements/html-content/).
- `wheelZoomPositionX` and `wheelZoomPositionY` added to `XYChart`. This value is not set by default, but you can use it to fix wheel zooming, to the end (if you set it to 1) or to the start (0) or middle (0.5). In `StockChart`, it is set to 1 by default, as this is common practice in financial charts.
- "Volume-Weighted Average Price (VWAP)" indicator added to `StockChart`.

### Changed
- Setting `id` setting when creating an object will not register it in `am5.registry.entitiesById` immediatelly, without waiting for the next frame.

### Fixed
- `RadialGradient`'s `x` and `y` settings were being ignored.
- Labels as bullets with `oversizedBehavior` set were not being displayed properly in some cases.
- `DateAxis` with `startLocation = 0.5` and `endLocation = 0.5` and single value only was showing a really big date range.
- Resizing `PieChart` to a very small size with a legend positioned on the left or right could cause some anomaly in layout.
- Updating `CategoryAxis` data with less items than there was originally was causing old columns/bullets to be shown.
- Setting `verticalScrollbar` on `Container` to `undefined` to remove a previously set scrollbar was not working.
- On some rare cases, when all values of the series were the same or the difference was very small, ValueAxis could go into stackowerflow and hang the browser.

## [5.2.10] - 2022-06-28

### Added
- `lineJoin` setting added to `Graphics` (default: `"miter"`). Possible values: `"miter"`, `"round"`, and `"bevel"`. [More info](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineJoin).

### Fixed
- `GaplessDateAxis` with one data item was not showing date label at all.
- Setting `colors` on a `ColorSet` will now properly reset all iterators, so that new color generation is consistent.
- If `data.setAll()` was called on a `MapSeries` with `geoJSON` set previously, objects from geoJSON would disappear.
- `PieSeries` was not keeping active slice pulled out when it was hidden and then shown up again.
- PDF export was not taking page orientation into account when auto-fitting an image.


## [5.2.9] - 2022-06-21

### Added
- New properties on `Root`: `tapToActivate` (default: `false`) - if enabled, requires to tap on chart pefore gesture-based functionality (zoom/pan) works, and `tapToActivateTimeout` (default: `3000`) - milliseconds of inactivity before chart becomes "inactive" for touch gestures. [More info](https://www.amcharts.com/docs/v5/getting-started/root-element/#Touch_related_options).

### Changed
- If there are no pan/zoom functionality set on charts, they should not prevent scrolling of the page by touch anymore.
- Bullets will no longer knock off user-set `maxWidth` on their `sprite` element.

### Fixed
- `DateRangeSelector` was not updating its label correctly when dates were picked.
- `LineSeries` with `templateField` and a lot of data items could cause chart to crash.


## [5.2.8] - 2022-06-15

### Added
- Private (read-only) setting `tooltipPosition` added to `Axis`.
- `"line-through"` label decoration added. Works both via `Label`'s `textDecoration` setting, and in-line, e.g. `This is [line-through]a crossed out text[/]`.
- `autoScale` (default: `false`) setting added to `MapPointSeries`. If set to `true`, bullets will resize together with a map while zooming.
- `PieSeries` and `FunnelSeries` now properly support bullets.

### Fixed
- Changing randius or innerRadius on a PieChart was not working.
- Changing legendValueText or legendLabel text on PercentSeries was not working.
- `exportfinished` event was not kicking in.
- Exporting plugin will now try to finish any ongoing rendering before genrating export image.
- Using mouse wheel on a non-chart element that is positioned over the chart works properly now.
- If some non-chart element was rendered over `Scrollbar`, doublicking on a thumb area would still zoom it out.
- Adding `click` event to an `XYChart` was causing it to pan a little when clicked.


## [5.2.7] - 2022-06-07

### Added
- `minDistance` to `LineSeries` (default: 0). If set, it will skip line points closer than X pixels, resulting in a smoother, less cluttery line.
- `isVisibleDeep()` method to `Sprite`. Check not only if `Sprite` itself is visible, but also its all ascendants.

### Changed
- TAB press should now skip over focusable elements of hidden series.

### Fixed
- Toggling `PieSeries` `alignLabels` after the chart was initialized was not working.
- Fixing bug where the wheel event would sometimes not trigger.
- When setting `stockSeries` with a new series on `StockChart` it was not inheriting `stockPositiveColor`/`stockNegativeColor` values.
- Tweaked default `StockToolbar` CSS to act better on pages with larger font sizes.
- DOM elements for focusable series items (columns, bullets, etc.) were being left behind when data for series was updated.
- Exporting chart to image was not inheriting document styles properly.
- If stock series increase/decrease colors were changed and then a series type was changed, new series used to reset colors and not use the ones user set.
- Dynamically changing page-wide font-related CSS (e.g. via media queries) could cause visual anomalies on the chart, especially on axes.


## [5.2.6] - 2022-05-25

### Added
- `nodePadding` added to `Pack`.
- `maxTooltipDistanceBy` with possible values `"x"`, `"y"`, and `"xy"` added. Indicates how distance from mouse pointer to the tooltip point should be measured when comparing with `maxTooltipDistance`.

### Fixed
- Exporting chart image was creating leftover canvas elements in the body of the document.
- Further improvements in `DateAxis` performance with grouping and timezone enabled.


## [5.2.5] - 2022-05-19

### Fixed
- When timezone was set, grouping days into weeks could produce some unexpected results.
- `GaplessDateAxis` first date of a month sometimes could go before the grid of a month.
- Improved performance with data grouping enabled on `DateAxis`, especially when timezone was set. Please note that using timezones will still affect the performance significantly.


## [5.2.4] - 2022-05-17

### Added
- `handleWheel()` method added to `XYChart`. Use it to mirror the same behavior as if the wheel was used on plot area.
- `useDefaultCSS` (default: `true`) setting added to `DateRangeSelector`.
- `inversed` added to `Tree` series. If set to `true`, will flip the direction of the tree.

### Fixed
- `StockToolbar` default CSS was using unnecessarily high `z-index` for its buttons.
- `StockToolbar` datepicker's style was off in some cases.
- `GaplessDateAxis` could display the same month name label two times in a row in some cases.


## [5.2.3] - 2022-05-12

### Changed
- Upgraded versions of `pdfmake` and `xlsx` dependencies.
- Reseting `x` and `y` of the `ForceDirectedSeries` data item will make the node be not ifxed anymore.
- Tweaked styles of `StockToolbar` controls to work better with theme colors.

### Fixed
- Enclosing multi-word parameters in in-line styles were not working.
- `DateAxis` was producing an error if series had no initial data and timezone was set on a root element.
- Vertically-stacked Y-axes was incorrectly plotting related series with Y-axis set as base axis.


## [5.2.2] - 2022-05-03

### Fixed
- Style issue with stroke style selection button in `StockChart` drawing mode.


## [5.2.1] - 2022-05-03

### Added
- `centerMapOnZoomOut` setting added to `MapChart` (default: `true`). Means the map will center itself (or go to `homeGeoPoint` if set) when fully zoomed out.
- `getGroupInterval(duration)` method added to `DateAxis`. Returns a time interval axis would group data to for a specified duration.
- `getIntervalMax(interval)` and `getIntervalMin(interval)` methods added to `DateAxis`. These methods return `min` and `max` of a specified time interval.

### Changed
- Axis fills on a `StockChart` are now not visible by default.
- All `Chart` elements now have `interactiveChildren: true` set by default, so that adding events on a chart does not automatically make all elements in it interactive.
- Zooming out `MapChart` using mouse wheel will now auto-center the map by default. Set `centerMapOnZoomOut: false` to bring back old behavior.

### Fixed
- Changing `inside` and `opposite` of `AxisRendererX` or `AxisRendererY` after the axis was already initialized was not working properly.
- `StockChart`'s' period selection buttons were not zooming to exact dates when data grouping of an X-axis was turned on.
- `StockChart`'s' series type switcher was not switching series properly when data grouping was enabled.
- `StockChart`'s' series type switcher was not switching series properly when comparing mode was on.
- If a `StockChart` was in percent scale mode, adding an indicator which was not on a separate panel was resulting in the indicator using wrong scale.
- Fixed week number calculation (again).
- Fixed CSS of `StockToolbar` for FireFox.
- Pinch-zoom of `MapChart` was ignoring `minZoomLevel` and `maxZoomLevel` settings.


## [5.2.0] - 2022-04-29

### Added
- Initial (beta) version of `StockChart` added. Check [documentation](https://www.amcharts.com/docs/v5/charts/stock/) and [product info](https://www.amcharts.com/stock-chart/).

### Fixed
- Week numbers for "leap weeks" were not being formated properly.
- Removing an axis range with a bullet was not removing the bullet itself.
- If one of the series had less data than another and their date axis had data grouping enabled, data of a series with less values could be not grouped.
- `ColumnSeries` was not coloring its legend marker initially if `useLastColorForLegendMarker` was `true`.
- Hovering on `ExportingMenu` was permanently disabling chart interactivity.


## [5.1.14] - 2022-04-22

### Fixed
- `ValueAxis` with a logarithmic scale was not showing some of the labels in some specific cases.
- Moved `zoomOutButton` of `XYChart` to `topPlotContainer` to solve unwanted zoom when cursor's `snapToSeries` was set.
- Initially-hidden series legend markers were not being dimmed out unless Animated theme was in use.
- When whole series was out of selected scope, its last or first value (depending on seleciton) was still included when calculating min and max, causing chart not to adjust min/max values to a visible series scope.
- `Annotator` was not disabling chart interactivite when activated in Firefox.


## [5.1.13] - 2022-04-15

### Added
- `useLastColorForLegendMarker` setting added to `BaseColumnSeries` (applicable to all column-based series like `ColumnSeries`, `CandlestickSeries`)
- `geodataNames` setting added to `MapSeries`. Allows setting translations to map features, e.g. countries. [More info](https://www.amcharts.com/docs/v5/charts/map-chart/map-translations/).
- Read-only private setting `gridInterval` added to `DateAxis`.

### Fixed
- If geoJSON contained multipolygons with just one polygon, hovering over polygon was resulting in a JS error.
- `DateAxis` displayed wrong time when time was switching to DST, when a timezone was set on a `Root` element.


## [5.1.12] - 2022-04-07

### Fixed
- Rounding a Date during daylight saving hour could produce incorrect result in some specific cases.


## [5.1.11] - 2022-04-06

### Added
- `groupDataWithOriginals` and `groupDataCallback` settings added to `XYSeries`. [More info](https://www.amcharts.com/docs/v5/charts/xy-chart/axes/date-axis/#Custom_aggregation_functions).
- `strictMinMaxSelection` setting added to `ValueAxis`. When set to `true`, the axis won't round `min` and `max` of a selection to the nearest round values, but will use actual min and max (`extraMin` and `extraMax` will still be added if set). This is a good feature when your series displays not actual but derivative values, like `valueYChangeSelection` as it helps to avoid frequent jumping of series to adjusted min and max of the axis.

### Changed
- Internal layout of `XYChart` containers was changed. `plotContainers` now goes to `yAxesAndPlotContainer`, and `plotContainer` and `topPlotContainer` goe into `plotContainers`.

### Fixed
- If `XYChart` was used without animated theme, and scrollbar's background was clicked to zoom to some specific spot, it resulted in scrollbar not being updated anymore when zoomed with wheel or zoom-out button.
- Fixed and issue where nodes of `ForceDirected` series were flickering to 0,0 point when div of a chart was resized.
- Fixed potential XSS injection issue with the accessibility of tooltips.
- `container` setting in `ExportingMenu` was being ignored.
- In some specific cases not all series were included in min/max calculation of a `ValueAxis` resulting not all series to be visible.
- When whole series was out of selected scope, its last or first value (depending on seleciton) was still included when calculating min and max.
- Layouts were allocating space for margins of hidden items.


## [5.1.10] - 2022-03-30

### Added
- New in-line text formatting property `verticalAlign` added. Currently supports only `"super"` and `"sub"` values. E.g. `Copyright[fontSize: 8px; verticalAlign: super;]TM[\]`.

### Changed
- Logarithmic scale on `ValueAxis` was revamped with a different approach. No changes from the configration, but might influence appearance/scale.
- When calculating derivative values for series, `low`, `high`, and `open` used previous `low`, `high`, and `open` values. Now they all use `value` instead.
- Updated to D3 v7.

### Fixed
- In some cases, using a text placehodler, an empty string was shown insteaf of a zero.
- Some grid container masking issues fixed.
- Sometimes `valueAxis` was zoomed-in a bit on the first render of an `XYChart`.
- Axis ranges with `dRadius > 0` were not visible on `RadarChart`.
- Dynamic change of `value*Show` fields of an `XYSeries` was not working.
- Removing data from a legend could lead to JS errors in some particular cases.
- Ghost label was creating a gap in an `XYChartScrollbar` between scrollbar bottom an scrollbar series.


## [5.1.9] - 2022-03-17

### Fixed
- Fixed the issue with resizing a chart inside of a flexbox. ([Issue 311](https://github.com/amcharts/amcharts5/issues/311))
- Fixed jumpy axis when panning an `XYChart` with mouse wheel.
- Panning XYChart with mouse wheel had incorrect direction if axis was inversed.
- If axis range had a gradient fill, gradient used to spread only through visible area, making it look icorrect.
- After pinch zooming and `XYChart` or zooming the chart with no animated theme used, CPU usage used to increase.
- `DateAxis` with `baseIntervals` `timeUnit` set to `"month"` could show incorrect month in the axis tooltip.
- If a `Graphics` had a gradient `fill`/`stroke` and initially was invisible, setting it to visible did not make the gradient to appear.
- While zooming `LineSeries`, a part of the line to the left of the first visible data point could disappear.


## [5.1.8] - 2022-03-10

### Added
- Settings `pinchZoomX` and `pinchZoomY` (defaults: `false`) added to `XYChart`. If set to `true` will allow pinch-zooming of a chart on touch devices. NOTE: these settings are not supported on `RadarChart`.
- `topPlotContainer` added to `XYChart`. It's a `Container` that can be used to place element over plot area.

### Changed
- The types for adapters has been changed to be more intuitive and useful. ([Issue 312](https://github.com/amcharts/amcharts5/issues/312))
- Tapping an element on a touch device will now generate `pointerover` event in addition to `click`. When tapped somewhere else, `pointerout` event will be triggered.

### Fixed
- Fixing ES6 module detection by BundlePhobia again ([Issue 294](https://github.com/amcharts/amcharts5/issues/294)).
- Pinch-zooming of a `MapChart` was not working well in some cases.
- `maxHeight` setting in `Sprite` was not working.
- Change of `minWidth` was not being applied at once, only if some other changes triggered chart to be redrawn.
- Changing or not setting data on an existing `FlowChart` was resulting in a JS error.
- `maxPanOut` setting in `MapChart` was not working.


## [5.1.7] - 2022-02-28

### Fixed
- Grouping to periods where `timeUnit` was `"day"` and `count > 1` was not working properly.
- When tooltips of multiple series were pointing at the same point, series order was not being respected (FF only).
- If a scrollbar was added before axes, scrolling series could result series to be out of sync with bullets.
- Tweaked `nb_NO` locale to better correspond to Norwegian Bokm? date formats.


## [5.1.6] - 2022-02-23

### Fixed
- Totals were not calculated until some interaction with `XYChart` chart if data was grouped initially.
- When tooltips of multiple series were pointing at the same point, series order was not being respected.
- Reverting "Fixing ES6 module detection by BundlePhobia" from 5.1.5 which was causing issues.


## [5.1.5] - 2022-02-22

### Added
- `minSize` setting added to `Flow` (`Chord` and `Sankey`) series. It's a relative value to the sum of all values in the series. If set, this relative value will be used for small-value nodes when calculating their size. For example, if it's set to `0.01`, small nodes will be sized like their value is 1% of the total sum of all values in series.

### Changed
- Direction of vertical panning with mouse wheel in an `XYChart` was inverted to make it consistent with OS native scrolling direction.

### Fixed
- Fixing ES6 module detection by BundlePhobia ([Issue 294](https://github.com/amcharts/amcharts5/issues/294)).
- Parsing of dates using `"i"` format was not working properly when no milliseconds were supplied.
- Using `minZoomCount` and `maxZoomCount` on a `GaplessDateAxis` was not working properly.
- Sometimes vertical `XYChart` scrollbar was not reacting to chart's pan via mouse drag or wheel.
- Using mouse wheel on a chart that was setup to pan was also zooming in/out in addition to pan.
- In some cases grid on `GaplessDateAxis` was not being placed properly. Grid and Label placement improved.
- `ForceDirectedTree` could freeze when used with Animated theme in some cases.
- Changing of baseInterval on DateAxis was not properly working in some cases.
- In some cases, when no animated theme was used, a state on a Sprite was not applied.
- Setting data on `MapSeries` after `geoJSON` was updated was not working properly which resulted heat rules not to be applied.
- It was difficult to make a selection close to the start/end of plot area on `RadarChart`.
- When `XYChart` was fully zoomed in, using mouse wheel would start panning the chart instead of zoom.


## [5.1.4] - 2022-02-11

### Added
- `affectsMinMax` added to value axis range.
- `segments` property added to `Line` class. Allows passing multiple segments instead of continous line.
- `tooltipIntervalOffset` setting added to `DateAxis`. If not set, axis' tooltip will use value of the `-tooltipLocation` (cell start timestamp by default), so that tooltip would should rounded value, like 06:00 instead of 06:30 when interval is hourly. [More info](https://www.amcharts.com/docs/v5/charts/xy-chart/axes/date-axis/#Axis_tooltip).
- `tooltipDateFormats` setting added to `DateAxis`. Allows specifying axis' tooltip date formats for time each time unit, different from `dateFormats`. NOTE: `tooltipDateFormat` will override the format if set. [More info](https://www.amcharts.com/docs/v5/charts/xy-chart/axes/date-axis/#Axis_tooltip).
- `syncWith` setting added to `XYCursor`. Set it to an array of other `XYCursor` objects to automatically position them as the cursor moves. [More info](https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/#syncing-cursors).

### Changed
- Default tooltip date formats have changed slightly for `DateAxis`. Previously, it was using formats from `dateFormats`. Now it uses defaults/user values from newly-introduced `tooltipDateFormats` setting.

### Fixed
- In some cases `DurationAxis` with "second" as its base duration was going to stack overflow.
- Background on a `ValueAxis` was not showing.
- Improved performance for charts with lots of stacked series with null.
- Fixing mouse position when using `transform: scale` or `zoom` ([Issue 258](https://github.com/amcharts/amcharts5/issues/258)).
- Some touch interactions were not working in iOS 12.


## [5.1.3] - 2022-02-03

### Added
- Added second parameter to `Root` constructor which contains settings object. For now, there's only one setting: `useSafeResolution` (default: `true`). [More info](https://www.amcharts.com/docs/v5/getting-started/root-element/#settings).

### Fixed
- Dynamic data updates on `MapPolygonSeries` were not working in some cases.


## [5.1.2] - 2022-02-01

### Added
- `"x!"` and `"y!"` options added to `XYCursor`'s `snapToSeriesBy` setting. Setting it to `"y!"` will make cursor will choose the nearest data point to snap to by measuring only
vertical distance and looking at the data items which are at the current X axis position (date or category). The same applies for `"x!"`.
- `tooltipDataItem` setting added to `XYSeries`. It's a read-only reference to a data item which series tooltip currently uses.

### Fixed
- `LineSeries` legend markers' stroke was not using series' color if `series.appear()` was called after series was initialized.
- `LineSeries` legend marker wasn't working properly if legend was using different `Root` element.
- Better disposing of `<canvas>` elements to work around iOS Safari GC bug.


## [5.1.1] - 2022-01-31

### Added
- New method `remove(key)` on Template's adapaters.
- Each chart-type package now exports its default theme as `DefaultTheme`. E.g. `am5xy.DefaultTheme`, `am5flow.DefaultTheme`, etc.
- TypeScript: Settings interfaces for all objects are now being exposed via bundled re-export files like `index.ts`, `xy.ts`, etc.
- New class `am5.Modal`.
- New `Container` setting: `reverseChildren`. If set to `true`, will start rendering from the last child, effectively flipping the order in how children of the cotainer are laid out. Useful for [right-to-left setups](
https://www.amcharts.com/docs/v5/concepts/locales/right-to-left-support/).

### Changed
- Charts on iOS devices will now automatically use lesser resolution to work around canvas memory restriction introduced in iOS 15 Safari.
- Charts will now use less built-in layers, and thus less `<canvas>` elements by default, reducing memory consumption.
- All low/high-related settings and fields moved from `CandlestickSeries` to `XYSeries`. Sometimes it could be useful to have low/high on other series even if they are not shown visually.

### Fixed
- `XYCursor` was not being hidden when its `positionX` or `positionY` was changed to `undefined` and `alwaysShow` was set to `false`.
- Auto-wrapped right-aligned labels were being rendered in wrong position.
- Auto-wrapped labels were not being trimmed for whitespace on each line.
- `dropFromPrevious` and `riseFromPrevious` states on `ColumnSeries` were not working properly on a column after a gap in data in case previous data item was outside of selection.
- Emoji characters were not being displayed on circular labels.


## [5.1.0] - 2022-01-20

### Added
- New `Root` setting: `timezone`. E.g. `"America/Vancouver"`, `"Australia/Sydney"`, `"UTC"`.
- New export CSV option: `addBOM` (default: `true`). Indicates whether to add BOM characters at start of CSV output so that data viewer (e.g. Excel) knows we're exporting UTF-8 data.
- New methods for `Adapters`: `remove(key)`, `disable(key)`, and `enable(key)`.
- `GaplessDateAxis` added. It's a version of `DateAxis` that removes data-less intervals from its scale. `CategoryAxis` is being deprecated in favor of `GaplessDateAxis`. [More info](https://www.amcharts.com/docs/v5/charts/xy-chart/axes/gapless-date-axis/).
- Timezone support added. [More info](https://www.amcharts.com/docs/v5/getting-started/root-element/#Time_zone).
- New `Component` method: `markDirtyValues()`. Will re-evaluate elements of the component that are data-reliant, such as axis labels.

### Fixed
- Clearing axis ranges from Axis and Series was not working properly.
- Slice with negative arc was ignoring `cornerRadius` property.
- `groupDataDisabled` on `XYSeries` was not working if set to `true`.
- Axis header was not updating its position if axes were stacked and size of an axis was updated.
- Disposing of charts with a lot of elements was quite slow.
- Series stacks with all-zero values could cause all stacks to disappear on zoom.


## [5.0.21] - 2022-01-11

### Added
- New `Sprite` setting: `forceInactive`. If set to `true`, it will override `interactive` setting as well as ignore any interaction events set on the element.
- `cursorhidden` event added to `XYCursor`. Dispatched when user rolls-out of the chart plot area and cursor is hidden.
- New `Component` method: `markDirtyValues()`. Forces a repaint of the element which relies on data.

### Changed
- Value (4th parameter of the Heat rule's `customFunction`) will now receive actual value of the target data item, not interpolated calculated setting value.

### Fixed
- Fixing bug when not passing the duration to the `animate` method ([Issue 181](https://github.com/amcharts/amcharts5/issues/181)).
- Horizontal and vertical layouts with `width`/`height` set in percents plus `minWidth`/`minHeight`/`maxWidth`/`maxHeight` set were arranging items incorrectly.
- Very small slices with `cornrerRadius > 0` were being drawn as a full circle.
- `SliceGrouper` with was not zooming out properly if there was no legend in chart.
- changing `groupData` from `false` to `true` on DateAxis was not working when doing so after the chart was built.


## [5.0.20] - 2021-12-30

### Fixed
- `SliceGrouper` with `clickBehavior = "zoom"` was not zooming out properly.
- `GridLayout` could leave empty gaps if some of the items in it were hidden.
- dragging sprites within rotated containers was not working properly.
- Null value was breaking stacking of columns in some cases.
- Fixing tooltips being broken inside of shadow DOM. ([Issue 166](https://github.com/amcharts/amcharts5/issues/166))


## [5.0.19] - 2021-12-27

### Added
- `groupDataDisabled` setting added to XYSeries. If set to `false` will exclude series from data grouping mechanism, even if it is enabled on related `DateSeries`.
- New plugin `SliceGrouper`. Can be used to automatically group small slices on percent charts like Pie, Funnel, etc. [More info](https://www.amcharts.com/docs/v5/charts/percent-charts/grouping-slices/).

### Fixed
- If data was added to percent series after initial data was already processed, the bew slices would get colors from the start of the color set.
- Multiple square bracket and apostrophe escaping was not working properly.
- A JS error could occur when changing `XYSeries` data with less data items then there were before.
- `PieSeries` were not arranging its labels properly in some cases.
- `XYCursor` taps were not working properly after chart zoom on touch devices.


## [5.0.18] - 2021-12-19

### Changed
- When auto-wrapping labels, text will no longer break on dots to prevent fractional numbers from wrapping.
- Scrollable `Container`'s scrollbar will auto-hide if contents fit in it without scrolling.

### Fixed
- Disabling click-toggling of legend, was disabling hover events, too.
- `ResponsiveTheme`'s custom rules were not working properly.
- `Exporting` was not applying proper background color to exported images.
- `CategoryDateAxis` grid and labels placing algorithm improved.
- Sometimes bullets of XYChart were not being properly clipped by the bounds of the plot area.
- Memory leak related to: https://bugs.chromium.org/p/chromium/issues/detail?id=1279394 was fixed.


## [5.0.17] - 2021-12-15

### Fixed
- `WordCloud` was not coloring words even if colors ColorSet was set or data with colors was used.
- `WordCloud` was not showing anything if all words had the same weight.
- Adding `type` and `main` fields to `package.json`.
- Fixed scrollbar issue with non-animated theme where clicking on a background of a scrollbar would not move to target position.


## [5.0.16] - 2021-12-10

### Added
- `tooltipPositionX` and `tooltipPositionY` added to `XYSeries` (possible values: `"value"`, `"open"`, `"low"`, and `"high"`). Indicates which data item value tooltip should be anchored to.
- New settings added to `Exporting` for formatting durations: `durationFields`, `durationFormat`, and `durationUnit`.
- `showTooltipOn` (default: `"hover"`) added to `Sprite`. Another option is `"always"` which will show tooltip without any interaction with the element. [More info](https://www.amcharts.com/docs/v5/concepts/common-elements/tooltips/#Sticky_tooltips).

### Changed
- `Hierarchy` will now set bottom-level node's `cursorOverStyle: "default"` via theme, instead of hardocding it, so that it can be overridden via node templates.

### Fixed
- Stacked `XYSeries` with missing values and `valueYShow` set to `"valueYTotalPercent"` or `valueXShow` set to `"valueXTotalPercent"` were not showing columns/lines.
- Changing legend position from bottom/top to right/left was not arranging elements properly.
- If `Slice` of a `PieSeries` had a `templateField` set, legend marker was not using all the settings of that slice properly.
- Bullets were causing performance issues when data grouping was turned on.
- `Label` underline was not inheriting label's color properly.
- `Label` underline was not beign placed properly on center/right-aligned labels.


## [5.0.15] - 2021-12-07

### Added
- Experimental support for underlined text added. Can be enabled via `Label` setting `fontDecoration: "underline"`, or via in-line style block (`[underline]`).
- Three new accessibility settings added: `ariaControls`, `ariaValueMin`, and `ariaValueMax`.

### Changed
- Focus elements used for accessibility are now enclosed in a container with `role="application"` which helps avoid "scan mode" in some screen readers.
- Tapping outside chart will now hide `XYCursor`.

### Fixed
- Sometimes `XYCursor` would stay on pointer moved out of chart area quickly.
- Fixed memory leak.
- Arabic text (and possibly other RTL languages) was not being displayed right on circular labels, even with `direction = "rtl"` set.
- Arabic text (`direction = "rtl"`) was being misplaced in tooltips.
- New line was resetting current in-line text style.


## [5.0.14] - 2021-12-01

### Changed
- When setting `markerState` on `Annotator` it will now automatically render annotations without the need to open annotation mode.

### Fixed
- Updating data dynamically on series in all-`ValueAxis` setups.
- Rmoving axis range was not working properly.
- Closing annotation mode would not make chart regain its interactivity.


## [5.0.13] - 2021-11-25

### Added
- `clickTarget` (possible vales: `"itemContainer"` (default), `"marker"`, and `"none"`) added to `Legend`. Use `clickTarget: "none"` to disable toggling of legend items.

### Changed
- Setting `wheelX`/`wheelY` on `XYChart` or `MapChart` no longer marks their plot areas as `wheelable`.

### Fixed
- In some cases using `oversizedBehavior = "wrap"` on labels in super small spaces the chart would hang.
- Updating data on a `ForcedDirectedTree` may cause JS errors.
- Hovering legend item of a hidden slice no longer tries to show the tooltip for it.
- Drill-down maps were displaying country in a wrong position after drill-down.


## [5.0.12] - 2021-11-24

### Added
- `latitudeField` and `longitudeField` added to `MapPointSeries` for an easier way to add data.

### Changed
- Tooltip arrangement algorithm with many XY series was improved.

### Fixed
- Axis fill rule of `DateAxis` sometimes skipped an interval or was drawn two fills in a row. Also, with months as interval between grids, the end of the fill was not at exact position where it should have been.
- When setting new data for a series, if new data has less items than series had before, a JS error could occur.


## [5.0.11] - 2021-11-23

### Added
- New `fps` property on `Root` which defines the maximum FPS that it will run at. Set it 30 or lower if performance is an issue.
- `"range"` theme tag is now added to all axis range elements (axisFill, grid, tick and label) so you could target specific theme rules.
- `"range"` and `"series"` theme tag is now added to all series axis range elements (axisFill, grid, tick and label) so you could target specific theme rules.

### Changed
- A `axisFill` of an axis range will not be shown unless its `visible: true` setting is set.

### Fixed
- Adapter for `text` of a `Label` was not kicking in when data item of its `Tooltip` (or other parent of a Label) was changed.
- Legend marker/label was not returning to a default state when clicked on a disabled item in some cases when Animated theme was not used.
- Axis range fill tooltip was being shown in a wrong position.


## [5.0.10] - 2021-11-22

### Fixed
- `LineSeries`' strokes in an axis range were using wrong template, which could result incorrect colors or other settings (since 5.0.9).
- When data was updated on a live chart and the chart was not fully zoomed-out, some unnecessary Y axis animation used to happen after data update.


## [5.0.9] - 2021-11-22

### Changed
- `maxTooltipDistance` in `XYCursor` now accepts `-1` value, which means that only single tooltip will be shown, even if multiple data items share the same value.

### Fixed
- `GraticuleSeries` was broken.


## [5.0.8] - 2021-11-21

### Changed
- Trying to create a `Root` in a container that already contains a chart will result in a hard error now.
- All `XYSeries` now use both main template and axis range template (the latter has a priority) when decorating columns/lines/etc for the sections covered by axis range.

### Fixed
- Axis fills were not working properly.
- Since 5.0.6: Map was zoomed to incorrect position in some specific cases when `goHome()` method was called.


## [5.0.7] - 2021-11-19

### Added
- New setting `pan` (default: `"none"`) added to `AxisRendererX` and `AxisRendererY`. If set to `"zoom"` will enable zoom of axis scale by dragging in axis label area.

### Changed
- Heat rules will not longer apply setting value if target data item does not have any numeric value.
- Hovering legend item will now simulate hover on related item on some charts (e.g. `PieSeries`, `Hierarchy`, `Venn`).

###
- `HeatLegend` was acting out when its `showValue()` method was called with non-numeric parameter.
- If series was pre-hidden before chart init, its status was not being correctly reflected in related legend item.
- Locales in script version were not working properly.


## [5.0.6] - 2021-11-18

### Added
- Accessibility: new setting on `Sprite`: `focusableGroup`. If set, TAB key will iterate through first elements of each focusable group, allowing user to select within group using arrow keys. [More info](https://www.amcharts.com/docs/v5/concepts/accessibility/#Grouping_focusable_elements).
- New `Root` setting: `autoResize` (default: `true`). If set to `false`, the chart will not automtically resize itself when width/height of its container change. Use `resize()` method to resize manually.
- New `Root` method: `resize()`. Resizes chart to fit container dimensions, if automatic resizing is disabled (`root.autoResize = false`).
- Global `am5.p0` shortcut function added which returns `Percent(0)`.
- All element will now have a read-only property `root` which holds their `Root` object.
- New `Sprite` events: `rightclick` and `middleclick`. Please note that adding `rightclick` event will not disable possible contextual menu on right-mouse click.
- New `XYCursor` setting: `snapToSeriesBy` (default: `"xy"`). Defines in which direction to look when searching for the nearest data item to snap to. Possible values: `"xy"` (default), `"x"`, and `"y"`.

### Changed
- If set `wheel` event will now fire even if `wheelable = false`. This allows capturing wheel events on elements without interfering with scroll of the document.

### Fixed
- `oversizedBehavior` on `Label` (still) was not handling `maxWidth` and `maxHeight` values properly (since `5.0.2`).
- Dynamically updating `geoJSON` on a `MapPolygonSeries` was not working properly in some cases.


## [5.0.5] - 2021-11-15

### Added
- New root element method: `moveDOM()` (accepts element id or reference as a parameter). Can be used to move whole chart to some other container within DOM.

### Fixed
- `ExportingMenu` was interfering with functionality of form elements on the same page (e.g. select).
- Fixed issues with text kerning with styling blocks mid-word.
- Animating values of `width`/`height` settings using percent values was not working properly.


## [5.0.4] - 2021-11-12

### Added
- `panstarted`, `panended`, and `wheelended` events added to `XYChart`.

### Fixed
- Fixed `RadarChart` issues when it was being created in hidden container.
- `XYCursor` and `snapToSeries` problems fixed: was not working with `ColumnSeries`, and was not working properly with stacked axes.
- Adding/changing data on a `DateAxis` with `groupData = true` was not working properly.
- If non-rounded dates were used in data, `XYCursor`'s tooltips were flickering while moving cursor over plot area.


## [5.0.3] - 2021-11-09

### Fixed
- Incorrect sizing of a label in a central `Sunburst` node.


## [5.0.2] - 2021-11-09

### Added
- `radius()` and `baseRadius()` methods added to `RadialLabel`. Return `radius`/`baseRadius` value in pixels, calculated based on all the other settings.
- Global function `am5.ready()` added. Accepts a function as a parameter, which is executed when DOM is ready.

### Changed
- `baseRadius` of `RadialLabel` can now accept Percent values. Previously this property was set internally, now user can set it to a number or percent value.

### Fixed
- Stacking line series with missing data on some series was incorrect.
- `oversizedBehavior` on `Label` was not handling `maxWidth` and `maxHeight` values properly.


## [5.0.1] - 2021-11-05

### Fixed
- `XYChart` with panning enabled an no Animated theme was flickering while panning.
- JS error could occur sometimes if data was updated while cursor was moving over the chart.


## [5.0.0] - 2021-11-02

### Changed
- First public release.


## [5.0.0-beta.44] - 2021-11-02 (release candidate)

### Added
- `Triangle` class added.
- `labelText` setting added to `Tooltip`. If set the text will automatically be applied to tooltip's label.


## [5.0.0-beta.43] - 2021-11-02

### Fixed
- Image resolution could get choppy when resized (since previous version).


## [5.0.0-beta.42] - 2021-11-01

### Added
- If a `Bullet` has `dynamic: true` set, its sprite size will be marked as dirty each time the bullet updates its position.
- Axis name added to `AxisLabel` when created so it could be targeted by axis type in theme rules.

### Changed
- Upgraded to `marker.js` 2.16.2.
- `Annotator` new setting: `markerState`. You can use it to pre-set annotations, or grab annotation data at any time.
- Default text of an `AxisLabel` for `CategoryAxis` set to `"{category}"`.

### Fixed
- `Picture` was not working properly in containers in a non-default layer.
- `locationX` or `locationY` was being ignored on `RadarLineSeries` in some specific cases.
- `Tooltip` as not coloring its text properly with "Dark" theme enabled.


## [5.0.0-beta.41] - 2021-10-31

### Added
- `dRadius` and `dInnerRadius` settings added to `Slice` (default: `0`). Allows tweaking `radius`/`innerRadius` values in charts where these settings are set by the chart (`PieSeries`, circular/radial axis fills, etc.).
- `adjustBulletPosition` added to `BaseColumnSeries` (default: `true`). If set to `false`, bullets will be positioned relatively to whole width/height of the column, rather then the portion that is currently visible.

### Fixed
- `RadarChart` with `RadarLineSeries` could result a JS error when zoomed.


## [5.0.0-beta.40] - 2021-10-30

### Fixed
- `Label` setting `oversizedBehavior` was not working properly when heigh/with was 0.
- `XYSeries` was not calculating `maxWidth`/`maxHeight` properly on data items with negative values.
- Data grouping was not being applied when data was being updated after chart init.


## [5.0.0-beta.39] - 2021-10-29

### Changed
- All `MapChart`-related zoom methods will now return `Animation` object.


## [5.0.0-beta.38] - 2021-10-28

### Added
- `"depthX"` (`depth0`, `depth1`, etc.) tags added to Hierarchy Nodes. This allows targeting node items via theme rules by the level.

### Changed
- A function that returns a Bullet can choose to return nothing, effectively ommitting bullet for the data item.
- `Picture` elements will no inherit interactivity from its parents. If image needs to be interactive it needs to be set so directly via `interactive` setting.
- `Picture` will now use source file's dimensions if neither `width` and `height` is set, and will also maintain aspect ratio if just one from `width` or `height` is set.

### Fixed
- Better color generation and step management in `ColorSet`.


## [5.0.0-beta.37] - 2021-10-26

### Added
- Dataviz, Kelly, Moonrise, Frozen, Material and Spirited themes added.
- `seriesTooltipTarget` setting added to `XYSeries` (possible values: `"series"` (default) and `"bullet"`). If set to `"bullet"`, first bullet of a data item will be used for as a tooltip target, making it inherit bullet's color rather than series.

### Changed
- `Scrollbar` grip buttons will now have `exportable: false` set by default, so that they are not exported to chart snapshots.
- `WordCloud` words are now sorted by value if data was set using `series.data`.

### Fixed
- First label of the `WordCloud` could overlap with other words afer the data update.
- `ColorSet` was ignoring values set in a theme.
- Bullets with `Rectangle` or `RoundedRectangle` as a `sprite` were not being shown on an `XYSeries`.
- `MapChart` was overriding width/height variables to 100%.


## [5.0.0-beta.36] - 2021-10-25

### Added
- New chart type: Venn. [More info](https://www.amcharts.com/docs/v5/charts/venn/).
- New chart type: WordCloud. [More info](https://www.amcharts.com/docs/v5/charts/word-cloud/).

### Changed
- `XYSeries` will now automatically set the first bullet of a data item as the series' `tooltipTarget`. This will make the series tooltip background to change color to
the bullet's fill.

### Fixed
- Code optimizations to reduce size of core package by 10%.
- If data was being set for a `CategoryAxis` not instantly but after some time, the chart was not rendered properly.
- `svgPath` with `A` or `a` commands was not being rendered properly.


## [5.0.0-beta.35] - 2021-10-15

### Added
- New axis type: `DurationAxis`. [More info](https://www.amcharts.com/docs/v5/charts/xy-chart/axes/duration-axis/).
- New formatter type: `DurationFormatter`. [More info](https://www.amcharts.com/docs/v5/concepts/formatters/formatting-durations/).
- New `Root` element property: `durationFormatter`. Holds a global instance of `DurationFormatter` which is used by `DurationAxis`.
- `Annotator` tool added to `Exporting` plugin. [More info](https://www.amcharts.com/docs/v5/concepts/exporting/annotator/).

### Fixed
- Circular labels with `inside = true` where not properly handling line-breaks.


## [5.0.0-beta.34] - 2021-10-13

### Added
- It is now possible to pass a custom draw methods for classes like `Rectangle`, `RoundedRectangle`, `Candlestick`, etc. This allows implementing completely custom look for those elements.

### Changed
- Bullets on a `ColumnSeries` are now positioned vertically relative to visible part of the column, not the whole column.


## [5.0.0-beta.33] - 2021-10-12

### Fixed
- In-line data placeholder formatting functions were not being applied when referring directly to keys in data.
- If settings on a `DataProcessor` were set after it was created, they were being ignored when parsing data.
- In some cases tooltips were losing their background/outline unless Animated theme was enabled.
- In some cases tooltips for a hidden series were still showing.


## [5.0.0-beta.32] - 2021-10-08

### Changed
- `Exporting` plugin now imports minified version of `xlsx` library for XSLX data exports.
- Axis tooltips have now `animationDuration: 200` set automatically by Animated theme, so there's no need to set it in code anymore.

### Fixed
- Charts with `CategoryAxis` + `DateAxis` were zooming incorrectly in some cases.


## [5.0.0-beta.31] - 2021-10-07

### Changed
- Axis will automatically add relative `themeTags` (e.g. `"axis"`, `"y"`, etc.) to a `Tooltip` when it is added. Setting `themeTags` manually is not required anymore.

### Fixed
- An adapter for a setting was not being invoked if source value was `undefined`.
- Tooltips on vertically or horizontally stacked axes were being shown in wrong positions.
- Tooltip background displayed some artifact in some rare cases.


## [5.0.0-beta.30] - 2021-10-05

### Added
- `shadow*` settings are now available on `Label` as well.
- `arrangeTooltips` (default: `true`) setting added to `XYChart`. If set to `false` will disable tooltip overlap check algo.

### Fixed
- Fixed type errors when importing maps (especially in Angular).
- Fixed `templateField` to override `template`.


## [5.0.0-beta.29] - 2021-10-01

### Added
- Wherever date or number format can be set (`DateFormatter`, `NumberFormatter`, `DateAxis`, `ValueAxis`, `Exporting`) it can now be set as `Intl.DateTimeFormatOptions` (for date format) or `Intl.NumberFormatOptions` (for number format) object in additional to string-based format. [More info](https://www.amcharts.com/docs/v5/tutorials/formatting-date-time-and-numbers-using-intl-object/).
- New list type `ListAutoDispose` added.

### Changed
- `XYCursor` will now ignore mouse movement if chart is obstructed by other element, unless zoomin/panning.
- `series`, `xAxes`, and `yAxes` on an `XYChart` are now `ListAutoDispose`, which means that removing items from those lists will automatically dispose them. Set `autoDispose = false` on those lists if you are planning on removing and reusing items.

### Fixed
- `Sunburst` nodes were shown on drill-down when they were not supposed to in some cases.
- `Hierarchy` node elements were ignoring `templateField`.
- It was impossible to move `XYChart` scrollbars to some other container.
- Fixed memory leaking when scrolling `LineSeries`, and when disposing series or other items.
- `XYCursor` was not firing `selectended` event if `behavior` was set to `"selectX"`, `"selectY"`, or `"selectXY"`.
- `XYCursor` was hiding selection when when behavior was set to `"selectX"`, `"selectY"`, or `"selectXY"`.
- `SerialChart.series.clear()` was not working properly.


## [5.0.0-beta.28] - 2021-09-28

### Added
- Two new settings in `Pattern`: `strokeDasharray` and `strokeDashoffset`.
- `Graphics` and `Picture` can now have shadows with additional settings: `shadowColor`, `shadowBlur`, `shadowOffsetX`, `shadowOffsetY`, and `shadowOpacity`. [More info](https://www.amcharts.com/docs/v5/concepts/colors-gradients-and-patterns/shadows/).
- New setting in `ListTemplate`: `autoDispose` (default: `true`). If set to `true` will dispose items removed from the list.

### Changed
- `width` and `height` settings in `Pattern` are now optional.

### Fixed
- Fixed the priority of `template` and `templateField`.
- It's now possible for the user to override the `template` of the `ListTemplate`.
- Fixed a memory leak where series' entities were not properly disposed.
- `DataProcessor` was not parsing dates as `Date` objects unless `dateFormat` was also set (which is completely not needed).
- `setRaw` and `setPrivateRaw` no longer trigger events if the value didn't change.


## [5.0.0-beta.27] - 2021-09-27

### Added
- Root element now has publicly-accessible property: `dom`. Holds a reference to chart container (div).

### Fixed
- Gradient/pattern fills were not working on some elements (since 5.0.0-beta.18).


## [5.0.0-beta.26] - 2021-09-24

### Fixed
- `MapLineSeries` with line geometry inside GeoJSON was not working properly.


## [5.0.0-beta.25] - 2021-09-24

### Added
- New `Entity` setting: `userData`. Use it to store any kind of proprietary data with any object in amCharts 5 that extends `Entity`.

### Changed
- Series axis range will now have `visible: false` set for all axis elements (grid, fill, label, tick) by deafult. If you need to enable them, set `visible: true` on a respective range element. [More info](https://www.amcharts.com/docs/v5/charts/xy-chart/axes/axis-ranges/#Elements_on_a_series_range).

### Fixed
- Improperly closed in-line text style blocks could cause label palcement issues.
- Using `\n\n` in text was not resulting in empty line.
- Horizontal `Sankey` bullets were not using their `locationX` as it should.


## [5.0.0-beta.24] - 2021-09-23

### Added
- `autoRotate` and `autoRotateAngle` settings added to `Bullet`. Works on `Flow` and `MapPointSeries` (when `MapPoint` is attached to a `MapLine`).

### Changed
- `Sankey` bullets will now check `locationY` if series is vertical, and `locationX` of its a horizontal series. It was using `positionY` for all orientations previously.

### Fixed
- In some cases labels with `oversizedBehavior: "fit"` were not being resized when available space was changed.
- `autoRotate`


## [5.0.0-beta.23] - 2021-09-23

### Fixed
- Scrollbar was doing some unneeded animations when grip was released while axis was still animating.
- Double-clicking on scrollbar thumb did not always result full zoomout.
- Clicking on Scrollbar background did not always result in animating to the clicked position.
- `stroke` & `fill` set on `ColumnSeries`' `columns.template` was being overriden by series `stroke` and `fill`.
- Not all settings of `columns.template` were copied to `ColumnSeries`' legend marker.


## [5.0.0-beta.22] - 2021-09-22

### Added
- `PercentSeries`, `FlowNodes`, and `Hierarchy` now have `fillField` setting. It can be used to specify slice/node fill color via data. If not set, colors will be assigned automatically from series' `colors` (`ColorSet`).

### Changed
- The way values of nodes in `Hierarchy` is counted updated to be consistent. There are two options now: a) set values on lowest nodes (no children) so that each node's value is a sum of all its descendants; b) set values for **each** node. Using any other approach might produce unpredictangle results.
- `colors` of the `PercentSeries`, `FlowNodes`, and `Hierarchy` will be reset every time new data is set.

### Fixed
- Charts now will update their resolution when zooming. That fixes blurriness when page is zoomed in.
- In some cases, axis' or series' tooltip was showing correct value but was not positioned in the right position.
- If a `templateField` was set on `FlowNodes`' `rectangles`, the `fill` of the rectangle set in the field was ignored.


## [5.0.0-beta.21] - 2021-09-21

### Fixed
- Compared `XYSeries` with `valueYShow: "valueYChangeSelectionPercent"` were redrawn no taking current zoom into account when mouse cursor left plot area when panning chart.


## [5.0.0-beta.20] - 2021-09-21

### Added
- `toFront()` and `toBack()` methods added to `Sprite`.
- `"above"` setting added to `AxisDataItem`. Allows putting `AxisRange` grid and fill elements above the series.
- New setting `ignoreFormatting` for `Label` added. If set to `true`, it will ignore square-bracketed style blocks and will display text as it is.

### Fixed
- Elements in chart will not generate hover events if they are obstructed by some other DOM element anymore.
- `XYSeries` with a vertical axis range was fully visible, even the part covered by an axis range.
- Axis bullets were not being hidden when axis data item was hidden.
- Labels in `BreadcrumbBar` were sometimes misaligned in Safari browser.
- Legend item of an initially-hidden series/slices/columns was being shown as enabled.


## [5.0.0-beta.19] - 2021-09-18

### Fixed
- Removing an axis from `xAxes` or `yAxes` was not working properly in some cases.
- If a `templateField` was set on some child of a bullet's `sprite`, it was being ignored.


## [5.0.0-beta.18] - 2021-09-17

### Added
- `areLinked()` method added to `LinkedHierarchy`.
- `unlinkDataItems()` method added to `LinkedHierarchy`.
- Global function `am5.disposeAllRootElements()` added. Disposes all charts.
- `am5.registry.rootElements` added which holds an array with instances of all active `Root` elements.
- `seriesGraphics` property added to `PictorialStackedSeries`. It's a `Graphics` which shows `svgPath` shape under all slices. Useful when `startLocation`/`endLocation` is used to make slices not occupy whole shape area.

### Changed
- `maxPanOut` of `MapChart` is temporarily disabled until we figure out proper behavior for it.

### Fixed
- Linking nodes with `linkDataItems` of `LinkedHierarchy` was not working if called after the data was set.
- `Micro` theme was not removing padding from charts.
- Adding in `@types/geojson` as a dependency.
- Map could jump to unpredictable position after the chart's container size changed and user zoomed or panned the map.
- In some cases `Label` with `oversizedBehavior = "fit"` could be incorrectly positioned.
- Removing series and axes from a serial chart was not working properly.


## [5.0.0-beta.17] - 2021-09-15

### Changed
- Default for `Treemap` setting `layoutAlgorithm` changed to `"squarify"`.
- Providing value in Hierarchy node's data will override sum of its children (except for `Pack`).

### Fixed
- `ForceDirected` nodes were linked to invisible top node even though `topDepth` was set to `1` meaning top node should not be visible. This was causing issues with the layout of such nodes.


## [5.0.0-beta.16] - 2021-09-14

### Fixed
- Fills for axis ranges could go out of plot area bounds.
- Tooltip of Y axis could be displayed out of bounds in some cases.


## [5.0.0-beta.15] - 2021-09-14

### Added
- `dynamic` setting added to `Bullet`, for the bullets that need their `sprite` element redrawn when related series changes in any way.
- `ClockHand` now supports negative radius value (distance from the target axis outer radius in pixels).
- `syncWithAxis` added to `ValueAxis`. If enabled, will sync grid between the axes.

### Changed
- If legend items container toggle key is set to `"none"`, clicking on the legend item will not do anything now.
- In `MapLineSeries`, if a data item had `pointsToConnect` set, map line now first looks at the point's longitude/latitude setting and then at the geometry.

### Fixed
- Play button was not chaning to default state instantly.
- Change of `curveFactory` of `LineSeries` was not forcing redraw of the series.
- `StepLineSeries` was not drawn properly when both X and Y axes were `ValueAxis`.
- `StepLineSeries` was not showing tooltip when it was set as a `snapToSeries` on chart Cursor.
- Theme rules now have the correct priority no matter where they are defined.


## [5.0.0-beta.14] - 2021-09-10

### Fixed
- `Scrollbar` grips' theme tags modified so that a correct color would be used.
- `XYCursor` with multiple entried in `snapToSeries` was causing multiple tooltips to show at all times.


## [5.0.0-beta.13] - 2021-09-09

### Added
- `Star` now supports inner radius set in percent.

### Fixed
- Tooltips for radar series were not show with `RadarCursor`.
- In some cases, Scrollbars were not being updated when zoomed-in with cursor.
- Clicking on scrollbar's background resulted in scrollbar animation, but the scrollbar did not update its axis.
- Dynamically changing `geoJSON` on a `MapSeries` was not working


## [5.0.0-beta.12] - 2021-09-08

### Added
- `AxisRendererCircular` now supports negative radius values.

### Changed
- When a template state is changed, it now automatically updates related `Entity`'s state as well.

### Fixed
- `LineSeries` was not working properly with `templateField` set on `strokes` or `fills`.
- `LineSeries` could stop drawing line while zooming if there were gaps in the data.


## [5.0.0-beta.11] - 2021-09-08

### Changed
- `fill` and `stroke` settings moved from `XYSeries` to `Series`, so that all series like `MapSeries` could be shown in Legend.
- Text of a tooltip text will now adaptively change color based on current background color.

### Fixed
- `"click"` event is no longer fired on right-click.
- Changing data dynamically on map-related series was not working properly.
- Switching projection on a zoomed-in/translated map was resulting in new map to be in a wrong position.


## [5.0.0-beta.10] - 2021-09-07

### Fixed
- A quick flash of chart position fixed (introduced in `5.0.0-beta.9`).
- MapChart.goHome() method fixed.


## [5.0.0-beta.9] - 2021-09-06

### Added
- `id` setting to all entities. If set, will also appear in `am5.registry.entitiesById`.
- `show()` and `hide()` methods of `DataItem` now accept duration param.

### Fixed
- Stacking of horizontal bars was not working properly.
- Children of a `Container` were not being disposed properly together with the container itself.
- Tooltip for a series close to the top/bottom of a plot area sometimes was not being displayed.
- `PieSeries` was overriding label `textType` setting.
- `XYChart` and `MapChart` were taking over mouse wheel action even when `wheelY` and `wheelX` were set to `"none"`.
- `XYCursor` was not showing series tooltips if Y axis was not a `ValueAxis`.
- `XYCursor` was showing previous data point tooltip if currently hovered position did not have data item or value was null.
- Percent chart could go to SO if there were no values in data.
- Changing `layer` value dynamically was not working properly.


## [5.0.0-beta.8] - 2021-09-02

### Added
- `deltaPosition` added to data item of a `CategoryAxis`. Can be used for sorting series columns without modifying data order.
- `resetExtremes()` method added to `XYSeries`. Resets series extremes to `undefined`. Can be used when values of a series are changed from outside.


## [5.0.0-beta.7] - 2021-08-31

### Added
- New `themeTagsSelf` setting for Entity which is the same as `themeTags` except it doesn't apply to the children.
- `clipBack` setting added to `MapLineSeries`.

### Changed
- Tooltips and Cursor are now `exportable: false` by default (meaning they won't be included in exported images).

### Fixed
- Sometimes plot container of an `XYChart` was not registering pointerout event.
- Accessibility: Not-measured items (e.g. columns) were not being properly outlined when focused.
- Zoom out button only zoomed out axes but not scrollbars.
- If a zoom out button was over columns or other interactive element, it was not working.
- `goHome()` method of `MapChart` was not working properly.
- Fixed fill style for `Scrollbar` grips.


## [5.0.0-beta.6] - 2021-08-29

### Fixed
- Hiding chart container or setting its width/height to zero was resulting in error.
- State setting values set in theme rules/templates were not being applied.
- Improved arrangement of multiple tooltips on a `XYChart`.
- Improved alignment of Legend labels improved.
- Huge numbers in `layer` setting were resulting in severe degration of performance.


## [5.0.0-beta.5] - 2021-08-27

### Fixed
- Fixed `RadarCursor` issues.


## [5.0.0-beta.4] - 2021-08-27

### Fixed
- Initial bugfixes.


## [5.0.0-beta.3] - 2021-08-25

### Fixed
- Initial bugfixes.


## [5.0.0-beta.2] - 2021-08-16

### Fixed
- Initial bugfixes.


## [5.0.0-beta.1] - 2021-08-13

### Added
- Initial preview release
