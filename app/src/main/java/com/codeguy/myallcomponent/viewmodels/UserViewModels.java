package com.codeguy.myallcomponent.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codeguy.myallcomponent.models.UserLists;
import com.codeguy.myallcomponent.reporsitory.UserRepository;

public class UserViewModels extends ViewModel {

    private UserRepository userRepository;
    private MutableLiveData<UserLists> userListsMutableLiveData;

    public void init(){
        if(userListsMutableLiveData != null){
            return;
        }
        userRepository = UserRepository.getInstance();
     //   userListsMutableLiveData = userRepository.getUserDetails();
        nextUsers(1);
    }


    public void nextUsers(int page){
       // Log.i("TAG","page "+page);
        userListsMutableLiveData  = userRepository.getNextUserDetails(page);
    }

    public LiveData<UserLists> getUserRepository(){
        return userListsMutableLiveData;
    }
}
