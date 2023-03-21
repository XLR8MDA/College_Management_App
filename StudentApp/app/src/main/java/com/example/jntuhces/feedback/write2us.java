package com.example.jntuhces.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jntuhces.MainActivity;
import com.example.jntuhces.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class write2us extends AppCompatActivity {

    private EditText nameid,nameid2;
    private Button  button1;

    DatabaseReference reference,dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write2us);

        nameid= findViewById(R.id.nameid);
        nameid2= findViewById(R.id.nameid2);
        button1= findViewById(R.id.buttonf);

        dbRef= FirebaseDatabase.getInstance().getReference().child("Feedback");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeFeedback();
            }
        });

    }

    private void takeFeedback() {
        String name =nameid.getText().toString();
        String msg = nameid2.getText().toString();

        Feedback feedback= new Feedback(name,msg);
        dbRef.push().setValue(feedback);
        Toast.makeText(this, "Feedback Saved", Toast.LENGTH_SHORT).show();
        navigateUpTo(new Intent( write2us.this,MainActivity.class));
    }
}
