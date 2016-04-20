package com.mvvm.dao;

import com.mvvm.dagger.AppApplication;
import com.mvvm.entity.UserEntity;
import com.mvvmdao.greendao.UserInfo;
import com.mvvmdao.greendao.UserInfoDao;

import java.util.List;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * User: 汪乐骏
 * Date: 2016-04-19
 * Time: 21:32
 * 用户信息数据库操作
 */
public class UserInofDbDao {
    private UserInfoDao userInfoDao;
    public static UserInofDbDao userInofDbDao;

    public static synchronized UserInofDbDao getInstance(){
        if (userInofDbDao == null){
            userInofDbDao = new UserInofDbDao();
        }
        return  userInofDbDao;
    }

    public UserInofDbDao(){
        userInfoDao = getUserInfoDao();
    }
    /**
     * 获取UserInfoDao数据库操作对象
     * @return UserInfoDao
     */
    public UserInfoDao getUserInfoDao(){
        UserInfoDao userInfoDao = AppApplication.getsInstance().getAppComponent().getDaoSession().getUserInfoDao();
        return userInfoDao;
    }

    /**
     * 添加userinfo
     * @param userEntity user对象
     */
    public void insertUserInfo(UserEntity userEntity){
        List<UserInfo> userInfoList = queryUserInfoOfObjectId(userEntity.getObjectId());
        UserInfo userInfo = new UserInfo(userEntity.getObjectId(),userEntity.getUsername(),userEntity.getPassword(),userEntity.getCreatedAt());
        //用户已存在 更新用户信息
        if(userInfoList!=null&&userInfoList.size()>0){
            userInfoDao.update(userInfo);
        }else{
            userInfoDao.insert(userInfo);
        }
    }

    /**
     * 更新userifno
     * @param userEntity user对象
     */
    public void updateUserInfo(UserEntity userEntity){
        UserInfo userInfo = new UserInfo(userEntity.getObjectId(),userEntity.getUsername(),userEntity.getPassword(),userEntity.getCreatedAt());
        userInfoDao.update(userInfo);
    }

    /**
     * 根据objecId查询userinfo
     * @param objectId
     * @return
     */
    public List<UserInfo> queryUserInfoOfObjectId(String objectId){
        Query<UserInfo> query = userInfoDao.queryBuilder().where(UserInfoDao.Properties.ObjectId.eq(objectId)).build();
        List<UserInfo> userInfoList = query.list();
        //输出log
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
        return  userInfoList;
    }
}
