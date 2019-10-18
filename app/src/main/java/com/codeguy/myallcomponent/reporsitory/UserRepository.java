package com.codeguy.myallcomponent.reporsitory;

import androidx.lifecycle.MutableLiveData;

import com.codeguy.myallcomponent.apis.RetrofitServices;
import com.codeguy.myallcomponent.apis.IUserApi;
import com.codeguy.myallcomponent.models.UserLists;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static UserRepository userRepository;
    private MutableLiveData<UserLists> userListsMutableLiveData = new MutableLiveData<>();
    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    private IUserApi userApi;

    private UserRepository() {
        userApi = RetrofitServices.createService(IUserApi.class);
    }

    public MutableLiveData<UserLists> getUserDetails(){
        userApi.doGetUserList().enqueue(new Callback<UserLists>() {
            @Override
            public void onResponse(Call<UserLists> call, Response<UserLists> response) {
                if(response.isSuccessful()){
                    userListsMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserLists> call, Throwable t) {
                userListsMutableLiveData.setValue(null);
            }
        });

        return userListsMutableLiveData;
    }

    public MutableLiveData<UserLists> getNextUserDetails(int page){
        userApi.doGetUserList(String.valueOf(page)).enqueue(new Callback<UserLists>() {
            @Override
            public void onResponse(Call<UserLists> call, Response<UserLists> response) {
                if(response.isSuccessful()){
                    userListsMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserLists> call, Throwable t) {
                userListsMutableLiveData.setValue(null);
            }
        });

        return userListsMutableLiveData;
    }

}
