package com.example.ari.itellu;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ari.itellu.fragment.frag1;
import com.example.ari.itellu.fragment.frag2;
import com.example.ari.itellu.fragment.frag3;
import com.example.ari.itellu.fragment.frag4;


public class tabsPager extends FragmentStatePagerAdapter {

    String titles[] =new String[]{"UKM","EVENT","INFORMASI TELKOM","LOKASI"};

    public tabsPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                frag1 frag1 = new frag1();
                return frag1;
            case 1:
                frag2 frag2 = new frag2();
                return frag2;
            case 2:
                frag3 frag3 = new frag3();
                return frag3;
            case 3:
                frag4 frag4 = new frag4();
                return frag4;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
