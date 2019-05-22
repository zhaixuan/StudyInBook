package com.dionysus.stydyinbook.xuitls3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.xuitls3.annotation.FragmentXutils3Acitivty;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * XUtils3注解框架
 */
@ContentView(R.layout.activity_xuitls3_acticity)
public class XUitls3Acticity extends Activity {

    @ViewInject(R.id.txt_title)
    private TextView mtxtTitle;
    @ViewInject(R.id.btn_annotation_module)
    private Button mbtnAnnotation;
    @ViewInject(R.id.btn_net)
    private Button mbtnNet;
    @ViewInject(R.id.btn_image)
    private Button mbtnImage;
    @ViewInject(R.id.btn_image_list)
    private Button mbtnImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_xuitls3_acticity);
        x.view().inject(this);
        // 设置标题名称
        mtxtTitle.setText(getString(R.string.xutils3_txt_title_name));
    }

    @Event(value = {R.id.btn_annotation_module, R.id.btn_net, R.id.btn_image, R.id.btn_image_list})
    private void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_annotation_module:
                Intent intent = new Intent(this, FragmentXutils3Acitivty.class);
                startActivity(intent);
                break;
            case R.id.btn_net:
                break;
            case R.id.btn_image:
                break;
            case R.id.btn_image_list:
                break;
            default:
                break;
        }
    }
}
