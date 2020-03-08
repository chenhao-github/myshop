package com.myshop.ui.home;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myshop.DetailActivity;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.base.BaseFragment;
import com.myshop.interfaces.home.HomeConstract;
import com.myshop.model.bean.HomeBean;
import com.myshop.presenter.home.HomePresenter;
import com.myshop.ui.home.adapter.BrandAdapter;
import com.myshop.ui.home.adapter.ChannelAdapter;
import com.myshop.ui.home.adapter.HotGoodsAdapter;
import com.myshop.ui.home.adapter.NewgoodsAdapter;
import com.myshop.ui.home.adapter.TopicAdapter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomeConstract.Presenter> implements HomeConstract.View {
    @BindView(R.id.banner_home)
    Banner mBanner;
    @BindView(R.id.rec_channel)
    RecyclerView mChannel;
    @BindView(R.id.rec_brand)
    RecyclerView mBrand;
    @BindView(R.id.rec_newgoods)
    RecyclerView mNewGoods;
    @BindView(R.id.rec_hotgoods)
    RecyclerView mHotGoods;
    @BindView(R.id.rec_topic)
    RecyclerView mTopic;

    private List<HomeBean.DataBean.ChannelBean> mChannelList;
    private ChannelAdapter mChannelAdapter;
    private List<HomeBean.DataBean.BrandListBean> mBrandList;
    private BrandAdapter mBrandAdapter;
    private List<HomeBean.DataBean.NewGoodsListBean> mNewGoodsList;
    private NewgoodsAdapter mNewgoodsAdapter;
    private List<HomeBean.DataBean.HotGoodsListBean> mHotGoodsList;
    private HotGoodsAdapter mHotGoodsAdapter;
    private List<HomeBean.DataBean.TopicListBean> mTopicList;
    private TopicAdapter mTopicAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomeConstract.Presenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        //设置频道数据
        initChannel();
        //设置品牌数据
        initBrand();
        //设置新品数据
        initNewGoods();
        //人气商品
        initHotGoods();
        //专题精选
        initTopic();
    }

    //配置频道信息
    private void initChannel() {
        mChannel.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true));
        mChannelList = new ArrayList<>();
        mChannelAdapter = new ChannelAdapter(context,mChannelList);
        mChannel.setAdapter(mChannelAdapter);
    }
    //配置品牌信息
    private void initBrand() {
        mBrand.setLayoutManager(new GridLayoutManager(context,2));
        mBrandList = new ArrayList<>();
        mBrandAdapter = new BrandAdapter(context, mBrandList);
        mBrand.setAdapter(mBrandAdapter);
        mBrandAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseAdapter.BaseViewHolder holder) {
                String desc = mBrandList.get(holder.getLayoutPosition()).getSimple_desc();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("desc",desc);
                startActivity(intent);
            }
        });

    }
    //配置新品信息
    private void initNewGoods() {
        mNewGoods.setLayoutManager(new GridLayoutManager(context,2));
        mNewGoodsList = new ArrayList<>();
        mNewgoodsAdapter = new NewgoodsAdapter(context, mNewGoodsList);
        mNewGoods.setAdapter(mNewgoodsAdapter);

    }
    //配置人气商品信息
    private void initHotGoods() {
        mHotGoods.setLayoutManager(new LinearLayoutManager(context));
        mHotGoods.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
        mHotGoodsList = new ArrayList<>();
        mHotGoodsAdapter = new HotGoodsAdapter(context, mHotGoodsList);
        mHotGoods.setAdapter(mHotGoodsAdapter);
    }
    //配置专题精选
    private void initTopic() {
        mTopic.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true));
        mTopic.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.HORIZONTAL));
        mTopicList = new ArrayList<>();
        mTopicAdapter = new TopicAdapter(context, mTopicList);
        mTopic.setAdapter(mTopicAdapter);

    }

    @Override
    protected void initData() {
        presenter.getHomeData();
    }

    @Override
    public void getHomeDataReturn(HomeBean result) {
        initBanner(result.getData().getBanner());//配置banner数据
        //配置channel数据
        mChannelAdapter.updataListClearAddMore(result.getData().getChannel());
        //配置brand数据
        mBrandAdapter.updataListClearAddMore(result.getData().getBrandList());
        //配置newgoods数据
        mNewgoodsAdapter.updataListClearAddMore(result.getData().getNewGoodsList());
        //配置hotgoods数据
        mHotGoodsAdapter.updataListClearAddMore(result.getData().getHotGoodsList());
        //配置专题精选
        mTopicAdapter.updataListClearAddMore(result.getData().getTopicList());
    }
    //配置banner数据
    private void initBanner(List<HomeBean.DataBean.BannerBean> banner) {
        mBanner.setImages(banner).setImageLoader(new BannerImageLoader()).start();
    }

    //banner图片加载器
    class BannerImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            HomeBean.DataBean.BannerBean bannerBean = (HomeBean.DataBean.BannerBean) path;
            Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
        }
    }
}