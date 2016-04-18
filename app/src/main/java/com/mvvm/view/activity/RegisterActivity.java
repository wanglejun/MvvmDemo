package com.mvvm.view.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mvvm.R;
import com.mvvm.dagger.AppComponet;
import com.mvvm.databinding.ActivityRegisterBinding;
import com.mvvm.viewmodel.UserInfoViewModel;

import javax.inject.Inject;

/**
 * 注册页面
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    //注入UserInfoViewModel
    @Inject
    UserInfoViewModel userInfoViewModel;
    private ActivityRegisterBinding registerBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        registerBinding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        activityComponet.inject(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAppComponet(AppComponet appComponet) {

    }

    @Override
    public void setListener() {
        registerBinding.registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_btn:
                userInfoViewModel.requestRegister(registerBinding.registerUsernameEdit.getText().toString().trim(),
                        registerBinding.registerPasswordEdit.getText().toString().trim());
                break;
        }
    }
}

