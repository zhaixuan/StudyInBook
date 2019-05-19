package com.dionysus.stydyinbook.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.dionysus.stydyinbook.base.BaseFragment;

/**
 * Author:Administrator
 * Date:2019/5/19 9:56
 * Description: 其他的Fragment
 */
public class OtherFragment extends BaseFragment {

    private static final String TAG = "OtherFragment";
    private TextView mTextView;

    @Override
    protected View initView() {
        Log.e(TAG, "其他Fragment页面被初始化了");
        mTextView = new TextView(mContext);
        mTextView.setText("其他页面");
        mTextView.setTextSize(20);
        mTextView.setTextColor(Color.RED);
        mTextView.setGravity(Gravity.CENTER);
        return mTextView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "其他Fragment页面数据被初始化了");
    }
}
