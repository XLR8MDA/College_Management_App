package com.example.teachersapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.teachersapp.Faculty.UpdateTeacher;
import com.example.teachersapp.fcm.notification;
import com.example.teachersapp.fp.classphoto;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice, addGalleryImage, faculty, pushNoti, logout, alumni, classphoto;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("login", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("isLogin", "false").equals("false")) {
            openLogin();
        }


        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        faculty = findViewById(R.id.faculty);
        pushNoti = findViewById(R.id.pushNoti);
        logout = findViewById(R.id.logout);
        alumni = findViewById(R.id.alumni);
        classphoto = findViewById(R.id.classphoto);

        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        faculty.setOnClickListener(this);
        pushNoti.setOnClickListener(this);
        logout.setOnClickListener(this);
        alumni.setOnClickListener(this);
        classphoto.setOnClickListener(this);

    }

    private void openLogin() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.addNotice:
                intent = new Intent(MainActivity.this, NoticeActivity.class);
                startActivity(intent);
                break;
            case R.id.addGalleryImage:
                intent = new Intent(MainActivity.this, UploadImage.class);
                startActivity(intent);
                break;
            case R.id.faculty:
                intent = new Intent(MainActivity.this, UpdateTeacher.class);
                startActivity(intent);
                break;
            case R.id.alumni:
                intent = new Intent(MainActivity.this, AlumniActivity.class);
                startActivity(intent);
                break;
            case R.id.classphoto:
                intent = new Intent(MainActivity.this, classphoto.class);
                startActivity(intent);
                break;
            case R.id.pushNoti:
                intent = new Intent(MainActivity.this, notification.class);
                startActivity(intent);
                break;
            case R.id.logout:
                editor.putString("isLogin", "false");
                editor.commit();
                openLogin();
                break;
        }
    }
}