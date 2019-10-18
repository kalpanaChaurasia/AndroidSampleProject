package com.codeguy.myallcomponent.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "habitClass")
public class Habit {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "habit")
    public String mHabit;

    public Habit(String mHabit) {
        this.mHabit = mHabit;
    }

    @NonNull
    public String getmHabit() {
        return mHabit;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "mHabit='" + mHabit + '\'' +
                '}';
    }
}
