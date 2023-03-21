package com.example.teachersapp.fcm;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teachersapp.R;
import com.google.firebase.messaging.FirebaseMessaging;

public class notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        FirebaseMessaging.getInstance().subscribeToTopic("Notification");

        EditText title= findViewById(R.id.Title);
        EditText body = findViewById(R.id.messTitle);

        findViewById(R.id.sendBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!title.getText().toString().isEmpty()){
                    FcmNotificationsSender notificationsSender= new FcmNotificationsSender("/topics/Notification",title.getText().toString(),body.getText().toString(),getApplicationContext(),notification.this);
                    notificationsSender.SendNotifications();
                }else{
                    Toast.makeText(notification.this, "Enter Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}