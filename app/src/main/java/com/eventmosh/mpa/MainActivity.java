package com.eventmosh.mpa;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private LineChart mChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChart = (LineChart) findViewById(R.id.chart);

        initLineChart(mChart);
        LineData mLineData = getLineData(7, 100);
        showChart(mChart, mLineData, Color.rgb(114, 188, 223));
    }


    private void initLineChart(LineChart mChart) {

        XAxis xAxis;         //X坐标轴
        YAxis yAxis;         //Y坐标轴
        YAxis yAxisRight;         //Y坐标轴

        xAxis = mChart.getXAxis();
        yAxis = mChart.getAxisLeft();
        yAxisRight = mChart.getAxisRight();

        // 把X坐标轴放置到底部。默认的是在顶部。
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // X轴坐标线的颜色
        xAxis.setAxisLineColor(Color.WHITE);
        xAxis.setTextColor(Color.WHITE);


        //X轴上的刻度竖线的颜色
        xAxis.setGridColor(Color.WHITE);
        yAxis.setEnabled(false);
        yAxisRight.setEnabled(false);

        mChart.getAxisRight().setDrawGridLines(true);
        mChart.getAxisLeft().setDrawGridLines(false);



    }


    // 设置显示的样式
    private void showChart(LineChart lineChart, LineData lineData, int color) {

        lineChart.setDrawBorders(true);  //是否在折线图上添加边框
        lineChart.setBorderColor(Color.WHITE);
        lineChart.setBorderWidth(0.35f);
        // no description text
        lineChart.setDescription("");// 数据描述
        // 如果没有数据的时候，会显示这个，类似listview的emtpyview
        lineChart.setNoDataTextDescription("You need to provide data for the chart.");

        // enable / disable grid background
        lineChart.setDrawGridBackground(false); // 是否显示表格颜色
        lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // 表格的的颜色，在这里是是给颜色设置一个透明度

        // enable touch gestures
        lineChart.setTouchEnabled(true); // 设置是否可以触摸

        // enable scaling and dragging
        lineChart.setDragEnabled(false);// 是否可以拖拽
        lineChart.setScaleEnabled(false);// 是否可以缩放

        // if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(false);//

        lineChart.setBackgroundColor(color);// 设置背景

        // add data
        lineChart.setData(lineData); // 设置数据

        // get the legend (only possible after setting data)
        Legend mLegend = lineChart.getLegend(); // 设置比例图标示，就是那个一组y的value的

        // modify the legend ...
        // mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
        mLegend.setForm(Legend.LegendForm.CIRCLE);// 样式
        mLegend.setFormSize(6f);// 字体
        mLegend.setTextColor(Color.WHITE);// 颜色
//      mLegend.setTypeface(mTf);// 字体

        lineChart.animateX(500); // 立即执行的动画,x轴
    }

    /**
     * 生成一个数据
     *
     * @param count 表示图表中有多少个坐标点
     * @param range 用来生成range以内的随机数
     * @return
     */
    private LineData getLineData(int count, float range) {

        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xValues.add(""+i);
        }

        // y轴的数据
        ArrayList<Entry> yValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float value = (float) (Math.random() * range)*2 + 3;
            yValues.add(new Entry(value, i));
        }

        // create a dataset and give it a type
        // y轴的数据集合
        LineDataSet lineDataSet = new LineDataSet(yValues, null /*显示在比例图上*/);
        // lineDataSet.setFillAlpha(110);
        //lineDataSet.setFillColor(Color.RED);



        //用y轴的集合来设置参数
        lineDataSet.setLineWidth(1.75f); // 线宽
        lineDataSet.setCircleSize(6f);// 显示的圆形大小
        lineDataSet.setColor(Color.WHITE);// 显示颜色
        lineDataSet.setCircleColor(Color.WHITE);// 圆形的颜色
        lineDataSet.setHighLightColor(Color.RED); // 高亮的线的颜色
        lineDataSet.setDrawHorizontalHighlightIndicator(false); // 是否显示横向高亮的线
        lineDataSet.setCircleRadius(3f);
        lineDataSet.setDrawCubic(true); //是否弧线
        lineDataSet.setCircleColorHole(Color.RED);

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
        lineDataSets.add(lineDataSet); // add the datasets


        ArrayList<Entry> yValues2 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float value = (float) i * 50;
            yValues2.add(new Entry(value, i));
        }

        LineDataSet lineDataSet2 = new LineDataSet(yValues2, null);
        lineDataSet2.setLineWidth(1.75f); // 线宽
        // lineDataSet2.setCircleSize(6f);// 显示的圆形大小
        lineDataSet2.setCircleRadius(6f); //显示的圆形大小
        lineDataSet2.setColor(Color.WHITE);// 显示颜色
        lineDataSet2.setCircleColor(Color.WHITE);// 圆形的颜色
        lineDataSet2.setHighLightColor(Color.BLUE); // 高亮的线的颜色
        //lineDataSet2.setHighlightLineWidth(1f); // 高亮的线的宽
        lineDataSet2.setDrawHorizontalHighlightIndicator(false); // 是否显示横向高亮的线
        lineDataSet2.setCircleRadius(3f);
        lineDataSet2.setDrawCubic(true); //是否弧线
        lineDataSet2.setCircleColorHole(Color.BLUE);
        lineDataSet2.setDrawStepped(true);
       // lineDataSet2.setValueTextColor(Color.TRANSPARENT); //设置提示文字为透明

        lineDataSets.add(lineDataSet2);

        // create a data object with the datasets
        LineData lineData = new LineData(xValues, lineDataSets);

        return lineData;
    }


}

