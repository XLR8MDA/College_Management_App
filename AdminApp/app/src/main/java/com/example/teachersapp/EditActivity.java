package com.example.teachersapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.teachersapp.Faculty.UpdateTeacher;
import com.example.teachersapp.fp.classphoto;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    CardView faculty, alumni, classphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        faculty = findViewById(R.id.faculty);
        alumni = findViewById(R.id.alumni);
        classphoto = findViewById(R.id.classphoto);


        faculty.setOnClickListener(this);
        alumni.setOnClickListener(this);
        classphoto.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.alumni:
                intent = new Intent(EditActivity.this, AlumniActivity.class);
                startActivity(intent);
                break;
            case R.id.faculty:
                intent = new Intent(EditActivity.this, UpdateTeacher.class);
                startActivity(intent);
                break;
            case R.id.classphoto:
                intent = new Intent(EditActivity.this, classphoto.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}