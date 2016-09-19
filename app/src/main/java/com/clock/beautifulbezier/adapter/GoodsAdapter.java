package com.clock.beautifulbezier.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clock.beautifulbezier.R;
import com.clock.beautifulbezier.entity.GoodsInfo;

import java.util.List;

/**
 * 商品列表适配器
 * <p/>
 * Created by Clock on 2016/9/19.
 */
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsHolder> implements View.OnClickListener {

    private List<GoodsInfo> mGoodsInfoList;
    private Context mContext;
    private OnAddListener mOnAddListener;

    public GoodsAdapter(Context context, List<GoodsInfo> goodsInfoList, OnAddListener onAddListener) {
        this.mContext = context;
        this.mGoodsInfoList = goodsInfoList;
        this.mOnAddListener = onAddListener;
    }

    @Override
    public GoodsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.goods_item, parent, false);
        return new GoodsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GoodsHolder holder, int position) {
        GoodsInfo goodsInfo = mGoodsInfoList.get(position);
        holder.mPhotoView.setImageResource(goodsInfo.getIcon());
        holder.mNameView.setText(goodsInfo.getName());
        String price = mContext.getString(R.string.goods_price, goodsInfo.getPrice());
        holder.mPriceView.setText(price);
        holder.mAddView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (mGoodsInfoList == null) {
            return 0;
        }
        return mGoodsInfoList.size();
    }

    @Override
    public void onClick(View v) {
        //do something

        if (mOnAddListener != null) {
            mOnAddListener.onAdd(v);
        }
    }

    static class GoodsHolder extends RecyclerView.ViewHolder {

        ImageView mPhotoView;
        TextView mNameView;
        TextView mPriceView;
        ImageView mAddView;

        public GoodsHolder(View itemView) {
            super(itemView);

            mPhotoView = (ImageView) itemView.findViewById(R.id.iv_goods_photo);
            mNameView = (TextView) itemView.findViewById(R.id.tv_goods_name);
            mPriceView = (TextView) itemView.findViewById(R.id.tv_goods_price);
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
