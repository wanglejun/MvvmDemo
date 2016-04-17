package com.mvvm;

import android.app.Application;

import com.mvvm.api.ApiRequestModule;

/**
 * User: 汪乐骏
 * Date: 2016-04-15
 * Time: 22:47
 */
public class AppApplication extends Application{
    private static AppApplication application;
    private AppComponet appComponet;
    @Override
    public void onCreate() {
        super.onCreate();
        this.application = this;
        initComponent();
    }

    /**
     * 初始AppComponet
     */
    private void initComponent(){
        appComponet = DaggerAppComponet.builder().appModule(new AppModule(this)).
                apiRequestModule(new ApiRequestModule()).build();
    }

    public static AppApplication getsInstance(){
        return application;
    }

    public AppComponet getAppComponent(){
        return appComponet;
    }
}
