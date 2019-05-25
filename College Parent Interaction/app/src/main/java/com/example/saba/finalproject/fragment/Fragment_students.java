package com.example.saba.finalproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.saba.finalproject.R;
import com.example.saba.finalproject.activity.StudentsHomeActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_students extends Fragment implements View.OnClickListener {
    EditText name,passward;
    Button button_login;
    public Fragment_students() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_students, container, false);
        name=v.findViewById(R.id.name);
        passward=v.findViewById(R.id.passward);
        button_login=v.findViewById(R.id.log_in);
        button_login.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(),"btn login clicked",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(getActivity(),StudentsHomeActivity.class);
        startActivity(intent);
    }
}
