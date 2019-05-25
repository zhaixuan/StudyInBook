package com.dionysus.stydyinbook.glide.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.glide.adapter.GlideRecyclerviewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideRecyclerviewActivity extends Activity {

    @BindView(R.id.txt_title)
    TextView mtxtTitle;
    @BindView(R.id.rv_glide)
    RecyclerView mrvGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_recyclerview);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mtxtTitle.setText("Glide在Recyclerview中加载图片");
        //初始化Recyclerview
        GlideRecyclerviewAdapter glideRecyclerviewAdapter = new GlideRecyclerviewAdapter(this);
        mrvGlide.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mrvGlide.setAdapter(glideRecyclerviewAdapter);
    }
}
