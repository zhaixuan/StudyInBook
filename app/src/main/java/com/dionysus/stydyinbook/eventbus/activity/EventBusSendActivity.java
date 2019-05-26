package com.dionysus.stydyinbook.eventbus.activity;

import android.app.Activity;
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

public class EventBusSendActivity extends Activity {

    @BindView(R.id.txt_title)
    TextView mTxtTitle;
    @BindView(R.id.bt_eventbus_send_main)
    Button mBtEventbusSendMain;
    @BindView(R.id.bt_eventbus_send_sticky)
    Button mBtEventbusSendSticky;
    @BindView(R.id.tv_eventbus_send_result)
    TextView mTvEventbusSendResult;

    private boolean bIsFirstParse = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_send);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mTxtTitle.setText(getString(R.string.eventbus_send_txt_title));
    }

    // 2-3.接收粘性事件
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void StickyEventBus(StickyEvent event) {
        // 2-4.显示接收的消息
        mTvEventbusSendResult.setText(event.strMsg);
    }

    @OnClick({R.id.bt_eventbus_send_main, R.id.bt_eventbus_send_sticky})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //主线程发送数据
            case R.id.bt_eventbus_send_main:
                //4.发送消息到主页面
                EventBus.getDefault().post(new MessageEvent(getString(R.string.eventbus_txt_receive_main)));
                //销毁当前页面
                finish();
                break;
            //接收粘性数据
            case R.id.bt_eventbus_send_sticky:
                if (bIsFirstParse) {
                    bIsFirstParse = false;
                    //2-5.注册粘性事件
                    EventBus.getDefault().register(EventBusSendActivity.this);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //2-6.解注册
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(EventBusSendActivity.this);
    }
}
