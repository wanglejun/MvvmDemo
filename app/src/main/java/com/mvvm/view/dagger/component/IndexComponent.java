package com.mvvm.view.dagger.component;

import com.mvvm.dagger.AppComponet;
import com.mvvm.dagger.scope.PerActivity;
import com.mvvm.view.activity.IndexActivity;
import com.mvvm.view.dagger.module.IndexModule;

import dagger.Component;

@PerActivity
@Component(dependencies = { AppComponet.class, ActivityComponet.class}, modules = IndexModule.class)
public interface IndexComponent {
    void inject(IndexActivity indexActivity);
}
