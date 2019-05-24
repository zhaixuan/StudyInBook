package com.dionysus.stydyinbook.glide.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideActivity extends AppCompatActivity {

    @BindView(R.id.txt_title)
    TextView mtxtTitle;
    @BindView(R.id.btn_base_use)
    Button mbtnBaseUse;
    @BindView(R.id.btn_recyclerview)
    Button mbtnRecyclerview;
    @BindView(R.id.btn_tranfromtations)
    Button mbtnTranfromtations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mtxtTitle.setText("Glide");
    }

    @OnClick({R.id.btn_base_use, R.id.btn_recyclerview, R.id.btn_tranfromtations})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_base_use:
                startActivity(new Intent(this, GlideBaseActivity.class));
                break;
            case R.id.btn_recyclerview:
                startActivity(new Intent(this, GlideRecyclerviewActivity.class));
                break;
            case R.id.btn_tranfromtations:
                startActivity(new Intent(this, GlideTranformationsActivity.class));
                break;
            default:
                break;
        }
    }
}
