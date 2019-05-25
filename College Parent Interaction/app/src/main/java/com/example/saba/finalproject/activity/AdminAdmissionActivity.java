package com.example.saba.finalproject.activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.saba.finalproject.Fragment.Fragment_AAGraduate;
import com.example.saba.finalproject.ViewPager.ViewPagerAdapterAA;
import com.example.saba.finalproject.R;
import com.example.saba.finalproject.fragment.Fragment_InterMain;

public class AdminAdmissionActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_admission);
        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.view_page);
        ViewPagerAdapterAA adapter;
        adapter = new ViewPagerAdapterAA(getSupportFragmentManager());
        adapter.addTabPage("Intermediate",new Fragment_InterMain());
        adapter.addTabPage("Graduate",new Fragment_AAGraduate());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
