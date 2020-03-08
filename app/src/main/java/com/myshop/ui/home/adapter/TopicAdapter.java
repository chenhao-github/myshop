package com.myshop.ui.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.HomeBean;

import java.util.List;

public class TopicAdapter extends BaseAdapter<HomeBean.DataBean.TopicListBean> {
    public TopicAdapter(Context context, List<HomeBean.DataBean.TopicListBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayout() {
        return R.layout.rec_item_topic;
    }

    @Override
    public void bindData(BaseViewHolder holder, HomeBean.DataBean.TopicListBean data) {
        ImageView img = (ImageView) holder.getViewById(R.id.img_pic);
        TextView title = (TextView) holder.getViewById(R.id.txt_title);
        TextView price = (TextView) holder.getViewById(R.id.txt_price);
        TextView subtitle = (TextView) holder.getViewById(R.id.txt_subtitle);


        Glide.with(mContext).load(data.getItem_pic_url()).into(img);
        title.setText(data.getTitle());
        price.setText("￥"+data.getPrice_info()+"元起");
        subtitle.setText(data.getSubtitle());
    }
}
