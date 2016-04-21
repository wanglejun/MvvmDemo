package com.mvvm.view.dagger.component;

import com.mvvm.dagger.AppComponet;
import com.mvvm.dagger.scope.PerActivity;
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
@PerActivity
@Component(dependencies = {AppComponet.class,ActivityComponet.class}, modules = UserInfoModule.class)
public interface UserInfoComponent {
    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);
    void inject(MainActivity mainActivity);
}
