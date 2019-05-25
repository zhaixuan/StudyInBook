package com.dionysus.stydyinbook.glide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.dionysus.stydyinbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @className: GlideRecyclerviewAdapter
 * @author: Dionysus
 * @date: 2019/5/25 22:28
 * @Description: GlideRecyclerviewAdapter
 */
public class GlideRecyclerviewAdapter extends RecyclerView.Adapter<GlideRecyclerviewAdapter.ViewHolder> {

    private Context mContext;
    /**
     * 准备数据
     */
    String[] mDatas = new String[]{
            "https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=77d1cd475d43fbf2da2ca023807fca1e/9825bc315c6034a8ef5250cec5134954082376c9.jpg",
            "http://s9.sinaimg.cn/mw690/006hikKrzy7pzDEQbFe68&690",
            "https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=be90787f60061d95624631384bf50a5d/5ab5c9ea15ce36d3c2a8827734f33a87e850b1cc.jpg",
            "https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=797c364c55b5c9ea7df305e3e538b622/cf1b9d16fdfaaf51be3981f8825494eef11f7a9a.jpg",
            "https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c3372645376d55fbdac670265d234f40/96dda144ad3459825717af0906f431adcaef8488.jpg",
            "http://b.zol-img.com.cn/desk/bizhi/image/3/960x600/1369964516723.jpg",
            "http://d-pic-image.yesky.com/1080x-/uploadImages/2019/044/59/1113V6L3Q6TY.jpg",
            "https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=6713d07a71cb0a469a228d395b62f63e/7dd98d1001e939014adfbfbe71ec54e737d19654.jpg",
            "https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=7673fbaf4b34970a5873162fa5cbd1c0/d043ad4bd11373f05ca25c1fae0f4bfbfaed0494.jpg",
            "https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=59ce6d407cc6a7efa626ae26cdfbafe9/f9dcd100baa1cd11cc54babfb312c8fcc2ce2d4b.jpg",
            "http://pic69.nipic.com/file/20150613/21217611_173253242649_2.jpg",
            "https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=0e94458ab6315c605c956defbdb0cbe6/a5c27d1ed21b0ef4f5bf71c1d7c451da80cb3ede.jpg",
            "https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=8eb490702d7f9e2f6f351b082f31e962/500fd9f9d72a60590a12c38c2234349b033bba21.jpg",
            "https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=efeba664be7eca800d053fe7a1229712/5fdf8db1cb13495454d9e823584e9258d0094ab5.jpg",
            "https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=8578a92453ee3d6d3dc681cb73176d41/902397dda144ad348dc73d04daa20cf431ad853d.jpg",
            "https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c4fd4e165de736d147138a08ab524ffc/241f95cad1c8a786b5e44ac46e09c93d71cf5029.jpg"
    };

    public GlideRecyclerviewAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = View.inflate(mContext, R.layout.item_glide_recyclerview, null);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // 获取当前数据

        // 显示数据
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, mContext.getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, mContext.getResources().getDisplayMetrics());

        Glide.with(mContext)
                .load(mDatas[position])
                .placeholder(R.mipmap.ic_launcher) //占位图
                .error(R.mipmap.ic_launcher)  //出错的占位图
                .override(width, height) //图片显示的分辨率 ，像素值 可以转化为DP再设置
//                .animate(R.anim.glide_anim)//图片加载时的动画效果[已被删除]
//                .centerCrop()
//                .fitCenter()
                .transition(GenericTransitionOptions.with(R.anim.glide_anim))//图片加载时的动画效果
                .into(viewHolder.mimgGlideRecyclerview);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_glide_recyclerview)
        ImageView mimgGlideRecyclerview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
