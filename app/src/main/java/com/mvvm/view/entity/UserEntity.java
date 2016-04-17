package com.mvvm.view.entity;

import android.databinding.ObservableField;

/**
 * Created by wang on 2016/4/17.
 * user model
 */
public class UserEntity{
    //用户名
    public String username;
    //密码
    public String password;
    //用户id
    public String objectId;
    //创建时间
    public String createAt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
