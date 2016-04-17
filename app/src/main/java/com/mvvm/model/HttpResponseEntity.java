package com.mvvm.model;

/**
 * Http下行Entity
 */
public class HttpResponseEntity<T> {
    //请求状态码 200：成功 202：失败
    private int code;
    //下行提示
    private String msg;
    //下行对象
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
