package com.example.jntuhces.gallery.mess;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jntuhces.R;
import com.example.jntuhces.ui.faculty.SectionPageAdapter;
import com.example.jntuhces.ui.notices.LinksFragment;
import com.example.jntuhces.ui.notices.insideNoticeFragment;
import com.google.android.material.tabs.TabLayout;


public class Mess extends Fragment {
    View myFragment;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment= inflater.inflate(R.layout.fragment_mess, container, false);

        viewPager=myFragment.findViewById(R.id.viewPager);
        tabLayout= myFragment.findViewById(R.id.tabLayout);

        return myFragment;

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setUpViewPager(ViewPager viewPager) {

        SectionPageAdapter adapter= new SectionPageAdapter(getChildFragmentManager());
        adapter.addFragment(new BoysmFragment(),"Boys");
        adapter.addFragment(new GirlsmFragment(),"Girls");

        viewPager.setAdapter(adapter);

    }
}
