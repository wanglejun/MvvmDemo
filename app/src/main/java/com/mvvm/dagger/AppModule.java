package com.mvvm.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * AppMoudel
 * User: 汪乐骏
 * Date: 2016-04-16
 * Time: 13:20
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application){
        this.application=application;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return application;
    }



}
