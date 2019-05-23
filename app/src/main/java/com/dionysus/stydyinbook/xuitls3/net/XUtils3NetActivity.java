package com.dionysus.stydyinbook.xuitls3.net;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dionysus.stydyinbook.R;

import org.xutils.common.Callback;
import org.xutils.common.task.PriorityExecutor;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

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
    /**
     * 读写权限
     */
    private static String[] PERMISSION_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE
            , Manifest.permission.WRITE_EXTERNAL_STORAGE};
    /**
     * 请求状态码
     */
    private static int REQUEST_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        mContext = getApplicationContext();
        mtxtTitle.setText(getString(R.string.xutils3_net_title_name));
        getReadAndWritePermission();
    }

    private void getReadAndWritePermission() {
        //判断当前版本
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSION_STORAGE, REQUEST_PERMISSION_CODE);
            } else {
                Log.d(TAG, "已有权限");
            }
        } else {
            Log.d(TAG, "小于 6.0");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i(TAG, "申请的权限为: " + permissions[i]
                        + "\n" + "申请结果: " + grantResults[i]);
            }
        }
    }

    @Event(value = {R.id.btn_request, R.id.btn_file_download, R.id.btn_file_upload})
    private void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_request:
                getandPostRequest();
                break;
            case R.id.btn_file_download:
                mtxtDisplay.setText(getString(R.string.net_txt_display));
                downloadFile();
                break;
            case R.id.btn_file_upload:
                Toast.makeText(mContext, "响应测试", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    /**
     * 下载文件
     */
    private void downloadFile() {
        RequestParams params = new RequestParams("http://vfx.mtime.cn/Video/2019/05/20/mp4/190520100523524835.mp4");
        //设置保存路径
        params.setSaveFilePath(Environment.getExternalStorageDirectory() + "/studyInBook/龙珠超-布罗利的归来(预告).mp4");
        //设置是否可以立即取消下载
        params.setCancelFast(true);
        //设置是否自动命名
        params.setAutoRename(false);
        //设置断点续传
        params.setAutoResume(true);
        //自定义线程池，有效的范围值[1,3]设置为3时，可能阻塞图片加载
        params.setExecutor(new PriorityExecutor(3, true));
        x.http().get(params, new Callback.ProgressCallback<File>() {
            /**
             * 下载成功的时候回调这个方法，并且将文件下载到哪个路径回传过来
             * @param file
             */
            @Override
            public void onSuccess(File file) {
                Log.e(TAG, "onSuccess：" + file.toString());
                Toast.makeText(XUtils3NetActivity.this, "onSuccess：" + file.toString()
                        , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError：" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled：" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished：");
            }

            @Override
            public void onWaiting() {
                Log.e(TAG, "onWaiting：");
            }

            @Override
            public void onStarted() {
                Log.e(TAG, "onStarted：");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                mProgressbar.setMax((int) total);
                mProgressbar.setProgress((int) current);
                Log.e(TAG, "onLoading：" + current
                        + "/" + total + "\n"
                        + "isDownloading：" + isDownloading);
            }
        });
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
