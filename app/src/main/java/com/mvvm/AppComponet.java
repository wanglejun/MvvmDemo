package com.mvvm;

import android.content.Context;

import com.mvvm.api.ApiRequestModule;
import com.mvvm.api.interfaces.IUserApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 *全局公用Componet
 * author wanglejun 汪乐骏
 * 16/4/15.
 */
@Singleton
@Component(modules={AppModule.class,ApiRequestModule.class})
public interface AppComponet{
//    void inject(AppApplication appApplication);
    IUserApi getIUserApi();
    Context context();
}
