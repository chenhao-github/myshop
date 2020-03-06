package com.myshop.presenter.topic;

import android.annotation.SuppressLint;

import com.myshop.base.BasePresenter;
import com.myshop.common.ResponseSubscriber;
import com.myshop.interfaces.topic.TopicConstract;
import com.myshop.model.HttpManager;
import com.myshop.model.bean.TopicBean;
import com.myshop.utils.RxUtils;

import io.reactivex.subscribers.ResourceSubscriber;

public class TopicPresenter extends BasePresenter<TopicConstract.View> implements TopicConstract.Presenter {
    @Override
    public void getTopicData(int page, int size) {
        addSubscribe(HttpManager.getInstance().getMyServer().getTopic(page,size)
        .compose(RxUtils.<TopicBean>rxScheduler())
        .subscribeWith(new ResponseSubscriber<TopicBean>(mView){
            @Override
            public void onNext(TopicBean topicBean) {
                mView.getTopicDataReturn(topicBean);

            }
        }));
//        HttpManager.getInstance().getMyServer().getTopic(page,size)
//                .compose(RxUtils.<TopicBean>rxScheduler())
//                .subscribeWith(new ResourceSubscriber<TopicBean>() {
//                    @Override
//                    public void onNext(TopicBean topicBean) {
//                        mView.getTopicDataReturn(topicBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        mView.showTips(t.getMessage());
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
