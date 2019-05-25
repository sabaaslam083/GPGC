package com.example.saba.finalproject.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.saba.finalproject.R;

public class SplashActivity extends AppCompatActivity {
    private static int splash_time = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, Home_Activity.class);
                startActivity(intent);
                finish();

            }
        }, splash_time);
    }
}
