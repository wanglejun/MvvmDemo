package com.mvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mvvm.R;
import com.mvvm.dagger.AppComponet;
import com.mvvm.databinding.ActivityMainBinding;
import com.mvvm.utils.Constants;
import com.mvvm.viewmodel.UserInfoViewModel;

import javax.inject.Inject;

/**
 * 主页
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{
    //注入UserInfoViewModel
    @Inject
    UserInfoViewModel userInfoViewModel;
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityComponet.inject(this);
        userInfoViewModel.setContext(this);
        mainBinding.setUserInfo(userInfoViewModel.getUserInfo());
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAppComponet(AppComponet appComponet) {

    }

    @Override
    public void setListener() {
        mainBinding.mainExitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //退出 修改登录状态
        userInfoViewModel.sharedPreferencesUtils.putBooleanValues(Constants.SP_KEY_LOGIN_STATUS,false);
        userInfoViewModel.activityIntentUtils.turnToNextActivity(LoginActivity.class);
    }
}
