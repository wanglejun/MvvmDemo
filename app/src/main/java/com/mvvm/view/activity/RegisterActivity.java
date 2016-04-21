package com.mvvm.view.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mvvm.R;
import com.mvvm.dagger.AppComponet;
import com.mvvm.databinding.ActivityRegisterBinding;
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
 * 注册页面
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    //注入UserInfoViewModel
    @Inject
    UserInfoViewModel userInfoViewModel;
    private ActivityRegisterBinding registerBinding;
    private boolean isRegisterSuccess = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        registerBinding = DataBindingUtil.setContentView(this,R.layout.activity_register);

    }

    @Override
    public void setListener() {
        registerBinding.registerBtn.setOnClickListener(this);
    }

    @Override
    public void initComponet() {
        DaggerUserInfoComponent.builder().appComponet(getAppComponent()).
                activityComponet(getActivityComponet()).build().inject(this);
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

    @Subscribe
    public void onEventMainThread(BaseEvent event) {
        if (event instanceof RegisterEvent) {
            Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
            isRegisterSuccess = true;
            finish();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注册成功loginUsernameEdit显示用户名
        if(isRegisterSuccess){
            EventBus.getDefault().post(new RegisterEvent(registerBinding.registerUsernameEdit.getText().toString().trim()));
        }
    }
}

