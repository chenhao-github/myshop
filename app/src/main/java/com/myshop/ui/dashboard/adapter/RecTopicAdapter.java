package com.myshop.ui.dashboard.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.TopicBean;

import java.util.List;

public class RecTopicAdapter extends BaseAdapter<TopicBean.DataBeanX.DataBean>{
    public RecTopicAdapter(Context context, List<TopicBean.DataBeanX.DataBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayout() {
        return R.layout.rec_item_topic;
    }

    @Override
    public void bindData(BaseViewHolder holder, TopicBean.DataBeanX.DataBean data) {
        ImageView img = (ImageView) holder.getViewById(R.id.img_pic);
        TextView tv = (TextView) holder.getViewById(R.id.txt_name);
        Glide.with(mContext).load(data.getScene_pic_url()).into(img);
        tv.setText(data.getTitle());
    }
}
