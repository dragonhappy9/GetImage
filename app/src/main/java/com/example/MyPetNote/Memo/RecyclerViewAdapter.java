package com.example.MyPetNote.Memo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyPetNote.R;
import com.example.MyPetNote.room.AppDatabase;
import com.example.MyPetNote.room.User;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<User> userData = new ArrayList<>();


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_recycler_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(userData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public void addItem(User user) {
        userData.add(user);
        notifyDataSetChanged();
    }

    public void addItems(ArrayList<User> users) {
        userData = users;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView key;
        private TextView title;
        private TextView description;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            key = itemView.findViewById(R.id.key);
            title = itemView.findViewById(R.id.memoTextView1);
            description = itemView.findViewById(R.id.memoTextView2);
        }

        public void onBind(User user, int position) {
            String s = "" + (position+1);
            key.setText(s);
            title.setText(user.getTitle());
            description.setText(user.getDes());

            itemView.setOnLongClickListener(v -> {
                userData.remove(user);
                AppDatabase.getInstance(itemView.getContext()).userDrago().delete(user);

                notifyDataSetChanged();
                return false;
            });

            itemView.setOnClickListener(v -> {

                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra("data", user);
                itemView.getContext().startActivity(intent);

            });
        }
    }
}