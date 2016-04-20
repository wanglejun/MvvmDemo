package com.mvvm.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.mvvm.dao.UserInofDbDao;
import com.mvvm.entity.UserEntity;
import com.mvvm.model.UserModel;
import com.mvvm.utils.ActivityIntentUtils;
import com.mvvm.utils.Constants;
import com.mvvm.utils.SharedPreferencesUtils;
import com.mvvm.view.activity.LoginActivity;
import com.mvvm.view.activity.MainActivity;
import com.mvvm.view.activity.RegisterActivity;
import com.mvvm.view.viewInterface.IUserInfoView;
import com.mvvmdao.greendao.UserInfo;

import java.util.List;

import javax.inject.Inject;



/**
 * User: 汪乐骏
 * Date: 2016-04-17
 * Time: 16:06
 * 用户信息  ViewModel
 */
public class UserInfoViewModel implements IUserInfoView{

    private UserModel userModel;
    private Context context;
    public SharedPreferencesUtils sharedPreferencesUtils;
    public ActivityIntentUtils activityIntentUtils;
    @Inject
    public UserInfoViewModel(UserModel userModel){
        this.userModel = userModel;
        userModel.setiUserInfoView(this);
    }

    public void setContext(Context context) {
        this.context = context;
        sharedPreferencesUtils = SharedPreferencesUtils.getInstance(context);
        activityIntentUtils = new ActivityIntentUtils(context);
    }

    public void requestLogin(String username, String password){
        if(!inputValidate(username,password)){
            return;
        }
        userModel.login(username, password);
    }

    public void requestRegister(String username, String password){
        if(!inputValidate(username,password)) {
            return;
        }
        userModel.register(username, password);
    }

    /**
     * 登录成功回调
     * @param userEntity
     */
    @Override
    public void loginSuccess(UserEntity userEntity) {
        Toast.makeText(context,"loginSuccess",Toast.LENGTH_LONG).show();
        activityIntentUtils.turnToNextActivity(MainActivity.class);
        //保存登录状态
        sharedPreferencesUtils.putBooleanValues(Constants.SP_KEY_LOGIN_STATUS,true);
        sharedPreferencesUtils.putStringValues(Constants.SP_KEY_LOGIN_OBJECT_ID, userEntity.getObjectId());
    }

    /**
     * 注册成功回调
     */
    @Override
    public void registerSuccess() {
        Toast.makeText(context,"注册成功",Toast.LENGTH_LONG).show();
        activityIntentUtils.turnToNextActivity(LoginActivity.class);
    }

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
