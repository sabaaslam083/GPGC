package com.example.saba.finalproject.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.saba.finalproject.R;
public class Fragment_AAIntermediate extends Fragment {
TextView textView_2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_aa_intermediate, container, false);
        textView_2=v.findViewById(R.id.f2);
        return v;
    }

}
