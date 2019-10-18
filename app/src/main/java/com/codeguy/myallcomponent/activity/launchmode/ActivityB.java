package com.codeguy.myallcomponent.activity.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.codeguy.myallcomponent.R;

public class ActivityB extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        TextView textView = findViewById(R.id.textDisplay);
        textView.setText("Activity B");
        showLog(textView.getText().toString());
        Button btn = findViewById(R.id.btnClick);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityB.this, ActivityC.class));
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        showLog("Activity B onNewIntent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("onDestroy activity B");
    }
}
