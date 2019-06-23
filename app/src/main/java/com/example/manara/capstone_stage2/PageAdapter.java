package com.example.manara.capstone_stage2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private   int numoftab;
    Fragment fragment;
    public PageAdapter(FragmentManager fm,int numoftab ) {
        super(fm);

        this.numoftab=numoftab;
      //  this.fragment=fragment;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Articles_Fragment();


            case 1:
                return new Favorite_Fragment();

            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Articles";
            case 1:
                return "Favorite";


        }
        return "";
    }
    @Override
    public int getCount() {
        return numoftab;
    }

}
