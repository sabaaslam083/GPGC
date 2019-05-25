package com.example.saba.finalproject.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.saba.finalproject.R;
import com.example.saba.finalproject.viewPager.ViewPagerAdapterAdmission;


public class Fragment_admissionHome extends Fragment  {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_admission_home, container, false);
        tabLayout = v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager = v.findViewById(R.id.view_page1);
        setupViewPager(viewPager);
        return v;
    }
    private void setupViewPager(ViewPager viewPager) {


        ViewPagerAdapterAdmission adapter = new ViewPagerAdapterAdmission(getChildFragmentManager());
        adapter.addTabPage("Levels",new Fragment_admissionLevel());
        adapter.addTabPage("Departments",new Fragment_admissionCategories());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
