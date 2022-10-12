package com.example.MyPetNote.Memo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyPetNote.R;
import com.example.MyPetNote.room.AppDatabase;
import com.example.MyPetNote.room.User;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final int SAVE_MEMO_ACTIVITY = 1;
    private Button add;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter mRecyclerAdapter;
    private List<User> mItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialized();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mRecyclerAdapter);


        add.setOnClickListener(v -> {
            move();
        });
    }

    private void initialized() {
        add = findViewById(R.id.btn_insert);
        recyclerView = findViewById(R.id.mainRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerAdapter = new RecyclerViewAdapter();

        mItemList = AppDatabase.getInstance(this).userDrago().getAll();
        int size = mItemList.size();
        for(int i = 0; i < size; i++){
            mRecyclerAdapter.addItem(mItemList.get(i));
        }
    }
    private void move() {
        Intent intent = new Intent(getApplicationContext(), SaveMemoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        mItemList = AppDatabase.getInstance(this).userDrago().getAll();
        mRecyclerAdapter.addItems((ArrayList) mItemList);
        super.onStart();
    }

}
