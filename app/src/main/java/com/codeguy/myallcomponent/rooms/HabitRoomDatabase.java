package com.codeguy.myallcomponent.rooms;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.codeguy.myallcomponent.models.Habit;


//Here, we have a Room class HabitRoomDatabase in which we had to declare all our entities and version of the
// database. getDatabase() method will return the room database instance.

@Database(entities = {Habit.class}, version = 1, exportSchema = false)
public abstract class HabitRoomDatabase extends RoomDatabase {

    public abstract HabitDao wordDao();

    //SINGLETON
    private static HabitRoomDatabase INSTANCE;

    public static HabitRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HabitRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), HabitRoomDatabase.class,
                            "habit_database").build();
                }
            }
        }
        return INSTANCE;
    }



}
