package com.myshop.ui.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.HomeBean;

import java.util.List;

public class BrandAdapter extends BaseAdapter<HomeBean.DataBean.BrandListBean> {
    public BrandAdapter(Context context, List<HomeBean.DataBean.BrandListBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayout() {
        return R.layout.rec_item_brand;
    }

    @Override
    public void bindData(BaseViewHolder holder, HomeBean.DataBean.BrandListBean data) {
        ImageView img = (ImageView) holder.getViewById(R.id.img_newpic);
        TextView txt_name = (TextView) holder.getViewById(R.id.txt_brand_name);
        TextView txt_price = (TextView) holder.getViewById(R.id.txt_price);
        Glide.with(mContext).load(data.getNew_pic_url()).into(img);
        txt_name.setText(data.getName());
        txt_price.setText(data.getFloor_price()+"元起");
    }
}
