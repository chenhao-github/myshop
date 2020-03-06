package com.myshop.interfaces.login;

import com.myshop.interfaces.IBasePresenter;
import com.myshop.interfaces.IBaseView;
import com.myshop.model.bean.LoginBean;

public interface LoginConstract {
    interface View extends IBaseView{
        void loginRetrun(LoginBean result);
    }

    interface Presenter extends IBasePresenter<View>{
        void login(String nickName, String password );
    }
}
