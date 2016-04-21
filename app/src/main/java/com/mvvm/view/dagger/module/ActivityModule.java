package com.mvvm.view.dagger.module;

import android.content.Context;


import com.mvvm.dagger.AppApplication;


import dagger.Module;
import dagger.Provides;

/**
 * User: 汪乐骏
 * Date: 2016-04-16
 * Time: 23:58
 */
@Module
public class ActivityModule {

    @Provides
    public Context provideContext(){
        return AppApplication.getsInstance().getAppComponent().context();
    }
}
