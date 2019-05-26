package com.dionysus.stydyinbook.glide.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.dionysus.stydyinbook.R;
import com.dionysus.stydyinbook.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

/**
 * @className: GlideTransformationAdapter
 * @author: Dionysus
 * @date: 2019/5/25 23:08
 * @Description: GlideTransformationAdapter
 */
public class GlideTransformationAdapter extends RecyclerView.Adapter<GlideTransformationAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mData = new ArrayList<>();

    public GlideTransformationAdapter(Context context) {
        mContext = context;
        for (int i = 1; i <= 21; i++) {
            mData.add(i + "");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewtype) {
        View view = View.inflate(mContext, R.layout.item_glide_transformtation, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 设置名称
        holder.mtxtName.setText("item" + (position + 1));

        int integer = Integer.parseInt(mData.get(position));
        switch (integer) {
            case 1: {
                int width = CommonUtils.getInstance().dip2px(mContext, 133.33f);
                int height = CommonUtils.getInstance().dip2px(mContext, 126.33f);
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .override(width, height)
                        .transform(new CenterCrop(),
                                new MaskTransformation(mContext, R.drawable.mask_starfish))
                        .into(holder.mImageview);
                break;
            }
            case 2: {
                int width = CommonUtils.getInstance().dip2px(mContext, 150.0f);
                int height = CommonUtils.getInstance().dip2px(mContext, 100.0f);
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .override(width, height)
                        .transform(new CenterCrop(),
                                new MaskTransformation(mContext, R.drawable.mask_chat_right))
                        .into(holder.mImageview);
                break;
            }
            case 3:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .transform(
                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.TOP))
                        .into(holder.mImageview);
                break;
            case 4:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(mContext, 300, 100))
                        .into(holder.mImageview);
                break;
            case 5:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .transform(
                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.BOTTOM))
                        .into(holder.mImageview);

                break;
            case 6:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .transform(new CropSquareTransformation(mContext))
                        .into(holder.mImageview);
                break;
            case 7:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .transform(new CropCircleTransformation(mContext))
                        .into(holder.mImageview);
                break;
            case 8:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .transform(new ColorFilterTransformation(mContext, Color.argb(80, 255, 0, 0)))
                        .into(holder.mImageview);
                break;
            case 9:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .transform(new GrayscaleTransformation(mContext))
                        .into(holder.mImageview);
                break;
            case 10:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .transform(new RoundedCornersTransformation(mContext, 30, 0,
                                RoundedCornersTransformation.CornerType.BOTTOM))
                        .into(holder.mImageview);
                break;
            case 11:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(new BlurTransformation(mContext, 25))
                        .into(holder.mImageview);
                break;
            case 12:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .transform(new ToonFilterTransformation(mContext))
                        .into(holder.mImageview);
                break;
            case 13:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(new SepiaFilterTransformation(mContext))
                        .into(holder.mImageview);
                break;
            case 14:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(new ContrastFilterTransformation(mContext, 2.0f))
                        .into(holder.mImageview);
                break;
            case 15:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(new InvertFilterTransformation(mContext))
                        .into(holder.mImageview);
                break;
            case 16:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(new PixelationFilterTransformation(mContext, 20))
                        .into(holder.mImageview);
                break;
            case 17:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(new SketchFilterTransformation(mContext))
                        .into(holder.mImageview);
                break;
            case 18:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(
                                new SwirlFilterTransformation(mContext, 0.5f, 1.0f, new PointF(0.5f, 0.5f)))
                        .into(holder.mImageview);
                break;
            case 19:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(new BrightnessFilterTransformation(mContext, 0.5f))
                        .into(holder.mImageview);
                break;
            case 20:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(new KuwaharaFilterTransformation(mContext, 25))
                        .into(holder.mImageview);
                break;
            case 21:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .transform(new VignetteFilterTransformation(mContext, new PointF(0.5f, 0.5f),
                                new float[]{0.0f, 0.0f, 0.0f}, 0f, 0.75f))
                        .into(holder.mImageview);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_glide_transformtation)
        ImageView mImageview;
        @BindView(R.id.txt_glide)
        TextView mtxtName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
