package com.mvvm.view.dagger.component;

import com.mvvm.view.activity.IndexActivity;
import com.mvvm.view.activity.LoginActivity;
import com.mvvm.view.activity.MainActivity;
import com.mvvm.view.activity.RegisterActivity;
import com.mvvm.view.dagger.module.UserInfoModule;

import dagger.Component;

/**
 * 用户信息Component
 * Created by wang on 2016/4/21.
 */

@Component(modules = {UserInfoModule.class})
public interface UserInfoComponent {
    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);
    void inject(MainActivity mainActivity);
    void inject(IndexActivity indexActivity);
}
