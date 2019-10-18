package com.codeguy.myallcomponent.rooms;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.codeguy.myallcomponent.models.Habit;

import java.util.List;

//An Interface where we put all our SQL queries. We don’t require to write whole queries now, we just need to
// make a method and annotate with specific annotations like “@Insert”, “@Delete”, “@Query(SELECT FROM *)”

@Dao
public interface HabitDao {

    @Insert
    void insert(Habit habit);

    @Query("DELETE FROM habitClass")
    void deleteAll();

    @Query("SELECT * FROM habitClass ORDER BY habit ASC")
    LiveData<List<Habit>> getAllHabits();
}
