package com.dionysus.stydyinbook.utils;

import android.content.Context;

/**
 * @className: CommonUtils
 * @author: Dionysus
 * @date: 2019/5/25 23:38
 * @Description: 工具类合集
 */
public class CommonUtils {

    private static CommonUtils sCommonUtils;

    private CommonUtils() {
    }

    public static CommonUtils getInstance() {
        if (null == sCommonUtils) {
            sCommonUtils = new CommonUtils();
        }
        return sCommonUtils;
    }

    /**
     * dip转换为px
     *
     * @param context 上下文
     * @param dp      dp值
     * @return
     */
    public int dip2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
