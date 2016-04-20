package com.mvvm.eventbus;

/**
 * User: 汪乐骏
 * Date: 2016-04-20
 * Time: 21:59
 * 注册event
 */
public class RegisterEvent extends BaseEvent{
    private String username;
    public RegisterEvent(){

    }

    public RegisterEvent(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
