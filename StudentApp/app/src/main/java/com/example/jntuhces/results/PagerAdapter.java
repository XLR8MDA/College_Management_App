package com.example.jntuhces.results;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    final int pageCount=3;
    private String tabTitles[]= new String[]{"Server1","Server2","Server3"};


    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new server1fragment();

            case 1:
                return new server2fragment();

            case 2:
               return new server3fragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return pageCount;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
