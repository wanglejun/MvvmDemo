package com.mvvm.api.interfaces;



import com.mvvm.entity.HttpResponseEntity;
import com.mvvm.entity.UserEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by wang on 2016/4/13.
 * 注册登录接口
 */
public interface IUserApi {
    String REQUEST_HEAD = "Content-Type: application/x-www-form-urlencoded";
    @FormUrlEncoded
    @Headers(REQUEST_HEAD)
    @POST("register")
    Call<HttpResponseEntity<String>> register(@Field("username")String username, @Field("password")String password);


    @FormUrlEncoded
    @Headers(REQUEST_HEAD)
    @POST("login")
    Call<HttpResponseEntity<UserEntity>> login(@Field("username")String username, @Field("password")String password);

}
