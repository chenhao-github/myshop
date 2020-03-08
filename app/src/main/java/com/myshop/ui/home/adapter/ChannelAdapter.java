package com.myshop.ui.home.adapter;

import android.content.Context;
import android.widget.TextView;

import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.HomeBean;

import java.util.List;

public class ChannelAdapter extends BaseAdapter<HomeBean.DataBean.ChannelBean> {
    public ChannelAdapter(Context context, List<HomeBean.DataBean.ChannelBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayout() {
        return R.layout.rec_item_channel;
    }

    @Override
    public void bindData(BaseViewHolder holder, HomeBean.DataBean.ChannelBean data) {
        TextView tv = (TextView) holder.getViewById(R.id.tv_channel_name);
        tv.setText(data.getName());
    }
}
