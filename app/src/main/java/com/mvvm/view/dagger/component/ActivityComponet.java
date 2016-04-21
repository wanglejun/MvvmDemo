package com.mvvm.view.dagger.component;


import android.app.Activity;

import com.mvvm.utils.ActivityIntentUtils;
import com.mvvm.view.activity.BaseActivity;
import com.mvvm.view.dagger.module.ActivityModule;

import dagger.Component;

/**
 * Activity使用
 */
@Component(modules = {ActivityModule.class})
public interface ActivityComponet {
    Activity getActivity();

    ActivityIntentUtils getACIntentUtils();
}
