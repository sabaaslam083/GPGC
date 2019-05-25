package com.example.saba.finalproject.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.saba.finalproject.R;
import com.example.saba.finalproject.fragment.Fragment_parents;
import com.example.saba.finalproject.fragment.Fragment_students;
import com.example.saba.finalproject.fragment.Fragment_teachers;
import com.example.saba.finalproject.viewPager.ViewPagerAdapterLogin;


public class LoginActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.view_page);
        ViewPagerAdapterLogin adapter = new ViewPagerAdapterLogin(getSupportFragmentManager());
        adapter.addTabPage("Teachers",new Fragment_teachers());
        adapter.addTabPage("Parents",new Fragment_parents());
        adapter.addTabPage("Students",new Fragment_students());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
