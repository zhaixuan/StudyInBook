package com.dionysus.stydyinbook.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author:Administrator
 * Date:2019/5/19 9:30
 * Description: BaseFragment
 */
public abstract class BaseFragment extends Fragment {

    /**
     * 上下文
     */
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 强制子类重写，实现子类特有的UI
     *
     * @return
     */
    protected abstract View initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 当子类需要初始化数据，或者连接网络请求数据，展示数据等可以重写该方法
     */
    protected void initData() {

    }

}
