package com.example.jntuhces.emerC;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.jntuhces.R;
import com.example.jntuhces.ui.faculty.TeacherAdapter;
import com.example.jntuhces.ui.faculty.TeacherData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class popup extends AppCompatActivity {

    private RecyclerView CSDepartment;
    private LinearLayout csNoData;
    private DatabaseReference reference, dbRef;
    private TeacherAdapter adapter;
    private List<TeacherData> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        csNoData = findViewById(R.id.csNoData);
        CSDepartment = findViewById(R.id.CSDepartment);
        reference = FirebaseDatabase.getInstance().getReference().child("Teachers");


        CSDepartment();

    }
    private void CSDepartment() {
        dbRef = reference.child("Emergency");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()) {
                    csNoData.setVisibility(View.VISIBLE);
                    CSDepartment.setVisibility(View.GONE);
                } else {
                    csNoData.setVisibility(View.GONE);
                    CSDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    CSDepartment.setHasFixedSize(true);
                    CSDepartment.setLayoutManager(new LinearLayoutManager(popup.this));
                    adapter = new TeacherAdapter(list1, popup.this,"Emergency");
                    CSDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(popup.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}