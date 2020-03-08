package com.myshop.ui.dashboard;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myshop.R;
import com.myshop.ui.dashboard.adapter.RecTopicAdapter;
import com.myshop.base.BaseAdapter;
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
    private RecTopicAdapter mAdapter;

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
        mAdapter = new RecTopicAdapter(activity, mData);
        rec_dash.setAdapter(mAdapter);
        //一个界面有一个列表时，可以用本类实现监听，如果有两个及以上，用内部类分开做
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseAdapter.BaseViewHolder holder) {
                String title = mData.get(holder.getLayoutPosition()).getTitle();
                showTips(title);
            }
        });
    }

    @Override
    protected void initData() {
        presenter.getTopicData(page,size);
    }

    @Override
    public void getTopicDataReturn(TopicBean result) {
        mAdapter.updataListClearAddMore(result.getData().getData());
    }
}