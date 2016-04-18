package com.mvvm.view.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;


import com.mvvm.dagger.AppComponet;
import com.mvvm.R;
import com.mvvm.databinding.ActivityLoginBinding;
import com.mvvm.viewmodel.UserInfoViewModel;

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
        activityComponet.inject(this);
//        loginBinding.setUserInfoViewModel(userInfoViewModel);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAppComponet(AppComponet appComponet) {

    }

    @Override
    public void setListener() {
        loginBinding.loginSignInBtn.setOnClickListener(this);
        loginBinding.loginRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_sign_in_btn:
                userInfoViewModel.requestLogin(loginBinding.loginUsernameEdit.getText().toString().trim(),
                        loginBinding.loginPasswordEdit.getText().toString().trim());
                break;

            case R.id.login_register_btn:
                userInfoViewModel.goRegister();
                break;
        }
    }
}

