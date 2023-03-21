package com.example.teachersapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LiveActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private Button sendBtn;
    private EditText updateLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        reference = FirebaseDatabase.getInstance().getReference();

         updateLink = findViewById(R.id.updateLink);
         sendBtn   =findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!updateLink.getText().toString().isEmpty()){
                 String value =  updateLink.getText().toString();
                reference.child("live").child("VideoId").setValue(value);
                    Toast.makeText(LiveActivity.this, "Value Updated Succesfully !", Toast.LENGTH_SHORT).show();
                    navigateUpTo(new Intent(LiveActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(LiveActivity.this, "Enter VideoId", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}