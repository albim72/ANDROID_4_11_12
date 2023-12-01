package com.marcin.tabswithswipegesture.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.marcin.tabswithswipegesture.GamesFragment;
import com.marcin.tabswithswipegesture.MoviesFragment;
import com.marcin.tabswithswipegesture.TopRatedFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TopRatedFragment();
            case 1:
                return new GamesFragment();
            case 2:
                return new MoviesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
