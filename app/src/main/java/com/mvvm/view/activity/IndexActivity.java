package com.mvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.mvvm.R;
import com.mvvm.dagger.AppComponet;
import com.mvvm.databinding.ActivityIndexBinding;
import com.mvvm.databinding.ActivityMainBinding;
import com.mvvm.utils.Constants;
import com.mvvm.viewmodel.UserInfoViewModel;

import javax.inject.Inject;

/**
 * 启动页
 */
public class IndexActivity extends BaseActivity implements View.OnClickListener{
    //注入UserInfoViewModel
    @Inject
    UserInfoViewModel userInfoViewModel;
    ActivityIndexBinding indexBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        indexBinding = DataBindingUtil.setContentView(this,R.layout.activity_index);
        activityComponet.inject(this);
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

    @Override
    public void initData() {

    }

    @Override
    public void initAppComponet(AppComponet appComponet) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
