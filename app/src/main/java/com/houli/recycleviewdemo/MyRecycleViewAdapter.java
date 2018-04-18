package com.houli.recycleviewdemo;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stone on 2018/4/17.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private ArrayList<String> mDatas;
    private static final int TYPE_TOPIC = 0;
    private static final int TYPE_DOUBLE = 2;
    private static final int TYPE_SINGLE = 1;

    public MyRecycleViewAdapter(Context mContext, ArrayList<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {//header 头标题
            return TYPE_TOPIC;
        } else {
            if (position % 2 == 0) {//出去header后的双数行
                return TYPE_DOUBLE;
            } else {
                return TYPE_SINGLE;
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_SINGLE) {
            return new MyViewHolder(mLayoutInflater.inflate(R.layout.simple_recycleview_item, parent, false));
        } else if (viewType == TYPE_DOUBLE) {
            return new MyViewHolder(mLayoutInflater.inflate(R.layout.double_recycleview_item, parent, false));
        } else {
            View inflate = mLayoutInflater.inflate(R.layout.header_title, parent, false);
            HeaderViewHolder headerViewHolder = new HeaderViewHolder(inflate);
            return headerViewHolder;
        }
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (position == 0) {
            return;
        }
        if (holder instanceof MyViewHolder) {
            String s = mDatas.get(position - 1);
            ((MyViewHolder) holder).img_recycle.setImageResource(R.mipmap.lack_coins_red);
            ((MyViewHolder) holder).mTextView.setText(s);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showToast(mContext,"点击了"+position);
                }
            });

        } else if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).mTextView.setText("测试列表开始处");
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        private final ImageView img_recycle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.item_recyle);
            img_recycle = itemView.findViewById(R.id.img_recycle);
        }

    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.header);
        }
    }


}
