package com.mvvm.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.mvvm.entity.UserEntity;
import com.mvvm.model.UserModel;
import com.mvvm.utils.ActivityIntentUtils;
import com.mvvm.utils.Constants;
import com.mvvm.utils.SPUtils;
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
    public SPUtils SPUtils;
    public ActivityIntentUtils intentUtils;

    @Inject
    public UserInfoViewModel(Activity context, UserModel userModel, SPUtils SPUtils, ActivityIntentUtils intentUtils){
        this.userModel = userModel;
        this.SPUtils = SPUtils;
        this.intentUtils = intentUtils;
        this.context = context;
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


    /**
     * 获取用户信息
     * @return
     */
    public UserEntity getUserInfo(){
        UserEntity userEntity = new UserEntity();
        List<UserInfo> userInfo = userModel.queryUserInfoOfObjectId(SPUtils.getStringValues(Constants.SP_KEY_LOGIN_OBJECT_ID));
        if(userInfo!=null&&userInfo.size()>0){
            userEntity.setUsername(userInfo.get(0).getUsername());
            userEntity.setCreatedAt(userInfo.get(0).getCteatAt());
        }
        return userEntity;
    }

    /**
     * 更新用户名显示
     * @param username
     */
    public UserEntity updateUsername(String username){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
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

    /**
     * 更新登录状态
     * @param objecId
     * @param isLogin
     */
    public void updatgeLoginStatus(String objecId,boolean isLogin){
        SPUtils.putBooleanValues(Constants.SP_KEY_LOGIN_STATUS, isLogin);
        if(!"".equals(objecId)){
            SPUtils.putStringValues(Constants.SP_KEY_LOGIN_OBJECT_ID,objecId );
        }
    }
}
