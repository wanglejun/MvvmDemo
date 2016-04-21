package com.mvvm.api;

import com.mvvm.api.interfaces.IUserApi;
import com.mvvm.dagger.scope.PerApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wang on 2016/4/12.
 * Retrofit 网络请求Module
 */
@Module
public class ApiRequestModule {
    public static final String API_BASE_URL = "http://cloud.bmob.cn/3b47306507ef6631/";

    @Provides
    public Retrofit provideRetrofit(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit  = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
        return retrofit;
    }

//    @Provides
//    public <T> T provideApiRequest(Class<T> serviceClass,Retrofit retrofit) {
//        return retrofit.create(serviceClass);
//    }

    @PerApp
    @Provides
    public IUserApi provideApiRequest(Retrofit retrofit) {
        return retrofit.create(IUserApi.class);
    }

}
