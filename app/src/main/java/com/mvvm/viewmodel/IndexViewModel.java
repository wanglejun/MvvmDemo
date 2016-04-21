package com.mvvm.viewmodel;

import android.os.Handler;

import com.mvvm.utils.ActivityIntentUtils;
import com.mvvm.utils.Constants;
import com.mvvm.utils.SPUtils;
import com.mvvm.view.activity.LoginActivity;
import com.mvvm.view.activity.MainActivity;

/**
 * User: 汪乐骏
 * Date: 2016-04-21
 * Time: 22:17
 * indextactivity viewmodel
 */
public class IndexViewModel {
    public IndexViewModel(final SPUtils SPUtils, final ActivityIntentUtils intentUtils){
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                //已登录
                if(SPUtils.getBooleanValues(Constants.SP_KEY_LOGIN_STATUS,false)){
                    intentUtils.turnToNextActivity(MainActivity.class);
                }else{
                    intentUtils.turnToNextActivity(LoginActivity.class);
                }
            }
        }, 1500);

    }
}
