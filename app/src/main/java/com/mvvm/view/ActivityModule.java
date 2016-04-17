package com.mvvm.view;

import android.content.Context;

import com.mvvm.AppApplication;
import com.mvvm.view.model.UserModel;
import com.mvvm.view.viewmodel.UserInfoViewModel;

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
    public Context provieContext(){
        return AppApplication.getsInstance().getAppComponent().context();
    }

    /**
     * 提供UserInfoViewModel
     * @return UserInfoViewModel
     */
    @Provides
    public UserInfoViewModel provideUserInfoViewModel(Context context){
        return new UserInfoViewModel(context,new UserModel());
    }
}
