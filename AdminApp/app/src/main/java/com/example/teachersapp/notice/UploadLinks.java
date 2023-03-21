package com.example.teachersapp.notice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teachersapp.NoticeActivity;
import com.example.teachersapp.R;
import com.example.teachersapp.fcm.FcmNotificationsSender;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UploadLinks extends AppCompatActivity {

    private EditText nameid, nameid2;
    private Button button1;
    private ProgressDialog pd;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_links);

        pd = new ProgressDialog(this);

        nameid = findViewById(R.id.nameid);
        nameid2 = findViewById(R.id.nameid2);
        button1 = findViewById(R.id.buttonf);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Links");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeLinks();
            }
        });

    }

    private void takeLinks() {
        pd.setMessage("Uploading...");
        pd.show();

        final String uniqueKey = dbRef.push().getKey();

        String title = nameid.getText().toString();
        String url = nameid2.getText().toString();

        Calendar ForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MM-yy");
        String date = currentDate.format(ForDate.getTime());

        Calendar ForTime = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("hh:mm a");
        String time = currentTime.format(ForTime.getTime());

        LinksData linksData = new LinksData(title, url, date, time, uniqueKey);

        dbRef.child(uniqueKey).setValue(linksData);

        pd.dismiss();
        Toast.makeText(UploadLinks.this, "Link Uploaded", Toast.LENGTH_SHORT).show();
        if (!title.toString().isEmpty()) {
            FcmNotificationsSender notificationsSender = new FcmNotificationsSender("/topics/Notification", title.toString(), title.toString(), getApplicationContext(), UploadLinks.this);
            notificationsSender.SendNotifications();
        } else {
            Toast.makeText(UploadLinks.this, "Failed to send Notification", Toast.LENGTH_SHORT).show();
        }
        navigateUpTo(new Intent(UploadLinks.this, NoticeActivity.class));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
