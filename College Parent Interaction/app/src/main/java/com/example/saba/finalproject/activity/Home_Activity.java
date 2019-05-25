package com.example.saba.finalproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.saba.finalproject.R;

public class Home_Activity extends AppCompatActivity {
ViewFlipper viewFlipper;
Button btn_1,btn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_1=findViewById(R.id.button_genral);
        btn_2=findViewById(R.id.button_regular);
        int Image[]={
                R.drawable.clg1,
                R.drawable.clg2,
                R.drawable.clg13,
                R.drawable.clg5,
                R.drawable.clg6,
                R.drawable.clg8,
                R.drawable.clg10,
                R.drawable.clg11,
                R.drawable.clg13
        };
        viewFlipper=findViewById(R.id.v_fliper);
        for(int image: Image){
            FlierImages (image);
        }
    }
    public void FlierImages(int images){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(images);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(800);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_Activity.this, SignUp_Activity.class);
                startActivity(intent);
            }

        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_home = new Intent(Home_Activity.this, LoginActivity.class);
                startActivity(intent_home);
            }
        });
    }


}
