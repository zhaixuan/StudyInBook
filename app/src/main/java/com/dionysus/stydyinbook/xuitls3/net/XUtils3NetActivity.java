package com.dionysus.stydyinbook.xuitls3.net;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dionysus.stydyinbook.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_xutils3_net)
public class XUtils3NetActivity extends AppCompatActivity {

    private static final String TAG = "XUtils3NetActivity";
    @ViewInject(R.id.txt_title)
    private TextView mtxtTitle;
    @ViewInject(R.id.btn_request)
    private Button mbtnRequest;
    @ViewInject(R.id.btn_file_download)
    private Button mbtnDownloadFile;
    @ViewInject(R.id.btn_file_upload)
    private Button mbtnUploadFile;
    @ViewInject(R.id.txt_display)
    private TextView mtxtDisplay;
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
                getandPostRequest();
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

    /**
     * Get和Post请求
     */
    private void getandPostRequest() {
        //1.Get请求
        //2.post请求，只需将x.http().get()由get改为post即可
        RequestParams params = new RequestParams("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "xUtils3联网请求成功：" + result);
                mtxtDisplay.setText("请求结果：" + "\n" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "xUtils3联网请求失败：" + ex.getMessage());
                mtxtDisplay.setText("xUtils3联网请求失败：" + "\n" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "xUtils3联网请求取消：" + cex.getMessage());
                mtxtDisplay.setText("xUtils3联网请求取消：" + "\n" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "xUtils3联网请求结束：");
            }
        });
    }
}
