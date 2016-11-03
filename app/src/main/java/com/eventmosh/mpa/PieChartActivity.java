package com.eventmosh.mpa;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    private PieChart mPieChart;

    // 凑成100 % 100
    private float[] y = { 30f, 40f, 30f };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        mPieChart= (PieChart) findViewById(R.id.pic_chart);

        initData();
        initStyle(mPieChart);
    }

    private void initStyle(PieChart pieChart) {

        pieChart.setDescription("");
        pieChart.setBackgroundColor(Color.TRANSPARENT);

        pieChart.setCenterText("123人");
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setCenterTextSize(15f);

        pieChart.setDrawHoleEnabled(true);
       // pieChart.setMaxAngle(180f);
        pieChart.setDrawSlicesUnderHole(true);
      //  pieChart.setD
        pieChart.setDrawSliceText(true);

        pieChart.setDragDecelerationFrictionCoef(0.90f);
        pieChart.setHoleRadius(50f);
        pieChart.setTransparentCircleRadius(61f);

        Legend mLegend = pieChart.getLegend();  //设置比例图
        mLegend.setEnabled(false);
      //  mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_INSIDE);  //最右边显示

    }


    private void initData(){

        // 准备x"轴"数据：在i的位置，显示x[i]字符串
        ArrayList<String> xVals = new ArrayList<>();
        xVals.add("北京");
        xVals.add("天津");
        xVals.add("河北");

        // 真实的饼状图百分比分区。
        // Entry包含两个重要数据内容：position和该position的数值。
        ArrayList<Entry> yVals = new ArrayList<>();

        for (int xi = 0; xi < 3; xi++) {
           // xVals.add(xi,xVals.get(xi));
            // y[i]代表在x轴的i位置真实的百分比占
            yVals.add(new Entry(y[xi], xi));
        }

        PieDataSet pieDataSet = new PieDataSet(yVals,null);

        // 每个百分比占区块绘制的不同颜色
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        pieDataSet.setColors(colors);

        pieDataSet.setValueTextSize(12f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setSelectionShift(20f);

        pieDataSet.setHighlightEnabled(true);


        //格式化数据
        pieDataSet.setValueFormatter(new ValueFormatter(){

            DecimalFormat mFormat=new DecimalFormat();

            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return mFormat.format(v) + " %";
            }
        });


        // 将x轴和y轴设置给PieData作为数据源

        PieData data = new PieData(xVals, pieDataSet);


        mPieChart.setData(data);
    }
}
