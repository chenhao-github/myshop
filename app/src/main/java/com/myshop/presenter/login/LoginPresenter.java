package com.myshop.presenter.login;

import com.myshop.base.BaseFragment;
import com.myshop.base.BasePresenter;
import com.myshop.interfaces.login.LoginConstract;
import com.myshop.model.HttpManager;
import com.myshop.model.bean.LoginBean;
import com.myshop.utils.RxUtils;

import io.reactivex.subscribers.ResourceSubscriber;

public class LoginPresenter extends BasePresenter<LoginConstract.View> implements LoginConstract.Presenter{
    @Override
    public void login(String nickName, String password) {
        addSubscribe(HttpManager.getInstance().getMyServer().login(nickName,password)
        .compose(RxUtils.<LoginBean>rxScheduler())
        .subscribeWith(new ResourceSubscriber<LoginBean>() {
            @Override
            public void onNext(LoginBean loginBean) {
                mView.loginRetrun(loginBean);
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
