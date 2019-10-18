package com.codeguy.myallcomponent.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codeguy.myallcomponent.R;
import com.codeguy.myallcomponent.models.Datum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private final Activity activity;
    private final ArrayList<Datum> articleArrayList;

    public UserListAdapter(Activity activity, ArrayList<Datum> articleArrayList) {
        this.activity = activity;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(articleArrayList != null){
            Datum datum = articleArrayList.get(position);
            Picasso.get().load(datum.getAvatar()).into(holder.ivAvtar);
            holder.tvEmail.setText(datum.getEmail());
            holder.tvTitle.setText(String.format("%s %s", datum.getFirst_name(), datum.getLast_name()));
        }
    }

    @Override
    public int getItemCount() {
        return articleArrayList != null ? articleArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAvtar;
        TextView tvTitle, tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvtar = itemView.findViewById(R.id.avatar);
            tvTitle = itemView.findViewById(R.id.name);
            tvEmail = itemView.findViewById(R.id.email);
        }
    }
}
