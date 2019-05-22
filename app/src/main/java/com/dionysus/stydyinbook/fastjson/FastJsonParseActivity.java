package com.dionysus.stydyinbook.fastjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;

/**
 * FastJson数据解析框架（阿里开源）
 * （1）将json格式的字符串{}转换为Java对象
 * （2）将json格式的字符串[]转换为Java对象的List
 * （3）将Java对象转换为json字符串{}
 * （4）将Java对象的List转换为json字符串[]
 */
public class FastJsonParseActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mbtnJsonToJava;
    private Button mbtnJsonArrayToJavaList;
    private Button mbtnJavaToJson;
    private Button mbtnJavaListToJsonArray;
    private TextView mtxtOriginal;
    private TextView mtxtLatest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_json_parse);
        initView();
        setListener();
    }

    /**
     * 初始化按钮的点击监听事件
     */
    private void setListener() {
        mbtnJsonToJava.setOnClickListener(this);
        mbtnJsonArrayToJavaList.setOnClickListener(this);
        mbtnJavaToJson.setOnClickListener(this);
        mbtnJavaListToJsonArray.setOnClickListener(this);
    }

    /**
     * 数据初始化
     */
    private void initView() {
        TextView txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText(getString(R.string.fastjson_txt_title_name));
        mbtnJsonToJava = (Button) findViewById(R.id.btn_json_to_java);
        mbtnJsonArrayToJavaList = (Button) findViewById(R.id.btn_jsonarray_to_javalist);
        mbtnJavaToJson = (Button) findViewById(R.id.btn_fastjson_java_to_json);
        mbtnJavaListToJsonArray = (Button) findViewById(R.id.btn_fastjson_javalist_to_jsonarray);
        mtxtOriginal = (TextView) findViewById(R.id.txt_original);
        mtxtLatest = (TextView) findViewById(R.id.txt_latest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_json_to_java:
                //（1）将json格式的字符串{}转换为Java对象
                break;
            case R.id.btn_jsonarray_to_javalist:
                //（2）将json格式的字符串[]转换为Java对象的List
                break;
            case R.id.btn_fastjson_java_to_json:
                //（3）将Java对象转换为json字符串{}
                break;
            case R.id.btn_fastjson_javalist_to_jsonarray:
                //（4）将Java对象的List转换为json字符串[]
                break;
            default:
                break;
        }
    }
}