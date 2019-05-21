package com.dionysus.stydyinbook.json.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.json.bean.ShopInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 手动JSON解析页面
 * 需要完成的事情：
 * （1）将json格式的字符串{}转换为Java对象
 * （2）将json格式的字符串[]转换为Java对象的List
 * （3）复杂json数据解析
 * （4）特殊json数据解析
 */
public class NativeJsonParseActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "NativeJsonParseActivity";
    private Context mContext;
    private TextView mtxtTitleName;
    private Button mbtnNativeToJavaobject;
    private Button mbtnNativeToJavalist;
    private Button mbtnNativeComplex;
    private Button mbtnNativeSpecial;
    private TextView mtxtOriginal;
    private TextView mtxtLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_json_parse);
        this.mContext = getApplicationContext();
        //绑定数据
        initView();
        //初始化监听
        initListener();
    }

    /**
     * 初始化监听按钮的点击事件
     */
    private void initListener() {
        mbtnNativeToJavaobject.setOnClickListener(this);
        mbtnNativeToJavalist.setOnClickListener(this);
        mbtnNativeComplex.setOnClickListener(this);
        mbtnNativeSpecial.setOnClickListener(this);
    }

    /**
     * 初始化数据
     */
    private void initView() {
        // 设置TitleBar的名称
        mtxtTitleName = (TextView) findViewById(R.id.txt_title);
        mtxtTitleName.setText(getString(R.string.json_titlebar_name));
        // 绑定数据
        mbtnNativeToJavaobject = (Button) findViewById(R.id.btn_native_to_javaobject);
        mbtnNativeToJavalist = (Button) findViewById(R.id.btn_native_to_javalist);
        mbtnNativeComplex = (Button) findViewById(R.id.btn_native_complex);
        mbtnNativeSpecial = (Button) findViewById(R.id.btn_native_special);
        mtxtOriginal = (TextView) findViewById(R.id.txt_original);
        mtxtLast = (TextView) findViewById(R.id.txt_last);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_native_to_javaobject:
                //（1）将json格式的字符串{}转换为Java对象
                jsoonToJavaObjectByNative();
                break;
            case R.id.btn_native_to_javalist:
                //（2）将json格式的字符串[]转换为Java对象的List
                jsonToJavaListByNative();
                break;
            case R.id.btn_native_complex:
                //（3）复杂json数据解析
                break;
            case R.id.btn_native_special:
                //（4）特殊json数据解析
                break;
            default:
                break;
        }
    }

    /**
     * 将json格式的字符串[]转换为Java对象的List
     */
    private void jsonToJavaListByNative() {
        // 1.获取或创建Json数据
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

        List<ShopInfo> shops = new ArrayList<>();
        // 2.解析数据
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (null != jsonObject) {
                    int id = jsonObject.optInt("id");
                    String name = jsonObject.optString("name");
                    double price = jsonObject.optDouble("price");
                    String imagePath = jsonObject.optString("imagePath");
                    // 封装java对象
                    ShopInfo shopInfo = new ShopInfo(id, name, price, imagePath);
                    shops.add(shopInfo);

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // 3.显示Json数据
        mtxtOriginal.setText(json);
        mtxtLast.setText(shops.toString());

    }

    /**
     * 将json格式的字符串{}转换为Java对象
     */
    private void jsoonToJavaObjectByNative() {
        //1.获取或创建Json数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        //2.解析json
        ShopInfo shopInfo = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            int id = jsonObject.optInt("id");
            String name = jsonObject.optString("name");
            double price = jsonObject.optDouble("price");
            String imagePath = jsonObject.optString("imagePath");
            // 封装java对象
            shopInfo = new ShopInfo(id, name, price, imagePath);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //3.显示json数据
        mtxtOriginal.setText(json);
        mtxtLast.setText(shopInfo.toString());
    }
}