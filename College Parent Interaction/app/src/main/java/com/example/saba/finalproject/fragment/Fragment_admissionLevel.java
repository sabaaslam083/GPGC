package com.example.saba.finalproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saba.finalproject.R;

import com.example.saba.finalproject.activity.GraduateActivity;
import com.example.saba.finalproject.activity.IntermediateActivity;


public class Fragment_admissionLevel extends Fragment {

Button btn_intermediate,btn_graduate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_admission_level, container, false);

         btn_intermediate=v.findViewById(R.id.Intermidiate);
         btn_graduate=v.findViewById(R.id.Graduate);
         btn_intermediate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(getActivity(),IntermediateActivity.class);
                 startActivity(intent);
             }

         });
       btn_graduate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GraduateActivity.class);
                startActivity(intent);
            }
        });

        return v;

    }



}
