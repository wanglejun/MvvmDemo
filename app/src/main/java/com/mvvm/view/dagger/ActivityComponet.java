package com.mvvm.view.dagger;

import com.mvvm.view.activity.LoginActivity;
import com.mvvm.view.activity.MainActivity;
import com.mvvm.view.activity.RegisterActivity;

import dagger.Component;

@Component(modules = {ActivityModule.class})
public interface ActivityComponet {
    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);
    void inject(MainActivity mainActivity);
}
