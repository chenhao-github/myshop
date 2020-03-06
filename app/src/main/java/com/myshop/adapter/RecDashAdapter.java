package com.myshop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.TopicBean;

import java.util.List;

public class RecDashAdapter extends BaseAdapter<TopicBean.DataBeanX.DataBean>{
    public RecDashAdapter(Context context, List<TopicBean.DataBeanX.DataBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayout() {
        return R.layout.rec_item_dash_layout;
    }

    @Override
    public void bindData(BaseViewHolder holder, TopicBean.DataBeanX.DataBean data) {
        ImageView img = (ImageView) holder.getViewById(R.id.img_dash);
        TextView tv = (TextView) holder.getViewById(R.id.tv_dash);
        Glide.with(mContext).load(data.getScene_pic_url()).into(img);
        tv.setText(data.getTitle());
    }
}
