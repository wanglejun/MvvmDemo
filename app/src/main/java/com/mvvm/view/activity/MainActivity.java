package com.mvvm.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mvvm.R;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
//        IUserApi userApi = ApiRequestModule.createRequest(IUserApi.class);
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("admin");
//        userEntity.setPassword("123");
//        Call<HttpResponseEntity<UserEntity>> callResponse = userApi.login("admin2","123");
//        callResponse.enqueue(new Callback<HttpResponseEntity<UserEntity>>() {
//            @Override
//            public void onResponse(Call<HttpResponseEntity<UserEntity>> call, Response<HttpResponseEntity<UserEntity>> response) {
//                System.out.println("");
//                System.out.println("sssssssssssssssssssss");
//                System.out.println("isSuccessful------------------>" + response.isSuccessful());
//                System.out.print("username------------------>" + response.body().toString());
//
//                HttpResponseEntity<UserEntity> responseEntity = response.body();
//                UserEntity userInfo = responseEntity.getData();
//                textView.setText("用户名：" + userInfo.getUsername());
//
//            }
//
//
//            @Override
//            public void onFailure(Call<HttpResponseEntity<UserEntity>> call, Throwable t) {
//
//            }
//        });



    }

}
