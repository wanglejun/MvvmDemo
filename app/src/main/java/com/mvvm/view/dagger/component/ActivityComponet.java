package com.mvvm.view.dagger.component;


import com.mvvm.view.activity.BaseActivity;
import com.mvvm.view.dagger.module.ActivityModule;

import dagger.Component;

/**
 * 全局Activity使用 暂时没用上
 */
@Component(modules = {ActivityModule.class})
public interface ActivityComponet {
    void inject(BaseActivity baseActivity);
}
