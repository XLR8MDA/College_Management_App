package com.example.jntuhces.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jntuhces.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class pcmFragment extends Fragment {

    private RecyclerView pyDepartment, cDepartment, mDepartment, eDepartment,peDepartment;
    private LinearLayout pyNoData, cNoData, mNoData, eNoData,peNoData;
    private DatabaseReference reference, dbRef;
    private TeacherAdapter adapter;
    private List<TeacherData> list1, list2, list3, list4,list5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pcm, container, false);

        pyNoData = view.findViewById(R.id.pyNoData);
        cNoData = view.findViewById(R.id.cNoData);
        mNoData = view.findViewById(R.id.mNoData);
        eNoData = view.findViewById(R.id.eNoData);
        peNoData = view.findViewById(R.id.peNoData);


        peDepartment = view.findViewById(R.id.peDepartment);
        pyDepartment = view.findViewById(R.id.pyDepartment);
        cDepartment = view.findViewById(R.id.cDepartment);
        mDepartment = view.findViewById(R.id.mDepartment);
        eDepartment = view.findViewById(R.id.eDepartment);

        reference = FirebaseDatabase.getInstance().getReference().child("Teachers");


        pyDepartment();
        cDepartment();
        mDepartment();
        eDepartment();
        peDepartment();

        return view;
    }

    private void pyDepartment() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()) {
                    pyNoData.setVisibility(View.VISIBLE);
                    pyDepartment.setVisibility(View.GONE);
                } else {
                    pyNoData.setVisibility(View.GONE);
                    pyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    pyDepartment.setHasFixedSize(true);
                    pyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext(), "Physics");
                    pyDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void cDepartment() {
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()) {
                    cNoData.setVisibility(View.VISIBLE);
                    cDepartment.setVisibility(View.GONE);
                } else {
                    cNoData.setVisibility(View.GONE);
                    cDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    cDepartment.setHasFixedSize(true);
                    cDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext(), "Chemistry");
                    cDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void mDepartment() {
        dbRef = reference.child("Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()) {
                    mNoData.setVisibility(View.VISIBLE);
                    mDepartment.setVisibility(View.GONE);
                } else {
                    mNoData.setVisibility(View.GONE);
                    mDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    mDepartment.setHasFixedSize(true);
                    mDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext(), "Mathematics");
                    mDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void eDepartment (){
        dbRef = reference.child("English");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()) {
                    eNoData.setVisibility(View.VISIBLE);
                    eDepartment.setVisibility(View.GONE);
                } else {
                    eNoData.setVisibility(View.GONE);
                    eDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    eDepartment.setHasFixedSize(true);
                    eDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext(), "English");
                    eDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void peDepartment() {
        dbRef = reference.child("Physical Education");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5= new ArrayList<>();
                if (!snapshot.exists()) {
                    peNoData.setVisibility(View.VISIBLE);
                    peDepartment.setVisibility(View.GONE);
                } else {
                    peNoData.setVisibility(View.GONE);
                    peDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    peDepartment.setHasFixedSize(true);
                    peDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5,getContext(),"Physical Education");
                    peDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}