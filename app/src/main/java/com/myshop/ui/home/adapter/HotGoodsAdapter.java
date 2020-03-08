package com.myshop.ui.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.HomeBean;

import java.util.List;

public class HotGoodsAdapter extends BaseAdapter<HomeBean.DataBean.HotGoodsListBean> {
    public HotGoodsAdapter(Context context, List<HomeBean.DataBean.HotGoodsListBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayout() {
        return R.layout.rec_item_hotgoods;
    }

    @Override
    public void bindData(BaseViewHolder holder, HomeBean.DataBean.HotGoodsListBean data) {
        ImageView img = (ImageView) holder.getViewById(R.id.img_pic);
        TextView name = (TextView) holder.getViewById(R.id.txt_name);
        TextView brief = (TextView) holder.getViewById(R.id.txt_brief);
        TextView price = (TextView) holder.getViewById(R.id.txt_price);
        Glide.with(mContext).load(data.getList_pic_url()).into(img);
        name.setText(data.getName());
        brief.setText(data.getGoods_brief());
        price.setText("￥"+data.getRetail_price());
    }
}
