package com.mvvm.view.dagger.module;

import com.mvvm.utils.ActivityIntentUtils;
import com.mvvm.utils.SPUtils;
import com.mvvm.viewmodel.IndexViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * User: 汪乐骏
 * Date: 2016-04-21
 * Time: 22:21
 * FIXME
 */
@Module
public class IndexModule {
    @Provides
    public IndexViewModel providesIndexViewModel(SPUtils SPUtils, ActivityIntentUtils intentUtils){
        return new IndexViewModel(SPUtils, intentUtils);
    }
}
