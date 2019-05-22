package com.dionysus.stydyinbook;

import android.app.Application;

import org.xutils.x;

/**
 * @className: MyApplication
 * @author: Dionysus
 * @date: 2019/5/23 0:30
 * @Description: 代表整个软件
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化XUitls3
        x.Ext.init(this);
        // 是否输出debug日志, 开启debug会影响性能.
        x.Ext.setDebug(true);
    }
}
