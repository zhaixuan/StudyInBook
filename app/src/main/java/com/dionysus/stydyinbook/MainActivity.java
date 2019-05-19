package com.dionysus.stydyinbook;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.dionysus.stydyinbook.base.BaseFragment;
import com.dionysus.stydyinbook.fragment.CommonFrameFragment;
import com.dionysus.stydyinbook.fragment.CustomFragment;
import com.dionysus.stydyinbook.fragment.OtherFragment;
import com.dionysus.stydyinbook.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup mRgMain;
    private List<BaseFragment> mBaseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化数据
        initView();
        // 初始化Fragment
        initFragment();
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        // 常用框架Fragment
        mBaseFragment.add(new CommonFrameFragment());
        // 第三方Fragment
        mBaseFragment.add(new ThirdPartyFragment());
        // 自定义Fragment
        mBaseFragment.add(new CustomFragment());
        // 其他Fragment
        mBaseFragment.add(new OtherFragment());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRgMain = (RadioGroup) findViewById(R.id.rg_main);
        // 设置默认选中常用框架
        mRgMain.check(R.id.rb_common_frame);
    }
}
