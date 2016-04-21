package com.mvvm.view.dagger.module;

import android.app.Activity;

import com.mvvm.model.UserModel;
import com.mvvm.utils.ActivityIntentUtils;
import com.mvvm.utils.SPUtils;
import com.mvvm.viewmodel.UserInfoViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * UserInfo模块module
 * Created by wang on 2016/4/21.
 */
@Module
public class UserInfoModule {

    @Provides
    public UserModel provideUserModel(){
        return new UserModel();
    }

    /**
     * 提供UserInfoViewModel
     * @return UserInfoViewModel
     */
    @Provides
    public UserInfoViewModel provideUserInfoViewModel(Activity context, UserModel userModel, SPUtils SPUtils, ActivityIntentUtils intentUtils){
        return new UserInfoViewModel(context,userModel, SPUtils,intentUtils);
    }
}
