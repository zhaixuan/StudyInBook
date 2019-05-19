package com.dionysus.stydyinbook.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.adapter.CommonFrameAdapter;
import com.dionysus.stydyinbook.base.BaseFragment;

/**
 * Author:Dionysus
 * Date:2019/5/19 9:56
 * Description: 常用框架的Fragment
 */
public class CommonFrameFragment extends BaseFragment {

    private static final String TAG = "CommonFrameFragment";
    private ListView mListView;
    private String[] datas;
    private CommonFrameAdapter commonFrameAdapter;

    @Override
    protected View initView() {
        Log.e(TAG, "常用框架Fragment页面被初始化了");
        View view = View.inflate(mContext, R.layout.layout_common_frame, null);
        mListView = view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                Toast.makeText(mContext, data, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架Fragment页面数据被初始化了");
        // 准备数据
        datas = new String[]{"OKHttp", "XUtils3", "Retrofit2", "Fresco", "Glide", "GreenDao", "RxJava", "Volley", "Gson", "FastJson", "Picasso", "EventBus", "jcvideoplayer", "pulltorefresh", "Expandablelistview", "UniversalVideoView", "....."};
        // 设置适配器
        commonFrameAdapter = new CommonFrameAdapter(mContext, datas);
        mListView.setAdapter(commonFrameAdapter);
    }
}
