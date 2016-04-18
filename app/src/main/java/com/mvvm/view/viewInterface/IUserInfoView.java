package com.mvvm.view.viewInterface;


import com.mvvm.entity.UserEntity;

/**
 * user view层接口 开放给vm层实现
 */
public interface IUserInfoView {
    //登录
    void loginSuccess(UserEntity userEntity);
    //注册
    void registerSuccess();
}
