package com.dionysus.stydyinbook.glide.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_glide)
public class GlideActivity extends AppCompatActivity {

    @ViewInject(R.id.txt_title)
    private TextView mtxtTitle;
    @ViewInject(R.id.btn_base_use)
    private Button mbtnBaseUse;
    @ViewInject(R.id.btn_recyclerview)
    private Button mbtnRecyclerview;
    @ViewInject(R.id.btn_tranfromtations)
    private Button mbtnTranfromtations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        x.view().inject(this);
        //设置标题名称
        mtxtTitle.setText(getString(R.string.glide_txt_title_name));
    }
}
