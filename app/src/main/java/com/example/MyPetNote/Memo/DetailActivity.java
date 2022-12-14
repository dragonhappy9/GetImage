package com.example.MyPetNote.Memo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.MyPetNote.R;
import com.example.MyPetNote.room.AppDatabase;
import com.example.MyPetNote.room.User;

public class DetailActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 200;

    private EditText detailTitle;
    private ImageView detailImage;
    private EditText detailDes;
    private AppDatabase db;

    private Button exit;
    private Button update;

    private int id;
    private String title;
    private String des;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initialized();


        // 수정
        update.setOnClickListener(v -> {
            //문제점 : 그냥 그대로 저장이된다.
            title = detailTitle.getText().toString();
            des = detailDes.getText().toString();
            System.out.println("####1" + title + " " +des + " " + id);
            db.userDrago().update(title, des, id);
            finish();
        });
        //그냥 종료
        exit.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), com.example.MyPetNote.Memo.MainActivity.class);
            startActivity(intent);
        });
    }

    private void initialized() {
        update = findViewById(R.id.update);
        exit = findViewById(R.id.exit);
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
        detailDes = findViewById(R.id.detailDes);
        db = AppDatabase.getInstance(this);

        User detail = getIntent().getParcelableExtra("data");

        id = detail.getId();
        title = detail.getTitle();
        des = detail.getDes();

        detailTitle.setText(title);
        detailDes.setText(des);
    }


}
