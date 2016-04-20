package com.mvvm.eventbus;

import com.mvvm.entity.UserEntity;

/**
 * User: 汪乐骏
 * Date: 2016-04-20
 * Time: 21:58
 * 登录event
 */
public class LoginEvent extends BaseEvent{

    private UserEntity userEntity;
    public LoginEvent(UserEntity userEntity){
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }
}
