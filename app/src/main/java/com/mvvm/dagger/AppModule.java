package com.mvvm.dagger;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    @Singleton
    @Provides
    public Context provideContext(){
        return application;
    }

    /****GreenDao 数据库初始化************/
    @Singleton
    @Provides
    public SQLiteDatabase provideSQLiteDatabase(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application,"userinfo-db",null);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        return sqLiteDatabase;
    }

    @Singleton
    @Provides
    public DaoMaster providesDaoMaster(SQLiteDatabase sqLiteDatabase){
        DaoMaster daoMaster = new DaoMaster(sqLiteDatabase);
        return daoMaster;
    }

    @Singleton
    @Provides
    public DaoSession providesDaoSession(DaoMaster daoMaster){
        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }

}
