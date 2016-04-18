package com.mvvm.view.dagger;

import android.content.Context;


import com.mvvm.dagger.AppApplication;
import com.mvvm.model.UserModel;
import com.mvvm.viewmodel.UserInfoViewModel;

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

    /**
     * 提供UserInfoViewModel
     * @return UserInfoViewModel
     */
    @Provides
    public UserInfoViewModel provideUserInfoViewModel(Context context){
        return new UserInfoViewModel(context,new UserModel());
    }
}
