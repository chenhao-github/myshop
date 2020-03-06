package com.myshop.interfaces.topic;

import com.myshop.interfaces.IBasePresenter;
import com.myshop.interfaces.IBaseView;
import com.myshop.model.bean.TopicBean;

public interface TopicConstract {
    interface View extends IBaseView{
        void getTopicDataReturn(TopicBean result);
    }
    interface Presenter extends IBasePresenter<View>{
        void getTopicData(int page,int size);
    }
}
