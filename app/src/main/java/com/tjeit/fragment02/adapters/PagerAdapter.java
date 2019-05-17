package com.tjeit.fragment02.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tjeit.fragment02.fragments.FragmentOne;
import com.tjeit.fragment02.fragments.FragmentThree;
import com.tjeit.fragment02.fragments.FragmentTwo;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    Fragment frag1, frag2, frag3;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int posotion) {

        Fragment fr = null;

        if(posotion == 0) {
            if(frag1 == null) {
                frag1 = new FragmentOne();
            }
            fr = frag1;
        }
        else if (posotion == 1) {
            if(frag2 == null) {
                frag2 = new FragmentOne();
            }
            fr = frag2;
        }
        else if (posotion == 2) {
            if(frag3 == null) {
                frag3 = new FragmentOne();
            }
            fr = frag3;
        }

        return fr;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
