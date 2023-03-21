package com.example.teachersapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.teachersapp.notice.DeleteLinksActivity;
import com.example.teachersapp.notice.DeleteNoticeActivity;
import com.example.teachersapp.notice.UploadLinks;
import com.example.teachersapp.notice.UploadNotice;
import com.example.teachersapp.notice.UploadPdf;
import com.example.teachersapp.notice.deletepdfActivity;

public class NoticeActivity extends AppCompatActivity implements View.OnClickListener {

    CardView addnotice, addlinks, addpdf, deletenotice, deletelinks,deletepdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        addnotice = findViewById(R.id.addnotice);
        addlinks = findViewById(R.id.addlinks);
        addpdf= findViewById(R.id.addpdf);
        deletelinks = findViewById(R.id.deletelinks);
        deletepdf = findViewById(R.id.deletepdf);
        deletenotice = findViewById(R.id.deletenotice);

        deletenotice.setOnClickListener(this);
        deletelinks.setOnClickListener(this);
        deletepdf.setOnClickListener(this);
        addlinks.setOnClickListener(this);
        addpdf.setOnClickListener(this);
        addnotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.addnotice:
                intent = new Intent(NoticeActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addlinks:
                intent = new Intent(NoticeActivity.this, UploadLinks.class);
                startActivity(intent);
                break;
            case R.id.addpdf:
                intent = new Intent(NoticeActivity.this, UploadPdf.class);
                startActivity(intent);
                break;
            case R.id.deletenotice:
                intent = new Intent(NoticeActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;
            case R.id.deletelinks:
                intent = new Intent(NoticeActivity.this, DeleteLinksActivity.class);
                startActivity(intent);
                break;
            case R.id.deletepdf:
                intent = new Intent(NoticeActivity.this, deletepdfActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}