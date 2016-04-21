package com.mvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;

import com.mvvm.R;
import com.mvvm.databinding.ActivityIndexBinding;
import com.mvvm.utils.Constants;
import com.mvvm.view.dagger.component.DaggerIndexComponent;
import com.mvvm.view.dagger.component.DaggerUserInfoComponent;
import com.mvvm.view.dagger.component.UserInfoComponent;
import com.mvvm.view.dagger.module.UserInfoModule;
import com.mvvm.viewmodel.IndexViewModel;
import com.mvvm.viewmodel.UserInfoViewModel;

import javax.inject.Inject;

/**
 * 启动页
 */
public class IndexActivity extends BaseActivity{
    //注入IndexViewModel
    @Inject
    IndexViewModel indexViewModel;
    ActivityIndexBinding indexBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        indexBinding = DataBindingUtil.setContentView(this,R.layout.activity_index);


    }

    @Override
    public void initComponet() {
        DaggerIndexComponent.builder()
                .appComponet(getAppComponent())
                .activityComponet(getActivityComponet())
                .build()
                .inject(this);
    }
}
