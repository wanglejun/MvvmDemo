package com.mvvm.view.entity;

import android.databinding.ObservableField;

/**
 * Created by wang on 2016/4/17.
 * user model
 */
public class UserEntity{
    //用户名
    public final ObservableField<String> username = new ObservableField<>();
    //密码
    public final ObservableField<String> password = new ObservableField<>();
    //用户id
    public final ObservableField<String> objectId = new ObservableField<>();
    //创建时间
    public final ObservableField<String> createAt = new ObservableField<>();


}
