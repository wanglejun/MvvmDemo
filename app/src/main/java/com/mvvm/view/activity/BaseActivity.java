package com.mvvm.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mvvm.AppApplication;
import com.mvvm.AppComponet;
import com.mvvm.R;
import com.mvvm.view.ActivityComponet;
import com.mvvm.view.ActivityModule;
import com.mvvm.view.DaggerActivityComponet;

/**
 * BaseActivity
 */
public abstract class BaseActivity extends AppCompatActivity {

    public ActivityComponet activityComponet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }



    private void init(){
        initAppComponet(AppApplication.getsInstance().getAppComponent());
        activityComponet = DaggerActivityComponet.builder().activityModule(new ActivityModule()).build();
        initView();
        initData();
        setListener();
    }
    /**
     * 初始化view
     */
    public abstract void initView();

    /**
     * 初始数据
     */
    public abstract void initData();

    /**
     * 初始全局Componet
     */
    public abstract void initAppComponet(AppComponet appComponet);

    /**
     * 设置监听
     */
    public abstract void setListener();
}

