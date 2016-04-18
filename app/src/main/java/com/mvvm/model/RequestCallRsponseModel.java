package com.mvvm.model;

import com.mvvm.entity.HttpResponseEntity;
import com.mvvm.entity.UserEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * User: 汪乐骏
 * Date: 2016-04-18
 * Time: 21:48
 */
public class RequestCallRsponseModel<T> {


    public void enqueue(Call<HttpResponseEntity<T>> callResponse){
        callResponse.enqueue(new Callback<HttpResponseEntity<T>>() {
            @Override
            public void onResponse(Call<HttpResponseEntity<T>> call, Response<HttpResponseEntity<T>> response) {

            }

            @Override
            public void onFailure(Call<HttpResponseEntity<T>> call, Throwable t) {

            }
        });
    }
}
