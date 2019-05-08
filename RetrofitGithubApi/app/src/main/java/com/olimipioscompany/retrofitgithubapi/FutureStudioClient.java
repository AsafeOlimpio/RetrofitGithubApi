package com.olimipioscompany.retrofitgithubapi;

import com.olimipioscompany.retrofitgithubapi.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface FutureStudioClient {

    @GET("/user/info")
    Call<UserInfo> getUserInfo();

    @PUT("/user/info")
    Call<UserInfo> updateUserInfo(
            @Body UserInfo userInfo
    );

    @DELETE("/user")
    Call<Void> deleteUser();

}
