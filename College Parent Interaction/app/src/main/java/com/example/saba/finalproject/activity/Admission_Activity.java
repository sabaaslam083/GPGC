package com.example.saba.finalproject.activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;;import com.example.saba.finalproject.R;
import com.example.saba.finalproject.fragment.Fragment_admissionHome;
import com.example.saba.finalproject.fragment.Fragment_parents;
import com.example.saba.finalproject.fragment.Fragment_schedualGraduate;
import com.example.saba.finalproject.fragment.Fragment_scheduleIntermediate;

public class Admission_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    TextView drawer;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);


        drawer=findViewById(R.id.text);
        drawerLayout=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView=findViewById(R.id.nav_view);
        frameLayout=findViewById(R.id.fragment_place);
        if (savedInstanceState==null){
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_place,new Fragment_admissionHome()).commit();
        }
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        View v=navigationView.getHeaderView(0);
        TextView name=v.findViewById(R.id.textView_name);
        TextView email=v.findViewById(R.id.textView2);
        ImageView imageView=v.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.person);
        name.setText("saba aslam");
        email.setText("sabaaslam083@gmail.com");

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=null;
        switch(id){
            case R.id.home:
                fragment=new Fragment_admissionHome();
                toolbar.setTitle("Govt.Post Graduate College");
                toolbar.setTitleTextColor(Color.WHITE);
                drawerLayout.closeDrawer(Gravity.START);
                break;
            case R.id.intermidiate:
                fragment=new Fragment_scheduleIntermediate();
                toolbar.setTitle("Intermediate Admission Schedule");
                toolbar.setTitleTextColor(Color.WHITE);
                drawerLayout.closeDrawer(Gravity.START);
                break;
            case R.id.Graduate:
                fragment=new Fragment_schedualGraduate();
                toolbar.setTitle("Graduate Admission Schedule");
                toolbar.setTitleTextColor(Color.WHITE);
                drawerLayout.closeDrawer(Gravity.START);
                break;

        }

        fm.beginTransaction().replace(R.id.fragment_place,fragment).commit();

        return false;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)){
            drawerLayout.closeDrawer(Gravity.START);
        }
        else {

            new AlertDialog.Builder( Admission_Activity.this).setTitle("Alert").setMessage("You want to Exit..!")
                    .setPositiveButton("Yes" ,new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_LONG).show();
                            finish();
                        }

                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_LONG).show();
                }
            }).setNeutralButton("", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Confirm",Toast.LENGTH_LONG).show();
                }
            }).show();





//           super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.menue_logout:
                Toast.makeText(this,"logout is clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.menue_settings:
                Toast.makeText(this,"settings is cliced",Toast.LENGTH_LONG).show();
                break;


        }
        return super.onOptionsItemSelected(item);

    }


}


