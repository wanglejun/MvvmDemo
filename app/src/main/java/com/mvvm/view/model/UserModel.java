package com.mvvm.view.model;

import com.mvvm.AppApplication;
import com.mvvm.api.interfaces.IUserApi;
import com.mvvm.model.HttpResponseEntity;
import com.mvvm.view.entity.UserEntity;
import com.mvvm.view.viewInterface.IUserInfoView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * User: 汪乐骏
 * Date: 2016-04-17
 * Time: 20:39
 * 用户模块model
 * */
public class UserModel {
    IUserApi iUserApi;

    private IUserInfoView iUserInfoView;

    @Inject
    public UserModel(){
        iUserApi = AppApplication.getsInstance().getAppComponent().getIUserApi();
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     */
    public void login(String username,String password){
        Call<HttpResponseEntity<UserEntity>> callResponse = iUserApi.login(username,password);
        callResponse.enqueue(new Callback<HttpResponseEntity<UserEntity>>() {
            @Override
            public void onResponse(Call<HttpResponseEntity<UserEntity>> call, Response<HttpResponseEntity<UserEntity>> response) {
                System.out.println();
                System.out.println("ssssssssssssssssssssss");
                System.out.println("isSuccessful----------------->"+response.isSuccessful());
                System.out.println("username----------------->"+response.body().getData().username.get());

                iUserInfoView.loginSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResponseEntity<UserEntity>> call, Throwable t) {

            }
        });
    }

    public void setiUserInfoView(IUserInfoView iUserInfoView) {
        this.iUserInfoView = iUserInfoView;
    }


}
