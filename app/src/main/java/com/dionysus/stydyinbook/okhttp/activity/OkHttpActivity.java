package com.dionysus.stydyinbook.okhttp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dionysus.stydyinbook.R;

/**
 * 手动JSON解析页面
 * 需要完成的事情：
 * （1）将json格式的字符串{}转换为Java对象
 * （2）将json格式的字符串[]转换为Java对象的List
 * （3）复杂json数据解析
 * （4）特殊json数据解析
 */
public class OkHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
    }
}
