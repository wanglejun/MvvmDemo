package com.mvvm.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mvvm.dagger.AppApplication;
import com.mvvm.dagger.AppComponet;


/**
 * BaseActivity
 */
public abstract class BaseActivity
//        <V extends ViewDataBinding>
        extends AppCompatActivity {

//    public ActivityComponet activityComponet;
//    private V dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }



    private void init(){
        initAppComponet(AppApplication.getsInstance().getAppComponent());
//        activityComponet = DaggerActivityComponet.builder().activityModule(new ActivityModule()).build();

//        dataBinding = DataBindingUtil.setContentView(this,inflaterContentView());
        initView();
        initData();
        setListener();
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
    public void initAppComponet(AppComponet appComponet){}

    /**
     * 设置监听
     */
    public void setListener(){

    }


//    public V getDataBinding(){
//        return dataBinding;
//    }
}

