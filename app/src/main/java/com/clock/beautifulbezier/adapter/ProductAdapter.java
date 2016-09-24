package com.clock.beautifulbezier.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.clock.beautifulbezier.R;
import com.clock.beautifulbezier.entity.ProductInfo;

import java.util.List;

/**
 * 商品列表适配器
 * <p/>
 * Created by Clock on 2016/9/19.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.GoodsHolder> implements View.OnClickListener {

    private List<ProductInfo> mProductsInfo;
    private Context mContext;
    private OnAddListener mOnAddListener;
    private DrawableTypeRequest<String> mRequest;

    public ProductAdapter(Context context, List<ProductInfo> productsInfo, OnAddListener onAddListener) {
        this.mContext = context;
        this.mProductsInfo = productsInfo;
        this.mOnAddListener = onAddListener;
        this.mRequest = Glide.with(context).fromString();
    }

    @Override
    public GoodsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.product_info_item, parent, false);
        return new GoodsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GoodsHolder holder, int position) {
        ProductInfo productInfo = mProductsInfo.get(position);
        String name = productInfo.getName();
        String introduction = productInfo.getIntroduction();
        String info = mContext.getString(R.string.product_info, name, introduction);
        holder.mInfoView.setText(info);
        mRequest.load(productInfo.getPosterUrl()).into(holder.mPosterView);
        holder.mAddView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (mProductsInfo == null) {
            return 0;
        }
        return mProductsInfo.size();
    }

    @Override
    public void onClick(View v) {
        //do something

        if (mOnAddListener != null) {
            mOnAddListener.onAdd(v);
        }
    }

    static class GoodsHolder extends RecyclerView.ViewHolder {

        ImageView mPosterView;
        TextView mInfoView;
        ImageView mAddView;

        public GoodsHolder(View itemView) {
            super(itemView);

            mPosterView = (ImageView) itemView.findViewById(R.id.iv_poster);
            mInfoView = (TextView) itemView.findViewById(R.id.tv_info);
            mAddView = (ImageView) itemView.findViewById(R.id.iv_add);

        }

    }

    public void setOnAddListener(OnAddListener onAddListener) {
        this.mOnAddListener = onAddListener;
    }

    /**
     * 添加操作监听接口
     */
    public static interface OnAddListener {
        /**
         * @param view
         */
        public void onAdd(View view);
    }

}
