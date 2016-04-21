package com.mvvm.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mvvm.dagger.AppApplication;
import com.mvvm.dagger.AppComponet;
import com.mvvm.view.dagger.component.ActivityComponet;
import com.mvvm.view.dagger.component.DaggerActivityComponet;
import com.mvvm.view.dagger.module.ActivityModule;


/**
 * BaseActivity
 */
public abstract class BaseActivity
//        <V extends ViewDataBinding>
        extends AppCompatActivity {

    public ActivityComponet activityComponet;
//    private V dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }



    private void init(){

        activityComponet = DaggerActivityComponet.builder().activityModule(new ActivityModule(this)).build();

//        dataBinding = DataBindingUtil.setContentView(this,inflaterContentView());
        initComponet();
        initView();
        initData();
        setListener();
    }

    public AppComponet getAppComponent(){
        return AppApplication.getsInstance().getAppComponent();
    }

    public ActivityComponet getActivityComponet(){
        return activityComponet;
    }


//    protected abstract int inflaterContentView();

    /**
     * 初始化view
     */
    public abstract void initView();

    /**
     * 初始数据
     */
    public void initData(){}


    /**
     * 初始全局Componet
     */
    public abstract void initComponet();

    /**
     * 设置监听
     */
    public void setListener(){

    }


//    public V getDataBinding(){
//        return dataBinding;
//    }
}

