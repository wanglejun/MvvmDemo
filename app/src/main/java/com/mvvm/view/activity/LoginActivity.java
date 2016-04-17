package com.mvvm.view.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;


import com.mvvm.AppComponet;
import com.mvvm.R;
import com.mvvm.api.interfaces.IUserApi;
import com.mvvm.databinding.ActivityLoginBinding;
import com.mvvm.model.HttpResponseEntity;
import com.mvvm.view.entity.UserEntity;
import com.mvvm.view.viewmodel.UserInfoViewModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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


    @Override
    public void initView() {
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        activityComponet.inject(this);
        loginBinding.setUserInfoViewModel(userInfoViewModel);
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
                System.out.println();
                System.out.println("username------------>"+loginBinding.loginUsernameEdit.getText().toString());
                userInfoViewModel.requestLogin(loginBinding.loginUsernameEdit.getText().toString(),
                        loginBinding.loginPasswordEdit.getText().toString());
                break;

            case R.id.login_register_btn:
                break;
        }
    }
}

