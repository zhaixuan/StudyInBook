package com.dionysus.stydyinbook.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author： Dionysus
 * @Date： 2019/5/19 22:58
 * @Description: 常用框架的Fragment
 */
public class CommonFrameAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] mDatas;

    public CommonFrameAdapter(Context context, String[] datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(20);
        textView.setText(mDatas[position]);
        textView.setPadding(20, 15, 0, 15);
        return textView;
    }
}
