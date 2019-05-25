package com.example.saba.finalproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.saba.finalproject.R;

public class StudentsHomeActivity extends AppCompatActivity implements View.OnClickListener  {
    Button btn_admission,btn_events,btn_result,btn_fees,btn_datesheet,btn_attandance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_home);
        btn_admission=findViewById(R.id.button1);
        btn_events=findViewById(R.id.button2);
        btn_result=findViewById(R.id.button3);
        btn_fees=findViewById(R.id.button4);
        btn_datesheet=findViewById(R.id.button5);
        btn_attandance=findViewById(R.id.button6);
        btn_attandance.setOnClickListener(this);
        btn_events.setOnClickListener(this);
        btn_result.setOnClickListener(this);
        btn_fees.setOnClickListener(this);
        btn_datesheet.setOnClickListener(this);
        btn_attandance.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        int id=btn.getId();
        switch(id){
            case R.id.button1:
                Toast.makeText(getApplicationContext(),"btn clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(),"btn clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.button3:
                Toast.makeText(getApplicationContext(),"btn clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.button4:
                Toast.makeText(getApplicationContext(),"btn clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.button5:
                Toast.makeText(getApplicationContext(),"btn clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.button6:
                Toast.makeText(getApplicationContext(),"btn clicked",Toast.LENGTH_LONG).show();
                break;

        }

    }
}
