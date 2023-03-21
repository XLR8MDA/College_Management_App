package com.example.jntuhces.gallery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.jntuhces.gallery.hostel.Hostel;


public class GalleryMainAdapter extends FragmentStatePagerAdapter {

    final int pageCount=2;
    private String tabTitles[]= new String[]{"College","Hostel"};

    public GalleryMainAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new College();

            case 1:
                return new Hostel();

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
