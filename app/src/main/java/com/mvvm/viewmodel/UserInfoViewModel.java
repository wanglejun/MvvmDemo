package com.mvvm.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.mvvm.dao.UserInofDbDao;
import com.mvvm.entity.UserEntity;
import com.mvvm.eventbus.BaseEvent;
import com.mvvm.model.UserModel;
import com.mvvm.utils.ActivityIntentUtils;
import com.mvvm.utils.Constants;
import com.mvvm.utils.SharedPreferencesUtils;
import com.mvvmdao.greendao.UserInfo;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;



/**
 * User: 汪乐骏
 * Date: 2016-04-17
 * Time: 16:06
 * 用户信息  ViewModel
 */
public class UserInfoViewModel{

    private UserModel userModel;
    private Context context;
    public SharedPreferencesUtils sharedPreferencesUtils;
    public ActivityIntentUtils activityIntentUtils;
    @Inject
    public UserInfoViewModel(UserModel userModel){
        this.userModel = userModel;
    }

    public void setContext(Context context) {
        this.context = context;
        sharedPreferencesUtils = SharedPreferencesUtils.getInstance(context);
        activityIntentUtils = new ActivityIntentUtils(context);
    }

    /**
     * 登录请求
     * @param username
     * @param password
     */
    public void requestLogin(String username, String password){
        if(!inputValidate(username,password)){
            return;
        }
        userModel.login(username, password);
    }

    /**
     * 注册请求
     * @param username
     * @param password
     */
    public void requestRegister(String username, String password){
        if(!inputValidate(username,password)) {
            return;
        }
        userModel.register(username, password);
    }


//    @Subscribe
//    public void onLoginEvent(){
//    }
//
//    @Subscribe
//    public void onEventMainThread(BaseEvent event) {
//    }



    /**
     * 获取用户信息
     * @return
     */
    public UserEntity getUserInfo(){
        UserEntity userEntity = new UserEntity();
        List<UserInfo> userInfo = userModel.queryUserInfoOfObjectId(sharedPreferencesUtils.getStringValues(Constants.SP_KEY_LOGIN_OBJECT_ID));
        if(userInfo!=null&&userInfo.size()>0){
            userEntity.setUsername(userInfo.get(0).getUsername());
            userEntity.setCreatedAt(userInfo.get(0).getCteatAt());
        }
        return userEntity;
    }

    public void registerEventBus(){
        EventBus.getDefault().register(context);
    }

    public void unRegisterEventBus(){
        EventBus.getDefault().unregister(context);
    }

    //    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.login_sign_in_btn:
//                userModel.login(loginBinding.loginUsernameEdit.getText().toString(),loginBinding.loginPasswordEdit.getText().toString());
//                break;
//
//            case R.id.login_register_btn:
//                break;
//        }
//    }
//
//    public void setLoginBinding(ActivityLoginBinding loginBinding) {
//        this.loginBinding = loginBinding;
//    }


    /**
     * 输入验证
     * @param username
     * @param password
     * @return
     */
    private boolean inputValidate(String username, String password){
        if("".equals(username)){
            Toast.makeText(context,"请输入用户名",Toast.LENGTH_LONG).show();
            return false;
        }

        if("".equals(password)){
            Toast.makeText(context,"请输入密码",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
