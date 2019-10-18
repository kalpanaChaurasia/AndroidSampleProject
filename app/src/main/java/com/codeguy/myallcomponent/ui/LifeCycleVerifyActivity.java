package com.codeguy.myallcomponent.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.codeguy.myallcomponent.R;

public class LifeCycleVerifyActivity extends AppCompatActivity {
    private String tag = LifeCycleVerifyActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        showLog("onCreate");

      //  try {

        if(savedInstanceState != null){
            showLog("create "+savedInstanceState.getString("key"));
        }

            Fragment fragment = new FragmentOne();

            FragmentManager mFragManager = getSupportFragmentManager();
            mFragManager.beginTransaction()
                    .add(R.id.frame, fragment)
                   // .addToBackStack(tag)
                    .commit();
       /* } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showLog("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLog("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLog("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLog("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLog("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("onDestroy");
    }

    public void showLog(String msg) {
        // Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.i("TAG", msg);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        showLog("onSaveInstanceState");
        outState.putString("key","kalpana");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showLog("onRestoreInstanceState");
        if(savedInstanceState != null){
            showLog(savedInstanceState.getString("key"));
        }
    }
}

