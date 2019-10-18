package com.codeguy.myallcomponent.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.codeguy.myallcomponent.models.Habit;
import com.codeguy.myallcomponent.reporsitory.HabitRepository;

import java.util.List;

public class HabitViewModel extends AndroidViewModel {
    private HabitRepository habitRepository;
    public LiveData<List<Habit>> allWords;

    public HabitViewModel(Application application) {
        super(application);
        habitRepository = new HabitRepository(application);
        allWords = habitRepository.getAllHabits();
    }

    public void insert(Habit habit) {
        habitRepository.insert(habit);
    }
}
