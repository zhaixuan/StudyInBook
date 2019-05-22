package com.dionysus.stydyinbook.xuitls3.annotation;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;

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
    }
}
