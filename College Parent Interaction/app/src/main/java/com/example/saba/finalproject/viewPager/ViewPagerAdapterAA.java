package com.example.saba.finalproject.ViewPager;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapterAA extends FragmentPagerAdapter {
    ArrayList<String> arrTitle=new ArrayList<>();
    ArrayList<Fragment> arrFragments=new ArrayList<>();
    public ViewPagerAdapterAA(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return arrFragments.get(position);
    }

    @Override
    public int getCount() {
        return arrFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrTitle.get(position);
    }
    public void addTabPage(String title,Fragment freg){
        arrTitle.add(title);
        arrFragments.add(freg);
    }


}


