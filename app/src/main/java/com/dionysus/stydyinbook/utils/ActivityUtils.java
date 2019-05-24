package com.dionysus.stydyinbook.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

/**
 * @className: ActivityUtils
 * @author: Dionysus
 * @date: 2019/5/25 0:13
 * @Description: Activity相关的工具类，采用了单例
 */
public class ActivityUtils {
    private static ActivityUtils sActivityUtils;
    private WeakReference<Activity> mActivityWeakReference;
    private WeakReference<Fragment> mFragmentWeakReference;

    private ActivityUtils() {
    }

    private ActivityUtils(Activity activity) {
        mActivityWeakReference = new WeakReference<>(activity);
    }

//    private ActivityUtils(Fragment fragment) {
//        mFragmentWeakReference = new WeakReference<>(fragment);
//    }

    public static ActivityUtils getInstance() {
        if (null == sActivityUtils) {
            sActivityUtils = new ActivityUtils();
        }
        return sActivityUtils;
    }

    private @Nullable
    Activity getActivity() {
        if (null != mActivityWeakReference) {
            return mActivityWeakReference.get();
        }
//        if (null != mFragmentWeakReference) {
//            Fragment fragment = mFragmentWeakReference.get();
//            return null == fragment ? null : fragment.getActivity();
//        }
        return null;
    }

    public void startActivity(Class<? extends Activity> clazz) {
        Activity activity = getActivity();
        if (null == activity) {
            return;
        }
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
    }
}
