package com.dionysus.stydyinbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRgMain = (RadioGroup) findViewById(R.id.rg_main);
        // 设置默认选中常用框架
        mRgMain.check(R.id.rb_common_frame);
    }
}
