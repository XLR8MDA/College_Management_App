package com.example.jntuhces;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.jntuhces.emerC.popup;
import com.example.jntuhces.feedback.write2us;

import com.example.jntuhces.fp.FamilyPic;
import com.example.jntuhces.gallery.gallery;
import com.example.jntuhces.results.webview;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    private int getNrRandom() {
        return (int) Math.floor(Math.random() * 5);
    }

    private void cambinarTheme(int nrTheme) {
        switch (nrTheme) {
            case 1:
                setTheme(R.style.Theme1);
                break;
            case 2:
                setTheme(R.style.Theme2);
                break;
            case 3:
                setTheme(R.style.Theme3);
                break;
            case 4:
                setTheme(R.style.Theme4);
                break;
            case 5:
                setTheme(R.style.Theme5);
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cambinarTheme(getNrRandom());

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);

        FirebaseMessaging.getInstance().subscribeToTopic("Notification");


        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sidemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        toggle.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.emerg:
                intent = new Intent(this, popup.class);
                startActivity(intent);
                return true;
            case R.id.rateus:
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(this, "unable to rate" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.shareus:
                try {
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "JNTUHCES");
                    intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                    startActivity(Intent.createChooser(intent, "Share with"));
                } catch (Exception e) {
                    Toast.makeText(this, "Unable to share this app", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.writeus:
                intent = new Intent(this, write2us.class);
                startActivity(intent);
                return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        String url;
        switch (item.getItemId()) {
            case R.id.navigation_developers:
                intent = new Intent(this, developers.class);
                startActivity(intent);
                break;
            case R.id.covid:
                intent = new Intent(this, covid.class);
                startActivity(intent);
                break;
            case R.id.navigation_videos:
                url = "https://www.youtube.com/channel/UC640y4UvDAlya_WOj5U4pfA";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                break;
            case R.id.navigation_live:
                intent = new Intent(this, live.class);
                startActivity(intent);
                break;
            case R.id.navigation_results:
                intent = new Intent(this, webview.class);
                startActivity(intent);
                break;
            case R.id.navigation_website:
                url = "http://jntuhces.ac.in/";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                break;
            case R.id.gallery:
                intent = new Intent(this, gallery.class);
                startActivity(intent);
                break;
            case R.id.archive:
                intent = new Intent(this, FamilyPic.class);
                startActivity(intent);
                break;
            case R.id.darkmode:
                Toast.makeText(this, "DarkMode will be added soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.themes:
                Toast.makeText(this, "Themes will be added soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.font:
                Toast.makeText(this, "Fonts will be added soon", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

}