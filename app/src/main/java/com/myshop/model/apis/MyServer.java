package com.myshop.model.apis;

import com.myshop.model.bean.HomeBean;
import com.myshop.model.bean.LoginBean;
import com.myshop.model.bean.RegistBean;
import com.myshop.model.bean.TopicBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyServer {

    @GET("index")
    Flowable<HomeBean> getHome();

    //专题数据请求接口
    @GET("topic/list")
    Flowable<TopicBean> getTopic(@Query("page") int page, @Query("size") int size);

    //登录接口
    @POST("auth/login")
    @FormUrlEncoded
    Flowable<LoginBean> login(@Field("nickname") String nickname, @Field("password") String password);

    //注册接口
    @POST("auth/register")
    @FormUrlEncoded
    Flowable<RegistBean> regist(@FieldMap Map<String,String> map);

}
