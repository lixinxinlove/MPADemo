package com.eventmosh.mpa.view;

import android.content.Context;
import android.widget.TextView;

import com.eventmosh.mpa.R;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

/**
 * Created by android on 2016/11/3.
 */
public class MyMarkerView extends MarkerView {

    private TextView tvTitle;
    private TextView tvPv;
    private TextView tvUv;
    private  ArrayList<ILineDataSet> lineDataSets;

    private int pos=0;

    public MyMarkerView(Context context, int layoutResource, ArrayList<ILineDataSet> lineDataSets) {
        super(context, layoutResource);
        tvTitle = (TextView) findViewById(R.id.title);
        tvPv = (TextView) findViewById(R.id.pv);
        tvUv = (TextView) findViewById(R.id.uv);

        this.lineDataSets=lineDataSets;
    }

    @Override
    public void refreshContent(Entry entry, Highlight highlight) {

        pos=entry.getXIndex();

        tvTitle.setText("2017年");

        tvPv.setText("pv:"+(int)lineDataSets.get(0).getEntryForIndex(entry.getXIndex()).getVal());
        tvUv.setText("uv:"+(int)lineDataSets.get(1).getEntryForIndex(entry.getXIndex()).getVal());
    }

    @Override
    public int getXOffset(float v) {

        if(pos==6){
            return -getWidth();
        }else {
            return 0;
        }
    }

    @Override
    public int getYOffset(float v) {
        return -(int)v+40;
    }


}
