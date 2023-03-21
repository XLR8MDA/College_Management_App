package com.example.teachersapp.Faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teachersapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateTeacher extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView CSDepartment, ECEDepartment, MEDepartment, CVDepartment, PYDepartment, CHDepartment, MDepartment, EDepartment, PEDepartment;
    private LinearLayout csNoData, eceNoData, meNoData, cvNoData, pyNoData, chNoData, mNoData, eNoData, peNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6, list7, list8, list9;
    private DatabaseReference reference, dbRef;
    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faulty);


        csNoData = findViewById(R.id.csNoData);
        eceNoData = findViewById(R.id.eceNoData);
        meNoData = findViewById(R.id.meNoData);
        cvNoData = findViewById(R.id.cvNoData);
        pyNoData = findViewById(R.id.pyNoData);
        chNoData = findViewById(R.id.chNoData);
        mNoData = findViewById(R.id.mNoData);
        eNoData = findViewById(R.id.eNoData);
        peNoData = findViewById(R.id.peNoData);

        CSDepartment = findViewById(R.id.CSDepartment);
        ECEDepartment = findViewById(R.id.ECEDepartment);
        MEDepartment = findViewById(R.id.MEDepartment);
        CVDepartment = findViewById(R.id.CVDepartment);
        PYDepartment = findViewById(R.id.PYDepartment);
        CHDepartment = findViewById(R.id.CHDepartment);
        MDepartment = findViewById(R.id.MDepartment);
        EDepartment = findViewById(R.id.EDepartment);
        PEDepartment = findViewById(R.id.PEDepartment);


        reference = FirebaseDatabase.getInstance().getReference().child("Teachers");

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateTeacher.this, AddTeachers.class));
            }
        });

        CSDepartment();
        ECEDepartment();
        MEDepartment();
        CVDepartment();
        PYDepartment();
        CHDepartment();
        MDepartment();
        EDepartment();
        PEDepartment();
    }

    private void CSDepartment() {
        dbRef = reference.child("Computer Science");
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
                    CSDepartment.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list1, UpdateTeacher.this, "Computer Science");
                    CSDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ECEDepartment() {
        dbRef = reference.child("Electronics and Communication");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()) {
                    eceNoData.setVisibility(View.VISIBLE);
                    ECEDepartment.setVisibility(View.GONE);
                } else {

                    eceNoData.setVisibility(View.GONE);
                    ECEDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    ECEDepartment.setHasFixedSize(true);
                    ECEDepartment.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list2, UpdateTeacher.this, "Electronics and Communication");
                    ECEDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void MEDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()) {
                    meNoData.setVisibility(View.VISIBLE);
                    MEDepartment.setVisibility(View.GONE);
                } else {

                    meNoData.setVisibility(View.GONE);
                    MEDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    MEDepartment.setHasFixedSize(true);
                    MEDepartment.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list3, UpdateTeacher.this, "Mechanical");
                    MEDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void CVDepartment() {
        dbRef = reference.child("Civil");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()) {
                    cvNoData.setVisibility(View.VISIBLE);
                    CVDepartment.setVisibility(View.GONE);
                } else {

                    cvNoData.setVisibility(View.GONE);
                    CVDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    CVDepartment.setHasFixedSize(true);
                    CVDepartment.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list4, UpdateTeacher.this, "Civil");
                    CVDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void PYDepartment() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                if (!snapshot.exists()) {
                    pyNoData.setVisibility(View.VISIBLE);
                    PYDepartment.setVisibility(View.GONE);
                } else {

                    pyNoData.setVisibility(View.GONE);
                    PYDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    PYDepartment.setHasFixedSize(true);
                    PYDepartment.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list5, UpdateTeacher.this, "Physics");
                    PYDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void CHDepartment() {
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6 = new ArrayList<>();
                if (!snapshot.exists()) {
                    chNoData.setVisibility(View.VISIBLE);
                    CHDepartment.setVisibility(View.GONE);
                } else {

                    chNoData.setVisibility(View.GONE);
                    CHDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    CHDepartment.setHasFixedSize(true);
                    CHDepartment.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list6, UpdateTeacher.this, "Chemistry");
                    CHDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void MDepartment() {
        dbRef = reference.child("Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list7 = new ArrayList<>();
                if (!snapshot.exists()) {
                    mNoData.setVisibility(View.VISIBLE);
                    MDepartment.setVisibility(View.GONE);
                } else {

                    mNoData.setVisibility(View.GONE);
                    MDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    MDepartment.setHasFixedSize(true);
                    MDepartment.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list7, UpdateTeacher.this, "Mathematics");
                    MDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void EDepartment() {
        dbRef = reference.child("English");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list8 = new ArrayList<>();
                if (!snapshot.exists()) {
                    eNoData.setVisibility(View.VISIBLE);
                    EDepartment.setVisibility(View.GONE);
                } else {

                    eNoData.setVisibility(View.GONE);
                    EDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    EDepartment.setHasFixedSize(true);
                    EDepartment.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list8, UpdateTeacher.this, "English");
                    EDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void PEDepartment() {
        dbRef = reference.child("Physical Education");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list9 = new ArrayList<>();
                if (!snapshot.exists()) {
                    peNoData.setVisibility(View.VISIBLE);
                    PEDepartment.setVisibility(View.GONE);
                } else {

                    peNoData.setVisibility(View.GONE);
                    PEDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list9.add(data);
                    }
                    PEDepartment.setHasFixedSize(true);
                    PEDepartment.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list9, UpdateTeacher.this, "Physical Education");
                    PEDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}