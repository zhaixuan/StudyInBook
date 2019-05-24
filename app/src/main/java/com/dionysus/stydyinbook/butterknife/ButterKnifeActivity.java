package com.dionysus.stydyinbook.butterknife;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.dionysus.stydyinbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeActivity extends Activity {

    @BindView(R.id.txt_title)
    TextView mtxtTitle;
    @BindView(R.id.txt_butterkninfe)
    TextView mtxtButterkninfe;
    @BindView(R.id.cb_butterkninfe)
    CheckBox mcbButterkninfe;
    @BindView(R.id.btn_butterkninfe)
    Button mbtnButterkninfe;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        mContext = getApplicationContext();
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mtxtTitle.setText(getString(R.string.butterknife_txt_title));
        mtxtButterkninfe.setText(getString(R.string.butterknife_text_set));
    }

    @OnClick({R.id.cb_butterkninfe, R.id.btn_butterkninfe})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cb_butterkninfe:
                Toast.makeText(mContext, "点击测试", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_butterkninfe:
                Toast.makeText(mContext, "点击测试", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
