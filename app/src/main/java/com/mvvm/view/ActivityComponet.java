package com.mvvm.view;

import com.mvvm.view.activity.LoginActivity;

import dagger.Component;

@Component(modules = {ActivityModule.class})
public interface ActivityComponet {
    void inject(LoginActivity loginActivity);
}
