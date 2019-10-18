package com.codeguy.myallcomponent.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codeguy.myallcomponent.R;
import com.codeguy.myallcomponent.models.Habit;

import java.util.List;

public class HabitListAdapter extends RecyclerView.Adapter<HabitListAdapter.HabitViewHolder> {

    private List<Habit> habitList =null;

    public void  setWords(List<Habit> habitList){
        this.habitList = habitList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new HabitViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
        if(habitList != null)
        holder.textView.setText(habitList.get(position).getmHabit());
    }

    @Override
    public int getItemCount() {
        return habitList != null ? habitList.size() : 0;
    }

    public class HabitViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public HabitViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
