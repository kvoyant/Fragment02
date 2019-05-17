package com.tjeit.fragment02.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tjeit.fragment02.fragments.FragmentOne;
import com.tjeit.fragment02.fragments.FragmentThree;
import com.tjeit.fragment02.fragments.FragmentTwo;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int posotion) {

        Fragment fr = null;

        if(posotion == 0) {
            FragmentOne frag1 = new FragmentOne();
            fr = frag1;
        }
        else if (posotion == 1) {
            FragmentTwo frag2 = new FragmentTwo();
            fr = frag2;
        }
        else if (posotion == 2) {
            FragmentThree frag3 = new FragmentThree();
            fr = frag3;
        }

        return fr;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
