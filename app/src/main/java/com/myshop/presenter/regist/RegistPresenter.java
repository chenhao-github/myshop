package com.myshop.presenter.regist;

import com.myshop.base.BasePresenter;
import com.myshop.common.ResponseSubscriber;
import com.myshop.interfaces.regist.RegistConstract;
import com.myshop.model.HttpManager;
import com.myshop.model.bean.RegistBean;
import com.myshop.utils.RxUtils;

import java.util.HashMap;

import io.reactivex.subscribers.ResourceSubscriber;

public class RegistPresenter extends BasePresenter<RegistConstract.View> implements RegistConstract.Presenter  {
    @Override
    public void regist(String nickname, String password, String verify) {
        HashMap<String, String> map = new HashMap<>();
        map.put("nickname",nickname);
        map.put("password",password);
        map.put("verify",verify);
        addSubscribe(HttpManager.getInstance().getMyServer().regist(map)
        .compose(RxUtils.<RegistBean>rxScheduler())
        .subscribeWith(new ResourceSubscriber<RegistBean>(){

            @Override
            public void onNext(RegistBean registBean) {
                mView.registReturn(registBean);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        }));
    }
}
