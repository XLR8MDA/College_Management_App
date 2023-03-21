package com.example.jntuhces.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;


import com.example.jntuhces.R;

import com.google.android.material.tabs.TabLayout;

public class gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ViewPager vp = findViewById(R.id.viewpager2);
        GalleryMainAdapter pA = new GalleryMainAdapter(getSupportFragmentManager());
        vp.setAdapter(pA);

        TabLayout tL = findViewById(R.id.slidingtabs);
        tL.setupWithViewPager(vp);

    }
}