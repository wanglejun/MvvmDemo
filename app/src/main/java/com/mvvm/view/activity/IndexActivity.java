package com.mvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;

import com.mvvm.R;
import com.mvvm.databinding.ActivityIndexBinding;
import com.mvvm.utils.Constants;
import com.mvvm.view.dagger.component.DaggerUserInfoComponent;
import com.mvvm.view.dagger.component.UserInfoComponent;
import com.mvvm.view.dagger.module.UserInfoModule;
import com.mvvm.viewmodel.UserInfoViewModel;

import javax.inject.Inject;

/**
 * 启动页
 */
public class IndexActivity extends BaseActivity{
    //注入UserInfoViewModel
    @Inject
    UserInfoViewModel userInfoViewModel;
    ActivityIndexBinding indexBinding;

    private UserInfoComponent userInfoComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        indexBinding = DataBindingUtil.setContentView(this,R.layout.activity_index);

        userInfoComponent = DaggerUserInfoComponent.builder().userInfoModule(new UserInfoModule()).build();
        userInfoComponent.inject(this);
        userInfoViewModel.setContext(this);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                //已登录
                if(userInfoViewModel.sharedPreferencesUtils.getBooleanValues(Constants.SP_KEY_LOGIN_STATUS,false)){
                    userInfoViewModel.activityIntentUtils.turnToNextActivity(MainActivity.class);
                }else{
                    userInfoViewModel.activityIntentUtils.turnToNextActivity(LoginActivity.class);
                }
            }
        }, 1500);
    }
}
