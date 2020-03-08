package com.myshop.presenter.home;

import android.util.Log;

import com.myshop.base.BasePresenter;
import com.myshop.interfaces.home.HomeConstract;
import com.myshop.model.HttpManager;
import com.myshop.model.bean.HomeBean;
import com.myshop.utils.RxUtils;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 *BasePresenter的泛型是HomeConstract.View，所以23行继承自BasePresenter的mView是HomeConstract.View
 *具有getHomeDataReturn方法
 */

public class HomePresenter extends BasePresenter<HomeConstract.View> implements HomeConstract.Presenter {
    @Override
    public void getHomeData() {
        HttpManager.getInstance().getMyServer().getHome()
                .compose(RxUtils.<HomeBean>rxScheduler())
                .subscribeWith(new ResourceSubscriber<HomeBean>() {
                    @Override
                    public void onNext(HomeBean homeBean) {
                        mView.getHomeDataReturn(homeBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
