var id = 0;

function createDiv() {
  id++;
  var div = document.getElementById("chartdiv");
  var container = document.createElement("div");
  container.id = "chart" + id;
  container.style.width = "300px";
  container.style.height = "300px";
  container.style.float = "left";
  container.style.margin = "10px";
  container.style.border = "1px solid #eee";
  div.appendChild(container);
  return container;
}


function createXY(column = true) {
  var root = am5.Root.new(createDiv());

  root.setThemes([
    am5themes_Animated.new(root)
  ]);

  var chart = root.container.children.push(
    am5xy.XYChart.new(root, {
      panX: false,
      panY: false,
      wheelX: "panX",
      wheelY: "zoomX"
    })
  );

  var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
    behavior: "zoomX"
  }));
  cursor.lineY.set("visible", false);

  var date = new Date();
  date.setHours(0, 0, 0, 0);
  var value = 100;

  function generateData() {
    value = Math.round((Math.random() * 10 - 5) + value);
    am5.time.add(date, "day", 1);
    return { date: date.getTime(), value: value };
  }

  function generateDatas(count) {
    var data = [];
    for (var i = 0; i < count; ++i) {
      data.push(generateData());
    }
    return data;
  }

  var xAxis = chart.xAxes.push(
    am5xy.DateAxis.new(root, {
      maxDeviation: 0,
      baseInterval: { timeUnit: "day", count: 1 },
      renderer: am5xy.AxisRendererX.new(root, {
        minGridDistance: 30
      })
    })
  );

  xAxis.get("periodChangeDateFormats")["day"] = "MMM";
  xAxis.get("dateFormats")["day"] = "dd";

  var yAxis = chart.yAxes.push(
    am5xy.ValueAxis.new(root, {
      renderer: am5xy.AxisRendererY.new(root, {})
    })
  );

  xAxis.set("tooltip", am5.Tooltip.new(root, {}))

  var series;

  if (column) {
    series = chart.series.push(
      am5xy.ColumnSeries.new(root, {
        name: "Series",
        xAxis: xAxis,
        yAxis: yAxis,
        valueYField: "value",
        valueXField: "date"
      })
    );
  }
  else {
    series = chart.series.push(
      am5xy.LineSeries.new(root, {
        name: "Series",
        xAxis: xAxis,
        yAxis: yAxis,
        valueYField: "value",
        valueXField: "date"
      })
    );

    series.strokes.template.setAll({
      strokeWidth: 2
    });
  }

  var tooltip = series.set("tooltip", am5.Tooltip.new(root, {}));
  tooltip.label.set("text", "{valueY}");

  var data = generateDatas(30);
  series.data.setAll(data);

  series.appear();
  chart.appear();
}

function createPie() {
  var root = am5.Root.new(createDiv());

  root.setThemes([
    am5themes_Animated.new(root)
  ]);

  var chart = root.container.children.push(
    am5percent.PieChart.new(root, {
      layout: root.verticalLayout,
      innerRadius: am5.percent(50)
    })
  );

  var series = chart.series.push(am5percent.PieSeries.new(root, {
    valueField: "value",
    categoryField: "category",
    alignLabels: false
  }));

  series.labels.template.setAll({
    forceHidden: true
  });

  series.ticks.template.setAll({
    forceHidden: true
  });

  series.data.setAll([
    { value: 10, category: "One" },
    { value: 9, category: "Two" },
    { value: 6, category: "Three" },
    { value: 5, category: "Four" },
    { value: 4, category: "Five" },
    { value: 3, category: "Six" },
    { value: 1, category: "Seven" },
  ]);

}

for (var i = 0; i < 10; i++) {
  createXY(true);
  createPie();
  createXY(false);
  createPie();
}