package com.codeguy.myallcomponent.reporsitory;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.codeguy.myallcomponent.models.Habit;
import com.codeguy.myallcomponent.rooms.HabitDao;
import com.codeguy.myallcomponent.rooms.HabitRoomDatabase;

import java.util.List;

public class HabitRepository {

    private HabitDao habitDao;
    private LiveData<List<Habit>> listLiveData;

    public HabitRepository(Application application){
        HabitRoomDatabase database = HabitRoomDatabase.getDatabase(application);
        habitDao = database.wordDao();
        listLiveData = habitDao.getAllHabits();
    }

    public LiveData<List<Habit>> getAllHabits(){
        return listLiveData;
    }

    public void insert(Habit word){
        new MyAsync(habitDao).execute(word);
    }

    public class MyAsync extends AsyncTask<Habit, Void, Void>{

        private HabitDao habitDao;

        public MyAsync(HabitDao habitDao) {
            this.habitDao = habitDao;
        }

        @Override
        protected Void doInBackground(Habit... habits) {
            habitDao.insert(habits[0]);
            return null;
        }
    }
}
