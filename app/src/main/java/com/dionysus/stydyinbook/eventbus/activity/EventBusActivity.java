package com.dionysus.stydyinbook.eventbus.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.eventbus.event.MessageEvent;
import com.dionysus.stydyinbook.eventbus.event.StickyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusActivity extends Activity {

    @BindView(R.id.txt_title)
    TextView mTxtTitle;
    @BindView(R.id.btn_skip)
    Button mBtnSkip;
    @BindView(R.id.btn_sticky_skip)
    Button mBtnStickySkip;
    @BindView(R.id.tv_eventbus_result)
    TextView mTvEventbusResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mTxtTitle.setText("EventBus");
        //1.注册EventBus事件
        EventBus.getDefault().register(EventBusActivity.this);
    }

    @OnClick({R.id.btn_skip, R.id.btn_sticky_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 跳转到发送页面
            case R.id.btn_skip:
                startActivity(new Intent(EventBusActivity.this, EventBusSendActivity.class));
                break;
            // 发送粘性事件跳转到发送页面
            case R.id.btn_sticky_skip:
                //2-2.发送粘性事件
                EventBus.getDefault().postSticky(new StickyEvent(getString(R.string.eventbus_txt_receive_sticky)));
                //2-3.跳转到发送事件页面
                startActivity(new Intent(EventBusActivity.this, EventBusSendActivity.class));
                break;
            default:
                break;
        }
    }

    //5.接收消息
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent event) {
        //展示接收到的消息
        mTvEventbusResult.setText(event.strContent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //2.解注册
        EventBus.getDefault().unregister(EventBusActivity.this);
    }
}
