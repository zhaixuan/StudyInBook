package com.dionysus.stydyinbook.jsonparse.fastjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.jsonparse.json.bean.ShopInfo;

import java.util.ArrayList;
import java.util.List;

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
                jsonToJavaObjectByFastJson();
                break;
            case R.id.btn_jsonarray_to_javalist:
                //（2）将json格式的字符串[]转换为Java对象的List
                jsonArrayToJavaListByFastJson();
                break;
            case R.id.btn_fastjson_java_to_json:
                //（3）将Java对象转换为json字符串{}
                javaObjectToJson();
                break;
            case R.id.btn_fastjson_javalist_to_jsonarray:
                //（4）将Java对象的List转换为json字符串[]
                javaListToJsonArray();
                break;
            default:
                break;
        }
    }

    /**
     * 将Java对象的List转换为json字符串[]
     */
    private void javaListToJsonArray() {
        //1.创建一个java集合
        ShopInfo xiaolongxia = new ShopInfo(1, "小龙虾", 100.0, "xiaokogxia");
        ShopInfo huajia = new ShopInfo(2, "花甲", 28.0, "huajia");
        List<ShopInfo> shops = new ArrayList<>();
        shops.add(xiaolongxia);
        shops.add(huajia);
        //2.解析json数据
        String jsonArray = JSON.toJSONString(shops);
        //3.展示数据
        mtxtOriginal.setText(shops.toString());
        mtxtLatest.setText(jsonArray);
    }

    /**
     * 将Java对象转换为json字符串{}
     */
    private void javaObjectToJson() {
        //1.创建一个java对象
        ShopInfo shop = new ShopInfo(1, "小龙虾", 100.0, "xiaokogxia");
        //2.解析json数据
        String jsonString = JSON.toJSONString(shop);
        //3.展示数据
        mtxtOriginal.setText(jsonString);
        mtxtLatest.setText(shop.toString());
    }

    /**
     * 将json格式的字符串[]转换为Java对象的List
     */
    private void jsonArrayToJavaListByFastJson() {
        //1.创建或获取json数据
        String json = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f1.jpg\",\n" +
                "        \"name\": \"大虾1\",\n" +
                "        \"price\": 12.3\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f2.jpg\",\n" +
                "        \"name\": \"大虾2\",\n" +
                "        \"price\": 12.5\n" +
                "    }\n" +
                "]";
        //2.解析json数据
        List<ShopInfo> shops = JSON.parseArray(json, ShopInfo.class);
        //3.展示数据
        mtxtOriginal.setText(json);
        mtxtLatest.setText(shops.toString());
    }

    /**
     * 将json格式的字符串{}转换为Java对象
     */
    private void jsonToJavaObjectByFastJson() {
        //1.创建或获取json数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        //2.解析json数据
        ShopInfo shopInfo = JSON.parseObject(json, ShopInfo.class);
        //3.展示数据
        mtxtOriginal.setText(json);
        mtxtLatest.setText(shopInfo.toString());
    }
}
