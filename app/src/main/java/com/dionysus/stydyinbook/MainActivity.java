package com.dionysus.stydyinbook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
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
    /**
     * 选中Fragment对应的位置
     */
    private int miPosition;

    /**
     * 上次切换的Fragment
     */
    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化数据
        initView();
        // 初始化Fragment
        initFragment();
        // 设置RadioGroup的监听
        setListener();
    }

    private void setListener() {
        mRgMain.setOnCheckedChangeListener(new MyOnCheckedListener());
        // 设置默认选中常用框架
        mRgMain.check(R.id.rb_common_frame);
    }

    class MyOnCheckedListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                //常用框架
                case R.id.rb_common_frame:
                    miPosition = 0;
                    break;
                //第三方
                case R.id.rb_thirdparty:
                    miPosition = 1;
                    break;
                //自定义
                case R.id.rb_custom:
                    miPosition = 2;
                    break;
                //其他
                case R.id.rb_other:
                    miPosition = 3;
                    break;
                default:
                    miPosition = 0;
                    break;
            }
            //根据位置得到对应的Fragment
            BaseFragment to = getFragment();
            //替换
            switchFragment(mContent, to);
        }
    }

    /**
     * 切换fragment
     *
     * @param from 原先显示的Fragment
     * @param to   将要展示的Fragment
     */
    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            mContent = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有添加
            if (!to.isAdded()) {
                //to没有被添加
                //from隐藏
                if (null != from) {
                    transaction.hide(from);
                }
                //添加to
                if (null != to) {
                    transaction.add(R.id.fl_content, to).commit();
                }
            } else {
                //to已经被添加
                //from隐藏
                if (null != from) {
                    transaction.hide(from);
                }
                //显示to
                if (null != to) {
                    transaction.show(to).commit();
                }
            }
        }
    }

    /**
     * 根据位置得到对应的Fragment
     *
     * @return
     */
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(miPosition);
        return fragment;
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
        mRgMain = findViewById(R.id.rg_main);
    }
}
