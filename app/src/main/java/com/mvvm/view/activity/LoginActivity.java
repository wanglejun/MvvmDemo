package com.mvvm.view.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;


import com.mvvm.dagger.AppComponet;
import com.mvvm.R;
import com.mvvm.databinding.ActivityLoginBinding;
import com.mvvm.eventbus.BaseEvent;
import com.mvvm.eventbus.LoginEvent;
import com.mvvm.eventbus.RegisterEvent;
import com.mvvm.utils.Constants;
import com.mvvm.view.dagger.component.DaggerUserInfoComponent;
import com.mvvm.view.dagger.component.UserInfoComponent;
import com.mvvm.view.dagger.module.UserInfoModule;
import com.mvvm.viewmodel.UserInfoViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;


/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{

    //注入UserInfoViewModel
    @Inject
    UserInfoViewModel userInfoViewModel;

    ActivityLoginBinding loginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Override
//    protected int inflaterContentView() {
//        return R.layout.activity_login;
//    }

    @Override
    public void initView() {
//        loginBinding = getDataBinding();
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        loginBinding.setUserInfo(userInfoViewModel.getUserInfo());
    }


    @Override
    public void setListener() {
        loginBinding.loginSignInBtn.setOnClickListener(this);
        loginBinding.loginRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void initComponet() {
        DaggerUserInfoComponent.builder().appComponet(getAppComponent()).
                activityComponet(getActivityComponet()).build().inject(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //登录
            case R.id.login_sign_in_btn:
                userInfoViewModel.requestLogin(loginBinding.loginUsernameEdit.getText().toString().trim(),
                        loginBinding.loginPasswordEdit.getText().toString().trim());
                break;

            //注册.
            case R.id.login_register_btn:
                userInfoViewModel.intentUtils.turnToActivity(RegisterActivity.class);
                break;
        }
    }



    @Subscribe
    public void onEventMainThread(BaseEvent event) {
        if (event instanceof LoginEvent) {
            Toast.makeText(this,"loginSuccess",Toast.LENGTH_LONG).show();
            userInfoViewModel.intentUtils.turnToNextActivity(MainActivity.class);
            //保存登录状态
            userInfoViewModel.updatgeLoginStatus(((LoginEvent) event).getUserEntity().getObjectId(), true);
        }

        else if (event instanceof RegisterEvent) {
            //注册成功loginUsernameEdit显示用户名
            if(!"".equals(((RegisterEvent) event).getUsername())){
                loginBinding.setUserInfo(userInfoViewModel.updateUsername(((RegisterEvent) event).getUsername()));
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        userInfoViewModel.registerEventBus();
    }

    @Override
    protected void onStop() {
        userInfoViewModel.unRegisterEventBus();
        super.onStop();
    }


}

