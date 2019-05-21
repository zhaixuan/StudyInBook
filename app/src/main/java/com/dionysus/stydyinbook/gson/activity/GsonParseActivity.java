package com.dionysus.stydyinbook.gson.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.json.bean.ShopInfo;
import com.google.gson.Gson;

/**
 * Gson解析页面
 */
public class GsonParseActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private Button mbtnJsonToJavaobject;
    private Button mbtnJsonArrayToJavalist;
    private Button mbtnJavaToJsonObject;
    private Button mbtnJavaToJsonArray;
    private TextView mtxtOriginal;
    private TextView mtxtLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_parse);
        mContext = getApplicationContext();
        initView();
    }

    private void initView() {
        // 设置TitleBar的名称
        TextView txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText(getString(R.string.gson_txt_title_name));
        // 绑定数据
        mbtnJsonToJavaobject = (Button) findViewById(R.id.btn_json_to_javaobject);
        mbtnJsonArrayToJavalist = (Button) findViewById(R.id.btn_jsonarray_to_javalist);
        mbtnJavaToJsonObject = (Button) findViewById(R.id.btn_gson_java_to_jsonobject);
        mbtnJavaToJsonArray = (Button) findViewById(R.id.btn_gson_java_to_jsonarray);
        mtxtOriginal = (TextView) findViewById(R.id.txt_original);
        mtxtLast = (TextView) findViewById(R.id.txt_last);
        //设置按钮的点击事件监听
        mbtnJsonToJavaobject.setOnClickListener(this);
        mbtnJsonArrayToJavalist.setOnClickListener(this);
        mbtnJavaToJsonObject.setOnClickListener(this);
        mbtnJavaToJsonArray.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_json_to_javaobject:
                //（1）将json格式的字符串{}转换为Java对象
                JsonToJavaObjectByGson();
                break;
            case R.id.btn_jsonarray_to_javalist:
                //（2）将json格式的字符串[]转换为Java对象的List
                break;
            case R.id.btn_gson_java_to_jsonobject:
                //（3）将Java对象转换为json字符串{}
                break;
            case R.id.btn_gson_java_to_jsonarray:
                //（4）将Java对象的List转换为json字符串[]
                break;
            default:
                break;

        }
    }

    /**
     * 将json格式的字符串{}转换为Java对象
     */
    private void JsonToJavaObjectByGson() {
        //1.获取或创建数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        //2.解析json数据
        Gson gson = new Gson();
        ShopInfo shopInfo = gson.fromJson(json, ShopInfo.class);
        //3.展示数据
        mtxtOriginal.setText(json);
        mtxtLast.setText(shopInfo.toString());
    }
}
