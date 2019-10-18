package com.codeguy.myallcomponent.apis;

import com.codeguy.myallcomponent.models.UserLists;
import com.codeguy.myallcomponent.models.Users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IUserApi {


    @GET("users")
    Call<UserLists> doGetUserList();

    @GET("users?")
    Call<UserLists> doGetUserList(@Query("page") String page);

}
