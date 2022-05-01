```
OHLCSeries <- CandlestickSeries <- ColumnSeries <- BaseColumnSeries <- XYSeries <- Series <- Component <- Container <- Sprite <- Entity
                              RadarColumnSeries <- BaseColumnSeries
           SmoothedRadarLineSeries <- RadarLineSeries <- LineSeries <- XYSeries
                                  SmoothedXLineSeries <- LineSeries
                                 SmoothedXYLineSeries <- LineSeries
                                  SmoothedYLineSeries <- LineSeries
                                       StepLineSeries <- LineSeries
                                                 ChordDirected <- Chord <- Flow <- Series
                                                                 Sankey <- Flow
                                                                           Venn <- Series
                                                                      WordCloud <- Series
                                                  MapPolygonSeries <- MapSeries <- Series
                                                    MapPointSeries <- MapSeries
                                                     MapLineSeries <- MapSeries
                                                ChordNonRibbon <- Chord
                                  ForceDirected <- LinkedHierarchy <- Hierarchy <- Series
                                           Tree <- LinkedHierarchy
                                                              Pack <- Hierarchy
                                                           Treemap <- Hierarchy
                                             Sunburst <- Partition <- Hierarchy
       PictorialStackedSeries <- PyramidSeries <- FunnelSeries <- PercentSeries <- Series
                                                     PieSeries <- PercentSeries
                                                                         Legend <- Series
                                                                                            HeatLegend <- Container
                                                                                               Tooltip <- Container
                                                                                  RadialLabel <- Label <- Container
                                                      PieChart <- PercentChart <- SerialChart <- Chart <- Container
                                                   SlicedChart <- PercentChart
                                                         RadarChart <- XYChart <- SerialChart
                                                                               RadarCursor <- XYCursor <- Container


                            Bullet <- Entity
      Circle <- Graphics <- Sprite <- Entity
Tick <- Line <- Graphics



GaplessDateAxis <- DateAxis <- ValueAxis <- Axis <- Component
               DurationAxis <- ValueAxis


buildContainer: Container, Series, XYChart
buildSubComponents: Container, SerialChart
applyTemplates: Container, LineSeries, SerialChart
```