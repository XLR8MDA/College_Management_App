package com.example.jntuhces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class FullImageView extends AppCompatActivity {

    private PhotoView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);

        imageview= findViewById(R.id.imageview);

        String image= getIntent().getStringExtra("image");

        Glide.with(this).load(image).into(imageview);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
