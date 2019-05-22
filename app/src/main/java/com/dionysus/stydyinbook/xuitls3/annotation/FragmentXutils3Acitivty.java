package com.dionysus.stydyinbook.xuitls3.annotation;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.xuitls3.annotation.fragment.DemoFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_xutils3_fragment)
public class FragmentXutils3Acitivty extends FragmentActivity {

    @ViewInject(R.id.txt_title)
    private TextView mtxtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //设置标题
        mtxtTitle.setText(getString(R.string.xutils3fragment_txt_title_name));
        //1.得到FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        //3.替换Fragment
        transaction.replace(R.id.fl_content, new DemoFragment());
        //4.提交
        transaction.commit();
    }
}
