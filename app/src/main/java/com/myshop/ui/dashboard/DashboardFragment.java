package com.myshop.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myshop.R;
import com.myshop.adapter.RecDashAdapter;
import com.myshop.base.BaseFragment;
import com.myshop.interfaces.topic.TopicConstract;
import com.myshop.model.bean.TopicBean;
import com.myshop.presenter.topic.TopicPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DashboardFragment extends BaseFragment<TopicConstract.Presenter> implements TopicConstract.View{
    private int page = 1;
    private int size = 100;
    @BindView(R.id.rec_dash)
    RecyclerView rec_dash;
    private List<TopicBean.DataBeanX.DataBean> mData;
    private RecDashAdapter mAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected TopicConstract.Presenter createPresenter() {
        return new TopicPresenter();
    }

    @Override
    protected void initView() {
        //初始化recycleview
        rec_dash.setLayoutManager(new LinearLayoutManager(getActivity()));
        mData = new ArrayList<>();
        mAdapter = new RecDashAdapter(activity, mData);
        rec_dash.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        presenter.getTopicData(page,size);
    }

    @Override
    public void getTopicDataReturn(TopicBean result) {
        mData.addAll(result.getData().getData());
        mAdapter.notifyDataSetChanged();
    }
}