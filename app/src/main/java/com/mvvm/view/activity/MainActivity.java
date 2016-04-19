package com.mvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mvvm.R;
import com.mvvm.dagger.AppComponet;
import com.mvvm.databinding.ActivityMainBinding;
import com.mvvm.viewmodel.UserInfoViewModel;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
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

    }

}
