package com.myshop.ui.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.HomeBean;

import java.util.List;

public class NewgoodsAdapter extends BaseAdapter<HomeBean.DataBean.NewGoodsListBean> {
    public NewgoodsAdapter(Context context, List<HomeBean.DataBean.NewGoodsListBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayout() {
        return R.layout.rec_item_newgoods;
    }

    @Override
    public void bindData(BaseViewHolder holder, HomeBean.DataBean.NewGoodsListBean data) {
        ImageView img = (ImageView) holder.getViewById(R.id.img_pic);
        TextView name = (TextView) holder.getViewById(R.id.txt_name);
        TextView price = (TextView) holder.getViewById(R.id.txt_price);
        Glide.with(mContext).load(data.getList_pic_url()).into(img);
        name.setText(data.getName());
        price.setText("￥"+data.getRetail_price());
    }
}
