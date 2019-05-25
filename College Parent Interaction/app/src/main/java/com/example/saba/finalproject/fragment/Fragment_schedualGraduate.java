package com.example.saba.finalproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saba.finalproject.R;


public class Fragment_schedualGraduate extends Fragment {

TextView textView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_schedule_graduate, container, false);
        textView=v.findViewById(R.id.f3);
        return  v;
    }

}
