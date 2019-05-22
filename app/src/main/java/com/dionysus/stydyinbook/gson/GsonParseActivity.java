package com.dionysus.stydyinbook.gson;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.json.bean.ShopInfo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
                jsonToJavaListByGson();
                break;
            case R.id.btn_gson_java_to_jsonobject:
                //（3）将Java对象转换为json字符串{}
                javaToJsonByGson();
                break;
            case R.id.btn_gson_java_to_jsonarray:
                //（4）将Java对象的List转换为json字符串[]
                javaListToJsonArrayByGson();
                break;
            default:
                break;

        }
    }

    /**
     * 将Java对象的List转换为json字符串[]
     */
    private void javaListToJsonArrayByGson() {
        //1.获取或创建java对象
        List<ShopInfo> shops = new ArrayList<>();
        ShopInfo baoyu = new ShopInfo(1, "鲍鱼", 250.0, "baoyu");
        ShopInfo longxia = new ShopInfo(2, "龙虾", 50.0, "龙虾");
        shops.add(baoyu);
        shops.add(longxia);
        //2.生成JSON数据
        Gson gson = new Gson();
        String json = gson.toJson(shops);
        //3.展示数据
        mtxtOriginal.setText(shops.toString());
        mtxtLast.setText(json);
    }

    /**
     * 将Java对象转换为json字符串{}
     */
    private void javaToJsonByGson() {
        //1.获取或创建java对象
        ShopInfo shopInfo = new ShopInfo(1, "鲍鱼", (double) 250, "baoyu");
        //2.生成JSON数据
        Gson gson = new Gson();
        String json = gson.toJson(shopInfo);
        //3.展示数据
        mtxtOriginal.setText(shopInfo.toString());
        mtxtLast.setText(json);
    }

    /**
     * 将json格式的字符串[]转换为Java对象的List
     */
    private void jsonToJavaListByGson() {
        //1.获取或创建数据
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
        // 4.创建集合
        List<Object> shops = new ArrayList<>();
        // 2.解析json数据
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (null != jsonObject) {
                    int id = jsonObject.optInt("id");
                    String name = jsonObject.optString("name");
                    Double price = jsonObject.optDouble("price");
                    String imagePath = jsonObject.optString("imagePath");
                    // 3.封装java对象
                    ShopInfo shopInfo = new ShopInfo(id, name, price, imagePath);
                    // 5.将java对象存储到集合中
                    shops.add(shopInfo);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // 6.展示数据
        mtxtOriginal.setText(json);
        mtxtLast.setText(shops.toString());
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
