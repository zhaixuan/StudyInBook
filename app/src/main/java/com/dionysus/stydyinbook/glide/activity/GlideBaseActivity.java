package com.dionysus.stydyinbook.glide.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.dionysus.stydyinbook.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideBaseActivity extends Activity {

    @BindView(R.id.txt_title)
    TextView mtxtTitle;
    @BindView(R.id.txt_glide_1)
    TextView mtxtGlide1;
    @BindView(R.id.img_glide_1)
    ImageView mimgGlide1;
    @BindView(R.id.txt_glide_2)
    TextView mtxtGlide2;
    @BindView(R.id.img_glide_2)
    ImageView mimgGlide2;
    @BindView(R.id.txt_glide_3)
    TextView mtxtGlide3;
    @BindView(R.id.img_glide_3)
    ImageView mimgGlide3;
    @BindView(R.id.txt_glide_4)
    TextView mtxtGlide4;
    @BindView(R.id.img_glide_4)
    ImageView mimgGlide4;
    @BindView(R.id.txt_glide_5)
    TextView mtxtGlide5;
    @BindView(R.id.img_glide_5)
    ImageView mimgGlide5;
    @BindView(R.id.txt_glide_6)
    TextView mtxtGlide6;
    @BindView(R.id.img_glide_6)
    ImageView mimgGlide6;
    @BindView(R.id.txt_glide_7)
    TextView mtxtGlide7;
    @BindView(R.id.img_glide_7)
    ImageView mimgGlide7;
    @BindView(R.id.txt_glide_8)
    TextView mtxtGlide8;
    @BindView(R.id.img_glide_8)
    ImageView mimgGlide8;
    @BindView(R.id.txt_glide_9)
    TextView mtxtGlide9;
    @BindView(R.id.img_glide_9)
    ImageView mimgGlide9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_base);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mtxtTitle.setText(getString(R.string.glide_txt_base_title));
        //（1）加载网络图片
        mtxtGlide1.setText("（1）加载网络图片");
        Glide.with(this)
                .load("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1558718021&di=5872339a5eb344a4e5de7f92eee07afd&src=http://img1.cache.netease.com/catchpic/4/47/47E5E3CA5A91B67C4D76CF2F01970A3D.jpg")
                .into(mimgGlide1);

        //（2）加载资源图片
        mtxtGlide2.setText("（2）加载资源图片");
        Glide.with(this).load(R.drawable.squirrel).into(mimgGlide2);

        //（3）加载本地图片
        mtxtGlide3.setText("（3）加载本地图片");
        String path = Environment.getExternalStorageDirectory() + "/1552905406211.jpg";
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        Glide.with(this).load(uri).into(mimgGlide3);

        // （4）加载网络gif
        mtxtGlide4.setText("（4）加载网络gif");
        String gifUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558729206657&di=61dbcc90eb464a59c35dc2881a6f9296&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170812%2Fdcc46a4a633645c0ac4cd2eb3556015e.jpg";
        Glide.with(this).load(gifUrl).placeholder(R.mipmap.ic_launcher).into(mimgGlide4);

        // （5）加载资源gif
        mtxtGlide5.setText("（5）加载资源gif");
        Glide.with(this).load(R.drawable.pig).placeholder(R.mipmap.ic_launcher).into(mimgGlide5);

        //（6）加载本地gif
        mtxtGlide6.setText("（6）加载本地gif");
        String gifPath = Environment.getExternalStorageDirectory() + "/studyInBook/scream.gif";
        File gifFile = new File(gifPath);
        Glide.with(this).load(gifFile).placeholder(R.mipmap.ic_launcher).into(mimgGlide6);

        //（7）加载本地小视频和快照
        mtxtGlide7.setText("（7）加载本地小视频和快照");
        String videoPath = Environment.getExternalStorageDirectory() + "/studyInBook/龙珠超-布罗利的归来(预告).mp4";
        File videoFile = new File(videoPath);
        Glide.with(this).load(Uri.fromFile(videoFile)).placeholder(R.mipmap.ic_launcher).into(mimgGlide7);

        //（8）设置缩略图比例,然后，先加载缩略图，再加载原图
        mtxtGlide8.setText("（8）设置缩略图比例,然后，先加载缩略图，再加载原图");
        String urlPath = Environment.getExternalStorageDirectory() + "/1552905406211.jpg";
        Glide.with(this).load(new File(urlPath)).thumbnail(0.1f).centerCrop().placeholder(R.mipmap.ic_launcher).into(mimgGlide8);

        //（9）先建立一个缩略图对象，然后，先加载缩略图，再加载原图
        mtxtGlide9.setText("（9）先建立一个缩略图对象，然后，先加载缩略图，再加载原图");
        RequestBuilder<Drawable> thumbnailRequest = Glide.with(this).load(new File(urlPath));
        Glide.with(this).load(Uri.fromFile(videoFile)).thumbnail(thumbnailRequest).centerCrop().placeholder(R.mipmap.ic_launcher).into(mimgGlide9);
    }
}
