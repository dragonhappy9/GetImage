package com.example.MyPetNote.Login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MyPetNote.MainFrameActivity;
import com.example.MyPetNote.R;

public class LoginInfo extends AppCompatActivity {

    private TextView tv_id, tv_pw;
    private Button btn_gofrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tv_id = findViewById(R.id.tv_id);
        tv_pw = findViewById(R.id.tv_pw);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPW = intent.getStringExtra("userPassword");

        tv_id.setText(userID);
        tv_pw.setText(userPW);

        btn_gofrag = findViewById(R.id.btn_gofrag);
        btn_gofrag.setOnClickListener(view -> {
            Intent intent1 = new Intent(LoginInfo.this, MainFrameActivity.class);
            startActivity(intent1);
        });
    }

}