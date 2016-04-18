package com.mvvm.model.interfaces;

import java.util.List;

/**
 * User: 汪乐骏
 * Date: 2016-04-18
 * Time: 22:03
 * 请求响应接口
 */
public interface IRequestResponse<T> {
    void onResponseFailure();
    void onResponseSuccess(T responseEntity);
    void onResponseSuccess(List<T> responseEntityList);
}
