package com.mvvm.model;

import android.content.Context;
import android.widget.Toast;

import com.mvvm.dagger.AppApplication;
import com.mvvm.api.interfaces.IUserApi;
import com.mvvm.entity.HttpResponseEntity;
import com.mvvm.entity.UserEntity;
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
public class UserModel{
    IUserApi iUserApi;
    private IUserInfoView iUserInfoView;
    private Context context;

    @Inject
    public UserModel(){
        this.context = AppApplication.getsInstance().getAppComponent().context();
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
                System.out.println("username----------------->"+response.body().getData().getUsername());
                if(response.code() == 200){
                    iUserInfoView.loginSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HttpResponseEntity<UserEntity>> call, Throwable t) {
                System.out.println();
                System.out.println("onFailure..............."+t.getMessage());
                Toast.makeText(context,"登录失败",Toast.LENGTH_LONG).show();

            }
        });
    }


    /**
     * 注册
     * @param username
     * @param password
     */
    public void register(String username,String password){
        Call<HttpResponseEntity<String>> callResponse = iUserApi.register(username,password);
        callResponse.enqueue(new Callback<HttpResponseEntity<String>>() {
            @Override
            public void onResponse(Call<HttpResponseEntity<String>> call, Response<HttpResponseEntity<String>> response) {
                System.out.println();
                System.out.println("register........");
                if(response.code() == 200){
                    iUserInfoView.registerSuccess();
                }else if(response.code() == 202){
                    Toast.makeText(context,"用户已存在",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<HttpResponseEntity<String>> call, Throwable t) {
                System.out.println();
                System.out.println("onFailure..............."+t.getMessage());
                Toast.makeText(context,"注册失败",Toast.LENGTH_LONG).show();

            }
        });

    }
    public void setiUserInfoView(IUserInfoView iUserInfoView) {
        this.iUserInfoView = iUserInfoView;
    }


}
