package com.dionysus.stydyinbook.xuitls3.net;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dionysus.stydyinbook.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_xutils3_net)
public class XUtils3NetActivity extends AppCompatActivity {

    @ViewInject(R.id.txt_title)
    private TextView mtxtTitle;
    @ViewInject(R.id.btn_request)
    private Button mbtnRequest;
    @ViewInject(R.id.btn_file_download)
    private Button mbtnDownloadFile;
    @ViewInject(R.id.btn_file_upload)
    private Button mbtnUploadFile;
    @ViewInject(R.id.progressbar)
    private ProgressBar mProgressbar;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        mContext = getApplicationContext();
        mtxtTitle.setText(getString(R.string.xutils3_net_title_name));
    }

    @Event(value = {R.id.btn_request, R.id.btn_file_download, R.id.btn_file_upload})
    private void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_request:
                Toast.makeText(mContext, "响应测试", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_file_download:
                Toast.makeText(mContext, "响应测试", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_file_upload:
                Toast.makeText(mContext, "响应测试", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
