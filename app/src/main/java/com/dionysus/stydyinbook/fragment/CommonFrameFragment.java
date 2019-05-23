package com.dionysus.stydyinbook.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.adapter.CommonFrameAdapter;
import com.dionysus.stydyinbook.base.BaseFragment;
import com.dionysus.stydyinbook.glide.activity.GlideActivity;
import com.dionysus.stydyinbook.jsonparse.fastjson.FastJsonParseActivity;
import com.dionysus.stydyinbook.jsonparse.gson.GsonParseActivity;
import com.dionysus.stydyinbook.jsonparse.json.activity.NativeJsonParseActivity;
import com.dionysus.stydyinbook.okhttp.activity.OkHttpActivity;
import com.dionysus.stydyinbook.xuitls3.XUitls3Acticity;

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
                if ("okhttp".equals(data.toLowerCase())) {
                    Intent intent = new Intent(mContext, OkHttpActivity.class);
                    mContext.startActivity(intent);
                } else if ("nativejsonparse".equals(data.toLowerCase())) {
                    // 点击条目跳转到手动JSON解析界面
                    Intent intent = new Intent(mContext, NativeJsonParseActivity.class);
                    mContext.startActivity(intent);
                } else if ("gson".equals(data.toLowerCase())) {
                    // 点击条目跳转到手动Gson解析界面
                    Intent intent = new Intent(mContext, GsonParseActivity.class);
                    mContext.startActivity(intent);
                } else if ("fastjson".equals(data.toLowerCase())) {
                    // 点击条目跳转到FastJson解析界面
                    Intent intent = new Intent(mContext, FastJsonParseActivity.class);
                    mContext.startActivity(intent);
                } else if ("xutils3".equals(data.toLowerCase()))
                {
                    // 点击条目跳转到XUtils3界面
                    Intent intent = new Intent(mContext, XUitls3Acticity.class);
                    mContext.startActivity(intent);
                }else if ("glide".equals(data.toLowerCase()))
                {
                    // 点击条目跳转到Glide界面
                    Intent intent = new Intent(mContext, GlideActivity.class);
                    mContext.startActivity(intent);
                }
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
        datas = new String[]{"OKHttp", "NativeJsonParse", "Gson", "FastJson", "XUtils3", "Retrofit2", "Fresco", "Glide", "GreenDao", "RxJava", "Volley", "Picasso", "EventBus", "jcvideoplayer", "pulltorefresh", "Expandablelistview", "UniversalVideoView", "....."};
        // 设置适配器
        commonFrameAdapter = new CommonFrameAdapter(mContext, datas);
        mListView.setAdapter(commonFrameAdapter);
    }
}
