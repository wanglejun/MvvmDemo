package com.mvvm.dagger;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.mvvm.dagger.scope.PerApp;
import com.mvvm.utils.SPUtils;
import com.mvvmdao.greendao.DaoMaster;
import com.mvvmdao.greendao.DaoSession;

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

    @PerApp
    @Provides
    public Context provideContext(){
        return application;
    }

    /****GreenDao 数据库初始化************/
    @PerApp
    @Provides
    public SQLiteDatabase provideSQLiteDatabase(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application,"userinfo-db",null);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        return sqLiteDatabase;
    }

    @PerApp
    @Provides
    public DaoMaster providesDaoMaster(SQLiteDatabase sqLiteDatabase){
        DaoMaster daoMaster = new DaoMaster(sqLiteDatabase);
        return daoMaster;
    }

    @PerApp
    @Provides
    public DaoSession providesDaoSession(DaoMaster daoMaster){
        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }

    @Provides
    public SPUtils providesSPUtils(){
        return new SPUtils(application);
    }
}
