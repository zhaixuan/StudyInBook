package com.dionysus.stydyinbook.glide.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.glide.adapter.GlideTransformationAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideTransformationActivity extends Activity {

    @BindView(R.id.txt_title)
    TextView mtxtTitle;
    @BindView(R.id.rv_glide_transformations)
    RecyclerView mrvGlideTransformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_tranformations);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //设置标题
        mtxtTitle.setText("Glide图形变换");
        //初始化Recyclerview
        GlideTransformationAdapter glideTransformationAdapter = new GlideTransformationAdapter(this);
        mrvGlideTransformations.setAdapter(glideTransformationAdapter);
        mrvGlideTransformations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
