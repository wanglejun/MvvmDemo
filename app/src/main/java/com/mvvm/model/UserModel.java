package com.mvvm.model;

import android.content.Context;
import android.widget.Toast;

import com.mvvm.dagger.AppApplication;
import com.mvvm.api.interfaces.IUserApi;
import com.mvvm.dao.UserInofDbDao;
import com.mvvm.entity.HttpResponseEntity;
import com.mvvm.entity.UserEntity;
import com.mvvm.eventbus.LoginEvent;
import com.mvvm.eventbus.RegisterEvent;
import com.mvvmdao.greendao.UserInfo;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

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
    private Context context;
    private UserInofDbDao userInofDbDao;
    @Inject
    public UserModel(){
        this.context = AppApplication.getsInstance().getAppComponent().context();
        iUserApi = AppApplication.getsInstance().getAppComponent().getIUserApi();
        userInofDbDao = UserInofDbDao.getInstance();
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     */
    public void login(String username, final String password){
        Call<HttpResponseEntity<UserEntity>> callResponse = iUserApi.login(username,password);
        callResponse.enqueue(new Callback<HttpResponseEntity<UserEntity>>() {
            @Override
            public void onResponse(Call<HttpResponseEntity<UserEntity>> call, Response<HttpResponseEntity<UserEntity>> response) {
                if(response.body().getCode() == 200){
                    UserEntity userEntity = response.body().getData();
                    userEntity.setPassword(password);
                    //保存用户信息
                    userInofDbDao.insertUserInfo(userEntity);
                    EventBus.getDefault().post(new LoginEvent(userEntity));
                }else{
                    if(!"".equals(response.body().getMsg())){
                        Toast.makeText(context,response.body().getMsg(),Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<HttpResponseEntity<UserEntity>> call, Throwable t) {
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
                if(response.body().getCode() == 200){
                    EventBus.getDefault().post(new RegisterEvent());
                }else if(response.body().getCode() == 202){
                    Toast.makeText(context,"用户已存在",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<HttpResponseEntity<String>> call, Throwable t) {
                System.out.println("onFailure..............."+t.getMessage());
                Toast.makeText(context,"注册失败",Toast.LENGTH_LONG).show();

            }
        });

    }



    /**
     * 根据objectId查询userinfo
     * @param objectId
     * @return
     */
    public List<UserInfo> queryUserInfoOfObjectId(String objectId){
        return userInofDbDao.queryUserInfoOfObjectId(objectId);
    }
}
