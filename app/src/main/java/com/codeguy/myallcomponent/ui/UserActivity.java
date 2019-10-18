package com.codeguy.myallcomponent.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codeguy.myallcomponent.R;
import com.codeguy.myallcomponent.models.Datum;
import com.codeguy.myallcomponent.models.UserLists;
import com.codeguy.myallcomponent.viewmodels.UserViewModels;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private ArrayList<Datum> articleArrayList = new ArrayList<>();
    private UserListAdapter userListAdapter;
    private Button btnNext;
    private static int nextPage = 1;
    private int totalPages;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setTitle("Users");
        init();
    }

    private void init() {
        final UserViewModels userViewModels = ViewModelProviders.of(this).get(UserViewModels.class);
        userViewModels.init();
        userViewModels.getUserRepository().observe(this, new Observer<UserLists>() {
            @Override
            public void onChanged(UserLists userLists) {
                if (userLists != null) {
                    nextPage = userLists.getPage();
                    totalPages = userLists.getTotalPages();
//                    Log.i("TAG", "nextPage " + nextPage);
//                    Log.i("TAG", "totalPages " + totalPages);
                    List<Datum> userList = userLists.getData();
                    articleArrayList.clear();
                    articleArrayList.addAll(userList);
                    userListAdapter.notifyDataSetChanged();
                }
            }
        });


        RecyclerView recyclerView = findViewById(R.id.user_view);
        if (userListAdapter == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            userListAdapter = new UserListAdapter(this, articleArrayList);
            recyclerView.setAdapter(userListAdapter);
        } else {
            userListAdapter.notifyDataSetChanged();
        }

        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalPages <= nextPage) {
                    nextPage = 1;
                } else {
                    nextPage += 1;
                }
                userViewModels.nextUsers(nextPage);
            }
        });
    }
}
