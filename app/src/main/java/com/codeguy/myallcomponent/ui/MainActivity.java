package com.codeguy.myallcomponent.ui;

import android.content.Intent;
import android.database.Observable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codeguy.myallcomponent.R;
import com.codeguy.myallcomponent.viewmodels.HabitViewModel;
import com.codeguy.myallcomponent.models.Habit;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button button, btnUser;
    private RecyclerView recyclerView;
    private HabitViewModel habitViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Basic");

        habitViewModel = ViewModelProviders.of(this).get(HabitViewModel.class);
        init();
        setup();

        rxjavaSample();

    }

    private void rxjavaSample() {
//        Observable<Integer> observable = Observable.range(1, 5)
//                .subscribeOn(Schedulers.io())
//                .map(integer -> {
//                    System.out.println(String.format("Squaring %d with itself", integer));
//                    return integer * integer;
//                });

        /*
         * Step 2: We are subscribing two subscribers to the Observable.
         *  */
//        observable.subscribe(s -> System.out.println("subscriber one: " + s));
//        observable.subscribe(s -> System.out.println("subscriber two: " + s));

    }

    private void setup() {
        final HabitListAdapter habitListAdapter = new HabitListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(habitListAdapter);

        habitViewModel.allWords.observe(this, new Observer<List<Habit>>() {
            @Override
            public void onChanged(List<Habit> habits) {
                habitListAdapter.setWords(habits);
            }
        });
    }

    private void init() {
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        btnUser = findViewById(R.id.btn_user);
        btnUser.setOnClickListener(this);
        recyclerView = findViewById(R.id.my_recycler_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Habit habit = new Habit(editText.getText().toString());
                habitViewModel.insert(habit);
                editText.setText("");
                break;
            case R.id.btn_user:
                startActivity(new Intent(MainActivity.this, UserActivity.class));
                break;
        }

    }

}
