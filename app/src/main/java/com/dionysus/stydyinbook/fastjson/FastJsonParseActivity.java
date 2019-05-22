package com.dionysus.stydyinbook.fastjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;

/**
 * FastJson数据解析框架（阿里开源）
 * （1）将json格式的字符串{}转换为Java对象
 * （2）将json格式的字符串[]转换为Java对象的List
 * （3）将Java对象转换为json字符串{}
 * （4）将Java对象的List转换为json字符串[]
 */
public class FastJsonParseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_json_parse);
        TextView txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText(getString(R.string.fastjson_txt_title_name));
    }
}
