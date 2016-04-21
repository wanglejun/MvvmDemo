package com.mvvm.dagger;

import android.content.Context;

import com.mvvm.api.ApiRequestModule;
import com.mvvm.api.interfaces.IUserApi;
import com.mvvm.dagger.scope.PerApp;
import com.mvvm.utils.SPUtils;
import com.mvvmdao.greendao.DaoSession;

import javax.inject.Singleton;

import dagger.Component;

/**
 *全局公用Componet
 * author wanglejun 汪乐骏
 * 16/4/15.
 */
@PerApp
@Component(modules={AppModule.class,ApiRequestModule.class})
public interface AppComponet{
//    void inject(AppApplication appApplication);
    IUserApi getIUserApi();
    Context context();
    DaoSession getDaoSession();
    SPUtils getSPUtils();
}
