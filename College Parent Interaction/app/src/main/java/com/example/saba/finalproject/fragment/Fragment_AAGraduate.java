package com.example.saba.finalproject.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saba.finalproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_AAGraduate extends Fragment {

TextView textView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_aa_graduate, container, false);
        textView=v.findViewById(R.id.f3);
        return  v;
    }

}
