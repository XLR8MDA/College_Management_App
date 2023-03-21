package com.example.jntuhces.results;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.jntuhces.R;
import com.google.android.material.tabs.TabLayout;

public class webview extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_webview);


        ViewPager vp = findViewById(R.id.viewpager2);
        PagerAdapter pA = new PagerAdapter(getSupportFragmentManager());
        vp.setAdapter(pA);

        TabLayout tL = findViewById(R.id.slidingtabs);
        tL.setupWithViewPager(vp);

    }
}